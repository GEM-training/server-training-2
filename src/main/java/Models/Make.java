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
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int make_id;
    private String address;
    private String description;
    private String name;
    private Date created_date;
    private Date updated_date;

    @OneToMany(mappedBy = "make")
    Set<Product> setProducts;

    public Make() {
    }

    public int getMake_id() {
        return make_id;
    }

    public void setMake_id(int make_id) {
        this.make_id = make_id;
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

    public Set<Product> getSetProducts() {
        return setProducts;
    }

    public void setSetProducts(Set<Product> setProducts) {
        this.setProducts = setProducts;
    }


    @Override
    public String toString() {
        return "ID: " + make_id + ", name: " + name;
    }
}
