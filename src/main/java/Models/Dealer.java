package Models;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

/**
 * Created by hoapham on 20/01/2016.
 */
@Entity
@Table(name = "Dealers")
public class Dealer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "dealer_id")
    private int dealerId;
    private String name;
    private String address;
    private String description;
    @Column(name = "created_date")
    private Date createdDate;
    @Column(name = "updated_date")
    private Date updatedDate;

    @OneToMany(mappedBy = "dealer")
    private Set<Inventory> setInventories;

    @ManyToMany
    @JoinTable(name = "ProductDealer", joinColumns = @JoinColumn(name = "dealer_id"), inverseJoinColumns = @JoinColumn(name = "product_id"))
    private Set<Product> listProducts;

    @OneToMany(mappedBy = "dealer")
    private Set<Staff> listStaffs;

    @OneToMany(mappedBy = "dealer")
    private Set<Sale> listSales;

    public Dealer() {
    }

    public int getDealerId() {
        return dealerId;
    }

    public void setDealerId(int dealerId) {
        this.dealerId = dealerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public void setUpdatedDate(Date updated_date) {
        this.updatedDate = updated_date;
    }

    public Set<Inventory> getSetInventories() {
        return setInventories;
    }

    public void setSetInventories(Set<Inventory> setInventories) {
        this.setInventories = setInventories;
    }

    public Set<Product> getListProducts() {
        return listProducts;
    }

    public void setListProducts(Set<Product> listProducts) {
        this.listProducts = listProducts;
    }

    public Set<Staff> getListStaffs() {
        return listStaffs;
    }

    public void setListStaffs(Set<Staff> listStaffs) {
        this.listStaffs = listStaffs;
    }

    public Set<Sale> getListSales() {
        return listSales;
    }

    public void setListSales(Set<Sale> listSales) {
        this.listSales = listSales;
    }

    @Override
    public String toString() {
        return "ID: " + dealerId + ", name: " + name;
    }
}
