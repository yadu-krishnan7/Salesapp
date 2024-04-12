package com.sparksupport.salesapp.service.implementation;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sparksupport.salesapp.domain.Product;
import com.sparksupport.salesapp.domain.Sale;
import com.sparksupport.salesapp.repository.ProductRepository;
import com.sparksupport.salesapp.service.ProductService;
import com.sparksupport.salesapp.service.SaleService;

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
    @Transactional(readOnly = true)
    public List<Product> getAllProducts() {

        log.info("Entered product service to fetch all the products");
        
         Iterable<Product> iterableProducts = productRepository.findAll(Sort.by("name"));

         List<Product> productList = new ArrayList<>();

         iterableProducts.forEach(productList::add);

         return productList;
    }

    @Override
    @Transactional(readOnly = true)
    public Product getProductById(Long id) throws Exception{

        log.info("Entered produt service getProductById with : {}",id);

        Optional<Product> productOptional = productRepository.findById(id);

        if(productOptional.isPresent()){
            log.info("Found product: {}", productOptional.get());
        return productOptional.get();
        }else{
            log.error("Product not found with ID: {}", id);
             throw new Exception("Product not found");
        }
    }

    @Override
    public Product addProduct(Product product) {
        log.info("Adding product: {}", product);
         product  = productRepository.save(product);
         log.info("Product added: {}", product);
         return product;
       
    }

    @Override
    public Product updateProduct(Long id, Product updatedProduct) throws Exception{
        log.info("Updating product with ID: {}", id);
        Optional<Product> productOptional = productRepository.findById(id);

        if(productOptional.isPresent()){

            Product existingProduct = productOptional.get();

              existingProduct.setDescription(updatedProduct.getDescription() != null ? updatedProduct.getDescription() : existingProduct.getDescription());
              existingProduct.setName(updatedProduct.getName() != null ? updatedProduct.getName() : existingProduct.getName());
              existingProduct.setPrice(updatedProduct.getPrice() != 0.0 ? updatedProduct.getPrice() : existingProduct.getPrice());
              existingProduct.setQuantity(updatedProduct.getQuantity() != null ? updatedProduct.getQuantity() : existingProduct.getQuantity());

              updatedProduct = productRepository.save(existingProduct);
              log.info("Product updated: {}", updatedProduct);
              return updatedProduct;
        }else{
            log.error("Product not found with ID: {}", id);
            throw new Exception("Product Not found ");
        }
    }

    @Override
    public void deleteProduct(Long id) throws Exception {
        log.info("Deleting product with ID: {}", id);
        Optional<Product> productOptional = productRepository.findById(id);

        if(productOptional.isPresent()){
        productRepository.deleteById(id);
        log.info("Product deleted with id: {}",id);

        }else{
            log.error("Product not found with ID: {}", id);
            throw new Exception("Product not found");
        }
    }

    @Override
    @Transactional(readOnly = true)
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
    @Transactional(readOnly = true)
    public double getTotalRevenue() {
       
        List<Sale> sales = saleService.getAllSales();

        double totalRevenue = sales.stream()
                              .mapToDouble(sale -> sale.getQuantity() * sale.getProduct().getPrice())
                              .sum();

            return totalRevenue;
                                                
    }
    
}
