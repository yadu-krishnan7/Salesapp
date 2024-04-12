package com.sparksupport.salesapp.service;

import java.util.List;

import com.sparksupport.salesapp.domain.Sale;

public interface SaleService {


    public List<Sale> getAllSales() ;

    public Sale getSaleById(Long id) ;

    public void addSale(Sale sale) ;

    public void updateSale(Long id, Sale updatedSale) ;

    public void deleteSale(Long id) ;
    
} 