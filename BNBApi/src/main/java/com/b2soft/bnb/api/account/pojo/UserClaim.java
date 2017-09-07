package com.b2soft.bnb.api.account.pojo;

import com.b2soft.bnb.api.account.vo.UserDataVO;

public class UserClaim {
    private String issuer;
    private String tenantId;
    private String userId;
    private long issueAt;
    private long expireTime;
    private String version;

    private UserClaim(UserClaimBuilder builder){
        this.tenantId = builder.tenantId;
        this.userId = builder.userId;
        this.version = builder.version;
        this.issuer = builder.issuer;
        this.issueAt = builder.issueAt;
        this.expireTime = builder.expireTime;
    }
    
    public String getIssuer() {
        return issuer;
    }

    
    public String getTenantId() {
        return tenantId;
    }

    
    public String getUserId() {
        return userId;
    }

    
    public long getIssueAt() {
        return issueAt;
    }

    
    public long getExpireTime() {
        return expireTime;
    }

    
    public String getVersion() {
        return version;
    }

    public static class UserClaimBuilder{
        private String issuer;
        private String tenantId;
        private String userId;
        private long issueAt;
        private long expireTime;
        private String version;
        
        public UserClaimBuilder(UserDataVO userData) {
            this.userId = userData.getUserId();
            this.tenantId = userData.getTenantId();
        }

        public UserClaimBuilder setIssuer(String issuer){
            this.issuer = issuer;
            return this;
        }
        
        public UserClaimBuilder setIssueAt(long issueAt){
            this.issueAt = issueAt;
            return this;
        }
        
        public UserClaimBuilder setVersion(String version){
            this.version = version;
            return this;
        }
        
        public UserClaim build(){
            return new UserClaim(this);
        }
        
    }
}
