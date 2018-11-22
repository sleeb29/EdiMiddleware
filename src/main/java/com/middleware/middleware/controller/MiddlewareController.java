package com.middleware.middleware.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.middleware.middleware.model.edi.po.EDI850;
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

    @RequestMapping(value="/converter", method = RequestMethod.POST)
    public ResponseEntity<Void> ediListener(@RequestBody EDI850 purchaseOrder){
        System.out.println(purchaseOrder);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value="/x12", method = RequestMethod.POST)
    public ResponseEntity<String > x12Listener(@RequestBody String purchaseOrder) throws NoSuchFieldException, IllegalAccessException, JsonProcessingException {
        String x12 = converterService.convertToEDI850(purchaseOrder);
        return new ResponseEntity<>(x12, HttpStatus.OK);
    }

}
