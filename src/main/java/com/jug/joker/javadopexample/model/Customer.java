package com.jug.joker.javadopexample.model;

import com.jug.joker.javadopexample.api.dto.SecuredEntityQualifier;
import org.springframework.data.annotation.Id;

import java.util.UUID;

public record Customer(
        @Id
        UUID id,
        String name
) implements SecuredEntity {
    @Override
    public SecuredEntityQualifier getQualifier() {
        return SecuredEntityQualifier.CUSTOMER;
    }
}
