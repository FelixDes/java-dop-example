package com.jug.joker.javadopexample.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
public non-sealed class Purchase extends SecuredEntity<Long> {
    @Column(name = "name", nullable = false)
    private String name;

    @ToString.Exclude
    @ManyToMany(mappedBy = "purchases", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
    private Set<Customer> customers = new LinkedHashSet<>();

    @ToString.Exclude
    @OneToMany(mappedBy = "purchase", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
    private Set<PurchasePart> purchaseParts = new LinkedHashSet<>();

}
    