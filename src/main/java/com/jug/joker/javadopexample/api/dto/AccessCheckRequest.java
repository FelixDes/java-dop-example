package com.jug.joker.javadopexample.api.dto;

import com.jug.joker.javadopexample.api.dto.definition.EntityDefinition;

public record AccessCheckRequest(
    EntityDefinition<?> entityDefinition,
    ActionType actionType
) {
}
