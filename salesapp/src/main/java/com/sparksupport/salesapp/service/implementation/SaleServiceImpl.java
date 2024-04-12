package com.sparksupport.salesapp.service.implementation;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sparksupport.salesapp.domain.Sale;
import com.sparksupport.salesapp.repository.SaleRepository;
import com.sparksupport.salesapp.service.SaleService;

@Service
public class SaleServiceImpl implements SaleService{


    private final SaleRepository saleRepository;

    public SaleServiceImpl(SaleRepository saleRepository){
        this.saleRepository = saleRepository;
    }

    @Override
    public List<Sale> getAllSales() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAllSales'");
    }

    @Override
    public Sale getSaleById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getSaleById'");
    }

    @Override
    public Sale addSale(Sale sale) {
        sale = saleRepository.save(sale);

        return sale;
    }

    @Override
    public Sale updateSale(Long id, Sale updatedSale) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateSale'");
    }

    @Override
    public void deleteSale(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteSale'");
    }
    
}
