package com.b2soft.common.response;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="header")
@XmlAccessorType(XmlAccessType.FIELD)
public class ResponseHeaderVO implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = -2925755070959154324L;
    
    @XmlElement(name = "status")
    private int status;
    
    public int getStatus() {
        return status;
    }
    
    public void setStatus(int status) {
        this.status = status;
    }
}
