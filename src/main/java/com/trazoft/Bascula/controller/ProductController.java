package com.trazoft.Bascula.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import com.trazoft.Bascula.dto.ProductDTO;
import com.trazoft.Bascula.models.Product;
import com.trazoft.Bascula.models.ResponseObject;
import com.trazoft.Bascula.repositories.ProductRepository;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
@RequestMapping(path="/api/Products")
public class ProductController {
    @Autowired 
    private ProductRepository repository;

    @GetMapping("/")
    List<Product> getAll() {
        return repository.findAll();
    }
    
    @GetMapping("/{id}")
    ResponseEntity<ResponseObject> getById(@PathVariable Long id) {
        Optional<Product> product = repository.findById(id);
        if(!product.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                new ResponseObject(false, "product_not_found_error", product)
            );
        }

        return ResponseEntity.status(HttpStatus.OK).body(
            new ResponseObject(true, "", product)
        );
    }

    @PostMapping("/add")
    ResponseEntity<ResponseObject> add(@Valid @RequestBody ProductDTO product){
        List<Product> existingProducts = repository.findByName(product.getName().trim());
        if(!existingProducts.isEmpty()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                new ResponseObject(false, "product_exist_error", "")
            );
        }

        // Creates a new object saves it and finish
        Product newProduct = new Product(product.getName(), product.getDescription(), LocalDateTime.now(), LocalDateTime.now());
        return ResponseEntity.status(HttpStatus.OK).body(
            new ResponseObject(true, "", repository.save(newProduct))
        );
    }
    
    @PutMapping("/update/{id}")
    ResponseEntity<ResponseObject> update(@PathVariable long id, @RequestBody ProductDTO productToUpdate) {
        Optional<Product> updatedProduct = repository.findById(id).map( product -> {
            product.setName(productToUpdate.getName());
            product.setDescription(productToUpdate.getDescription());
            product.setLastUpdateDate(LocalDateTime.now());
            return repository.save(product);
        });

        if(updatedProduct.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                new ResponseObject(false, "product_not_found_error", "")
            );
        }

        return ResponseEntity.status(HttpStatus.OK).body(
            new ResponseObject(true, "", updatedProduct)
        );
    }
}
