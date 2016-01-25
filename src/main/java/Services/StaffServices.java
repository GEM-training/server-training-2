package Services;

import Models.Staff;

import java.util.List;

/**
 * Created by phong on 1/22/2016.
 */
public interface StaffServices {
    List<Staff> getAllStaffs();

    Integer save(Staff staff);

    void delete(Integer staffId);

    Staff findById(Integer staffId);

}
