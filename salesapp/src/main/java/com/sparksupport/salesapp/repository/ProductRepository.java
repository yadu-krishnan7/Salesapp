package com.sparksupport.salesapp.repository;

import java.util.List;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.sparksupport.salesapp.domain.Product;

public interface ProductRepository extends PagingAndSortingRepository<Product,Long>{

     List<Product> findAll(Pageable pageable);
} 
