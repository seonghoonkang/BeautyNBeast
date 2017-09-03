package com.b2soft.common.error.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.b2soft.common.error.BnbException;
import com.b2soft.common.error.CommonErrorCode;


@Controller
public class ErrorController {

    @RequestMapping(value = "/error/400")
    public void badRequest() {
        throw new BnbException(CommonErrorCode.BAD_REQUEST);
    }

    @RequestMapping(value = "/error/403")
    public void forbidden() {
        throw new BnbException(CommonErrorCode.FORBIDDEN);
    }

    @RequestMapping(value = "/error/404")
    public void resourceNotFound() {
        throw new BnbException(CommonErrorCode.NOTFOUND);
    }

    @RequestMapping(value = "/error/405")
    public void methodNotAllowed() {
        throw new BnbException(CommonErrorCode.METHOD_NOT_ALLOWED);
    }

    @RequestMapping(value = "/error/406")
    public void notAcceptable() {
        throw new BnbException(CommonErrorCode.NOT_ACCEPTABLE);
    }

    @RequestMapping(value = "/error/408")
    public void requestTimeout() {
        throw new BnbException(CommonErrorCode.REQUEST_TIMEOUT);
    }

    @RequestMapping(value = "/error/409")
    public void conflict() {
        throw new BnbException(CommonErrorCode.CONFLICT);
    }

    @RequestMapping(value = "/error/413")
    public void requestEntityTooLong() {
        throw new BnbException(CommonErrorCode.REQUEST_ENTITY_TOO_LONG);
    }

    @RequestMapping(value = "/error/414")
    public void requestUriTooLong() {
        throw new BnbException(CommonErrorCode.REQUEST_URI_TOO_LONG);
    }

    @RequestMapping(value = "/error/415")
    public void unsupportedMediaType() {
        throw new BnbException(CommonErrorCode.UNSUPPORTED_MEDIA_TYPE);
    }

    @RequestMapping(value = "/error/500")
    public void internalServerError() {
        throw new BnbException(CommonErrorCode.INTERNAL_SERVER_ERROR);
    }

    @RequestMapping(value = "/error")
    public void etcError() {
        throw new BnbException(CommonErrorCode.FORBIDDEN);
    }
}