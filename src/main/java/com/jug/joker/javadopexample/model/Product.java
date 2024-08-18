package com.jug.joker.javadopexample.model;

import com.jug.joker.javadopexample.api.dto.SecuredEntityQualifier;
import lombok.Data;
import org.springframework.data.annotation.Id;

import static com.jug.joker.javadopexample.api.dto.SecuredEntityQualifier.*;

@Data
public final class Product implements SecuredEntity<Long> {
    @Id
    private final Long id;
    private final String name;

    @Override
    public SecuredEntityQualifier getQualifier() {
        return PRODUCT;
    }
}
