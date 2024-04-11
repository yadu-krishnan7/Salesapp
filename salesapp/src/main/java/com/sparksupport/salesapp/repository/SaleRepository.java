package com.sparksupport.salesapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sparksupport.salesapp.domain.Sale;

public interface SaleRepository extends JpaRepository<Sale,Long>{
    
}
