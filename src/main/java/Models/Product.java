package Models;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

/**
 * Created by hoapham on 19/01/2016.
 */

@Entity
@Table(name = "Products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "product_id")
    private int productId;
    private String name;
    private String description;

    @Column(name = "is_unit")
    private boolean isUnit;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "make_id")
    private Make make;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "of_unit_id")
    private Product unit;

    @OneToMany(mappedBy = "unit")
    private Set<Product> listParts;

    @ManyToMany(mappedBy = "listProducts")
    private Set<Dealer> listDealers;

    @ManyToMany(mappedBy = "listProducts")
    private Set<Inventory> listInventories;

    @ManyToMany(mappedBy = "listProducts")
    private Set<Sale> listSales;
    @Column(name = "created_date")
    private Date createdDate;
    @Column(name = "updated_date")
    private Date updatedDate;

    public Product() {
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int product_id) {
        this.productId = product_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Make getMake() {
        return make;
    }

    public void setMake(Make make) {
        this.make = make;
    }

    public Product getUnit() {
        return unit;
    }

    public void setUnit(Product unit) {
        this.unit = unit;
    }

    public Set<Product> getListParts() {
        return listParts;
    }

    public void setListParts(Set<Product> listParts) {
        this.listParts = listParts;
    }

    public Set<Dealer> getListDealers() {
        return listDealers;
    }

    public void setListDealers(Set<Dealer> listDealers) {
        this.listDealers = listDealers;
    }

    public Set<Inventory> getListInventories() {
        return listInventories;
    }

    public void setListInventories(Set<Inventory> listInventories) {
        this.listInventories = listInventories;
    }

    public Set<Sale> getListSales() {
        return listSales;
    }

    public void setListSales(Set<Sale> listSales) {
        this.listSales = listSales;
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

    public boolean isUnit() {
        return isUnit;
    }

    public void setUnit(boolean unit) {
        isUnit = unit;
    }


    @Override
    public String toString() {
        return "ID: " + productId + ", name: " + name;
    }
}
