package com.b2soft.common.error.resolver;

import java.util.List;
import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;

import com.b2soft.common.error.BnbException;
import com.b2soft.common.error.CommonErrorCode;
import com.b2soft.common.error.ErrorCode;
import com.b2soft.common.response.ErrorResponseVO;

public class BnbExceptionResolver implements HandlerExceptionResolver {

	private static final Logger LOGGER = LoggerFactory.getLogger(BnbExceptionResolver.class);

	@Autowired
	private MessageSource msgSource;

	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception ex) {
		ModelAndView mav = new ModelAndView();
		ErrorResponseVO result = new ErrorResponseVO();
		Locale locale = (Locale) request.getAttribute(CookieLocaleResolver.class.getName() + ".LOCALE");
		// Locale locale = new Locale("ko");
		String requestURI = request.getRequestURI();
		LOGGER.debug(" kind of Exception = " + ex.getClass());
		LOGGER.debug(" cause of Exception = " + ex.getCause());
		LOGGER.debug(" Place of Exception = " + ex.getStackTrace()[0].getClassName() + "."
				+ ex.getStackTrace()[0].getMethodName() + "(Line : " + ex.getStackTrace()[0].getLineNumber() + ")");

		if (ex instanceof BnbException) {
			BnbException exception = (BnbException) ex;
			ErrorCode errorObj = exception.getErrorCode();
			Object[] params = exception.getErrorParams();

			List<ConcurrentHashMap<String, String>> errorDataList = exception.getErrDataList();
			if (errorObj == null) {
				errorObj = CommonErrorCode.INTERNAL_SERVER_ERROR;
			}
			LOGGER.debug(" Exception errorObject = " + errorObj);
			LOGGER.debug(" Exception params size = " + (params != null ? params.length : 0));
			LOGGER.debug(" Exception locale = " + locale);

			if (exception.getMessage() == null) {
				exception.setMessage(msgSource.getMessage(errorObj.getErrorCode(), params, "hello exception",
						new Locale(locale.getLanguage())));
			}
			response.setStatus(errorObj.getResponseCode());

			result.getHeader().setStatus(response.getStatus());
			result.getBody().getDocs().setErrCode(errorObj.getErrorCode());
			result.getBody().getDocs().setErrMessage(exception.getMessage());
			result.getBody().getDocs().setErrDataList(errorDataList);

			mav.addObject("response", result);

		} else {
			int status = HttpStatus.INTERNAL_SERVER_ERROR.value();
			String errorCode = CommonErrorCode.INTERNAL_SERVER_ERROR.getErrorCode();

			response.setStatus(status);

			result.getHeader().setStatus(status);
			result.getBody().getDocs().setErrCode(errorCode);
			result.getBody().getDocs().setErrMessage(msgSource.getMessage(errorCode, null, locale));

			mav.addObject("response", result);
		}
		return mav;
	}

	private Throwable getCause(Throwable ex) {
		Throwable cause = ex.getCause();

		if (cause != null) {
			if (cause instanceof BnbException) {
				cause = cause.getCause() == null ? cause : cause.getCause();
			}
		} else {
			cause = ex;
		}

		return cause;
	}
}
