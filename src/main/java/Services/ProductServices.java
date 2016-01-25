package Services;

import Models.Dealer;
import Models.Make;
import Models.Product;
import Models.Sale;

import java.util.List;

/**
 * Created by hoak57uet on 1/21/16.
 */
public interface ProductServices {
    List<Product> getAllProducts();

    Product findById(Integer productId);

    Integer save(Product product);

    boolean delete(Integer productId);

    List<Dealer> getDealers(Integer productId);

    Make getMake(Integer productId);

    List<Sale> getListSales(Integer productId);
}
