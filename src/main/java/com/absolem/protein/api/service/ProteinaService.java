package com.absolem.protein.api.service;

import com.absolem.protein.api.model.Enlace;
import com.absolem.protein.api.model.Proteina;

import java.util.List;

/**
 * Created by murmu on 26/05/17.
 */
public interface ProteinaService extends GenericService<Proteina> {

    List<Proteina> list(String search);
    Proteina get(Long idProteina);
    Proteina addEnlace(Long idProteina, Enlace enlace);
    List<Proteina> getAll();
    List<Proteina> findByNameOrUniprot(String search);
    List<Proteina> searchByReaction(String search);
    List<Proteina> searchByOrganism(String search);
}
