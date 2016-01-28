package Services;

import Models.Make;
import Models.Product;

import java.util.List;
import java.util.Set;

/**
 * Created by hoak57uet on 1/21/16.
 */
public interface MakeServices {
    List<Make> getAllMakes();

    List<Make> getMakes(int startIndex);

    Integer save(Make make);

    void saveOrUpdate(Make make);

    void delete(Integer makeId);

    Make findById(Integer makeId);

    Set<Product> getProducts(Integer makeId);
}
