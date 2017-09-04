package com.b2soft.bnb.api.account;

import com.b2soft.bnb.api.account.vo.LoginRequestVO;
import com.b2soft.bnb.api.account.vo.LoginResponseVO;

public interface AccountDAO {
    public LoginResponseVO getLoginInfo(LoginRequestVO loginRequestVO);
}
