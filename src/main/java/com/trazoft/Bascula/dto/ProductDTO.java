package com.trazoft.Bascula.dto;

import jakarta.validation.constraints.NotBlank;

public class ProductDTO {
    @NotBlank(message="product_name_mandatory")
    private String name;
    private String description;

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
}
