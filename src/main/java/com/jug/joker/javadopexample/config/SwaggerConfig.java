package com.jug.joker.javadopexample.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import org.springframework.context.annotation.Configuration;

import static io.swagger.v3.oas.annotations.enums.SecuritySchemeType.HTTP;

@Configuration
@OpenAPIDefinition(
        info = @Info(title = "Composite access resolver api")
)
@SecurityScheme(
        type = HTTP,
        name = "basicAuth",
        scheme = "basic"
)
public class SwaggerConfig {
}
