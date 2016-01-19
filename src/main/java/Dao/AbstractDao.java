package Dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by hoapham on 19/01/2016.
 */
public class AbstractDao {
    @Autowired
    private SessionFactory sessionFactory;

    public AbstractDao() {

    }

    public Session getSession(){
        return sessionFactory.getCurrentSession();
    }

    protected void persist(Object entity) {
        getSession().persist(entity);
    }

    public void delete(Object entity) {
        getSession().delete(entity);
    }

    public Object saveObject(Object object) {
        Object id= getSession().save(object);
        return id;
    }

    protected Object getObjectById(Integer objectId) {
        Object obj = getSession().get(getClass(), objectId);
        return obj;
    }
    protected List<Object> getAllObjects() {
        List results = getSession().createCriteria(getClass()).list();
        return results;
    }

    public void deleteObjectById(Integer objectId) {
        Session session = getSession();
        Object object = session.get(getClass(), objectId);
        session.delete(object);
    }

}
