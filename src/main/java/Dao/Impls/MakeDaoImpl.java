package Dao.Impls;

import Dao.AbstractDao;
import Dao.MakeDao;
import Models.Inventory;
import Models.Make;
import Models.Product;
import Utils.Constants;
import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

/**
 * Created by hoapham on 19/01/2016.
 */
@Transactional
@Configuration
@PropertySource("classpath:Config.properties")
public class MakeDaoImpl extends AbstractDao implements MakeDao {
    @Autowired
    Environment env;

    public List<Make> getAllMakes() {
        Criteria criteria = getSession().createCriteria(Make.class);
        return (List<Make>) criteria.list();
    }

    public List<Make> getMakes(int startIndex) {
        Criteria criteria = getSession().createCriteria(Make.class);
        String propertyOrder = env.getProperty(Constants.MAKE.ORDER_ATTRIBUTE);
        int pageSize = Integer.parseInt(env.getProperty(Constants.MAKE.PAGE_SIZE));
        criteria.addOrder(Order.asc(propertyOrder));
        criteria.setMaxResults(pageSize);
        criteria.add(Restrictions.gt(propertyOrder, startIndex));
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
        return getSession().get(Make.class, makeId);
    }

}
