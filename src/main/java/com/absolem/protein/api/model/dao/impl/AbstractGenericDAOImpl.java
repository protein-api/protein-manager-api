package com.absolem.protein.api.model.dao.impl;

import com.absolem.protein.api.model.Proteina;
import com.absolem.protein.api.model.dao.GenericDAO;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 * Created by murmu on 26/05/17.
 */
@SuppressWarnings("unchecked")
public abstract class AbstractGenericDAOImpl<T> implements GenericDAO<T> {

    private final Class<T> entityClass;

    @Autowired
    protected SessionFactory sessionFactory;

    protected AbstractGenericDAOImpl() {
        this.entityClass = (Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass())
                .getActualTypeArguments()[0];
    }


    @Override
    public List<T> list() {
        Criteria criteria = sessionFactory.openSession().createCriteria(entityClass);

        return criteria.list();
    }

    @Override
    public T get(Long id) {
        return sessionFactory.openSession().get(entityClass,id);
    }

    @Override
    public T save(T entity) {
        Session session = sessionFactory.openSession();
        Long id = (Long) session.save(entity);
        return  session.get(entityClass,id);
    }

    @Override
    public void update(T entity) {
          sessionFactory.openSession().update(entity);
    }
}
