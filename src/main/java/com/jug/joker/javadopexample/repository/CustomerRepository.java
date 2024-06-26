package com.jug.joker.javadopexample.repository;

import com.jug.joker.javadopexample.model.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}