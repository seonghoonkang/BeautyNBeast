package com.b2soft.bnb.api.account;


import com.b2soft.bnb.api.account.vo.LoginRequestVO;
import com.b2soft.bnb.api.account.vo.UserDataVO;
import com.b2soft.common.error.BnbException;

import net.sf.json.JSONObject;

public interface AccountService {
    public UserDataVO login(LoginRequestVO loginParam) throws BnbException;
    public void logout(JSONObject claim) throws BnbException;
    
}
