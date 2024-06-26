package com.jug.joker.javadopexample;

import org.springframework.boot.SpringApplication;

public class TestJavaDopExampleApplication {

    public static void main(String[] args) {
        SpringApplication.from(JavaDopExampleApplication::main).with(TestcontainersConfiguration.class).run(args);
    }

}
