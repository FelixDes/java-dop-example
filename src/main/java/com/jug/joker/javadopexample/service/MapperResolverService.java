package com.jug.joker.javadopexample.service;

import com.jug.joker.javadopexample.api.dto.ActionType;
import com.jug.joker.javadopexample.model.SecuredEntity;
import com.jug.joker.javadopexample.service.resolver.AccessResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.function.Function;

@RequiredArgsConstructor
@Service
public class MapperResolverService {
    private final AccessResolver accessResolver;

    public Function<SecuredEntity, Boolean> getMapperByAccessTypeAndRoleSet(
            ActionType actionType,
            Collection<? extends GrantedAuthority> authorities) {
        return (entity) -> accessResolver.checkAccess(entity, actionType, authorities);
    }
}
