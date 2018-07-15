package com.absolem.protein.api.repository;

import com.absolem.protein.api.model.Proteina;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProteinRepository extends JpaRepository<Proteina, Long> {

    List<Proteina> findByNombreContainingOrCodigoUniProtContaining(String nombre, String codigoUniProt);

    @Query("select p from Proteina p join Reaccion r ON p.id = r.proteina.id WHERE r.nombre LIKE %?1%")
    List<Proteina> findByReaction(String search);

    List<Proteina> findByOrganismoContaining(String organismo);
}