package com.middleware.middleware.model.edi.po;

import com.middleware.middleware.model.edi.ST;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElement;

@XmlRootElement(name = "ST")
@XmlAccessorType(XmlAccessType.FIELD)
public class PO_ST extends ST {
	@XmlElement(name="BEG")
    BEG BEG;
	@XmlElement(name="CTT")
    CTT CTT;

    public BEG getBEG() {
        return BEG;
    }

    public void setBEG(BEG BEG) {
        this.BEG = BEG;
    }

    public CTT getCTT() {
        return CTT;
    }

    public void setCTT(CTT CTT) {
        this.CTT = CTT;
    }
}
