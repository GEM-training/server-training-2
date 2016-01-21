package Controllers;

import Dao.ProductInventoryDao;
import Models.ProductInventory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
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

    @RequestMapping("/delete")
    public String deleteProductInventory(@PathVariable("productInventoryId") Integer productInventoryId) {
        productInventoryDao.delete(productInventoryId);
        return "delete productInventory sucess";
    }


}
