package com.middleware.middleware.model.edi.po;

public class BEG {

    String transactionSetPurchaseCode;
    String purchaseOrderTypeCode;
    String purchaseOrderNumber;
    String releaseNumber;
    String purchaseOrderDate;
    String contractNumber;

    N9 N9;
    DTM DTM;
    EXT_MSG MSG;
    PO PO;
    REF REF;
    MSG MSG2;

    public String getTransactionSetPurchaseCode() {
        return transactionSetPurchaseCode;
    }

    public void setTransactionSetPurchaseCode(String transactionSetPurchaseCode) {
        this.transactionSetPurchaseCode = transactionSetPurchaseCode;
    }

    public String getPurchaseOrderTypeCode() {
        return purchaseOrderTypeCode;
    }

    public void setPurchaseOrderTypeCode(String purchaseOrderTypeCode) {
        this.purchaseOrderTypeCode = purchaseOrderTypeCode;
    }

    public String getPurchaseOrderNumber() {
        return purchaseOrderNumber;
    }

    public void setPurchaseOrderNumber(String purchaseOrderNumber) {
        this.purchaseOrderNumber = purchaseOrderNumber;
    }

    public String getReleaseNumber() {
        return releaseNumber;
    }

    public void setReleaseNumber(String releaseNumber) {
        this.releaseNumber = releaseNumber;
    }

    public String getPurchaseOrderDate() {
        return purchaseOrderDate;
    }

    public void setPurchaseOrderDate(String purchaseOrderDate) {
        this.purchaseOrderDate = purchaseOrderDate;
    }

    public String getContractNumber() {
        return contractNumber;
    }

    public void setContractNumber(String contractNumber) {
        this.contractNumber = contractNumber;
    }

    public com.middleware.middleware.model.edi.po.N9 getN9() {
        return N9;
    }

    public void setN9(com.middleware.middleware.model.edi.po.N9 n9) {
        N9 = n9;
    }

    public com.middleware.middleware.model.edi.po.DTM getDTM() {
        return DTM;
    }

    public void setDTM(com.middleware.middleware.model.edi.po.DTM DTM) {
        this.DTM = DTM;
    }

    public EXT_MSG getMSG() {
        return MSG;
    }

    public void setMSG(EXT_MSG MSG) {
        this.MSG = MSG;
    }

    public com.middleware.middleware.model.edi.po.PO getPO() {
        return PO;
    }

    public void setPO(com.middleware.middleware.model.edi.po.PO PO) {
        this.PO = PO;
    }

    public com.middleware.middleware.model.edi.po.REF getREF() {
        return REF;
    }

    public void setREF(com.middleware.middleware.model.edi.po.REF REF) {
        this.REF = REF;
    }

    public com.middleware.middleware.model.edi.po.MSG getMSG2() {
        return MSG2;
    }

    public void setMSG2(com.middleware.middleware.model.edi.po.MSG MSG2) {
        this.MSG2 = MSG2;
    }
}
