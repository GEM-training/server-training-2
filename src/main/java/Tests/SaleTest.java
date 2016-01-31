package Tests;

import com.gem.server.model.Sale;
import com.gem.server.service.SaleService;
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
public class SaleTest extends TestCase {
    @Autowired
    SaleService saleService;
    /*@Autowired
    DealerService dealerService;
    @Autowired
    ProductDealerService productDealerServices;*/

    @Test
    public void testCreateSale(){
        Sale sale = new Sale();
        sale.setSaleId(2);
        sale.setStatus(0);
        assertEquals((Integer)2, saleService.save(sale));
    }

    @Test
    public void testDeleteSale(){
        assertEquals(true, saleService.delete(1));
    }

    @Test
    public void testFindSale(){
        assertEquals(1, saleService.findById(1).getStatus());
    }

    @Test
    public void testGetCustomerInfo(){
        assertEquals("0948682045", saleService.findById(1).getCustomer().getPhone());
    }

    @Test
    public void testGetSaleDetail(){
        assertEquals(2, saleService.findById(1).getListSaleDetails().size());
    }
}
