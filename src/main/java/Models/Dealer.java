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
    @GeneratedValue
    private int dealer_id;
    private String name;
    private String address;
    private String description;
    private Date created_date;
    private Date updated_date;

    @OneToMany(mappedBy = "dealer")
    private Set<Inventory>setInventories;

    @ManyToMany
    @JoinTable(name = "ProductDealer", joinColumns=@JoinColumn(name = "dealer_id"),inverseJoinColumns = @JoinColumn(name = "product_id"))
    private Set<Product> listProducts;

    @OneToMany(mappedBy = "dealer")
    private Set<Staff> listStaffs;

    @OneToMany(mappedBy = "dealer")
    private Set<Sale> listSales;

    public Dealer() {
    }

    public int getDealer_id() {
        return dealer_id;
    }

    public void setDealer_id(int dealer_id) {
        this.dealer_id = dealer_id;
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

    public Date getCreated_date() {
        return created_date;
    }

    public void setCreated_date(Date created_date) {
        this.created_date = created_date;
    }

    public Date getUpdated_date() {
        return updated_date;
    }

    public void setUpdated_date(Date updated_date) {
        this.updated_date = updated_date;
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
}
