package Tests;

import com.gem.server.model.Customer;
import com.gem.server.service.CustomerService;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by jojo on 25/01/2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/META-INF/dispatcher-servlet.xml" })
@Transactional
@Configuration
public class CustomerTest extends TestCase {
    @Autowired
    CustomerService customerServices;
    /*@Autowired
    DealerService dealerService;
    @Autowired
    ProductDealerService productDealerServices;*/

    @Test
    public void testCreateCustomer(){
        Customer customer = new Customer();
        customer.setCustomerId(10);
        customer.setName("Hello");
        customer.setAddress("Vn");
        assertEquals((Integer)4, customerServices.save(customer));
    }

    @Test
    public void testDeleteCustomer(){
        assertEquals(true, customerServices.delete(1));
    }

    @Test
    public void testFindCustomer(){
        assertEquals("JOJO", customerServices.findById(1).getName());
    }
}
