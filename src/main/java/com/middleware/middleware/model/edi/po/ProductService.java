package com.middleware.middleware.model.edi.po;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElement;

@XmlRootElement(name = "EDI850")
@XmlAccessorType(XmlAccessType.FIELD)
public class ProductService {
	@XmlElement(name="productServiceId")
    String productServiceId;
	@XmlElement(name="productServiceIdQualifiers")
    String productServiceIdQualifiers;

    public String getProductServiceId() {
        return productServiceId;
    }

    public void setProductServiceId(String productServiceId) {
        this.productServiceId = productServiceId;
    }

    public String getProductServiceIdQualifiers() {
        return productServiceIdQualifiers;
    }

    public void setProductServiceIdQualifiers(String productServiceIdQualifiers) {
        this.productServiceIdQualifiers = productServiceIdQualifiers;
    }
}
