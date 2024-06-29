package com.jug.joker.javadopexample.service;

import com.jug.joker.javadopexample.api.dto.AccessCheckRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.function.Predicate;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class CompositeAccessResolutionService {
    private final EntityWalkerService<Boolean> entityWalkerService;
    private final SecuredEntityByDefinitionRegistryFetcher entityFetcher;
    private final MapperResolverService mapperResolver;

    public boolean checkAccess(AccessCheckRequest accessCheckRequest) {
        // Build mapper
        var accessType = accessCheckRequest.actionType();
        var authorities = SecurityContextHolder.getContext().getAuthentication().getAuthorities();
        var mapper = mapperResolver.getMapperByAccessTypeAndRoleSet(accessType, authorities);
        // Fetch entity
        var entityDefinition = accessCheckRequest.entityDefinition();
        var rootEntity = entityFetcher.findEntityByDefinition(entityDefinition).orElseThrow();
        // Process the entity tree
        return entityWalkerService
                .processEntityTree(rootEntity, mapper)
                .stream()
                // If all entities down the tree are accessible -> root accessible
                .allMatch(Predicate.isEqual(true));
    }
}
