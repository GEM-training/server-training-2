package Models;

import javax.persistence.*;

/**
 * Created by hoapham on 20/01/2016.
 */
@Entity
@Table(name = "Staffs")
public class Staff {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int staffId;
    private String name;
    private String phone;
    private String address;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "dealer_id")
    private Dealer dealer;

    public Staff() {
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


    @Override
    public String toString() {
        return "ID: " + staffId + ", name: " + name;
    }
}
