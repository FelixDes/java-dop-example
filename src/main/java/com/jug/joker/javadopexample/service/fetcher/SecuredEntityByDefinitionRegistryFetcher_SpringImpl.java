package com.jug.joker.javadopexample.service.fetcher;

import com.jug.joker.javadopexample.api.dto.definition.EntityDefinition;
import com.jug.joker.javadopexample.model.SecuredEntity;
import com.jug.joker.javadopexample.service.fetcher.spring_way.SecuredEntityFetcherStrategyRegistry;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Primary
@Service
public class SecuredEntityByDefinitionRegistryFetcher_SpringImpl implements SecuredEntityByDefinitionRegistryFetcher {
    private final SecuredEntityFetcherStrategyRegistry registry;

    @Override
    public <T> Optional<? extends SecuredEntity<T>> findEntityByDefinition(EntityDefinition<T> entityDefinition) {
        var fetchStrategy = registry.getStrategy(entityDefinition);
        var id = entityDefinition.getId();
        return fetchStrategy.fetch(id);
    }
}
