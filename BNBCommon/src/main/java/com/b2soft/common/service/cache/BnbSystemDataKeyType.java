package com.b2soft.common.service.cache;

import java.util.UUID;

public enum BnbSystemDataKeyType {
    
    TOKEN_SECRET_KEY {

        @Override
        public String getKeyName() {
            String randomSecretKey = UUID.randomUUID().toString();
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
    
}
