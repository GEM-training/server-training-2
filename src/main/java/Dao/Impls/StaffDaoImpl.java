package Dao.Impls;

import Dao.AbstractDao;
import Dao.StaffDao;
import Models.Staff;
import Utils.Constants;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by phong on 20/01/2016.
 */
@Transactional
@Configuration
@PropertySource("classpath:Config.properties")
public class StaffDaoImpl extends AbstractDao implements StaffDao {
    @Autowired
    Environment env;

    public List<Staff> getAllStaffs() {
        Criteria criteria = getSession().createCriteria(Staff.class);
        return (List<Staff>) criteria.list();
    }

    public Integer save(Staff staff) {
        return (Integer) getSession().save(staff);
    }

    public void delete(Integer id) {
        Staff staff = getSession().load(Staff.class, id);
        if (staff != null)
            getSession().delete(staff);
    }


    public Staff findById(Integer id) {
        return getSession().get(Staff.class, id);
    }

    public List<Staff> getStaffs(int startIndex) {
        Criteria criteria = getSession().createCriteria(Staff.class);
        String propertyOrder = env.getProperty(Constants.STAFF.ORDER_ATTRIBUTE);
        int pageSize = Integer.parseInt(env.getProperty(Constants.STAFF.PAGE_SIZE));
        criteria.addOrder(Order.asc(propertyOrder));
        criteria.setMaxResults(pageSize);
        criteria.add(Restrictions.gt(propertyOrder, startIndex));
        return (List<Staff>) criteria.list();
    }
}
