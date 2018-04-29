package com.absolem.protein.api.model.dao;

import com.absolem.protein.api.model.Proteina;

import java.util.List;

/**
 * Created by murmu on 22/05/17.
 */
public interface ProteinaDAO extends GenericDAO<Proteina> {

    List<Proteina> list(String search);
    Proteina merge(Proteina proteina);
    List<Proteina> getAll();
    List<Proteina> findByNameOrUniprot(String search);
    List<Proteina> searchByReaction(String search);
    List<Proteina> searchByOrganism(String search);
}
