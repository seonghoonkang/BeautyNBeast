package com.b2soft.bnb.api.account;

import javax.servlet.http.HttpServletRequest;

import com.b2soft.bnb.api.account.vo.LoginRequestVO;
import com.b2soft.bnb.api.account.vo.LoginResponseVO;
import com.b2soft.bnb.api.account.vo.UserDataVO;
import com.b2soft.common.error.BnbException;

import net.sf.json.JSONObject;

public interface AccountService {
    public LoginResponseVO login(LoginRequestVO loginParam) throws BnbException;
    public void logout(JSONObject claim) throws BnbException;
    public LoginResponseVO getUserInfo(HttpServletRequest request, UserDataVO userData);
    
}
