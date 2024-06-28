package com.jug.joker.javadopexample.api.dto;

import com.jug.joker.javadopexample.api.dto.definition.EntityDefinition;
import lombok.Data;

@Data
public final class AccessCheckRequest {
    private final EntityDefinition entityDefinition;
    private final ActionType actionType;
}
