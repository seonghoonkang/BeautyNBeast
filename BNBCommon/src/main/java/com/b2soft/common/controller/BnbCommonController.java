package com.b2soft.common.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;

import com.b2soft.common.response.CommonResultDataVO;
import com.b2soft.common.response.ResponseVO;

public abstract class BnbCommonController {

    @Autowired
    MessageSource messageSource;

    protected CommonResultDataVO getProcessSuccessCode() {
        CommonResultDataVO result = new CommonResultDataVO();
        return result;
    }

    protected <T> ResponseVO<T> makeResponseData(HttpStatus status, List<T> resultDataList) {
        ResponseVO<T> response = new ResponseVO<T>();
        response.getHeader().setStatus(status.value());
        response.getBody().setDocCnt(resultDataList.size());
        response.getBody().setDocs(resultDataList);
        return response;
    }

    protected <T> ResponseVO<T> makeResponseData(HttpStatus status, T resultData) {
        ResponseVO<T> response = new ResponseVO<T>();
        response.getHeader().setStatus(status.value());
        response.getBody().setDocCnt(1);
        response.getBody().setDoc(resultData);
        return response;
    }

    protected <T> ResponseVO<T> makeResponseData(HttpStatus status, List<T> resultDataList, int currentPageNum, int pageViewSize,
            int totalCount) {
        ResponseVO<T> response = new ResponseVO<T>();

        return response;
    }
}
