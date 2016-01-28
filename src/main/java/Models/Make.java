package Models;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
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

    @NotNull(message = "address could not empty !")
    private String address;
    private String description;

    @NotNull(message = "name could not empty !")
    private String name;
    @Column(name = "created_date")
    private Date createdDate;
    @Column(name = "updated_date")
    private Date updatedDate;

    @OneToMany(mappedBy = "make",fetch =FetchType.LAZY)
    @JsonIgnore
    Set<Product> setProducts;

    public Make() {
        createdDate=new Date(System.currentTimeMillis());
        updatedDate=new Date(System.currentTimeMillis());
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

}
