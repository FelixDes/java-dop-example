package com.jug.joker.javadopexample.model;

import com.jug.joker.javadopexample.api.dto.SecuredEntityQualifier;
import org.springframework.data.annotation.Id;

import static com.jug.joker.javadopexample.api.dto.SecuredEntityQualifier.*;

public record ProductProperties(
        @Id
        Long id,
        String propKey,
        String propValue
) implements SecuredEntity {
    @Override
    public SecuredEntityQualifier getQualifier() {
        return PRODUCT_PROPERTIES;
    }
}
