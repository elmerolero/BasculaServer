package com.trazoft.Bascula.models;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name="product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true, length = 300)
    private String name;
    @Column(nullable = false)
    private String description;
    private LocalDateTime creationDate;
    private LocalDateTime lastUpdateDate;
    private boolean available;

    public Product() {}

    public Product(
        String name, 
        String description, 
        LocalDateTime creationDate, 
        LocalDateTime lastUpdateDate, 
        boolean available ){
        this.name = name;
        this.description = description;
        this.creationDate = creationDate;
        this.lastUpdateDate = lastUpdateDate;
        this.available = available;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public LocalDateTime getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(LocalDateTime lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }
    
    public void setAvailable(boolean available) {
        this.available = available;
    }

    public boolean isAvailable() {
        return this.available;
    }

    @Override
    public String toString(){
        return "Product{" +
                    "id=" + id + "," +
                    "name=\"" + name + "\"," +
                    "description=\"" + description + "\"," +
                    "creationDate=\"" + creationDate.toString() + "\"," +
                    "lastUpdateDate=\"" + lastUpdateDate.toString() + "\"" +
                    "available=\"" + available + "\"" +
               "}";
    }
}
