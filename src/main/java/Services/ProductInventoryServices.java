package Services;

import java.util.List;

/**
 * Created by nguyenkhoi on 1/25/16.
 */
public interface ProductInventoryServices {
    List<Models.ProductInventory> getAllProductInventory();

    void delete(Integer productInventoryId);

    Models.ProductInventory findById(Integer productInventoryId);

    Integer save(Models.ProductInventory product_inventory);


}
