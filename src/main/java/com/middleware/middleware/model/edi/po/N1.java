package com.middleware.middleware.model.edi.po;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElement;

@XmlRootElement(name = "EDI850")
@XmlAccessorType(XmlAccessType.FIELD)
public class N1 {
	@XmlElement(name="entityIdCode")
    String entityIdCode;
	@XmlElement(name="nameOfBuyingParty")
    String nameOfBuyingParty;
	@XmlElement(name="idCodeQualifier")
    String idCodeQualifier;
	@XmlElement(name="idCode")
    String idCode;

    public String getEntityIdCode() {
        return entityIdCode;
    }

    public void setEntityIdCode(String entityIdCode) {
        this.entityIdCode = entityIdCode;
    }

    public String getNameOfBuyingParty() {
        return nameOfBuyingParty;
    }

    public void setNameOfBuyingParty(String nameOfBuyingParty) {
        this.nameOfBuyingParty = nameOfBuyingParty;
    }

    public String getIdCodeQualifier() {
        return idCodeQualifier;
    }

    public void setIdCodeQualifier(String idCodeQualifier) {
        this.idCodeQualifier = idCodeQualifier;
    }

    public String getIdCode() {
        return idCode;
    }

    public void setIdCode(String idCode) {
        this.idCode = idCode;
    }
}
