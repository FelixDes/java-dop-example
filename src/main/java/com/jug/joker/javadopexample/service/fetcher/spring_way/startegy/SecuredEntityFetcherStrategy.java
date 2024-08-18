package com.jug.joker.javadopexample.service.fetcher.spring_way.startegy;

import com.jug.joker.javadopexample.api.dto.definition.EntityDefinition;
import com.jug.joker.javadopexample.model.SecuredEntity;
import com.jug.joker.javadopexample.service.fetcher.spring_way.SecuredEntityFetcherStrategyRegistry;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public interface SecuredEntityFetcherStrategy<ENTITY extends SecuredEntity<ID>, ID> {
    Class<? extends EntityDefinition<ID>> getKey();

    Optional<ENTITY> fetch(ID id); // delegation

    @Autowired
    default void register(SecuredEntityFetcherStrategyRegistry registry) {
        registry.register(this);
    }
}
