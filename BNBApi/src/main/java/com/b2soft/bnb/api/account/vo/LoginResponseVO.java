package com.b2soft.bnb.api.account.vo;

import java.io.Serializable;
import java.util.List;


public class LoginResponseVO implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1616096378447893734L;
    
    private String tenantId;
    private String userName;
    private String userId;
    private String deptName;
    private String picURL;
    private String posName;
    private String rankName;
    private String dutyName;
    private int resultCode;
    private List<String> userAuth;
    
    public String getName() {
        return userName;
    }
    
    public void setName(String userName) {
        this.userName = userName;
    }
    
    public String getDeptName() {
        return deptName;
    }
    
    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }
    
    public String getPicURL() {
        return picURL;
    }
    
    public void setPicURL(String picURL) {
        this.picURL = picURL;
    }
    
    public String getPosName() {
        return posName;
    }
    
    public void setPosName(String posName) {
        this.posName = posName;
    }
    
    public String getRankName() {
        return rankName;
    }
    
    public void setRankName(String rankName) {
        this.rankName = rankName;
    }
    
    public String getDutyName() {
        return dutyName;
    }
    
    public void setDutyName(String dutyName) {
        this.dutyName = dutyName;
    }
    
    public List<String> getUserAuth() {
        return userAuth;
    }
    
    public void setUserAuth(List<String> userAuth) {
        this.userAuth = userAuth;
    }

    public int getLoginResult() {
        return resultCode;
    }

    public void setLoginResult(int resultCode) {
        this.resultCode = resultCode;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

}
