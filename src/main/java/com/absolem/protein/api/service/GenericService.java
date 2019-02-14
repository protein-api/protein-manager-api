package com.absolem.protein.api.service;

import java.util.List;

/**
 * Created by murmu on 26/05/17.
 */
public interface GenericService <T> {

    List<T> list();
    T get(Long id);
    T save(T entity);
    void update(T entity);
}
