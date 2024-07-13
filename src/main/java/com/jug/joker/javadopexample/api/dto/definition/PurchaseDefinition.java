package com.jug.joker.javadopexample.api.dto.definition;

import com.jug.joker.javadopexample.api.dto.SecuredEntityQualifier;

import static com.jug.joker.javadopexample.api.dto.SecuredEntityQualifier.*;

public record PurchaseDefinition(
        Long id
) implements LongIdEntityDefinition {
    public PurchaseDefinition {
        if (id <= 0) throw new IllegalArgumentException("id must be positive");
    }

    @Override
    public SecuredEntityQualifier getQualifier() {
        return PURCHASE;
    }
}
