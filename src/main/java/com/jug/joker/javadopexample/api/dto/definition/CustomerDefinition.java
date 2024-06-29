package com.jug.joker.javadopexample.api.dto.definition;

import com.jug.joker.javadopexample.api.dto.SecuredEntityQualifier;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@NoArgsConstructor(force = true)
@Data
public final class CustomerDefinition implements UUIDEntityDefinition {
    private final UUID id;

    public UUID getId() {
        return id;
    }

    @Override
    public SecuredEntityQualifier getQualifier() {
        return SecuredEntityQualifier.CUSTOMER;
    }
}
