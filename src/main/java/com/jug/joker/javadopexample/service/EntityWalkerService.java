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
import java.util.stream.Collectors;
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

        if (entity instanceof Purchase) {
            var purchase = (Purchase) entity;
            result = Stream.concat(
                    result, Stream.concat(
                            purchase.getProducts()
                                    .stream()
                                    .flatMap(ref -> productRepository.findById(ref.getId()).stream())
                                    .flatMap(p -> processEntityTreeToStream(p, mapper)),
                            processEntityTreeToStream(
                                    customerRepository.findById(purchase.getCustomerId().getId()).orElseThrow(),
                                    mapper
                            )
                    )
            );
        } else if (entity instanceof Product) {
            var product = (Product) entity;
            result = Stream.concat(
                    result,
                    propertiesIntegrationService
                            .findAllByProductId(product.getId())
                            .stream()
                            .flatMap(pp -> processEntityTreeToStream(pp, mapper))
            );
        } else if (entity instanceof Customer || entity instanceof ProductProperties) {
            // Nowhere to step into
        } else {
            throw new RuntimeException("Not expected");
        }

        return result;
    }

    public List<T> processEntityTree(
            SecuredEntity entity,
            Function<SecuredEntity, T> mapper
    ) {
        return processEntityTreeToStream(entity, mapper).collect(Collectors.toList());
    }
}