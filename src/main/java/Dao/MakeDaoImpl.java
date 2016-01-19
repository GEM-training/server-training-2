package Dao;

import Models.Make;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created by hoapham on 19/01/2016.
 */
public class MakeDaoImpl extends AbstractDao implements MakesDao {


    public List<Make> getAllMakes() {
        Criteria criteria = getSession().createCriteria(Make.class);
        return (List<Make>)criteria.list();
    }

    public Integer save(Make make) {
        return (Integer)getSession().save(make);
    }

    public void deleteMake(Integer makeId) {
        Make make = getSession().load(Make.class,makeId);
        if(make!=null)
            getSession().delete(make);
    }

    public Make findById(Integer makeId) {
        return (Make) getObjectById(makeId);
    }

}
