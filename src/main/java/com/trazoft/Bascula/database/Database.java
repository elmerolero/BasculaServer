package com.trazoft.Bascula.database;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.time.LocalDateTime;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.trazoft.Bascula.models.Product;
import com.trazoft.Bascula.repositories.ProductRepository;

@Configuration
public class Database {
    // Logger
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(Database.class);
    @Bean
    CommandLineRunner initDatabase(ProductRepository productRepository){
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                Product productA = new Product("MacBook Pro 16", "Apple computer", LocalDateTime.now(), LocalDateTime.now());
                Product productB = new Product("iPhone 13", "Apple telephone", LocalDateTime.now(), LocalDateTime.now());
                logger.info("Insert data: " + productRepository.save(productA));
                logger.info("Inser data: " + productRepository.save(productB));
            }
        };
    }
}
