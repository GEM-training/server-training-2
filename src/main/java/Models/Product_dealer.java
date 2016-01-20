package Models;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by hoapham on 20/01/2016.
 */
@Entity
@Table(name = "Product_dealer")
public class Product_dealer {
    @Id
    @GeneratedValue
    private int product_dealer_id;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    private float price;

    private Date created_date;
    private Date updated_date;

    public Product_dealer() {
    }

    public int getProduct_dealer_id() {
        return product_dealer_id;
    }

    public void setProduct_dealer_id(int product_dealer_id) {
        this.product_dealer_id = product_dealer_id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
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
}
