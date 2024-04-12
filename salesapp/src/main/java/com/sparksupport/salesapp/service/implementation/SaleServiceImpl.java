package com.sparksupport.salesapp.service.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sparksupport.salesapp.domain.Sale;
import com.sparksupport.salesapp.repository.SaleRepository;
import com.sparksupport.salesapp.service.SaleService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class SaleServiceImpl implements SaleService{


    private final SaleRepository saleRepository;

    public SaleServiceImpl(SaleRepository saleRepository){
        this.saleRepository = saleRepository;
    }

    @Override
    public List<Sale> getAllSales() {
        return saleRepository.findAll();
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

    @Override
    public List<Sale> getProductById(Long productId) {
        log.info("Entered sale service getProductById with productId : {}",productId);
        Optional<List<Sale>> saleListOptional = saleRepository.findByProductId(productId);

        if(saleListOptional.isPresent()){
            log.info("returned sales with product id", saleListOptional);
            return saleListOptional.get();
        }else{
            log.info("returned null");
            return null;
        }
    }
    
}
