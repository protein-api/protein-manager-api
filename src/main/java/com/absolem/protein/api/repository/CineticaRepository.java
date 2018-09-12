package com.absolem.protein.api.repository;

import com.absolem.protein.api.model.Cinetica;
import com.absolem.protein.api.model.Reaccion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CineticaRepository extends JpaRepository<Cinetica, Long> {

    List<Cinetica> findByProteinaId(Long proteinId);

    List<Cinetica> findByReaccion(Reaccion reaccion);
}
