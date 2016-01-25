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
@ContextConfiguration(locations = {"classpath:/META-INF/spring/dispatcher-servlet.xml"})
@Transactional
@Configuration
public class StaffTest extends TestCase {

    @Autowired
    StaffServices staffServices;
    @Autowired
    DealerServices dealerServices;

    public int createStaff() {
        Staff staff = new Staff();
        staff.setStaffId(10);
        staff.setName("Nguyen A");
        staff.setAddress("Hanoi");
        staff.setPhone("090900909");
        staff.setDealer(dealerServices.getAllDealers().get(0));
        return staffServices.save(staff);
    }

    // join 2 table
    public int getDealerFromStaff() {
        Dealer dealer = staffServices.findById(10).getDealer();
        return dealer.getDealerId();
    }

    public int countStaff() {
        return staffServices.getAllStaffs().size();
    }

    @Test
    public void testStaffTable() {
        assertEquals(10, createStaff());


    }

    @Test
    public void test1StaffTable() {

        assertEquals(0, getDealerFromStaff());

    }

    @Test
    public void test2StaffTable() {

        assertEquals(2, countStaff());

    }


}
