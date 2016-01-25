package Tests;

import Models.Dealer;
import Models.Staff;
import Services.DealerServices;
import Services.StaffServices;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by phong on 1/24/2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/META-INF/dispatcher-servlet.xml"})
@Transactional
@Configuration
public class StaffTest extends TestCase {

    @Autowired
    StaffServices staffServices;
    @Autowired
    DealerServices dealerServices;

    @Test
    public void createStaff() {
        Staff staff = new Staff();
        staff.setStaffId(10);
        staff.setName("Nguyen A");
        staff.setAddress("Hanoi");
        staff.setPhone("090900909");

        assertEquals(new Integer(20),staffServices.save(staff));
    }

    // join 2 table
    @Test
    public void getDealerFromStaff() {
        Dealer dealer = staffServices.findById(10).getDealer();
        assertEquals(7,dealer.getDealerId());
    }






}
