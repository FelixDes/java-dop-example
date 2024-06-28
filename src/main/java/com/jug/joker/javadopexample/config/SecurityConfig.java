package com.jug.joker.javadopexample.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@EnableWebSecurity
@Configuration
public class SecurityConfig {
    @Bean
    public SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        return http
                .httpBasic(withDefaults())
                .cors(withDefaults())
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(authorize ->
                        authorize
                                .requestMatchers(
                                        "/swagger-ui/**",
                                        "/swagger-ui.html",
                                        "/v3/api-docs/**"
                                )
                                .permitAll()
                                .anyRequest()
                                .authenticated()
                ).build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails admin = User.builder()
                .username("admin")
                .password("{noop}admin")
                .roles("ADMIN")
                .build();

        UserDetails lessPrivileged = User.builder()
                .username("user")
                .password("{noop}admin")
                .build();

        UserDetails productServiceAccount = User.builder()
                .username("PRODUCT_SERVICE_ACCOUNT")
                .password("{noop}admin")
                .roles("PRODUCT_AND_BELOW")
                .build();

        UserDetails crmServiceAccount = User.builder()
                .username("CRM_SERVICE_ACCOUNT")
                .password("{noop}admin")
                .roles("CUSTOMER")
                .build();

        return new InMemoryUserDetailsManager(
                admin,
                lessPrivileged,
                productServiceAccount,
                crmServiceAccount
        );
    }
}
    