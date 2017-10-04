package com.b2soft.bnb.api.account;

import com.b2soft.bnb.api.account.vo.LoginRequestVO;
import com.b2soft.bnb.api.account.vo.UserDataVO;

public interface AccountDAO {
    public UserDataVO getLoginInfo(LoginRequestVO loginRequestVO);
}
