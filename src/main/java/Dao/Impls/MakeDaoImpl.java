package Dao.Impls;

import Dao.AbstractDao;
import Dao.MakeDao;
import Models.Inventory;
import Models.Make;
import Models.Product;
import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

/**
 * Created by hoapham on 19/01/2016.
 */
@Transactional
public class MakeDaoImpl extends AbstractDao implements MakeDao {


    public List<Make> getAllMakes() {
        Criteria criteria = getSession().createCriteria(Make.class);
        return (List<Make>) criteria.list();
    }

    public Integer save(Make make) {
        return (Integer) getSession().save(make);
    }

    public void saveOrUpdate(Make make) {
        getSession().saveOrUpdate(make);
    }

    public Set<Product> getProducts(Integer makeId) {
        Make make = findById(makeId);
        Hibernate.initialize(make.getSetProducts());
        return make.getSetProducts();
    }

    public void delete(Integer makeId) {
        Make make = getSession().load(Make.class, makeId);
        if (make != null)
            getSession().delete(make);
    }

    public Make findById(Integer makeId) {
<<<<<<< HEAD:src/main/java/Dao/MakeDaoImpl.java
        return (Make) getSession().get(Make.class,makeId);
=======
        return getSession().get(Make.class, makeId);
>>>>>>> 8c12c06edac80b0e58328d16e89e5908743ec4eb:src/main/java/Dao/Impls/MakeDaoImpl.java
    }

}
