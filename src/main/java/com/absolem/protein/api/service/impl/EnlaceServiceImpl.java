package com.absolem.protein.api.service.impl;

import com.absolem.protein.api.model.Enlace;
import com.absolem.protein.api.model.Proteina;
import com.absolem.protein.api.model.TipoEnlace;
import com.absolem.protein.api.model.dao.EnlaceDAO;
import com.absolem.protein.api.model.dao.ProteinaDAO;
import com.absolem.protein.api.service.EnlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by murmu on 20/06/17.
 */
@Service
public class EnlaceServiceImpl extends AbstractGenericServiceImpl<Enlace,EnlaceDAO> implements EnlaceService {

    @Autowired
    private ProteinaDAO proteinaDAO;

    @Override
    public Enlace save(Enlace enlace, Long idProteina) {
        Proteina proteina = proteinaDAO.get(idProteina);
        //TODO poner validacion de existencia de proteina

        if(proteina!=null){
          enlace.setProteina(proteina);
          this.getGenericDAO().save(enlace);
        }
        return enlace;
    }

    @Override
    public List<Enlace> list(TipoEnlace tipoEnlace, Long idProteina) {
        return ((EnlaceDAO)this.getGenericDAO()).list(tipoEnlace,idProteina);
    }
}
