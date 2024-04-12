package com.sparksupport.salesapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sparksupport.salesapp.domain.Sale;

@Repository
public interface SaleRepository extends JpaRepository<Sale,Long>{
    
}
