package com.middleware.middleware.model.edi.po;

import com.middleware.middleware.model.edi.EDI;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElement;

@XmlRootElement(name = "EDI850")
@XmlAccessorType(XmlAccessType.FIELD)
public class EDI850 {
    PO_ST ST;

    public PO_ST getST() {
        return ST;
    }

    public void setST(PO_ST ST) {
        this.ST = ST;
    }
}
