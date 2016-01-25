package Controllers;

import Dao.CustomerDao;
import Dao.MakeDao;
import Models.Customer;
import Models.Make;
import Services.CustomerServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


/**
 * Created by jojo on 21/01/2016.
 */

@RestController
@RequestMapping("/customer")
@Transactional
public class CustomerController {
    @Autowired
    CustomerServices customerServices;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String getListCustomer() {
        return "" + customerServices.getAllCustomers();
    }

    @RequestMapping(value = "/add-one")
    public String addOneCustomer() {
        Customer customer = new Customer();
        customer.setName("Make demo no " + customerServices.getAllCustomers().size());
        customerServices.save(customer);
        return "Successful";
    }

    @RequestMapping(value = "/delete-one")
    public void delete() {
        Customer customer = new Customer();
        customerServices.delete(1);
    }

    @RequestMapping(value = "/find-one")
    public String findCustomer() {
        return customerServices.findById(1).getName();
    }
}


