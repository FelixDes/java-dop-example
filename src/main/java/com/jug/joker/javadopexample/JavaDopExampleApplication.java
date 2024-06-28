package com.jug.joker.javadopexample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;

@EnableJdbcRepositories
@SpringBootApplication
public class JavaDopExampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(JavaDopExampleApplication.class, args);
    }
}
