package Models;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by hoapham on 20/01/2016.
 */
@Entity
@Table(name = "Product_Dealer")
public class ProductDealer {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int product_dealer_id;
    private int product_id;
    private int dealer_id;
    private float price;
    private Date created_date;
    private Date updated_date;

    public ProductDealer() {
    }

    public int getProduct_dealer_id() {
        return product_dealer_id;
    }

    public void setProduct_dealer_id(int product_dealer_id) {
        this.product_dealer_id = product_dealer_id;
    }


    public float getPrice() {
        return price;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public int getDealer_id() {
        return dealer_id;
    }

    public void setDealer_id(int dealer_id) {
        this.dealer_id = dealer_id;
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
