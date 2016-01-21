package Controllers;

import Dao.ProductInventoryDao;
import Models.ProductInventory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by nguyenkhoi on 1/21/16.
 */

@RestController
@RequestMapping("/productInventory")
@Transactional
public class ProductInventoryController {

    @Autowired
    ProductInventoryDao productInventoryDao;

    @RequestMapping("/list")
    public String getListProductInventory() {
        return ""+productInventoryDao.getAllProductInventory().size();
    }

    @RequestMapping("/add-one")
    public String addOneProductInventory() {
        ProductInventory productInventory = new ProductInventory();
        productInventory.setProduct_inventory_id(productInventory.getProduct_inventory_id());
        return "Add product inventory success";
    }

}
