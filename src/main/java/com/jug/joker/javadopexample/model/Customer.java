package com.jug.joker.javadopexample.model;

import com.jug.joker.javadopexample.api.dto.SecuredEntityQualifier;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.UUID;

import static com.jug.joker.javadopexample.api.dto.SecuredEntityQualifier.*;

@Data
public final class Customer implements SecuredEntity {
    @Id
    private final UUID id;
    private final String name;

    @Override
    public SecuredEntityQualifier getQualifier() {
        return CUSTOMER;
    }
}
