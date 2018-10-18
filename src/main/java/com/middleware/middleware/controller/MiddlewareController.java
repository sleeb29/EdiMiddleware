package com.middleware.middleware.controller;

import com.middleware.middleware.service.ConverterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class MiddlewareController {

    @Autowired
    ConverterService converterService;

    @RequestMapping(value="/converter/*/*", method = RequestMethod.POST)
    public ResponseEntity<Void> ediListener(String purchaseOrder){
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
