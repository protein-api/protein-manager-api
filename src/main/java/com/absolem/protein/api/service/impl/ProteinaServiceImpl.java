package com.absolem.protein.api.service.impl;

import com.absolem.protein.api.model.Enlace;
import com.absolem.protein.api.model.Proteina;
import com.absolem.protein.api.model.dao.ProteinaDAO;
import com.absolem.protein.api.service.GenericService;
import com.absolem.protein.api.service.ProteinaService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by murmu on 26/05/17.
 */
@Service
public class ProteinaServiceImpl extends AbstractGenericServiceImpl<Proteina,ProteinaDAO> implements ProteinaService{
    @Override
    public List<Proteina> list(String search) {
        return this.getGenericDAO().list(search);
    }

    @Override
    public Proteina addEnlace(Long idProteina, Enlace enlace) {
        Proteina proteina = this.getGenericDAO().get(idProteina);
        if(proteina != null){
            enlace.setProteina(proteina);
            proteina.getDois().add(enlace);
            this.getGenericDAO().update(proteina);
        }

        return null;
    }

    @Override
    public List<Proteina> getAll() {
        return this.getGenericDAO().getAll();
    }

    @Override
    public List<Proteina> findByNameOrUniprot(String search) {
        return this.getGenericDAO().findByNameOrUniprot(search);
    }

    @Override
    public List<Proteina> searchByReaction(String search) {
        return this.getGenericDAO().searchByReaction(search);
    }

    @Override
    public List<Proteina> searchByOrganism(String search) {
        return this.getGenericDAO().searchByOrganism(search);
    }

    public Proteina get(Long id){
       Proteina result =  this.getGenericDAO().get(id);
       //result.setDois(null);
       return result;
    }
}
