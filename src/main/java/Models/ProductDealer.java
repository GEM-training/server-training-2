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
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "product_dealer_id")
    private int productDealerId;
    @Column(name = "product_id")
    private int productId;
    @Column(name = "dealer_id")
    private int dealerId;
    private float price;
    @Column(name = "created_date")
    private Date createdDate;
    @Column(name = "updated_date")
    private Date updatedDate;

    public ProductDealer() {
        createdDate=new Date(System.currentTimeMillis());
        updatedDate=new Date(System.currentTimeMillis());
    }

    public int getProductDealerId() {
        return productDealerId;
    }

    public void setProductDealerId(int productDealerId) {
        this.productDealerId = productDealerId;
    }


    public float getPrice() {
        return price;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int product_id) {
        this.productId = product_id;
    }

    public int getDealerId() {
        return dealerId;
    }

    public void setDealerId(int dealer_id) {
        this.dealerId = dealer_id;
    }

    public void setPrice(float price) {
        this.price = price;
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
