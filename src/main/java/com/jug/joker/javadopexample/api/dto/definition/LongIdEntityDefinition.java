package com.jug.joker.javadopexample.api.dto.definition;


public sealed interface LongIdEntityDefinition extends EntityDefinition
        permits
        ProductDefinition,
        ProductPropertiesDefinition,
        PurchaseDefinition {
}
