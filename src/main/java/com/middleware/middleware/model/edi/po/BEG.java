package com.middleware.middleware.model.edi.po;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElement;

@XmlRootElement(name = "EDI850")
@XmlAccessorType(XmlAccessType.FIELD)
public class BEG {

	@XmlElement(name="transactionSetPurchaseCode")
    String transactionSetPurchaseCode;
	@XmlElement(name="purchaseOrderTypeCode")
    String purchaseOrderTypeCode;
	@XmlElement(name="purchaseOrderNumber")
    String purchaseOrderNumber;
	@XmlElement(name="releaseNumber")
    String releaseNumber;
	@XmlElement(name="purchaseOrderDate")
    String purchaseOrderDate;
	@XmlElement(name="contractNumber")
    String contractNumber;

	@XmlElement(name="N9")
    N9 N9;
	@XmlElement(name="DTM")
    DTM DTM;
    @XmlElement(name="MSG")
    EXT_MSG MSG;
	@XmlElement(name="PO")
    PO PO;
	@XmlElement(name="REF")
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
