package com.jug.joker.javadopexample.service.resolver;

import com.jug.joker.javadopexample.api.dto.ActionType;
import com.jug.joker.javadopexample.model.SecuredEntity;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

@FunctionalInterface
public interface AccessResolver {
    boolean checkAccess(
            SecuredEntity entity,
            ActionType actionType,
            Collection<? extends GrantedAuthority> authorities
    );
}
