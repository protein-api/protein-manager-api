package com.absolem.protein.api.model.dao;

import com.absolem.protein.api.model.Reaccion;

import java.util.List;

/**
 * Created by murmu on 31/05/17.
 */
public interface ReaccionDAO extends GenericDAO<Reaccion> {

    List<Reaccion> list(Long idProteina);
}
