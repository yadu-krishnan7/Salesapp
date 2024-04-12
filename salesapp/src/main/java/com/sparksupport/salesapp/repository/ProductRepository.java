package com.sparksupport.salesapp.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.sparksupport.salesapp.domain.Product;

@Repository
public interface ProductRepository extends PagingAndSortingRepository<Product,Long>,CrudRepository<Product,Long>{

} 
