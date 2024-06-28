package com.jug.joker.javadopexample.repository;

import com.jug.joker.javadopexample.model.Purchase;
import org.springframework.data.repository.CrudRepository;

public interface PurchaseRepository extends CrudRepository<Purchase, Long> {
}