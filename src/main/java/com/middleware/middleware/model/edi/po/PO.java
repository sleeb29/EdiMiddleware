package com.middleware.middleware.model.edi.po;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElement;

@XmlRootElement(name = "PO")
@XmlAccessorType(XmlAccessType.FIELD)
public class PO {
	@XmlElement(name="assignedIdentifier")
    String assignedIdentifier;
	@XmlElement(name="quantityOrdered")
    String quantityOrdered;
	@XmlElement(name="unitOfMeasure")
    String unitOfMeasure;
	@XmlElement(name="itemUnitPrice")
    String itemUnitPrice;

	PID pid;

    List<ProductService> productServiceList;

    public String getAssignedIdentifier() {
        return assignedIdentifier;
    }

    public void setAssignedIdentifier(String assignedIdentifier) {
        this.assignedIdentifier = assignedIdentifier;
    }

    public String getQuantityOrdered() {
        return quantityOrdered;
    }

    public void setQuantityOrdered(String quantityOrdered) {
        this.quantityOrdered = quantityOrdered;
    }

    public String getUnitOfMeasure() {
        return unitOfMeasure;
    }

    public void setUnitOfMeasure(String unitOfMeasure) {
        this.unitOfMeasure = unitOfMeasure;
    }

    public String getItemUnitPrice() {
        return itemUnitPrice;
    }

    public void setItemUnitPrice(String itemUnitPrice) {
        this.itemUnitPrice = itemUnitPrice;
    }

    public List<ProductService> getProductServiceList() {
        return productServiceList;
    }

    public void setProductServiceList(List<ProductService> productServiceList) {
        this.productServiceList = productServiceList;
    }

    public PID getPid() {
        return pid;
    }

    public void setPid(PID pid) {
        this.pid = pid;
    }
}
