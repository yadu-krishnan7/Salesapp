package com.sparksupport.salesapp.service;

import java.util.List;

import com.sparksupport.salesapp.domain.Sale;

public interface SaleService {


    public List<Sale> getAllSales() ;

    public Sale getSaleById(Long id) throws Exception;

    public Sale addSale(Sale sale) ;

    public Sale updateSale(Long id, Sale updatedSale) throws Exception;

    public void deleteSale(Long id) throws Exception;

    public List<Sale> getProductById(Long productId) throws Exception;
    
} 