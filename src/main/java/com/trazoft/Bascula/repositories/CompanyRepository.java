package com.trazoft.Bascula.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.trazoft.Bascula.models.Company;

public interface CompanyRepository extends JpaRepository<Company, Long>{
    
}
