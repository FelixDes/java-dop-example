package com.jug.joker.javadopexample.model;

import com.jug.joker.javadopexample.api.dto.SecuredEntityQualifier;
import lombok.Data;

@Data
public final class ProductProperties implements SecuredEntity {
    private final Long id;
    private final String prop_key;
    private final String prop_value;

    @Override
    public SecuredEntityQualifier getQualifier() {
        return SecuredEntityQualifier.PRODUCT_PROPERTIES;
    }
}
