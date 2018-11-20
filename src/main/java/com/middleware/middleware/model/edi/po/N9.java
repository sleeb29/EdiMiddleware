package com.middleware.middleware.model.edi.po;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElement;

@XmlRootElement(name = "N9")
@XmlAccessorType(XmlAccessType.FIELD)
public class N9 {
	@XmlElement(name="referenceIdentificationQualifier")
    String referenceIdentificationQualifier;
	@XmlElement(name="referenceIdentification")
    String referenceIdentification;

    public String getReferenceIdentificationQualifier() {
        return referenceIdentificationQualifier;
    }

    public void setReferenceIdentificationQualifier(String referenceIdentificationQualifier) {
        this.referenceIdentificationQualifier = referenceIdentificationQualifier;
    }

    public String getReferenceIdentification() {
        return referenceIdentification;
    }

    public void setReferenceIdentification(String referenceIdentification) {
        this.referenceIdentification = referenceIdentification;
    }
}
