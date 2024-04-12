package com.sparksupport.salesapp.service;

import java.util.List;

import com.sparksupport.salesapp.domain.Product;

public interface ProductService {

    public List<Product> getAllProducts() ;

    public Product getProductById(Long id) throws Exception;

    public Product addProduct(Product product) ;

    public Product updateProduct(Long id, Product updatedProduct) throws Exception;

    public void deleteProduct(Long id) throws Exception ;
    public double getRevenueByProduct(Long productId) throws Exception;
    public double getTotalRevenue() ;
}
