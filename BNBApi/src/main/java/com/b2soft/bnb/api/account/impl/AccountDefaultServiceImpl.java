package com.b2soft.bnb.api.account.impl;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.b2soft.bnb.api.account.AccountDAO;
import com.b2soft.bnb.api.account.AccountService;
import com.b2soft.bnb.api.account.vo.LoginRequestVO;
import com.b2soft.bnb.api.account.vo.LoginResponseVO;
import com.b2soft.bnb.api.account.vo.UserDataVO;
import com.b2soft.common.error.BnbException;
import com.b2soft.common.error.CommonErrorCode;

import net.sf.json.JSONObject;

@Service
public class AccountDefaultServiceImpl implements AccountService {

    private static final Logger LOGGER = LoggerFactory.getLogger(AccountDefaultServiceImpl.class);
    @Autowired
    private AccountDAO accountDAO;
    
    @Override
    public LoginResponseVO login(LoginRequestVO loginParam) throws BnbException {
        // TODO Auto-generated method stub
        LoginResponseVO userData = new LoginResponseVO();
        userData = accountDAO.getLoginInfo(loginParam);
        if(userData == null){
            throw new BnbException(CommonErrorCode.NOT_EXISTS_USER, "Login Account is not Exists");
        }else if(userData.getLoginResult() == 0){
            LOGGER.debug("login Failed");
            throw new BnbException(CommonErrorCode.WRONG_PASSWORD, "Login password is wrong");
        }else{
            LOGGER.debug("login SUCCESS");
            return userData;
        }
    }

	@Override
	public void logout(JSONObject claim) throws BnbException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public LoginResponseVO getUserInfo(HttpServletRequest request, UserDataVO userData) {
		// TODO Auto-generated method stub
		return null;
	}

}
