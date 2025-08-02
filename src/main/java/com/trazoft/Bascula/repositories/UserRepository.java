package com.trazoft.Bascula.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.trazoft.Bascula.models.User;

public interface UserRepository extends JpaRepository<User, Long> {
    
}
