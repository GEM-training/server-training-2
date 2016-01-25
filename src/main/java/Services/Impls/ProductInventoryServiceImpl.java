package Services.Impls;

import Dao.ProductInventoryDao;
import Models.ProductInventory;
import Services.ProductInventoryServices;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by nguyenkhoi on 1/25/16.
 */
public class ProductInventoryServiceImpl implements ProductInventoryServices {
    @Autowired
    ProductInventoryDao productInventoryDao;
    public List<ProductInventory> getAllProductInventory() {
        return productInventoryDao.getAllProductInventory();
    }
    public Integer save(ProductInventory productInventory) {
        return productInventoryDao.save(productInventory);
    }
    public ProductInventory findById(Integer productInventoryId) {
        return productInventoryDao.findById(productInventoryId);
    }
    public void delete(Integer productInventoryId) {
        productInventoryDao.delete((productInventoryId));
    }
}
