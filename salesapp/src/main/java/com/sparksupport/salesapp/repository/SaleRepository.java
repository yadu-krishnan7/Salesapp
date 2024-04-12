package com.sparksupport.salesapp.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sparksupport.salesapp.domain.Sale;

@Repository
public interface SaleRepository extends JpaRepository<Sale,Long>{
    Optional<List<Sale>> findByProductId(Long productId);
}
