package com.jug.joker.javadopexample.repository;

import com.jug.joker.javadopexample.model.Customer;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface CustomerRepository extends CrudRepository<Customer, UUID>  {
}