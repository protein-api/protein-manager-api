package com.absolem.protein.api;

import com.absolem.protein.api.model.Proteina;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by murmu on 27/05/17.
 */
@RestController
public class RestHello {

    @RequestMapping( name ="/hello",method = RequestMethod.GET)
    public ResponseEntity<String> get(){
        String hello ="Hello";
        return new ResponseEntity<String>(hello, HttpStatus.OK);
    }
}
