package com.trazoft.Bascula.models;

import java.time.LocalDateTime;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class Product {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String name;
    private String description;
    private LocalDateTime creationDate;
    private LocalDateTime lastUpdateDate;

    public Product() {}

    public Product(String name, String description, LocalDateTime creationDate, LocalDateTime lastUpdateDate ){
        this.name = name;
        this.description = description;
        this.creationDate = creationDate;
        this.lastUpdateDate = lastUpdateDate;
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

    @Override
    public String toString(){
        return "Product{" +
                    "id=" + id + "," +
                    "name=\"" + name + "\"," +
                    "description=\"" + description + "\"," +
                    "creationDate=\"" + creationDate.toString() + "\"," +
                    "lastUpdateDate=\"" + lastUpdateDate.toString() + "\"" +
               "}";
    }
}
