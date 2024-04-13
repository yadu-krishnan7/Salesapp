package com.sparksupport.salesapp.web;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sparksupport.salesapp.domain.Sale;
import com.sparksupport.salesapp.exception.BadRequestAlertException;
import com.sparksupport.salesapp.service.SaleService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/sales")
public class SaleController {
    

    private final SaleService saleService;

    public SaleController(SaleService saleService){
        this.saleService = saleService;
    }

    @GetMapping
    public ResponseEntity<?> getAllSales() {
        log.info("Request received to fetch all sales");
        List<Sale> sales = saleService.getAllSales();
        return new ResponseEntity<>(sales, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getSaleById(@PathVariable Long id) {
        log.info("Request received to fetch sale by id: {}", id);
        try{
        Sale sale = saleService.getSaleById(id);
       
            return new ResponseEntity<>(sale, HttpStatus.OK);
        } catch(Exception e) {
            log.error("Error occurred while fetching sale with id: {}", id, e);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Sale not found with this sale id");
        }
    }

    @PostMapping
    public ResponseEntity<?> addSale(@RequestBody Sale sale) {
        log.info("Request received to add a new sale");
        if(sale.getId() != null){
            log.warn("New sale request contains an Id, ignoring the provided Id");
            throw new BadRequestAlertException("New sale Already have an Id");
        }

        sale = saleService.addSale(sale);
        log.info("New sale added successfully with Id: {}", sale.getId());
        return ResponseEntity.status(HttpStatus.CREATED).body(sale);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateSale(@PathVariable Long id, @RequestBody Sale updatedSale) {
        log.info("Request received to update sale with id: {}", id);
       try {
            Sale sale = saleService.updateSale(id, updatedSale);
            log.info("Sale updated successfully with id: {}", id);
            return new ResponseEntity<>(sale,HttpStatus.OK);
        } catch(Exception e) {
            log.error("Error occurred while updating sale with id: {}", id, e);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Sale not found for updation");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteSale(@PathVariable Long id) {
        log.info("Request received to delete sale with id: {}", id);
       try {
            saleService.deleteSale(id);
            log.info("Sale deleted successfully with id: {}", id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch(Exception e) {
            log.error("Error occurred while deleting sale with id: {}", id, e);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Sale not found for deletion");
        }
    }
}
