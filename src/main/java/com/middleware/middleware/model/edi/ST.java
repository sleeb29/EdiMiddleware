package com.middleware.middleware.model.edi;

public abstract class ST {

   String transactionSetIdentifierCode;
   String transactionSetControlNumber;

    public void setTransactionSetIdentifierCode(String transactionSetIdentifierCode) {
        this.transactionSetIdentifierCode = transactionSetIdentifierCode;
    }

    public void setTransactionSetControlNumber(String transactionSetControlNumber) {
        this.transactionSetControlNumber = transactionSetControlNumber;
    }

    public String getTransactionSetIdentifierCode() {
        return transactionSetIdentifierCode;
    }

    public String getTransactionSetControlNumber() {
        return transactionSetControlNumber;
    }
}
