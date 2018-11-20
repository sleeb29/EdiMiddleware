package com.middleware.middleware.model.edi.po;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElement;

@XmlRootElement(name = "DTM")
@XmlAccessorType(XmlAccessType.FIELD)
public class DTM {
	@XmlElement(name="dateTimeQualifier")
    String dateTimeQualifier;
	@XmlElement(name="systemDate")
    String systemDate;
	@XmlElement(name="systemTime")
    String systemTime;

    public String getDateTimeQualifier() {
        return dateTimeQualifier;
    }

    public void setDateTimeQualifier(String dateTimeQualifier) {
        this.dateTimeQualifier = dateTimeQualifier;
    }

    public String getSystemDate() {
        return systemDate;
    }

    public void setSystemDate(String systemDate) {
        this.systemDate = systemDate;
    }

    public String getSystemTime() {
        return systemTime;
    }

    public void setSystemTime(String systemTime) {
        this.systemTime = systemTime;
    }
}
