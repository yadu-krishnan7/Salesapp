package com.sparksupport.salesapp.service.implementation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.sparksupport.salesapp.domain.Product;
import com.sparksupport.salesapp.repository.ProductRepository;
import com.sparksupport.salesapp.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{


    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository){
        this.productRepository = productRepository;
    }
    @Override
    public List<Product> getAllProducts() {
        
         Iterable<Product> iterableProducts = productRepository.findAll(Sort.by("name"));

         List<Product> productList = new ArrayList<>();

         iterableProducts.forEach(productList::add);

         return productList;
    }

    @Override
    public Product getProductById(Long id) {

        Product product = new Product();
        product.setDescription("super");
        return product;
    }

    @Override
    public Product addProduct(Product product) {
         product  = productRepository.save(product);

         return product;
       
    }

    @Override
    public Product updateProduct(Long id, Product updatedProduct) {
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
