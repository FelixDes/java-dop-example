package com.jug.joker.javadopexample.model;

import com.jug.joker.javadopexample.api.dto.SecuredEntityQualifier;

public sealed interface SecuredEntity
        permits
        Customer,
        Product,
        ProductProperties,
        Purchase {
    SecuredEntityQualifier getQualifier();
}
