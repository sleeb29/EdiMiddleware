package com.middleware.middleware.model.edi.po;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElement;

@XmlRootElement(name = "PER")
@XmlAccessorType(XmlAccessType.FIELD)
public class PER {
	@XmlElement(name="contractFunctionCode")
    String contractFunctionCode;
	@XmlElement(name="name")
    String name;
	@XmlElement(name="communicationNumberQualifier")
    String communicationNumberQualifier;
	@XmlElement(name="telephoneNumber")
    String telephoneNumber;

    public String getContractFunctionCode() {
        return contractFunctionCode;
    }

    public void setContractFunctionCode(String contractFunctionCode) {
        this.contractFunctionCode = contractFunctionCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCommunicationNumberQualifier() {
        return communicationNumberQualifier;
    }

    public void setCommunicationNumberQualifier(String communicationNumberQualifier) {
        this.communicationNumberQualifier = communicationNumberQualifier;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }
}
