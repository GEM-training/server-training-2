package com.gem.server.dao.impl;

import com.gem.server.dao.GenericDao;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by hoak57uet on 1/29/16.
 */
@Transactional
public class GenericDaoImpl<T> implements GenericDao<T> {
    private Class<T> tClass;
    @Autowired
    SessionFactory sessionFactory;

    public GenericDaoImpl(Class<T> tClass) {
        this.tClass = tClass;
    }

    public T findById(Integer id) {
        return (T) getSession().get(tClass, id);
    }

    public List<T> findAll() {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(tClass.getName());
        return criteria.list();
    }

    public Integer save(T entity) {
        return (Integer) getSession().save(entity);
    }

    public void update(T entity) {
        getSession().update(entity);
    }

    public void delete(T entity) {
        getSession().delete(entity);
    }

    public void deleteById(Integer entityId) {
        T entity = findById(entityId);
        delete(entity);
    }

    public Class<T> gettClass() {
        return tClass;
    }

    public void settClass(Class<T> tClass) {
        this.tClass = tClass;
    }

    public Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
