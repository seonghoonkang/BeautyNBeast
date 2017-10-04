package com.b2soft.common.service.cache;

import org.springframework.stereotype.Repository;

import com.b2soft.common.dao.BnbCommonDAO;

@Repository
public class BnbSystemDataDAO extends BnbCommonDAO {

    public String selectAppVersion() {
        return ((String) super.getSqlSession().selectOne("application.selectVersion"));
    }

}


