package com.b2soft.common.service.cache;

import org.springframework.stereotype.Repository;
import com.b2soft.common.dao.CommonDAO;


@Repository
public class SystemDataDAO extends CommonDAO {
    public String selectAppVersion() {
        return ((String) super.getSqlSession().selectOne("application.selectVersion"));
    }
}
