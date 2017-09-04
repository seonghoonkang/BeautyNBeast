package com.b2soft.bnb.api.account;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.b2soft.bnb.api.account.impl.TokenGenerator;
import com.b2soft.bnb.api.account.vo.LoginRequestVO;
import com.b2soft.bnb.api.account.vo.LoginResponseVO;
import com.b2soft.common.controller.BnbCommonController;
import com.b2soft.common.error.BnbException;
import com.b2soft.common.response.ResponseVO;

@RestController
public class AccountController extends BnbCommonController {

	private static final Logger LOGGER = LoggerFactory.getLogger(AccountController.class);

	@Autowired
	private AccountService accountService;
	@Autowired
	private TokenGenerator tokenGenerator;

	@RequestMapping(value = "/account/login", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseVO<LoginResponseVO> doLogIn(@RequestBody @Valid LoginRequestVO loginRequestVO,
			HttpServletRequest request, HttpServletResponse response) {
		LOGGER.debug("Hello, Welcome to the office zone:");
		LoginResponseVO result = null;
		try {
			result = accountService.login(loginRequestVO);
			tokenGenerator.setCookieAccessToken(request, response, result);
		} catch (Exception e) {
			throw new BnbException(e);
		}
		return super.makeResponseData(HttpStatus.OK, result);
	}

	@RequestMapping(value = "/account/logout", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseVO<LoginResponseVO> doLogout(HttpServletRequest request, HttpServletResponse response) {
		LOGGER.debug("Good bye......");
		LoginResponseVO result = null;

		return super.makeResponseData(HttpStatus.OK, result);
	}
}
