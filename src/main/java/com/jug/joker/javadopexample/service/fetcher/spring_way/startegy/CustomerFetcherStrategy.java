package com.jug.joker.javadopexample.service.fetcher.spring_way.startegy;

import com.jug.joker.javadopexample.api.dto.definition.CustomerDefinition;
import com.jug.joker.javadopexample.api.dto.definition.EntityDefinition;
import com.jug.joker.javadopexample.model.Customer;
import com.jug.joker.javadopexample.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class CustomerFetcherStrategy implements SecuredEntityFetcherStrategy<Customer, UUID> {
    private final CustomerRepository customerRepository;

    @Override
    public Class<? extends EntityDefinition<UUID>> getKey() {
        return CustomerDefinition.class;
    }

    @Override
    public Optional<Customer> fetch(UUID uuid) {
        return customerRepository.findById(uuid);
    }
}
