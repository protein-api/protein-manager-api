package com.absolem.protein.api.model.dao.impl;

import com.absolem.protein.api.model.Enlace;
import com.absolem.protein.api.model.Reaccion;
import com.absolem.protein.api.model.TipoEnlace;
import com.absolem.protein.api.model.dao.ReaccionDAO;
import org.hibernate.Query;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by murmu on 31/05/17.
 */
@Component
public class ReaccionDAOImpl extends AbstractGenericDAOImpl<Reaccion> implements ReaccionDAO {

    @Override
    public List<Reaccion> list( Long idProteina) {
        Query query = this.sessionFactory.openSession().createSQLQuery("select * from reaccion where proteina_id = :idProteina").addEntity("reaccion",Reaccion.class);
        query.setParameter("idProteina",idProteina);
        return  query.list();
    }
}
