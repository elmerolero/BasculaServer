package com.trazoft.Bascula.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.trazoft.Bascula.models.Product;
import java.util.List;


public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByName(String name);
}
