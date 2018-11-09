package com.middleware.middleware.converter;

import com.middleware.middleware.model.edi.EDI;
import com.middleware.middleware.model.edi.po.EDI850;

public class StringToEDIConverter {

    public EDI convertToEDI850Object(String message){

        EDI850 edi850 = new EDI850();
        String[] lines = message.split("\n");

        return null;

    }

}
