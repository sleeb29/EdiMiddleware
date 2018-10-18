package com.middleware.middleware.model.edi.po;

public class REF {

    String referenceIdentificationQualifier;
    String referenceIdentification;
    String description;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
