package com.b2soft.common.service.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BnbSystemDataAccessor {
    @Autowired
    private BnbSystemDataDAO systemDataDao;
    private static final String SECRET_KEY_TYPE = BnbSystemDataKeyType.TOKEN_SECRET_KEY.getKeyName();
    
    public String getTokenVersion() {
        return "v" + systemDataDao.selectAppVersion();
    }

    public String getSecretKey() {
        // TODO Auto-generated method stub
        return SECRET_KEY_TYPE.toString();
    }
}
