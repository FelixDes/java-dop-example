package com.jug.joker.javadopexample.api.dto.definition;

import com.jug.joker.javadopexample.api.dto.SecuredEntityQualifier;

import java.util.UUID;

public record CustomerDefinition(
        UUID id
) implements UUIDEntityDefinition {
    @Override
    public SecuredEntityQualifier getQualifier() {
        return SecuredEntityQualifier.CUSTOMER;
    }
}
