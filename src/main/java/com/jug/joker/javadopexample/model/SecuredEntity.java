package com.jug.joker.javadopexample.model;

import com.jug.joker.javadopexample.api.dto.SecuredEntityQualifier;

public interface SecuredEntity<ID> {
    SecuredEntityQualifier getQualifier();

    ID getId();
}
