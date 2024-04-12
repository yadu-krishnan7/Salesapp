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
import com.sparksupport.salesapp.service.SaleService;

@RestController
@RequestMapping("/api/sales")
public class SaleController {
    

    private final SaleService saleService;

    public SaleController(SaleService saleService){
        this.saleService = saleService;
    }

    @GetMapping
    public ResponseEntity<?> getAllSales() {
        List<Sale> sales = saleService.getAllSales();
        return new ResponseEntity<>(sales, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getSaleById(@PathVariable Long id) {
        try{
        Sale sale = saleService.getSaleById(id);
       
            return new ResponseEntity<>(sale, HttpStatus.OK);
        } catch(Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Sale not found with this sale id");
        }
    }

    @PostMapping
    public ResponseEntity<?> addSale(@RequestBody Sale sale) {
        sale = saleService.addSale(sale);
        return ResponseEntity.status(HttpStatus.CREATED).body(sale);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateSale(@PathVariable Long id, @RequestBody Sale updatedSale) {
       try {
            Sale sale = saleService.updateSale(id, updatedSale);
            return new ResponseEntity<>(sale,HttpStatus.OK);
        } catch(Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Sale not found for updation");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteSale(@PathVariable Long id) {
       try {
            saleService.deleteSale(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch(Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Sale not found for deletion");
        }
    }
}
