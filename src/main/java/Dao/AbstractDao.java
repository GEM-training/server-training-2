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

    public Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    protected void persist(Object entity) {
        getSession().persist(entity);
    }

}
