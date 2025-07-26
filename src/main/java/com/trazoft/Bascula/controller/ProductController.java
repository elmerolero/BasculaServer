package com.trazoft.Bascula.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDateTime;
import java.util.List;
import com.trazoft.Bascula.models.Product;
import com.trazoft.Bascula.repositories.ProductRepository;
import jakarta.persistence.Entity;

@Entity
@RestController
@RequestMapping(path="/api/Products")
public class ProductController {
    @Autowired 
    private ProductRepository repository;

    @GetMapping("")
    List<Product> getAll() {
        return repository.findAll();
    }
    
}
