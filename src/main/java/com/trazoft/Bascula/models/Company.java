package com.trazoft.Bascula.models;

import java.time.LocalDateTime;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name="company")
public class Company {
    @Id
    @SequenceGenerator(
        name="company_sequence",
        sequenceName = "company_sequence",
        allocationSize = 1
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "company_sequence"
    )
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private LocalDateTime creationDate;
    @Column(nullable = false)
    private LocalDateTime lastUpdateDate;
    @OneToOne(cascade = CascadeType.ALL)
    @Column(nullable = false)
    private User owner;
    @Column(nullable = false)
    private boolean available;
    
    public Company(
        String name,
        LocalDateTime creationDate,
        LocalDateTime lastUpdateDate,
        User owner,
        boolean available 
    ){
        this.name = name;
        this.creationDate = creationDate;
        this.lastUpdateDate = lastUpdateDate;
        this.owner = owner;
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

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Override
    public String toString(){
        return new StringBuilder("Company{")
                    .append("id=").append(id).append(",")
                    .append("name=\"").append(name).append("\",")
                    .append("creationDate=\"").append(creationDate != null ? creationDate.toString() : "").append("\",")
                    .append("lastUpdateDate=\"").append(lastUpdateDate != null ? lastUpdateDate.toString() : "").append("\",")
                    .append("available=").append(available).append("")
                    .append("}").toString();
    }
}