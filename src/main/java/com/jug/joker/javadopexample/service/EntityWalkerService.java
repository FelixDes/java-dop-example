package com.jug.joker.javadopexample.service;

import com.jug.joker.javadopexample.model.*;
import com.jug.joker.javadopexample.repository.CustomerRepository;
import com.jug.joker.javadopexample.repository.ProductRepository;
import com.jug.joker.javadopexample.service.integration.ProductPropertiesIntegrationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

@RequiredArgsConstructor
@Service
@Transactional(readOnly = true)
public class EntityWalkerService<T> {
    private final CustomerRepository customerRepository;
    private final ProductRepository productRepository;
    private final ProductPropertiesIntegrationService propertiesIntegrationService;

    private Stream<T> processEntityTreeToStream(
            SecuredEntity entity,
            Function<SecuredEntity, T> mapper
    ) {
        var result = Stream.of(mapper.apply(entity));

        switch (entity) {
            case Purchase(
                    var ignored,
                    var products,
                    var customerRef
            ) -> result = Stream.concat(
                    result, Stream.concat(
                            products.stream()
                                    .flatMap(ref -> productRepository.findById(ref.id()).stream())
                                    .flatMap(p -> processEntityTreeToStream(p, mapper)),
                            processEntityTreeToStream(
                                    customerRepository.findById(customerRef.getId()).orElseThrow(),
                                    mapper
                            )
                    )
            );
            case Product(
                    Long id,
                    var ignored
            ) -> result = Stream.concat(
                    result,
                    propertiesIntegrationService.findAllByProductId(id)
                            .stream()
                            .flatMap(pp -> processEntityTreeToStream(pp, mapper))
            );
            case Customer ignored -> {
            }
            case ProductProperties ignored -> {
            }
        }

        return result;
    }

    public List<T> processEntityTree(
            SecuredEntity entity,
            Function<SecuredEntity, T> mapper
    ) {
        return processEntityTreeToStream(entity, mapper).toList();
    }
}