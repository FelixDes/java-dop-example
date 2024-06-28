package com.jug.joker.javadopexample.api.dto.definition;

import com.jug.joker.javadopexample.api.dto.SecuredEntityQualifier;

public record PurchaseDefinition(
        long id
) implements LongIdEntityDefinition {
    @Override
    public SecuredEntityQualifier getQualifier() {
        return SecuredEntityQualifier.PURCHASE;
    }
}
