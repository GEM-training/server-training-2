package Dao;

import Models.Staff;
import org.hibernate.Criteria;

import java.util.List;

/**
 * Created by phong on 20/01/2016.
 */
public class StaffDaoImpl extends AbstractDao implements StaffDao {

    public List<Staff> getStaffs() {
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
        return (Staff) getObjectById(id);
    }
}
