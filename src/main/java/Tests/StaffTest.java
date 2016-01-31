package Tests;

import com.gem.server.model.Dealer;
import com.gem.server.model.Staff;
import com.gem.server.service.DealerService;
import com.gem.server.service.StaffService;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by phong on 1/24/2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/META-INF/dispatcher-servlet.xml"})
@Transactional
@Configuration
public class StaffTest extends TestCase {

    @Autowired
    StaffService staffService;
    @Autowired
    DealerService dealerService;

    @Test
    public void createStaff() {
        Staff staff = new Staff();
        staff.setStaffId(10);
        staff.setName("Nguyen A");
        staff.setAddress("Hanoi");
        staff.setPhone("090900909");

        assertEquals(new Integer(20), staffService.save(staff));
    }

    // join 2 table
    @Test
    public void getDealerFromStaff() {
        Dealer dealer = staffService.findById(10).getDealer();
        assertEquals(7,dealer.getDealerId());
    }
}
