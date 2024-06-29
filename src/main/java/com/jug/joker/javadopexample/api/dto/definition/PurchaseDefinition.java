package com.jug.joker.javadopexample.api.dto.definition;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.jug.joker.javadopexample.api.dto.SecuredEntityQualifier;
import lombok.Data;


@Data
public final class PurchaseDefinition implements LongIdEntityDefinition {
    private final long id;

    @JsonCreator
    public PurchaseDefinition(long id) {
        if (id < 0) throw new IllegalArgumentException("id must be positive");
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    @Override
    public SecuredEntityQualifier getQualifier() {
        return SecuredEntityQualifier.PURCHASE;
    }
}
