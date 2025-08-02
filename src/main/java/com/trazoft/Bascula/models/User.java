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
@Table(name="user")
public class User {
    @Id
    @SequenceGenerator(
        name="user_sequence",
        sequenceName = "user_sequence",
        allocationSize = 1
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "user_sequence"
    )
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(unique = true, nullable = false)
    private String email;
    @Column(nullable = false)
    private LocalDateTime registrationDate;
    @Column(nullable = false)
    private LocalDateTime lastUpdateDate;
    @Column(nullable = false)
    private boolean available;

    public User(
        String name,
        String email,
        LocalDateTime registrationDate,
        LocalDateTime lastUpdateDate,
        boolean available
    ){
        this.name = name;
        this.email = email;
        this.registrationDate = registrationDate;
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
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDateTime getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDateTime registrationDate) {
        this.registrationDate = registrationDate;
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
        return new StringBuilder("User{")
                    .append("id=").append(id).append(",")
                    .append("name=\"").append(name).append("\",")
                    .append("email=\"").append(email).append("\",")
                    .append("registrationDate=\"").append(registrationDate != null ? registrationDate.toString() : "").append("\",")
                    .append("lastUpdateDate=\"").append(lastUpdateDate != null ? lastUpdateDate.toString() : "").append("\",")
                    .append("available=").append(available).append("")
                    .append("}").toString();
    }
}
