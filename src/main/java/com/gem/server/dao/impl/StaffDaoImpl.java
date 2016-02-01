package com.gem.server.dao.impl;

import com.gem.server.utils.Constants;
import com.gem.server.dao.StaffDao;
import com.gem.server.model.Staff;
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

@Configuration
@PropertySource("classpath:config.properties")
public class StaffDaoImpl extends GenericDaoImpl<Staff> implements StaffDao {
    @Autowired
    Environment env;

    private String propertyOrderStaff;
    private int staffPageSize;

    public StaffDaoImpl() {
        super(Staff.class);
    }

    public List<Staff> getStaffs(int startIndex) {
        propertyOrderStaff = env.getProperty(Constants.STAFF.order);
        staffPageSize = Integer.parseInt(env.getProperty(Constants.STAFF.page_size));
        Criteria criteria = getSession().createCriteria(Staff.class);
        criteria.addOrder(Order.asc(propertyOrderStaff));
        criteria.setMaxResults(staffPageSize);
        criteria.add(Restrictions.gt(propertyOrderStaff, startIndex));
        return (List<Staff>) criteria.list();
    }
}
