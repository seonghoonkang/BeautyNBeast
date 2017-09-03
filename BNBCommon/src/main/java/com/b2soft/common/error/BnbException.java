package com.b2soft.common.error;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.validation.FieldError;

/**
 * OfficeException
 * 
 * @author Kangpual
 */
public class BnbException extends RuntimeException {

    /**
     * 
     */
    private static final long serialVersionUID = 1077078834392922877L;

    private ErrorCode errorCode;
    private Object[] errorParams;
    private String message;
    private List<ConcurrentHashMap<String, String>> errDataList;

    public BnbException(ErrorCode errorCode) {
        super();

        this.errorCode = errorCode;
    }

    public BnbException(FieldError fieldError) {
        super();

        this.errorCode = CommonErrorCode.BAD_REQUEST;
        this.message = fieldError.getField() + " - " + fieldError.getDefaultMessage();
    }

    public BnbException(String message, ErrorCode errorCode) {
        super();

        this.errorCode = errorCode;
        this.message = message;
    }

    public BnbException(ErrorCode errorCode, String errorParam) {
        super();

        this.errorCode = errorCode;
        this.errorParams = new Object[1];
        errorParams[0] = errorParam;
    }

    public BnbException(ErrorCode errorCode, String[] errorParams) {
        super();

        this.errorCode = errorCode;
        this.errorParams = errorParams;
    }

    public BnbException(Throwable e, ErrorCode errorCode) {
        super(e);

        this.errorCode = errorCode;
        this.message = e.getMessage();
    }

    public BnbException(Throwable e, ErrorCode errorCode, String errorParam) {
        super(e);

        this.errorCode = errorCode;
        this.errorParams = new Object[1];
        this.message = e.getMessage();

        errorParams[0] = errorParam;
    }

    public BnbException(Throwable e, ErrorCode errorCode, String[] errorParams) {
        super(e);

        this.errorCode = errorCode;
        this.errorParams = errorParams;
        this.message = e.getMessage();
    }

    public BnbException(ErrorCode errorCode, List<ConcurrentHashMap<String, String>> errDataList) {
        super();

        this.errorCode = errorCode;
        this.errDataList = errDataList;
    }

    public BnbException(String message, ErrorCode errorCode, List<ConcurrentHashMap<String, String>> errDataList) {
        super();

        this.errorCode = errorCode;
        this.message = message;
        this.errDataList = errDataList;
    }

    public BnbException(ErrorCode errorCode, String errorParam, List<ConcurrentHashMap<String, String>> errDataList) {
        super();

        this.errorCode = errorCode;
        this.errorParams = new Object[1];
        this.errorParams[0] = errorParam;
        this.errDataList = errDataList;
    }

    public BnbException(ErrorCode errorCode, String[] errorParams, List<ConcurrentHashMap<String, String>> errDataList) {
        super();

        this.errorCode = errorCode;
        this.errorParams = errorParams;
        this.errDataList = errDataList;
    }

    public BnbException(Throwable e, ErrorCode errorCode, List<ConcurrentHashMap<String, String>> errDataList) {
        super(e);

        this.errorCode = errorCode;
        this.message = e.getMessage();
        this.errDataList = errDataList;
    }

    public BnbException(Throwable e, ErrorCode errorCode, String errorParam, List<ConcurrentHashMap<String, String>> errDataList) {
        super(e);

        this.errorCode = errorCode;
        this.message = e.getMessage();
        this.errorParams = new Object[1];
        this.errorParams[0] = errorParam;
        this.errDataList = errDataList;
    }

    public BnbException(Throwable e, ErrorCode errorCode, String[] errorParams, List<ConcurrentHashMap<String, String>> errDataList) {
        super(e);

        this.errorCode = errorCode;
        this.errorParams = errorParams;
        this.message = e.getMessage();
        this.errDataList = errDataList;
    }

    public BnbException(BnbException e) {
        super(e);

        this.errorCode = e.getErrorCode();
        this.message = e.getMessage();
        this.errorParams = e.getErrorParams();
        this.errDataList = e.getErrDataList();
    }

    public BnbException(Throwable e) {
        super(e);

        if(e instanceof BnbException) {
            BnbException exception = (BnbException) e;

            this.errorCode = exception.getErrorCode();
            this.message = exception.getMessage();
            this.errorParams = exception.getErrorParams();
            this.errDataList = exception.getErrDataList();
        }
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }

    public Object[] getErrorParams() {
        return errorParams;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<ConcurrentHashMap<String, String>> getErrDataList() {
        return errDataList;
    }

    public void setErrDataList(List<ConcurrentHashMap<String, String>> errDataList) {
        this.errDataList = errDataList;
    }
}
