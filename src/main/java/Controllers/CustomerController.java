package Controllers;

import Dao.CustomerDao;
import Dao.MakeDao;
import Models.Customer;
import Models.Make;
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
    CustomerDao customerDao;

    @RequestMapping(value = "/list",method= RequestMethod.GET)
    public String getListCustomer(){
        return ""+customerDao.getAllCustomers();
    }

    @RequestMapping(value = "/add-one")
    public String addOneCustomer(){
        Customer customer = new Customer();
        customer.setName("Make demo no "+customerDao.getAllCustomers().size());
        customerDao.save(customer);
        return "Successful";
    }
}


