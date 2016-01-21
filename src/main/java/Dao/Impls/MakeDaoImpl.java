package Dao.Impls;

import Dao.AbstractDao;
import Dao.MakeDao;
import Models.Make;
import Models.Product;
import org.hibernate.Criteria;

import java.util.List;

/**
 * Created by hoapham on 19/01/2016.
 */
public class MakeDaoImpl extends AbstractDao implements MakeDao {


    public List<Make> getAllMakes() {
        Criteria criteria = getSession().createCriteria(Make.class);
        return (List<Make>) criteria.list();
    }

    public Integer save(Make make) {
        return (Integer) getSession().save(make);
    }

    public List<Product> getAllProducts(Integer makeId) {
        return (List<Product>) findById(makeId).getSetProducts();
    }

    public void delete(Integer makeId) {
        Make make = getSession().load(Make.class, makeId);
        if (make != null)
            getSession().delete(make);
    }

    public Make findById(Integer makeId) {
        return getSession().get(Make.class, makeId);
    }

}
