package com.sparksupport.salesapp.service;

import java.util.List;

import com.sparksupport.salesapp.domain.Product;

public interface ProductService {

    public List<Product> getAllProducts() ;

    public Product getProductById(Long id) ;

    public void addProduct(Product product) ;

    public void updateProduct(Long id, Product updatedProduct) ;

    public void deleteProduct(Long id) ;
    public double getRevenueByProduct(Long productId);
    public double getTotalRevenue() ;
}
