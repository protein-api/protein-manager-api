package com.absolem.protein.api.service;

import com.absolem.protein.api.model.Cinetica;
import com.absolem.protein.api.model.Reaccion;
import com.absolem.protein.api.repository.CineticaRepository;
import com.absolem.protein.api.repository.ReactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;

@Service
public class CineticaService {

    @Autowired
    private CineticaRepository cineticaRepository;

    @Autowired
    private ReactionRepository reactionRepository;

    public List<List<Cinetica>> findByProteinId(Long proteinId) {
        List<Cinetica> cineticas = this.cineticaRepository.findByProteinaId(proteinId);
        Map<Long, List<Cinetica>> result = cineticas.stream().collect(groupingBy(Cinetica::getParejitaId));
        return new ArrayList<>(result.values());
    }

    public List<List<Cinetica>> findByReaccionId(Long reaccionId) {
        Reaccion reaccion = this.reactionRepository.getOne(reaccionId);
        List<Cinetica> cineticas = this.cineticaRepository.findByReaccion(reaccion);
        Map<Long, List<Cinetica>> result = cineticas.stream().collect(groupingBy(Cinetica::getParejitaId));
        return new ArrayList<>(result.values());
    }
}
