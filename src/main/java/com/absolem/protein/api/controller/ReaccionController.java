package com.absolem.protein.api.controller;

import com.absolem.protein.api.model.Enlace;
import com.absolem.protein.api.model.Reaccion;
import com.absolem.protein.api.model.TipoEnlace;
import com.absolem.protein.api.service.ReaccionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by murmu on 31/05/17.
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/reaccion")
public class ReaccionController {

    @Autowired
    private ReaccionService reaccionService;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Reaccion> add(@RequestBody Reaccion reaccion, @RequestParam("idProteina") Long idProteina){
        Reaccion result = this.reaccionService.save(reaccion,idProteina);
        return new ResponseEntity<Reaccion>(result, HttpStatus.OK);
    }


    @RequestMapping( method = RequestMethod.GET)
    public ResponseEntity<List<Reaccion>>list( @RequestParam("idProteina") Long idProteina){
        List<Reaccion> result = reaccionService.list(idProteina);
        return new ResponseEntity<List<Reaccion>>(result, HttpStatus.OK);
    }

    @RequestMapping(
            value = "/**",
            method = RequestMethod.OPTIONS
    )
    public ResponseEntity handle() {
        return new ResponseEntity(HttpStatus.OK);
    }

}
