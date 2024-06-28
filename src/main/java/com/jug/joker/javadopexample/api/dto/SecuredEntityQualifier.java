package com.jug.joker.javadopexample.api.dto;

public enum SecuredEntityQualifier {
    CUSTOMER(Constants.CUSTOMER),
    PRODUCT(Constants.PRODUCT),
    PRODUCT_PROPERTIES(Constants.PRODUCT_PROPERTIES),
    PURCHASE(Constants.PURCHASE);

    SecuredEntityQualifier(String qualifier) {
    }

    public static class Constants {
        public static final String CUSTOMER = "CUSTOMER";
        public static final String PRODUCT = "PRODUCT";
        public static final String PURCHASE = "PURCHASE";
        public static final String PRODUCT_PROPERTIES = "PRODUCT_PROPERTIES";
    }
}
