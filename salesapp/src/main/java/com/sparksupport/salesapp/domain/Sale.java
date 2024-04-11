package com.sparksupport.salesapp.domain;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "sale")
public class Sale {
   
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private Product product;

    private Long quantity;
    private Date saleDate;


    public Sale() {
    }

    public Sale(Product product, Long quantity, Date saleDate) {
        this.product = product;
        this.quantity = quantity;
        this.saleDate = saleDate;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public Date getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(Date saleDate) {
      this.saleDate = saleDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Sale)) {
            return false;
        }
        return getId() != null && getId().equals(((Sale) o).getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

    @Override
    public String toString() {
        return "Sale [id=" + id + ", product=" + product + ", quantity=" + quantity + ", saleDate=" + saleDate + "]";
    }

    
    
}
