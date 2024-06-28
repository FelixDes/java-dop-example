package com.jug.joker.javadopexample.api.dto;

import lombok.experimental.FieldNameConstants;

@FieldNameConstants(onlyExplicitlyIncluded = true)
public enum SecuredEntityQualifier {
    @FieldNameConstants.Include
    CUSTOMER,
    @FieldNameConstants.Include
    PRODUCT,
    @FieldNameConstants.Include
    PRODUCT_PROPERTIES,
    @FieldNameConstants.Include
    PURCHASE;
}
