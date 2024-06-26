package com.jug.joker.javadopexample.model.entity;

import jakarta.persistence.MappedSuperclass;
import org.springframework.data.jpa.domain.AbstractPersistable;

import java.io.Serializable;

@MappedSuperclass
public abstract sealed class SecuredEntity<ID extends Serializable>
        extends AbstractPersistable<ID>
        permits
        Customer,
        Purchase,
        PurchasePart {
}
    