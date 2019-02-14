package com.absolem.protein.api.model.dao;


import java.util.List;

/**
 * Created by murmu on 26/05/17.
 */
public interface GenericDAO<T> {

    List<T> list();
    T get(Long id);
    T save(T entity);
    void update(T entity);
}
