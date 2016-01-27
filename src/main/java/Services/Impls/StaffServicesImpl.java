package Services.Impls;

import Dao.StaffDao;
import Models.Staff;
import Services.StaffServices;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by phong on 1/22/2016.
 */
public class StaffServicesImpl implements StaffServices {
    @Autowired
    StaffDao staffDao;

    public List<Staff> getAllStaffs() {
        return staffDao.getAllStaffs();
    }

    public Integer save(Staff staff) {
        return staffDao.save(staff);
    }

    public boolean delete(Integer staffId) {
        try {
            staffDao.delete(staffId);
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    public Staff findById(Integer staffId) {
        return staffDao.findById(staffId);
    }
}
