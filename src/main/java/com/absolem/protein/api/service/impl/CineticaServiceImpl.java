package com.absolem.protein.api.service.impl;

import com.absolem.protein.api.model.Cinetica;
import com.absolem.protein.api.model.Reaccion;
import com.absolem.protein.api.model.dao.CineticaDAO;
import com.absolem.protein.api.model.dao.ReaccionDAO;
import com.absolem.protein.api.service.CineticaService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by murmu on 06/09/17.
 */
public class CineticaServiceImpl extends AbstractGenericServiceImpl<Cinetica,CineticaDAO> implements CineticaService{

    @Autowired
    private ReaccionDAO reaccionDAO;

    @Override
    public Cinetica save(Cinetica cinetica, Long idReaccion) {
        Reaccion reaccion = reaccionDAO.get(idReaccion);
        //TODO poner validacion de existencia de proteina

        if(reaccion!=null){
            cinetica.setReaccion(reaccion);
            this.getGenericDAO().save(cinetica);
        }
        return cinetica;
    }
}
