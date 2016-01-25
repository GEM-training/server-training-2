package Services;

import Models.Make;
import Models.Product;

import java.util.List;

/**
 * Created by hoak57uet on 1/21/16.
 */
public interface MakeServices {
    List<Make> getAllMakes();

    Integer save(Make make);

    void delete(Integer makeId);

    Make findById(Integer makeId);

    List<Product> getAllProducts(Integer makeId);
}
