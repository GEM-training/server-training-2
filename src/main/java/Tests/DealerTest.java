package Tests;

import com.gem.server.dao.DealerDao;
import com.gem.server.dao.ProductDao;
import com.gem.server.dao.ProductDealerDao;
import com.gem.server.model.Dealer;
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
    ProductDao productServices;
    @Autowired
    DealerDao dealerServices;
    @Autowired
    ProductDealerDao productDealerServices;

    @Test
    public void testDealerTable() {
        Dealer dealer = new Dealer();
        dealer.setDealerId(10);
        dealer.setName("Hello");
        dealer.setAddress("Vn");
        assertEquals(new Integer(3), dealerServices.save(dealer));
    }
    @Test
    public void getStaffFromDealer(){
        Dealer dealer = dealerServices.findById(1);
        assertEquals(3,dealer.getStaffs().size());

    }
    @Test
    void  getProductFromDealer(){
        Dealer dealer = dealerServices.findById(1);
        assertEquals(5,dealer.getProducts().size());
    }
    @Test
    public  void getSalesFromDealer(){
        Dealer dealer = dealerServices.findById(1);
        assertEquals(1, dealer.getSales());
    }
}
