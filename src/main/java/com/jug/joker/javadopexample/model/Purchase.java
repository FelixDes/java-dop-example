package com.jug.joker.javadopexample.model;

import com.jug.joker.javadopexample.api.dto.SecuredEntityQualifier;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.jdbc.core.mapping.AggregateReference;
import org.springframework.data.relational.core.mapping.MappedCollection;

import java.util.Set;
import java.util.UUID;

import static com.jug.joker.javadopexample.api.dto.SecuredEntityQualifier.*;

@Data
public final class Purchase implements SecuredEntity<Long> {
    @Id
    private final Long id;
    @MappedCollection(idColumn = "PURCHASE_ID")
    private final Set<ProductRef> products;
    private final AggregateReference<Customer, UUID> customerId;


    @Override
    public SecuredEntityQualifier getQualifier() {
        return PURCHASE;
    }
}
