package com.middleware.middleware.model.edi;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElement;

@XmlRootElement(name = "IEA")
@XmlAccessorType(XmlAccessType.FIELD)
public class IEA {
    String IEA01;
    String IEA02;

    public String getIEA01() {
        return IEA01;
    }

    public void setIEA01(String IEA01) {
        this.IEA01 = IEA01;
    }

    public String getIEA02() {
        return IEA02;
    }

    public void setIEA02(String IEA02) {
        this.IEA02 = IEA02;
    }
}
