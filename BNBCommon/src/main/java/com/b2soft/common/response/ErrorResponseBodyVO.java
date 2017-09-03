package com.b2soft.common.response;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "error")
@XmlAccessorType(XmlAccessType.FIELD)
public class ErrorResponseBodyVO implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = -8878460664737055395L;

    @XmlElement(name = "doc")
    private ErrorMessageVO docs = new ErrorMessageVO();

    public ErrorMessageVO getDocs() {
        return docs;
    }

    public void setDocs(ErrorMessageVO docs) {
        this.docs = docs;
    }
}
