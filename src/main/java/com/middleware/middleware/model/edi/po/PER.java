package com.middleware.middleware.model.edi.po;

public class PER {

    String contractFunctionCode;
    String name;
    String communicationNumberQualifier;
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
