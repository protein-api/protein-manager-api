package com.absolem.protein.api.service.impl;

import com.absolem.protein.api.model.dao.GenericDAO;
import com.absolem.protein.api.service.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by murmu on 26/05/17.
 */
@Service
public abstract class AbstractGenericServiceImpl <T,E extends GenericDAO<T>> implements GenericService<T>{



    @Autowired

    private E genericDAO;

    public E getGenericDAO() {
        return genericDAO;
    }

    public void setGenericDAO(E genericDAO) {
        this.genericDAO = genericDAO;
    }

    @Override
    public List<T> list() {
        return genericDAO.list();
    }

    @Override
    public T get(Long id) {
        return genericDAO.get(id);
    }

    @Override
    public T save(T entity) {
        return genericDAO.save(entity);
    }

    @Override
    public void update(T entity) {
         genericDAO.update(entity);
    }
}
