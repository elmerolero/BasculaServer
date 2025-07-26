package com.trazoft.Bascula.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.trazoft.Bascula.models.Product;
import jakarta.persistence.Entity;

@Entity
public interface ProductRepository extends JpaRepository<Product, Long> {
    
}
