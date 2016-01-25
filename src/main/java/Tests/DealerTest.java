package Tests;

import Models.Dealer;
import Services.DealerServices;
import Services.ProductDealerServices;
import Services.ProductServices;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by phong on 1/24/2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/META-INF/dispatcher-servlet.xml"})
@Transactional
@Configuration
public class DealerTest extends TestCase {
    @Autowired
    ProductServices productServices;
    @Autowired
    DealerServices dealerServices;
    @Autowired
    ProductDealerServices productDealerServices;

    @Test
    public void testDealerTable() {
        Dealer dealer = new Dealer();
        dealer.setDealerId(10);
        dealer.setName("Hello");
        dealer.setAddress("Vn");
        assertEquals(new Integer(3), dealerServices.save(dealer));
    }
}
