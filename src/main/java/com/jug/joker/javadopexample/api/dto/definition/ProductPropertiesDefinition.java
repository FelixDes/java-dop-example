package com.jug.joker.javadopexample.api.dto.definition;

import com.jug.joker.javadopexample.api.dto.SecuredEntityQualifier;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor(force = true)
@Data
public final class ProductPropertiesDefinition implements LongIdEntityDefinition {
    private final long id;

    @Override
    public SecuredEntityQualifier getQualifier() {
        return SecuredEntityQualifier.PRODUCT_PROPERTIES;
    }
}
