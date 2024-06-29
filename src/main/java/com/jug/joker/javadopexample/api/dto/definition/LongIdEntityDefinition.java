package com.jug.joker.javadopexample.api.dto.definition;


public sealed interface LongIdEntityDefinition extends EntityDefinition<Long>
        permits
        ProductDefinition,
        ProductPropertiesDefinition,
        PurchaseDefinition {
}
