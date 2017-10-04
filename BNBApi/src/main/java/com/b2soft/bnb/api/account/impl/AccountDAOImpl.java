package com.b2soft.bnb.api.account.impl;

import org.springframework.stereotype.Repository;

import com.b2soft.bnb.api.account.AccountDAO;
import com.b2soft.bnb.api.account.vo.LoginRequestVO;
import com.b2soft.bnb.api.account.vo.UserDataVO;
import com.b2soft.common.dao.BnbCommonDAO;

@Repository
public class AccountDAOImpl extends BnbCommonDAO implements AccountDAO {

    @Override
    public UserDataVO getLoginInfo(LoginRequestVO loginRequestVO) {
        // TODO Auto-generated method stub
        return super.getSqlSession().selectOne("account.certification", loginRequestVO);
    }

}
