package com.absolem.protein.api.service;

import com.absolem.protein.api.model.Cinetica;

/**
 * Created by murmu on 06/09/17.
 */
public interface CineticaService extends GenericService<Cinetica> {

    Cinetica save(Cinetica cinetica, Long idProteina);
}
