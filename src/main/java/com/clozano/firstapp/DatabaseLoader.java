package com.clozano.firstapp;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1) // si jamais il y en a un autre, celui ci sera le premier à être executé
public class DatabaseLoader implements CommandLineRunner{

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Database Loader...");
    }

}