package com.sparksupport.salesapp;

import java.time.Instant;
import java.util.Date;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.sparksupport.salesapp.domain.Product;
import com.sparksupport.salesapp.domain.Sale;
import com.sparksupport.salesapp.service.ProductService;
import com.sparksupport.salesapp.service.SaleService;

@SpringBootApplication
public class SalesappApplication implements CommandLineRunner{

	private final ProductService productService;

	private final SaleService saleService;

	public SalesappApplication( ProductService productService, SaleService saleService){
		this.productService = productService;
		this.saleService = saleService;
	}

	public static void main(String[] args) {
		
		SpringApplication.run(SalesappApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Product product1 = new Product(null,"Shoe","Best Shoes",500.0,100000l);
        Product product2 = new Product(null,"Shocks","Best Shocks",50.0,100000l);
        Product product3 = new Product(null,"chappal","Best chappal",150.0,60000l);
        
		Product productResponse = productService.addProduct(product1);
		Sale sale1 = new Sale(null,productResponse, 5l, Date.from(Instant.now()));
		Sale sale2 = new Sale(null,productResponse, 65l, Date.from(Instant.now()));
		Sale sale3 = new Sale(null,productResponse, 15l, Date.from(Instant.now()));
		Sale sale4 = new Sale(null,productResponse, 55l, Date.from(Instant.now()));
		Sale sale5 = new Sale(null,productResponse, 75l, Date.from(Instant.now()));
		Product productResponse2 = productService.addProduct(product2);
		Sale sale6 = new Sale(null,productResponse2, 65l, Date.from(Instant.now()));
		Sale sale7 = new Sale(null,productResponse2, 51l, Date.from(Instant.now()));
		Sale sale8 = new Sale(null,productResponse2, 15l, Date.from(Instant.now()));
		Sale sale9 = new Sale(null,productResponse2, 100l, Date.from(Instant.now()));
		Sale sale10 = new Sale(null,productResponse2, 10l, Date.from(Instant.now()));
		Product productResponse3 = productService.addProduct(product3);
		Sale sale11 = new Sale(null,productResponse3, 10l, Date.from(Instant.now()));
		Sale sale12 = new Sale(null,productResponse3, 10l, Date.from(Instant.now()));
		Sale sale13 = new Sale(null,productResponse3, 10l, Date.from(Instant.now()));
		Sale sale14 = new Sale(null,productResponse3, 10l, Date.from(Instant.now()));
		Sale sale15 = new Sale(null,productResponse3, 10l, Date.from(Instant.now()));
		Sale sale16 = new Sale(null,productResponse3, 10l, Date.from(Instant.now()));
		Sale sale17 = new Sale(null,productResponse3, 10l, Date.from(Instant.now()));
		Sale sale18 = new Sale(null,productResponse3, 10l, Date.from(Instant.now()));
		Sale sale19 = new Sale(null,productResponse3, 10l, Date.from(Instant.now()));
		Sale sale20 = new Sale(null,productResponse3, 10l, Date.from(Instant.now()));

        
        saleService.addSale(sale1);
        saleService.addSale(sale2);
        saleService.addSale(sale3);
        saleService.addSale(sale4);
        saleService.addSale(sale5);
        saleService.addSale(sale6);
        saleService.addSale(sale7);
        saleService.addSale(sale8);
        saleService.addSale(sale9);
        saleService.addSale(sale10);
        saleService.addSale(sale11);
        saleService.addSale(sale12);
        saleService.addSale(sale13);
        saleService.addSale(sale14);
        saleService.addSale(sale15);
        saleService.addSale(sale16);
        saleService.addSale(sale17);
        saleService.addSale(sale18);
        saleService.addSale(sale19);
        saleService.addSale(sale20);
	}

}
