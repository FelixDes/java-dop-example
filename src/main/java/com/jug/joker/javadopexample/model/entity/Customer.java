package com.jug.joker.javadopexample.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
public non-sealed class Customer extends SecuredEntity<Long> {
    @Column(name = "name", nullable = false)
    private String name;
}
    