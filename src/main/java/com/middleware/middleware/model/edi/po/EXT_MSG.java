package com.middleware.middleware.model.edi.po;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElement;

@XmlRootElement(name = "EDI850")
@XmlAccessorType(XmlAccessType.FIELD)
public class EXT_MSG {
	@XmlElement(name="N1")
    N1 N1;
	@XmlElement(name="N3")
    N3 N3;
	@XmlElement(name="N4")
    N4 N4;
	@XmlElement(name="PER")
    PER PER;

    public com.middleware.middleware.model.edi.po.N1 getN1() {
        return N1;
    }

    public void setN1(com.middleware.middleware.model.edi.po.N1 n1) {
        N1 = n1;
    }

    public com.middleware.middleware.model.edi.po.N3 getN3() {
        return N3;
    }

    public void setN3(com.middleware.middleware.model.edi.po.N3 n3) {
        N3 = n3;
    }

    public com.middleware.middleware.model.edi.po.N4 getN4() {
        return N4;
    }

    public void setN4(com.middleware.middleware.model.edi.po.N4 n4) {
        N4 = n4;
    }

    public com.middleware.middleware.model.edi.po.PER getPER() {
        return PER;
    }

    public void setPER(com.middleware.middleware.model.edi.po.PER PER) {
        this.PER = PER;
    }
}
