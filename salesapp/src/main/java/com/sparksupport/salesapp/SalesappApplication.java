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
		Product product1 = new Product(null,"Shoe","Best Shoes",500.0,10l);
        Product product2 = new Product(null,"Shocks","Best Shocks",50.0,1000l);
        Product product3 = new Product(null,"chappal","Best chappal",150.0,600l);
        Product product4 = new Product(null,"Bags","Best bags",900.0,1000l);
        Product product5 = new Product(null,"Books","Best books",15.0,10000l);
        Product product6 = new Product(null,"Pen","Best pens",10.0,10000l);
        Product product7 = new Product(null,"EarPhones","Best headsets",5000.0,1000l);
        Product product8 = new Product(null,"Mobile covers","Best covers",500.0,1000l);
        Product product9 = new Product(null,"Bottles","Best bottles",90.0,1000l);
        Product product10 = new Product(null,"Pencil","Best pencil",5.0,1000l);
        
		Sale sale1 = new Sale(null,productService.addProduct(product1), 5l, Date.from(Instant.now()));
		Sale sale2 = new Sale(null,productService.addProduct(product2), 65l, Date.from(Instant.now()));
		Sale sale3 = new Sale(null,productService.addProduct(product3), 15l, Date.from(Instant.now()));
		Sale sale4 = new Sale(null,productService.addProduct(product4), 55l, Date.from(Instant.now()));
		Sale sale5 = new Sale(null,productService.addProduct(product5), 75l, Date.from(Instant.now()));
		Sale sale6 = new Sale(null,productService.addProduct(product6), 65l, Date.from(Instant.now()));
		Sale sale7 = new Sale(null,productService.addProduct(product7), 51l, Date.from(Instant.now()));
		Sale sale8 = new Sale(null,productService.addProduct(product8), 15l, Date.from(Instant.now()));
		Sale sale9 = new Sale(null,productService.addProduct(product9), 100l, Date.from(Instant.now()));
		Sale sale10 = new Sale(null,productService.addProduct(product10), 10l, Date.from(Instant.now()));
        
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
	}

}
