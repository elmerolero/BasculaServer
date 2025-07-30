package com.trazoft.Bascula.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.trazoft.Bascula.models.WeightMachine;

public interface WeightMachineRepository extends JpaRepository<WeightMachine, Long>{
    
}
