package com.jug.joker.javadopexample.service.fetcher.spring_way;

import com.jug.joker.javadopexample.api.dto.definition.EntityDefinition;
import com.jug.joker.javadopexample.service.fetcher.spring_way.startegy.SecuredEntityFetcherStrategy;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class SecuredEntityFetcherStrategyRegistry {
    private final Map<
            Class<? extends EntityDefinition<?>>,
            SecuredEntityFetcherStrategy<?, ?>
            > strategies = new HashMap<>();

    public void register(SecuredEntityFetcherStrategy<?, ?> strategy) {
        if (strategies.containsKey(strategy.getKey())) {
            throw new IllegalStateException("This strategy already exist in registry");
        } else {
            strategies.put(strategy.getKey(), strategy);
        }
    }

    public <T> SecuredEntityFetcherStrategy<?, T> getStrategy(EntityDefinition<T> definition) {
        return (SecuredEntityFetcherStrategy<?, T>) strategies.get(definition.getClass());
    }
}
