package com.jug.joker.javadopexample.repository;

import com.jug.joker.javadopexample.model.entity.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PurchaseRepository extends JpaRepository<Purchase, Long> {
}