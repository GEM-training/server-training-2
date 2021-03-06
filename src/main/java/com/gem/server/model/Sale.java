package com.gem.server.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

/**
 * Created by hoapham on 20/01/2016.
 */
@Entity
@Table(name = "Sales")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Sale {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "sale_id")
    private int saleId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dealer_id")
    @JsonIgnore
    private Dealer dealer;

    @ManyToMany
    @JoinTable(name = "sale_details", joinColumns = @JoinColumn(name = "sale_id"), inverseJoinColumns = @JoinColumn(name = "product_id"))
    @JsonIgnore
    private Set<Product> listProducts;

    @OneToMany(mappedBy = "sale")
    @JsonIgnore
    private Set<SaleDetail> listSaleDetails;

    private int status;
    @Column(name = "created_date")
    private Date createdDate;
    @Column(name = "updated_date")
    private Date updatedDate;

    public Sale() {
        createdDate=new Date(System.currentTimeMillis());
        updatedDate=new Date(System.currentTimeMillis());
    }

    public int getSaleId() {
        return saleId;
    }

    public void setSaleId(int saleId) {
        this.saleId = saleId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Dealer getDealer() {
        return dealer;
    }

    public void setDealer(Dealer dealer) {
        this.dealer = dealer;
    }

    public Set<Product> getListProducts() {
        return listProducts;
    }

    public void setListProducts(Set<Product> listProducts) {
        this.listProducts = listProducts;
    }

    public Set<SaleDetail> getListSaleDetails() {
        return listSaleDetails;
    }

    public void setListSaleDetails(Set<SaleDetail> listSaleDetails) {
        this.listSaleDetails = listSaleDetails;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }
}
