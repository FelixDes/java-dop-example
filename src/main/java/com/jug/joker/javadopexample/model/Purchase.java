package com.jug.joker.javadopexample.model;

import com.jug.joker.javadopexample.api.dto.SecuredEntityQualifier;
import org.springframework.data.annotation.Id;
import org.springframework.data.jdbc.core.mapping.AggregateReference;
import org.springframework.data.relational.core.mapping.MappedCollection;

import java.util.Set;
import java.util.UUID;

import static com.jug.joker.javadopexample.api.dto.SecuredEntityQualifier.*;

public record Purchase(
        @Id
        Long id,
        @MappedCollection(idColumn = "PURCHASE_ID")
        Set<ProductRef> products,
        AggregateReference<Customer, UUID> customerId
) implements SecuredEntity {
    @Override
    public SecuredEntityQualifier getQualifier() {
        return PURCHASE;
    }
}
