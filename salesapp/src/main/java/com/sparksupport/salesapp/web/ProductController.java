package com.sparksupport.salesapp.web;


import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sparksupport.salesapp.domain.Product;
import com.sparksupport.salesapp.exception.BadRequestAlertException;
import com.sparksupport.salesapp.service.ProductService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/products")
public class ProductController {
    

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<?> getAllProducts(@RequestParam(defaultValue = "0") int page,
    @RequestParam(defaultValue = "10") int size,
    @RequestParam(defaultValue = "name") String sort) {
        log.info("Entered product controller to fetch all the product");

        Pageable pageable = PageRequest.of(page, size, Sort.by(sort));
        return ResponseEntity.ok(productService.getAllProducts(pageable));
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('ROLE_USER')") 
    public ResponseEntity<?> getProductById(@PathVariable Long id) {
        log.info("Entered product controller getProductById with : {}",id);
        try{
            Product product = productService.getProductById(id);
            return ResponseEntity.ok(product);
        } catch(Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found");
        }
    }

    @PostMapping
    public ResponseEntity<?> addProduct(@RequestBody Product product) {
         log.info("Entered product controller addProduct with : {}",product);
        if(product.getId() != null){
            throw new BadRequestAlertException("A new appUser cannot already have an ID");
        }
       product = productService.addProduct(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(product);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateProduct(@PathVariable Long id, @RequestBody Product product) {

        log.info("Entered product controller updateProduct with : {} ",id);

       try{
        product = productService.updateProduct(id, product);
        return ResponseEntity.ok("Product updated successfully " + product);
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found for updation");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable Long id) {
        log.info("Entered product controller deleteProduct with : {} ",id);

      try{
        productService.deleteProduct(id);
        return ResponseEntity.ok("Product deleted successfully");
      }catch(Exception e){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found for deletion");
    }
        
    }

    @GetMapping("/revenue")
    public ResponseEntity<Double> getTotalRevenue() {
        log.info("Entered product controller getTotalRevenue to fetch the total revenue");
 
        double totalRevenue = productService.getTotalRevenue();
        return ResponseEntity.ok(totalRevenue);
       
    }

    @GetMapping("/revenue/{id}")
    public ResponseEntity<?> getRevenueByProduct(@PathVariable Long id) {
        try{
            log.info("Entered getRevenueByProduct with productid : {}",id);
        double productRevenue = productService.getRevenueByProduct(id);
        return ResponseEntity.ok(productRevenue);
    }catch(Exception e){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found");
    }
    }
}
