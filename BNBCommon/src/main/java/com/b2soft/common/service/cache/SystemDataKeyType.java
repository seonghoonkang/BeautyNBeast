package com.b2soft.common.service.cache;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public enum SystemDataKeyType {
    
    TOKEN_SECRET_KEY {

        @Override
        public String getKeyName() {
            String randomSecretKey = UUID.randomUUID().toString();
            LOGGER.debug("make new SecretKey : " + randomSecretKey);
            return randomSecretKey;
        }

        @Override
        public String getKeyName(String param) {
            throw new UnsupportedOperationException();
        }
    }, TOKEN_VERSION{

        @Override
        public String getKeyName() {
           return this.toString();
        }

        @Override
        public String getKeyName(String menuId) {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException();
        }
        
    };
    
    public abstract String getKeyName();
    public abstract String getKeyName(String menuId);    
    private static final Logger LOGGER = LoggerFactory.getLogger(SystemDataAccessor.class);
    
}
