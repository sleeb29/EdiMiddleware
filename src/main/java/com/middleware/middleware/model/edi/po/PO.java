package com.middleware.middleware.model.edi.po;

import java.util.List;

public class PO {

    String assignedIdentifier;
    String quantityOrdered;
    String unitOfMeasure;
    String itemUnitPrice;

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
}
