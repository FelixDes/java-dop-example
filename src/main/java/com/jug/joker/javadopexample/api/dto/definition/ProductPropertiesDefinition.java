package com.jug.joker.javadopexample.api.dto.definition;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.jug.joker.javadopexample.api.dto.SecuredEntityQualifier;

public record ProductPropertiesDefinition(
        Long id
) implements LongIdEntityDefinition {
    @JsonCreator
    public ProductPropertiesDefinition {
        if (id <= 0) throw new IllegalArgumentException("id must be positive");
    }

    @Override
    public SecuredEntityQualifier getQualifier() {
        return SecuredEntityQualifier.PRODUCT_PROPERTIES;
    }
}
