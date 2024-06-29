package com.jug.joker.javadopexample.api.dto.definition;

import java.util.UUID;

public sealed interface UUIDEntityDefinition extends EntityDefinition<UUID>
        permits
        CustomerDefinition {
}
