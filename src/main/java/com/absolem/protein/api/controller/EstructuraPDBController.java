package com.absolem.protein.api.controller;

import com.absolem.protein.api.model.EstructuraPDB;
import com.absolem.protein.api.service.EstructuraPDBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by murmu on 04/08/17.
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController()
@RequestMapping("/estrutura-pdb")
public class EstructuraPDBController {

    @Autowired
    private EstructuraPDBService estructuraPDBService;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<EstructuraPDB>add(@RequestBody EstructuraPDB estructuraPDB, @RequestParam("idProteina") Long idProteina){

        EstructuraPDB result = estructuraPDBService.save(estructuraPDB);
        return new ResponseEntity<EstructuraPDB>(result, HttpStatus.OK);
    }
}
