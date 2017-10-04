package com.b2soft.common.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class BnbCommonDAO extends SqlSessionDaoSupport{

    @Override
    @Autowired
    public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
        // TODO Auto-generated method stub
        super.setSqlSessionTemplate(sqlSessionTemplate);
    }

}
