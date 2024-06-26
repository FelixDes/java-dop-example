package com.jug.joker.javadopexample;

import org.springframework.ai.autoconfigure.openai.OpenAiAutoConfiguration;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(exclude = OpenAiAutoConfiguration.class)
public class JavaDopExampleApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(JavaDopExampleApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

    }
}
