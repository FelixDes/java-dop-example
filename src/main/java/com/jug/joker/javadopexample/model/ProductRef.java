package com.jug.joker.javadopexample.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.jdbc.core.mapping.AggregateReference;
import org.springframework.data.relational.core.mapping.Table;


@Table("PURCHASE_PRODUCT")
public record ProductRef(
        @Id
        Long id,
        AggregateReference<Product, Long> productId
) {
}
