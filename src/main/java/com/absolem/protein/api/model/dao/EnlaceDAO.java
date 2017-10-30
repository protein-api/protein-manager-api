package com.absolem.protein.api.model.dao;

import com.absolem.protein.api.model.Enlace;
import com.absolem.protein.api.model.TipoEnlace;

import java.util.List;

/**
 * Created by murmu on 20/06/17.
 */
public interface EnlaceDAO extends GenericDAO<Enlace> {

    List<Enlace> list (TipoEnlace tipoEnlace, Long idProteina);
}
