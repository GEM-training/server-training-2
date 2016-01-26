package Services;

import Models.Dealer;
import Models.Make;
import Models.Product;
import Models.Sale;

import java.util.List;
import java.util.Set;

/**
 * Created by hoak57uet on 1/21/16.
 */
public interface ProductServices {
    List<Product> getAllProducts();

    Product findById(Integer productId);

    Integer save(Product product);

    void delete(Integer productId);

    Set<Dealer> getDealers(Integer productId);

    Make getMake(Integer productId);

    Set<Sale> getSales(Integer productId);

    Set<Product> getParts(Integer productId);
}
