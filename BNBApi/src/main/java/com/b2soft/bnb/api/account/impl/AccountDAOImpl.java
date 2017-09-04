package com.b2soft.bnb.api.account.impl;

import org.springframework.stereotype.Repository;

import com.b2soft.bnb.api.account.AccountDAO;
import com.b2soft.bnb.api.account.vo.LoginRequestVO;
import com.b2soft.bnb.api.account.vo.LoginResponseVO;
import com.b2soft.common.dao.CommonDAO;

@Repository
public class AccountDAOImpl extends CommonDAO implements AccountDAO {

    @Override
    public LoginResponseVO getLoginInfo(LoginRequestVO loginRequestVO) {
        // TODO Auto-generated method stub
        return super.getSqlSession().selectOne("account.certification", loginRequestVO);
    }

}
