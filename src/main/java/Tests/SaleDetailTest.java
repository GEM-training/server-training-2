package Tests;

import Models.SaleDetail;
import Services.SaleDetailServices;
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
public class SaleDetailTest extends TestCase {
    @Autowired
    SaleDetailServices saleDetailServices;
    /*@Autowired
    DealerServices dealerServices;
    @Autowired
    ProductDealerServices productDealerServices;*/

    @Test
    public void testCreateSaleDetail(){
        SaleDetail saleDetail = new SaleDetail();
        saleDetail.setSaleDetailId(2);
        saleDetail.setQuantity(10);
        assertEquals((Integer)2, saleDetailServices.save(saleDetail));
    }

    @Test
    public void testDeleteSaleDetail(){
        assertEquals(true, saleDetailServices.delete(10));
    }

    @Test
    public void testFindSaleDetail(){
        assertEquals(10, saleDetailServices.findById(1).getQuantity());
    }
}
