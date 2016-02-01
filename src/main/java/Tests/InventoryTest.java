package Tests;

import com.gem.server.model.Dealer;
import com.gem.server.model.Inventory;
import com.gem.server.service.InventoryService;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by nguyenkhoi on 1/25/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/META-INF/dispatcher-servlet.xml"})
@Transactional
@Configuration
public class InventoryTest extends TestCase {
    @Autowired
    InventoryService inventoryService;

    @Test
    public void testAddInventory() {
        Inventory inventory = new Inventory();
        assertEquals(new Integer(55), inventoryService.save(inventory));
    }

    @Test
    public void testDeleteInventory() {
        assertEquals(true, inventoryService.delete(7));
    }

    @Test
    public void testFindInventory() {
        assertEquals("Kho Bắc Ninh", inventoryService.findById());
    }
    @Test
    public void getDealerFromInventory() {
        Dealer dealer = inventoryService.findById(7).getDealer();
        assertEquals(1, dealer.getDealerId());

    }

}
