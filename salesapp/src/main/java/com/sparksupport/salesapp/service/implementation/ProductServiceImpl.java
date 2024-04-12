package com.sparksupport.salesapp.service.implementation;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.sparksupport.salesapp.domain.Product;
import com.sparksupport.salesapp.domain.Sale;
import com.sparksupport.salesapp.repository.ProductRepository;
import com.sparksupport.salesapp.service.ProductService;
import com.sparksupport.salesapp.service.SaleService;

import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ProductServiceImpl implements ProductService{


    private final ProductRepository productRepository;
    private final SaleService saleService;

    public ProductServiceImpl(ProductRepository productRepository,SaleService saleService){
        this.productRepository = productRepository;
        this.saleService = saleService;
    }
    @Override
    public List<Product> getAllProducts() {
        
         Iterable<Product> iterableProducts = productRepository.findAll(Sort.by("name"));

         List<Product> productList = new ArrayList<>();

         iterableProducts.forEach(productList::add);

         return productList;
    }

    @Override
    public Product getProductById(Long id) throws Exception{

        Optional<Product> productOptional = productRepository.findById(id);

        if(productOptional.isPresent()){
        return productOptional.get();
        }else{
            
             throw new Exception("Product not found");
        }
    }

    @Override
    public Product addProduct(Product product) {
         product  = productRepository.save(product);

         return product;
       
    }

    @Override
    public Product updateProduct(Long id, Product updatedProduct) throws Exception{
       
        Optional<Product> productOptional = productRepository.findById(id);

        if(productOptional.isPresent()){

            Product existingProduct = productOptional.get();

              existingProduct.setDescription(updatedProduct.getDescription() != null ? updatedProduct.getDescription() : existingProduct.getDescription());
              existingProduct.setName(updatedProduct.getName() != null ? updatedProduct.getName() : existingProduct.getName());
              existingProduct.setPrice(updatedProduct.getPrice() != 0.0 ? updatedProduct.getPrice() : existingProduct.getPrice());
              existingProduct.setQuantity(updatedProduct.getQuantity() != null ? updatedProduct.getQuantity() : existingProduct.getQuantity());

              updatedProduct = productRepository.save(existingProduct);

              return updatedProduct;
        }else{
            throw new Exception("Product Not found ");
        }
    }

    @Override
    public void deleteProduct(Long id) throws Exception {

        Optional<Product> productOptional = productRepository.findById(id);

        if(productOptional.isPresent()){
        productRepository.deleteById(id);
        log.info("Product deleted : {}",id);

        }else{
            throw new Exception("Product not found");
        }
    }

    @Override
    public double getRevenueByProduct(Long productId) throws Exception{
        log.info("Enter product service getRevenueByProduct with product id : {}",productId);
         List<Sale> sales = saleService.getProductById(productId);

         if(sales.isEmpty()){
           
            throw new Exception("Sales not found with this product id :"+productId);
 
         }else{
            log.info("Got sales list : {}", sales);
            double totalRevenue = sales.stream()
            .mapToDouble(sale -> sale.getQuantity() * sale.getProduct().getPrice())
            .sum();

            return totalRevenue;
         }
    }

    @Override
    public double getTotalRevenue() {
       
        List<Sale> sales = saleService.getAllSales();

        double totalRevenue = sales.stream()
                              .mapToDouble(sale -> sale.getQuantity() * sale.getProduct().getPrice())
                              .sum();

            return totalRevenue;
                                                
    }
    
}
