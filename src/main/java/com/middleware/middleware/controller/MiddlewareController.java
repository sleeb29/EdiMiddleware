package com.middleware.middleware.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.middleware.middleware.model.edi.po.EDI850;
import com.middleware.middleware.service.ConverterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;


@RestController
public class MiddlewareController {

    @Autowired
    ConverterService converterService;

    @RequestMapping(value="/x12", method = RequestMethod.POST)
    public ResponseEntity<Void > x12Listener(@RequestBody String purchaseOrder) throws NoSuchFieldException, IllegalAccessException, JsonProcessingException {
        converterService.convertToEDI850(purchaseOrder);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value="/processPurchaseOrders", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<List<EDI850>> processPurchaseOrder() throws JsonProcessingException {
        List<EDI850> edi850Messages = converterService.processPurchaseOrders();
        return new ResponseEntity<>(edi850Messages, HttpStatus.OK);
    }

    @RequestMapping(value="/sendPurchaseOrderResponse", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Void> sendPurchaseOrderResponse(@RequestBody EDI850 purchaseOrder) throws JsonProcessingException {
        converterService.sendProcessedPurchaseOrder(purchaseOrder);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value="/x12Response", method = RequestMethod.GET)
    public ResponseEntity<String> getX12Response() throws IOException, IllegalAccessException {
        String x12Response = converterService.getX12Response();
        return new ResponseEntity<>(x12Response, HttpStatus.OK);
    }
}
