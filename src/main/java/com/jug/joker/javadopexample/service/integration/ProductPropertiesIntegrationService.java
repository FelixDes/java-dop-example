package com.jug.joker.javadopexample.service.integration;


import com.jug.joker.javadopexample.model.ProductProperties;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class ProductPropertiesIntegrationService {
    private final Map<Long, ProductProperties> productToPropertiesMap = Map.of(
            1L, new ProductProperties(1L, "type", "wireless"),
            2L, new ProductProperties(2L, "diagonal", "6.4"),
            3L, new ProductProperties(3L, "diagonal", "15.6")
    );
    private final Map<Long, ProductProperties> propertiesMap = productToPropertiesMap
            .values()
            .stream()
            .collect(Collectors.toMap(
                    ProductProperties::getId,
                    Function.identity()
            ));

    public Optional<ProductProperties> findById(long id) {
        return Optional.ofNullable(propertiesMap.get(id));
    }

    public Set<ProductProperties> findAllByProductId(long id) {
        return productToPropertiesMap
                .entrySet()
                .stream()
                .filter(v -> v.getKey().equals(id))
                .map(Map.Entry::getValue)
                .collect(Collectors.toSet());
    }
}
