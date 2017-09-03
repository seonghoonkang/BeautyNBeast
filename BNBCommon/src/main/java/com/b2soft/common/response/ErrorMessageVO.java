package com.b2soft.common.response;

import java.io.Serializable;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class ErrorMessageVO implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = -615026894777972434L;

    @XmlAttribute(name = "errCode")
    private String errCode;

    @XmlElement(name = "errMessage")
    private String errMessage;

    private List<ConcurrentHashMap<String, String>> errDataList;

    public String getErrCode() {
        return errCode;
    }

    public void setErrCode(String errCode) {
        this.errCode = errCode;
    }

    public String getErrMessage() {
        return errMessage;
    }

    public void setErrMessage(String errMessage) {
        this.errMessage = errMessage;
    }

    public List<ConcurrentHashMap<String, String>> getErrDataList() {
        return errDataList;
    }

    public void setErrDataList(List<ConcurrentHashMap<String, String>> errDataList) {
        this.errDataList = errDataList;
    }
}
