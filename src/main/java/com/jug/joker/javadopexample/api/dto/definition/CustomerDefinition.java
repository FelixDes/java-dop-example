package com.jug.joker.javadopexample.api.dto.definition;

import com.jug.joker.javadopexample.api.dto.SecuredEntityQualifier;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

import static com.jug.joker.javadopexample.api.dto.SecuredEntityQualifier.*;

@NoArgsConstructor(force = true)
@Data
public final class CustomerDefinition implements UUIDEntityDefinition {
    private final UUID id;

    @Override
    public SecuredEntityQualifier getQualifier() {
        return CUSTOMER;
    }
}
