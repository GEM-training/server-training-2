/*
package Tests;

import com.gem.server.model.SaleDetail;
import com.gem.server.service.SaleDetailService;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

*/
/**
 * Created by jojo on 25/01/2016.
 *//*

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/META-INF/dispatcher-servlet.xml" })
@Transactional
@Configuration
public class SaleDetailTest extends TestCase {
    @Autowired
    SaleDetailService saleDetailService;
    */
/*@Autowired
    DealerService dealerService;
    @Autowired
    ProductDealerService productDealerServices;*//*


    @Test
    public void testCreateSaleDetail(){
        SaleDetail saleDetail = new SaleDetail();
        saleDetail.setSaleDetailId(2);
        saleDetail.setQuantity(10);
        assertEquals((Integer)2, saleDetailService.save(saleDetail));
    }

    @Test
    public void testDeleteSaleDetail(){
        assertEquals(true, saleDetailService.delete(10));
    }

    @Test
    public void testFindSaleDetail(){
        assertEquals(10, saleDetailService.findById(1).getQuantity());
    }
}
*/
