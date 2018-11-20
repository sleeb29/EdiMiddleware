package com.middleware.middleware.model.edi;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElement;

@XmlRootElement(name = "GS")
@XmlAccessorType(XmlAccessType.FIELD)
public class GS {
	@XmlElement(name="GS01")
    String GS01;
	@XmlElement(name="GS02")
    String GS02;
	@XmlElement(name="GS03")
    String GS03;
	@XmlElement(name="GS04")
    String GS04;
	@XmlElement(name="GS05")
    String GS05;
	@XmlElement(name="GS06")
    String GS06;
	@XmlElement(name="GS07")
    String GS07;
	@XmlElement(name="GS08")
    String GS08;

    public String getGS01() {
        return GS01;
    }

    public void setGS01(String GS01) {
        this.GS01 = GS01;
    }

    public String getGS02() {
        return GS02;
    }

    public void setGS02(String GS02) {
        this.GS02 = GS02;
    }

    public String getGS03() {
        return GS03;
    }

    public void setGS03(String GS03) {
        this.GS03 = GS03;
    }

    public String getGS04() {
        return GS04;
    }

    public void setGS04(String GS04) {
        this.GS04 = GS04;
    }

    public String getGS05() {
        return GS05;
    }

    public void setGS05(String GS05) {
        this.GS05 = GS05;
    }

    public String getGS06() {
        return GS06;
    }

    public void setGS06(String GS06) {
        this.GS06 = GS06;
    }

    public String getGS07() {
        return GS07;
    }

    public void setGS07(String GS07) {
        this.GS07 = GS07;
    }

    public String getGS08() {
        return GS08;
    }

    public void setGS08(String GS08) {
        this.GS08 = GS08;
    }
}
