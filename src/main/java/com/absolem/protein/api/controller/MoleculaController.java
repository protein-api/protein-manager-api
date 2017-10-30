package com.absolem.protein.api.controller;

import com.absolem.protein.api.model.Molecula;
import com.absolem.protein.api.service.MoleculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by murmu on 06/09/17.
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController()
@RequestMapping("/molecula")

public class MoleculaController {

    @Autowired
    private MoleculaService moleculaService;

    @RequestMapping( method = RequestMethod.POST)
    public ResponseEntity<Molecula>add(@RequestBody Molecula molecula){
        Molecula result = this.moleculaService.save(molecula);
        return  new ResponseEntity<Molecula>(result, HttpStatus.OK);
    }
}
