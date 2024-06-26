package com.jug.joker.javadopexample.repository;

import com.jug.joker.javadopexample.model.entity.PurchasePart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PurchasePartRepository extends JpaRepository<PurchasePart, Long> {
}