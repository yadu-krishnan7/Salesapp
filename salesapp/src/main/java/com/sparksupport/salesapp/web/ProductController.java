package com.sparksupport.salesapp.web;

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
import org.springframework.web.bind.annotation.RestController;

import com.sparksupport.salesapp.domain.Product;
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
    public ResponseEntity<?> getAllProducts() {
        return ResponseEntity.ok(productService.getAllProducts());
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('ROLE_USER')") 
    public ResponseEntity<?> getProductById(@PathVariable Long id) {
        log.info("Entered getProductById with : {}",id);
        Product product = productService.getProductById(id);
        if (product != null) {
            return ResponseEntity.ok(product);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found");
        }
    }

    @PostMapping
    public ResponseEntity<?> addProduct(@RequestBody Product product) {
        productService.addProduct(product);
        return ResponseEntity.status(HttpStatus.CREATED).body("Product added successfully");
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateProduct(@PathVariable Long id, @RequestBody Product product) {
        productService.updateProduct(id, product);
        return ResponseEntity.ok("Product updated successfully");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return ResponseEntity.ok("Product deleted successfully");
    }

    @GetMapping("/revenue")
    public ResponseEntity<Double> getTotalRevenue() {
        double totalRevenue = productService.getTotalRevenue();
        return ResponseEntity.ok(totalRevenue);
    }

    @GetMapping("/revenue/{id}")
    public ResponseEntity<Double> getRevenueByProduct(@PathVariable Long id) {
        double productRevenue = productService.getRevenueByProduct(id);
        return ResponseEntity.ok(productRevenue);
    }
}
