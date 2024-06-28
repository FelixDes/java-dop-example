package com.jug.joker.javadopexample.api.dto.definition;

import com.jug.joker.javadopexample.api.dto.SecuredEntityQualifier;

public record ProductPropertiesDefinition(
        long id
) implements LongIdEntityDefinition {
    @Override
    public SecuredEntityQualifier getQualifier() {
        return SecuredEntityQualifier.PRODUCT_PROPERTIES;
    }
}
