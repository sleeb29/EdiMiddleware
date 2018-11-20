package com.middleware.middleware.model.edi;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElement;

@XmlRootElement(name = "SE")
@XmlAccessorType(XmlAccessType.FIELD)
public class SE {
	@XmlElement(name="numberOfSegmenetsIncluded")
    String numberOfSegmenetsIncluded;
	@XmlElement(name="transactionSetControlNumber")
    String transactionSetControlNumber;

    public String getNumberOfSegmenetsIncluded() {
        return numberOfSegmenetsIncluded;
    }

    public void setNumberOfSegmenetsIncluded(String numberOfSegmenetsIncluded) {
        this.numberOfSegmenetsIncluded = numberOfSegmenetsIncluded;
    }

    public String getTransactionSetControlNumber() {
        return transactionSetControlNumber;
    }

    public void setTransactionSetControlNumber(String transactionSetControlNumber) {
        this.transactionSetControlNumber = transactionSetControlNumber;
    }
}
