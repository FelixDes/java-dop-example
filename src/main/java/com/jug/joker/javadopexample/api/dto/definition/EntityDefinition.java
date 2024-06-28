package com.jug.joker.javadopexample.api.dto.definition;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.jug.joker.javadopexample.api.dto.SecuredEntityQualifier;

import static com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import static com.jug.joker.javadopexample.api.dto.SecuredEntityQualifier.Constants.*;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        property = "qualifier",
        visible = true
)
@JsonSubTypes({
        @Type(value = ProductDefinition.class, name = PRODUCT),
        @Type(value = CustomerDefinition.class, name = CUSTOMER),
        @Type(value = PurchaseDefinition.class, name = PURCHASE),
        @Type(value = ProductPropertiesDefinition.class, name = PRODUCT_PROPERTIES),
})
public sealed interface EntityDefinition
        permits LongIdEntityDefinition, UUIDEntityDefinition {
    SecuredEntityQualifier getQualifier();
}
