package com.absolem.protein.api.controller;

import com.absolem.protein.api.model.Cinetica;
import com.absolem.protein.api.service.CineticaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController()
@RequestMapping("/cineticas")
public class CineticaController {

    @Autowired
    private CineticaService cineticaService;

    @RequestMapping(path = "/getByProteinId/{proteinId}", method = RequestMethod.GET)
    public ResponseEntity<List<List<Cinetica>>> getByProteinId(@PathVariable Long proteinId){
        List<List<Cinetica>> result = this.cineticaService.findByProteinId(proteinId);
        return  new ResponseEntity<>(result, HttpStatus.OK);

    }

    @RequestMapping(path = "/getByReaccionId/{reaccionId}", method = RequestMethod.GET)
    public ResponseEntity<List<List<Cinetica>>> getByReaccionId(@PathVariable Long reaccionId){
        List<List<Cinetica>> result = this.cineticaService.findByReaccionId(reaccionId);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

}
