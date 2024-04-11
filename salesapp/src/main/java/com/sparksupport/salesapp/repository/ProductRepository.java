package com.sparksupport.salesapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sparksupport.salesapp.domain.Product;

public interface ProductRepository extends JpaRepository<Product,Long>{

    
} 
