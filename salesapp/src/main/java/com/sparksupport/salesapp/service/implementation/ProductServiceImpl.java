package com.sparksupport.salesapp.service.implementation;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sparksupport.salesapp.domain.Product;
import com.sparksupport.salesapp.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{

    @Override
    public List<Product> getAllProducts() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAllProducts'");
    }

    @Override
    public Product getProductById(Long id) {

        Product product = new Product();
        product.setDescription("super");
        return product;
    }

    @Override
    public void addProduct(Product product) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addProduct'");
    }

    @Override
    public void updateProduct(Long id, Product updatedProduct) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateProduct'");
    }

    @Override
    public void deleteProduct(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteProduct'");
    }

    @Override
    public double getRevenueByProduct(Long productId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getRevenueByProduct'");
    }

    @Override
    public double getTotalRevenue() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getTotalRevenue'");
    }
    
}
