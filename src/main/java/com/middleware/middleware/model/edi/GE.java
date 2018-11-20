package com.middleware.middleware.model.edi;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "GE")
public class GE
{
    @XmlElement(name="GE01")
    String GE01;
    @XmlElement(name="GE02")
    String GE02;

    public String getGE01() {
        return GE01;
    }

    public void setGE01(String GE01) {
        this.GE01 = GE01;
    }

    public String getGE02() {
        return GE02;
    }

    public void setGE02(String GE02) {
        this.GE02 = GE02;
    }
}
