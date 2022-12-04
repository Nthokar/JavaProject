package com.example.javaproject;

import Repos.DbManager;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class JavaProjectApplication {


    public static void main(String[] args) {
        SpringApplication.run(JavaProjectApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository){
        return args -> {
            new DbManager(repository).foo();
        };
    }
}
