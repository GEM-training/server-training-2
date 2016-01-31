package com.gem.server.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.io.Serializable;
import java.util.List;

/**
 * Created by hoapham on 19/01/2016.
 */
public interface GenericDao<T> {
    public T findById(Integer id);

    public List<T> findAll();

    public Integer save(T entity);

    public void update(T entity);

    public void delete(T entity);

    public void deleteById(Integer entityId);

    public Session getSession();

}
