package com.absolem.protein.api.model.dao.impl;

import com.absolem.protein.api.model.Proteina;
import com.absolem.protein.api.model.dao.ProteinaDAO;
import org.hibernate.Query;
import org.springframework.stereotype.Component;


import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by murmu on 22/05/17.
 */
@Component
public class ProteinaDAOImpl extends AbstractGenericDAOImpl<Proteina> implements ProteinaDAO{


    @Override
    public List<Proteina> list(String search) {
        Query query = this.sessionFactory.openSession().createSQLQuery("select prote.*,reac.* from proteina as prote, reaccion as reac" +
                " where reac.proteina_id = prote.id and (prote.nombre like :search or reac.nombre) order by case WHEN prote.nombre = :literal THEN 1        WHEN prote.nombre like :startWith THEN 2        when prote.nombre like :search THEN 3        when reac.nombre = :literal THEN 4        when reac.nombre like :startWith THEN 5        when reac.nombre like :search THEN 6        ELSE 7    end").addEntity("proteina",Proteina.class);
        query.setParameter("search","%"+search+"%");
        query.setParameter("startWith",search+"%");
        query.setParameter("literal",search);

        return (List<Proteina>) query.list().stream().distinct().collect(Collectors.toList());
    }

    @Override
    public Proteina merge(Proteina proteina) {
        this.sessionFactory.openSession().merge(proteina);
        return (Proteina) this.sessionFactory.openSession().merge(proteina);
    }

    @Override
    public List<Proteina> getAll() {
        Query query = this.sessionFactory.openSession().createSQLQuery("" +
                "SELECT * FROM proteina")
                .addEntity(Proteina.class);
        return (List<Proteina>) query.list().stream().distinct().collect(Collectors.toList());
    }

    @Override
    public List<Proteina> findByNameOrUniprot(String search) {
        Query query = this.sessionFactory.openSession().createSQLQuery("" +
                "SELECT * FROM proteina " +
                "WHERE proteina.nombre LIKE :nameOrUniprot OR proteina.codigo_uni_prot LIKE :nameOrUniprot")
                .addEntity(Proteina.class);
        query.setParameter("nameOrUniprot", "%"+search+"%");
        return (List<Proteina>) query.list().stream().distinct().collect(Collectors.toList());
    }

    @Override
    public List<Proteina> searchByReaction(String search) {
        Query query = this.sessionFactory.openSession().createSQLQuery("SELECT * FROM proteina JOIN reaccion ON proteina.id = reaccion.proteina_id WHERE reaccion.nombre LIKE :searchR")
                .addEntity(Proteina.class);
        query.setParameter("searchR", "%"+search+"%");
        return (List<Proteina>) query.list().stream().distinct().collect(Collectors.toList());
    }

    @Override
    public List<Proteina> searchByOrganism(String search) {
        Query query = this.sessionFactory.openSession().createSQLQuery("SELECT * FROM proteina WHERE proteina.organismo LIKE :organism")
                .addEntity(Proteina.class);
        query.setParameter("organism", "%"+search+"%");
        return (List<Proteina>) query.list().stream().distinct().collect(Collectors.toList());
    }


}
