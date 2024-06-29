package com.jug.joker.javadopexample.api.dto.definition;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.jug.joker.javadopexample.api.dto.SecuredEntityQualifier;

public record ProductDefinition(
        Long id
) implements LongIdEntityDefinition {
    @JsonCreator
    public ProductDefinition {
        if (id <= 0) throw new IllegalArgumentException("id must be positive");
    }

    @Override
    public SecuredEntityQualifier getQualifier() {
        return SecuredEntityQualifier.PRODUCT;
    }
}
