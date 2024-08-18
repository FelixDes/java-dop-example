package com.jug.joker.javadopexample.service.fetcher;

import com.jug.joker.javadopexample.api.dto.definition.EntityDefinition;
import com.jug.joker.javadopexample.model.SecuredEntity;

import java.util.Optional;

public interface SecuredEntityByDefinitionRegistryFetcher {
    <T> Optional<? extends SecuredEntity<T>> findEntityByDefinition(EntityDefinition<T> entityDefinition);
}
