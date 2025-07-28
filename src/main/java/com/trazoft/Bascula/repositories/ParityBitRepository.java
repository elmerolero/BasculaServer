package com.trazoft.Bascula.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.trazoft.Bascula.models.Parity;

public interface ParityBitRepository extends JpaRepository<Parity, Long> {
    
}
