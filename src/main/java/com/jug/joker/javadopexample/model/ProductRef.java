package com.jug.joker.javadopexample.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.jdbc.core.mapping.AggregateReference;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table("PURCHASE_PRODUCT")
public final class ProductRef {
    @Id
    private final Long id;
    private final AggregateReference<Product, Long> productId;
}
