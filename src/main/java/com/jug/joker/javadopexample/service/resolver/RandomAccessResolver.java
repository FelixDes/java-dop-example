package com.jug.joker.javadopexample.service.resolver;

import com.jug.joker.javadopexample.api.dto.ActionType;
import com.jug.joker.javadopexample.model.SecuredEntity;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;
import java.util.concurrent.ThreadLocalRandom;

public class RandomAccessResolver implements AccessResolver {
    @Override
    public boolean checkAccess(
            SecuredEntity entity,
            ActionType actionType,
            Collection<? extends GrantedAuthority> authorities) {
        return ThreadLocalRandom.current().nextBoolean()
                || ThreadLocalRandom.current().nextBoolean();
    }
}
