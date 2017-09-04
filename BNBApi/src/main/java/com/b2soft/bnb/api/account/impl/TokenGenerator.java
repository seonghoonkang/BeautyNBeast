package com.b2soft.bnb.api.account.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.jwt.Jwt;
import org.springframework.security.jwt.JwtHelper;
import org.springframework.security.jwt.crypto.sign.MacSigner;
import org.springframework.stereotype.Component;
import org.springframework.web.util.CookieGenerator;

import com.b2soft.bnb.api.account.pojo.UserClaim;
import com.b2soft.bnb.api.account.pojo.UserClaim.UserClaimBuilder;
import com.b2soft.bnb.api.account.vo.LoginResponseVO;
import com.b2soft.common.service.cache.SystemDataAccessor;
import com.b2soft.common.service.cache.SystemDataKeyType;

import net.sf.json.JSONObject;

@Component
public class TokenGenerator {

    private static final Logger LOGGER = LoggerFactory.getLogger(TokenGenerator.class);
    @Autowired
    private SystemDataAccessor systemDataAccess;

    @Value("#{config['com.softz.cookie.token']}")
    protected String accessTokenName;
    
    public void setCookieAccessToken(HttpServletRequest request, HttpServletResponse response, LoginResponseVO userData) {
        // TODO Auto-generated method stub
        CookieGenerator tokenCookieGenerator = new CookieGenerator();
        CookieGenerator langCookieGenerator = new CookieGenerator();
        
        String accessToken = this.createAccessToken(userData, request.getServerName());
        String browserLang = this.getBrowserLanguage(request);

        tokenCookieGenerator.setCookieHttpOnly(true);
//-- SSL 사용시에만 설정한다.    
//-- True 인경우 브라우저는 HTTPS가 아닌 통신에서는 쿠키를 전송하지 않는다.        
//        tokenCookieGenerator.setCookieSecure(true);
        tokenCookieGenerator.setCookieName(accessTokenName);
        tokenCookieGenerator.setCookiePath("/");
        tokenCookieGenerator.addCookie(response, accessToken);
        
        langCookieGenerator.setCookieHttpOnly(false);
        langCookieGenerator.setCookieName("lang");
        langCookieGenerator.setCookiePath("/");
        langCookieGenerator.addCookie(response, browserLang);
    }

    private String createAccessToken(LoginResponseVO userData, String serverName) {
        // TODO Auto-generated method stub
        String version = systemDataAccess.getTokenVersion();
        String secretKey = systemDataAccess.getSecretKey();
        
        long epochTime = System.currentTimeMillis() / 1000;
        UserClaim userClaim = new UserClaimBuilder(userData).setIssueAt(epochTime).setIssuer(serverName).setVersion(version).build();
        JSONObject claim = JSONObject.fromObject(userClaim);
        MacSigner signer = new MacSigner(secretKey);
        Jwt jwt = JwtHelper.encode(claim.toString(), signer);
        byte[] byteAccessToken = jwt.bytes();
        
        LOGGER.debug("encryption secret key : " + secretKey);
        LOGGER.debug("token cookie version(" + SystemDataKeyType.TOKEN_VERSION.toString() + ") : " + version);
        LOGGER.debug(new String(byteAccessToken, 0, byteAccessToken.length));
        LOGGER.debug(jwt.toString());
        
        String result = new String(byteAccessToken, 0, byteAccessToken.length);
        return result;
    }
    public String getBrowserLanguage(HttpServletRequest request) {
        String requestLang = request.getHeader("Accept-Language");
        String result = null;

        if(requestLang != null && !"".equals(requestLang)) {
            result = requestLang.split(",")[0].split("-")[0];
        } else {
            result = "ko";
        }

        return result;
    }    
}
