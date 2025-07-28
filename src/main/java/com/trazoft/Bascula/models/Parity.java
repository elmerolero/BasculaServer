package com.trazoft.Bascula.models;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name="parity")
public class Parity {
    @Id
    @SequenceGenerator(
        name = "parity_sequence",
        sequenceName = "parity_sequence",
        allocationSize = 1
    )
    @GeneratedValue(
        strategy= GenerationType.SEQUENCE,
        generator = "parity_sequence"
    )
    private Long id;
    private String name;
    private LocalDateTime creationDate;
    private LocalDateTime lastUpdateDate;
    private boolean available;

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

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Override
    public String toString(){
        return new StringBuilder("Parity{")
                    .append("id=").append(id).append(",")
                    .append("name=\"").append(name).append("\",")
                    .append("creationDate=\"").append(creationDate != null ? creationDate.toString() : "").append("\",")
                    .append("lastUpdateDate=\"" ).append(lastUpdateDate != null ? lastUpdateDate.toString() : "").append("\",")
                    .append("available=").append(available).append(",")
                    .append("}").toString();
    }
}
