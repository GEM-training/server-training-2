package Controllers;

import Dao.DealersDao;
import Dao.StaffDao;
import Models.Dealer;
import Models.Staff;
import Services.DealerServices;
import Services.StaffServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by phong on 21/01/2016.
 */
@RestController
@RequestMapping("/staff")
@Transactional
public class StaffController {
    @Autowired
    StaffServices staffServices;
    @Autowired
    DealerServices dealerServices;

    @RequestMapping(value = "/list")
    public String getAllStaffs() {
        return staffServices.getAllStaffs().toString();
    }

    @RequestMapping(value = "/add-one")
    public String addOneStaff() {
        Staff staff = new Staff();
        staff.setAddress("Ameriaca");
        Dealer dealer = dealerServices.getAllDealers().get(0);
        staff.setDealer(dealer);
        int result = staffServices.save(staff);
        return "Result:" + result;
    }

    @RequestMapping(value = "/delete/{id}")
    public String deleteStaff(@PathVariable("id") int id) {
        staffServices.delete(id);
        return "Delete";

    }

    @RequestMapping(value = "/{id}")
    public String showStaff(@PathVariable("id") int id) {
        Staff staff = staffServices.findById(id);
        return staff.getName() + staff.getStaffId();

    }
}
