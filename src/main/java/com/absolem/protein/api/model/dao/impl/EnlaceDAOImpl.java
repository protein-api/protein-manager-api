package com.absolem.protein.api.model.dao.impl;

import com.absolem.protein.api.model.Enlace;
import com.absolem.protein.api.model.TipoEnlace;
import com.absolem.protein.api.model.dao.EnlaceDAO;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EnlaceDAOImpl extends AbstractGenericDAOImpl<Enlace> implements EnlaceDAO {

    @Override
    public Enlace save(Enlace entity) {
        Session session = sessionFactory.openSession();
        Long id = (Long) session.save(entity);
        entity.setId(id);
        return entity;
    }

    @Override
    public List<Enlace> list(TipoEnlace tipoEnlace, Long idProteina) {
        Query query = this.sessionFactory.openSession().createSQLQuery("select * from enlace where proteina_id = :idProteina and tipo =:tipoEnlace").addEntity("enlace",Enlace.class);
        query.setParameter("idProteina",idProteina);
        query.setParameter("tipoEnlace",tipoEnlace);
        return  query.list();
    }
}
