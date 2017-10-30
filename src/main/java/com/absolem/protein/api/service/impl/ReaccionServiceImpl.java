package com.absolem.protein.api.service.impl;

import com.absolem.protein.api.model.Proteina;
import com.absolem.protein.api.model.Reaccion;
import com.absolem.protein.api.model.dao.ProteinaDAO;
import com.absolem.protein.api.model.dao.ReaccionDAO;
import com.absolem.protein.api.service.ReaccionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by murmu on 31/05/17.
 */
@Service
public class ReaccionServiceImpl extends AbstractGenericServiceImpl<Reaccion,ReaccionDAO> implements ReaccionService {

    @Autowired
    private ProteinaDAO proteinaDAO;

    @Override
    public Reaccion save(Reaccion reaccion, Long idProteina) {

        Proteina proteina = proteinaDAO.get(idProteina);
        if (proteina!=null){
            reaccion.setProteina(proteina);
            this.getGenericDAO().save(reaccion);
        }
        return reaccion;
    }

    public List<Reaccion> list(Long idProteina){
        return this.getGenericDAO().list(idProteina);
    }
}
