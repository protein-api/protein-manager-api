package com.absolem.protein.api.controller;

/**
 * Created by murmu on 26/05/17.
 */

import com.absolem.protein.api.model.Proteina;
import com.absolem.protein.api.service.ProteinaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController()
@RequestMapping("/proteins")
public class ProteinaController {

    @Autowired
    private ProteinaService proteinaService;



    @RequestMapping( method = RequestMethod.POST)
    public ResponseEntity<Proteina> add(@RequestBody Proteina proteina){
        Proteina result = proteinaService.save(proteina);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @RequestMapping(path = "/get/{idProteina}", method = RequestMethod.GET)
    public ResponseEntity<Proteina>get(@PathVariable Long idProteina){
        Proteina result = proteinaService.get(idProteina);
        return  new ResponseEntity<>(result,HttpStatus.OK);
    }

    @RequestMapping(path = "/getAll", method = RequestMethod.GET)
    public ResponseEntity<List<Proteina>> getAll() {
        List<Proteina> result = proteinaService.getAll();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @RequestMapping(path = "/search/{search}", method = RequestMethod.GET)
    public ResponseEntity<List<Proteina>> findBy(@PathVariable String search){
        List<Proteina> result = proteinaService.findByNameOrUniprot(search);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @RequestMapping(path = "/searchByReaction/{search}", method = RequestMethod.GET)
    public ResponseEntity<List<Proteina>> searchByReaction(@PathVariable String search){
        List<Proteina> result = proteinaService.searchByReaction(search);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @RequestMapping(path = "/searchByOrganism/{search}", method = RequestMethod.GET)
    public ResponseEntity<List<Proteina>> searchByOrganism(@PathVariable String search){
        List<Proteina> result = proteinaService.searchByOrganism(search);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }


    @RequestMapping(
            value = "/**",
            method = RequestMethod.OPTIONS
    )
    public ResponseEntity handle() {
        return new ResponseEntity(HttpStatus.OK);
    }
}
