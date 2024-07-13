package com.jug.joker.javadopexample.api.dto.definition;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.jug.joker.javadopexample.api.dto.SecuredEntityQualifier;
import lombok.Data;

import static com.jug.joker.javadopexample.api.dto.SecuredEntityQualifier.*;

@Data
public final class PurchaseDefinition implements LongIdEntityDefinition {
    private final Long id;

    @JsonCreator
    public PurchaseDefinition(long id) {
        if (id <= 0) throw new IllegalArgumentException("id must be positive");
        this.id = id;
    }

    @Override
    public SecuredEntityQualifier getQualifier() {
        return PURCHASE;
    }
}
