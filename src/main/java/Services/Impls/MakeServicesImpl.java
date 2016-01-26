package Services.Impls;

import Dao.MakeDao;
import Models.Make;
import Models.Product;
import Services.MakeServices;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Set;

/**
 * Created by hoak57uet on 1/21/16.
 */
public class MakeServicesImpl implements MakeServices {
    @Autowired
    MakeDao makeDao;

    public List<Make> getAllMakes() {
        return makeDao.getAllMakes();
    }

    public Integer save(Make make) {
        return makeDao.save(make);
    }

    public void delete(Integer makeId) {
        makeDao.delete(makeId);
    }

    public Make findById(Integer makeId) {
        return makeDao.findById(makeId);
    }

    public Set<Product> getProducts(Integer makeId) {
        return makeDao.getProducts(makeId);
    }
}
