package com.absolem.protein.api.service;

import com.absolem.protein.api.model.Enlace;
import com.absolem.protein.api.model.TipoEnlace;

import java.util.List;

/**
 * Created by murmu on 20/06/17.
 */
public interface EnlaceService extends GenericService<Enlace> {

    Enlace save(Enlace enlace, Long idProteina);

    List<Enlace> list(TipoEnlace tipoEnlace,Long idProteina);
}
