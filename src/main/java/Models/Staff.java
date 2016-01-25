package Models;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by hoapham on 20/01/2016.
 */
@Entity
@Table(name = "Staffs")
public class Staff {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "staff_id")
    private int staffId;
    private String name;
    private String phone;
    private String address;
    @Column(name = "created_date")
    private Date createdDate;
    @Column(name = "updated_date")
    private Date updatedDate;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "dealer_id")
    private Dealer dealer;

    public Staff() {
        createdDate = new Date(System.currentTimeMillis());
        updatedDate = new Date(System.currentTimeMillis());
    }

    public int getStaffId() {
        return staffId;
    }

    public void setStaffId(int staff_id) {
        this.staffId = staffId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Dealer getDealer() {
        return dealer;
    }

    public void setDealer(Dealer dealer) {
        this.dealer = dealer;
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

    @Override
    public String toString() {
        return "ID: " + staffId + ", name: " + name;
    }
}
