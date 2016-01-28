package Dao;

import Models.Make;
import Models.Product;

import java.util.List;
import java.util.Set;

/**
 * Created by hoapham on 19/01/2016.
 */
public interface MakeDao {
    List<Make> getAllMakes();

    List<Make> getMakes(int startIndex);

    Integer save(Make make);

    void saveOrUpdate(Make make);

    void delete(Integer makeId);

    Make findById(Integer makeId);

    Set<Product> getProducts(Integer makeId);

}
