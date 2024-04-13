package com.sparksupport.salesapp.service.implementation;

import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    @Transactional(readOnly = true)
    public List<Sale> getAllSales() {
        log.info("Fetching all sales");
        return saleRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Sale getSaleById(Long id) throws Exception{
        log.info("Fetching sale by id: {}", id);
        Optional<Sale> saleOptional = saleRepository.findById(id);

        if(saleOptional.isPresent()){
            return saleOptional.get();
        }else{
            log.error("Sale not found with id: {}", id);
            throw new Exception("Sale not found");
        }
    }

    @Override
    public Sale addSale(Sale sale) {
        log.info("Adding new sale");
        sale.setSaleDate(Date.from(Instant.now()));
        sale = saleRepository.save(sale);

        return sale;
    }

    @Override
    public Sale updateSale(Long id, Sale updatedSale) throws Exception{
        log.info("Updating sale with id: {}", id);
        Optional<Sale> saleOptional = saleRepository.findById(id);

         if(saleOptional.isPresent()){
            Sale existingSale = saleOptional.get();

            existingSale.setProduct(updatedSale.getProduct() != null ? updatedSale.getProduct() : existingSale.getProduct());
            existingSale.setQuantity(updatedSale.getQuantity() != null ? updatedSale.getQuantity() : existingSale.getQuantity());
            existingSale.setSaleDate(updatedSale.getSaleDate() != null ? updatedSale.getSaleDate() : Date.from(Instant.now()));

            return saleRepository.save(existingSale);
         }else{
            log.error("Failed to update sale. Sale not found with id: {}", id);
            throw new Exception("Failed to update Sale not found ");
         }
    }

    @Override
    public void deleteSale(Long id) throws Exception {
        log.info("Deleting sale with id: {}", id);
        Optional<Sale> saleOptional = saleRepository.findById(id);

        if(saleOptional.isPresent()){
            saleRepository.deleteById(id);
        }else{
            log.error("Failed to delete sale. Sale not found with id: {}", id);
            throw new Exception("Failed to delete product sale not found");
        }
    }

    @Override
    @Transactional(readOnly = true)
    public List<Sale> getProductById(Long productId) throws Exception{
        log.info("Fetching sales by product id: {}", productId);
        Optional<List<Sale>> saleListOptional = saleRepository.findByProductId(productId);

        if(saleListOptional.isPresent()){
            log.info("Returned sales with product id: {}", productId);
            return saleListOptional.get();
        }else{
            log.error("Sales not found with product id: {}", productId);
            throw new Exception("Sales not found");
        }
    }
    
}
