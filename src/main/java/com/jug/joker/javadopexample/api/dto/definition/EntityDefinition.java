package com.jug.joker.javadopexample.api.dto.definition;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.jug.joker.javadopexample.api.dto.SecuredEntityQualifier;

import static com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import static com.jug.joker.javadopexample.api.dto.SecuredEntityQualifier.*;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        property = "qualifier",
        visible = true
)
@JsonSubTypes({
        @Type(value = ProductDefinition.class, name = Fields.PRODUCT),
        @Type(value = CustomerDefinition.class, name = Fields.CUSTOMER),
        @Type(value = PurchaseDefinition.class, name = Fields.PURCHASE),
        @Type(value = ProductPropertiesDefinition.class, name = Fields.PRODUCT_PROPERTIES),
})
public sealed interface EntityDefinition<T>
        permits LongIdEntityDefinition, UUIDEntityDefinition {
    T id();
    SecuredEntityQualifier getQualifier();
}
