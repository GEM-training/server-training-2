package Controllers;


import Models.Inventory;
import Models.Product;
import Models.ProductInventory;
import Services.Impls.InventoryServiceImpl;
import Services.InventoryServices;
import Services.ProductInventoryServices;
import Services.ProductServices;
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
    ProductInventoryServices productInventoryServices;
    @Autowired
    ProductServices productServices;
    @Autowired
    InventoryServices inventoryServices;

    @RequestMapping("/list")
    public String getListProductInventory() {
        return productInventoryServices.getAllProductInventory().toString();
    }

    @RequestMapping("/add")
    public String addOneProductInventory() {
        ProductInventory productInventory = new ProductInventory();
        Product product =   productServices.findById(0);
        Inventory inventory = inventoryServices.findById(0);
        productInventory.setInventoryId(inventory.getInventoryId()) ;
        productInventory.setProductId(product.getProductId());
        productInventory.setQuantity(1000);
        return "Result" +productInventoryServices.save(productInventory);
    }

}