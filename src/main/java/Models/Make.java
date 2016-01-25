package Models;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

/**
 * Created by hoapham on 19/01/2016.
 */
@Entity
@Table(name = "Makes")
public class Make {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "make_id")
    private int makeId;
    private String address;
    private String description;
    private String name;
    @Column(name = "created_date")
    private Date createdDate;
    @Column(name = "updated_date")
    private Date updatedDate;

    @OneToMany(mappedBy = "make")
    Set<Product> setProducts;

    public Make() {
    }

    public int getMakeId() {
        return makeId;
    }

    public void setMakeId(int make_id) {
        this.makeId = make_id;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Set<Product> getSetProducts() {
        return setProducts;
    }

    public void setSetProducts(Set<Product> setProducts) {
        this.setProducts = setProducts;
    }


    @Override
    public String toString() {
        return "ID: " + makeId + ", name: " + name;
    }
}
