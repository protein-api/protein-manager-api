package com.absolem.protein.api.service;

import com.absolem.protein.api.model.Proteina;
import com.absolem.protein.api.repository.ProteinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class ProteinService {

    @Autowired
    private ProteinRepository proteinRepository;

    public List<Proteina> findAll() {
        return this.proteinRepository.findAll();
    }

    public Proteina findById(Long proteinId) {
        return this.proteinRepository.findById(proteinId).orElseThrow(() -> new EntityNotFoundException());
    }

    public List<Proteina> findByNameOrUniprot(String search) {
        return this.proteinRepository.findByNombreContainingOrCodigoUniProtContaining(search, search);
    }

    public List<Proteina> searchByReaction(String search) {
        return this.proteinRepository.findByReaction(search);
    }

    public List<Proteina> searchByOrganism(String search) {
        return this.proteinRepository.findByOrganismoContaining(search);
    }
}
