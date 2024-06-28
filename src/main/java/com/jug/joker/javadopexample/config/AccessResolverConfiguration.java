package com.jug.joker.javadopexample.config;

import com.jug.joker.javadopexample.service.resolver.AccessResolver;
import com.jug.joker.javadopexample.service.resolver.RandomAccessResolver;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AccessResolverConfiguration {
    @Bean
    @ConditionalOnProperty(value = "access-resolution", havingValue = "random", matchIfMissing = true)
    AccessResolver accessResolver() {
        return new RandomAccessResolver();
    }
}
