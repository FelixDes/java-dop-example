package com.jug.joker.javadopexample.model;

import com.jug.joker.javadopexample.api.dto.SecuredEntityQualifier;
import org.springframework.data.annotation.Id;

import java.util.UUID;

import static com.jug.joker.javadopexample.api.dto.SecuredEntityQualifier.*;

public record Customer(
        @Id
        UUID id,
        String name
) implements SecuredEntity {
    @Override
    public SecuredEntityQualifier getQualifier() {
        return CUSTOMER;
    }
}
