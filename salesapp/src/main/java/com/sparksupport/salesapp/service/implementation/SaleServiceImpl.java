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
    public Sale getSaleById(Long id) throws Exception{
        
        Optional<Sale> saleOptional = saleRepository.findById(id);

        if(saleOptional.isPresent()){
            return saleOptional.get();
        }else{
            throw new Exception("Sale not found");
        }
    }

    @Override
    public Sale addSale(Sale sale) {
        sale = saleRepository.save(sale);

        return sale;
    }

    @Override
    public Sale updateSale(Long id, Sale updatedSale) throws Exception{
        
        Optional<Sale> saleOptional = saleRepository.findById(id);

         if(saleOptional.isPresent()){
            Sale existingSale = saleOptional.get();

            existingSale.setProduct(updatedSale.getProduct() != null ? updatedSale.getProduct() : existingSale.getProduct());
            existingSale.setQuantity(updatedSale.getQuantity() != null ? updatedSale.getQuantity() : existingSale.getQuantity());
            existingSale.setSaleDate(updatedSale.getSaleDate() != null ? updatedSale.getSaleDate() : existingSale.getSaleDate());

            return saleRepository.save(existingSale);
         }else{
            throw new Exception("Failed to update Sale not found ");
         }
    }

    @Override
    public void deleteSale(Long id) throws Exception {
        Optional<Sale> saleOptional = saleRepository.findById(id);

        if(saleOptional.isPresent()){
            saleRepository.deleteById(id);
        }else{
            throw new Exception("Failed to delete product sale not found");
        }
    }

    @Override
    public List<Sale> getProductById(Long productId) throws Exception{
        log.info("Entered sale service getProductById with productId : {}",productId);
        Optional<List<Sale>> saleListOptional = saleRepository.findByProductId(productId);

        if(saleListOptional.isPresent()){
            log.info("returned sales with product id", saleListOptional);
            return saleListOptional.get();
        }else{
            log.info("Sales not found with product id : {}",productId);
            throw new Exception("Sales not found");
        }
    }
    
}
