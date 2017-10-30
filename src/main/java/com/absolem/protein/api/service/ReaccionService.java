package com.absolem.protein.api.service;

import com.absolem.protein.api.model.Reaccion;

import java.util.List;

/**
 * Created by murmu on 31/05/17.
 */
public interface ReaccionService extends GenericService<Reaccion> {

    Reaccion save (Reaccion reaccion,Long idProteina);

    List<Reaccion> list(Long idProteina);
}
