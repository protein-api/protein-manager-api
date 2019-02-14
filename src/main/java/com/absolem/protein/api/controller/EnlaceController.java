package com.absolem.protein.api.controller;


import com.absolem.protein.api.model.Enlace;
import com.absolem.protein.api.model.Proteina;
import com.absolem.protein.api.model.TipoEnlace;
import com.absolem.protein.api.service.EnlaceService;
import com.absolem.protein.api.service.ProteinaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController()
@RequestMapping("/enlace")
public class EnlaceController {

    @Autowired
    private EnlaceService enlaceService;
    @Autowired
    ProteinaService proteinaService;

    public EnlaceService getEnlaceService() {
        return enlaceService;
    }

    public void setEnlaceService(EnlaceService enlaceService) {
        this.enlaceService = enlaceService;
    }

    @RequestMapping( method = RequestMethod.POST)
    public ResponseEntity<Enlace> add(@RequestBody Enlace enlace, @RequestParam("idProteina") Long idProteina){
       // Proteina proteina = proteinaService.addEnlace(idProteina,enlace);
        Enlace result = enlaceService.save(enlace,idProteina);
        return new ResponseEntity<Enlace>(enlace, HttpStatus.OK);
    }

    @RequestMapping( method = RequestMethod.GET)
    public ResponseEntity<List<Enlace>>list(@RequestParam("tipo")TipoEnlace tipoEnlace, @RequestParam("idProteina") Long idProteina){
        List<Enlace> result = enlaceService.list(tipoEnlace,idProteina);
        return new ResponseEntity<List<Enlace>>(result, HttpStatus.OK);
    }

    @RequestMapping(
            value = "/**",
            method = RequestMethod.OPTIONS
    )
    public ResponseEntity handle() {
        return new ResponseEntity(HttpStatus.OK);
    }




}
