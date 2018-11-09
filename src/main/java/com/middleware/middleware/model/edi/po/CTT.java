package com.middleware.middleware.model.edi.po;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElement;

@XmlRootElement(name = "EDI850")
@XmlAccessorType(XmlAccessType.FIELD)
public class CTT {
	@XmlElement(name="totalNumberOfPurchaseOrderLineItems")
    String totalNumberOfPurchaseOrderLineItems;
	@XmlElement(name="hashTotal")
    String hashTotal;

    public String getTotalNumberOfPurchaseOrderLineItems() {
        return totalNumberOfPurchaseOrderLineItems;
    }

    public void setTotalNumberOfPurchaseOrderLineItems(String totalNumberOfPurchaseOrderLineItems) {
        this.totalNumberOfPurchaseOrderLineItems = totalNumberOfPurchaseOrderLineItems;
    }

    public String getHashTotal() {
        return hashTotal;
    }

    public void setHashTotal(String hashTotal) {
        this.hashTotal = hashTotal;
    }
}
