package com.jug.joker.javadopexample.service;

import com.jug.joker.javadopexample.model.*;
import com.jug.joker.javadopexample.repository.CustomerRepository;
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
    private final ProductPropertiesIntegrationService propertiesIntegrationService;

    private Stream<T> processEntityTreeToStream(
            SecuredEntity entity,
            Function<SecuredEntity, T> mapper
    ) {
        var result = Stream.of(mapper.apply(entity));

        if (entity instanceof Purchase purchase) {
            result = Stream.concat(
                    result, Stream.concat(
                            purchase.products()
                                    .stream()
                                    .flatMap(p -> processEntityTreeToStream(p, mapper)),
                            processEntityTreeToStream(
                                    customerRepository.findById(purchase.customerId().getId()).orElseThrow(),
                                    mapper
                            )
                    )
            );
        } else if (entity instanceof Product product) {
            result = Stream.concat(
                    result,
                    propertiesIntegrationService
                            .findAllByProductId(product.id())
                            .stream()
                            .flatMap(pp -> processEntityTreeToStream(pp, mapper))
            );
        } else if (entity instanceof Customer || entity instanceof ProductProperties) {
            // Nowhere to step into
        } else {
            throw new RuntimeException("Absurdly impossible");
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