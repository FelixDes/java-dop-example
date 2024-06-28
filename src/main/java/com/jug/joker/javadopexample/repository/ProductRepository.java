package com.jug.joker.javadopexample.repository;

import com.jug.joker.javadopexample.model.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {
}