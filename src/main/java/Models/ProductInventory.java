package Models;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by hoapham on 20/01/2016.
 */
@Entity
@Table(name = "Product_Inventory")
public class ProductInventory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "product_inventory_id")
    private int productInventoryId;
    @Column(name = "product_id")
    private int productId;
    @Column(name = "inventory_id")
    private int inventoryId;

    private int quantity;
    @Column(name = "created_date")
    private Date createdDate;
    @Column(name = "updated_date")
    private Date updatedDate;

    public ProductInventory() {
        createdDate=new Date(System.currentTimeMillis());
        updatedDate=new Date(System.currentTimeMillis());
    }

    public int getProductInventoryId() {
        return productInventoryId;
    }

    public void setProductInventoryId(int product_inventory_id) {
        this.productInventoryId = product_inventory_id;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int product_id) {
        this.productId = product_id;
    }

    public int getInventoryId() {
        return inventoryId;
    }

    public void setInventoryId(int inventory_id) {
        this.inventoryId = inventory_id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
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
