package com.b2soft.bnb.api.account.impl;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.jwt.JwtHelper;
import org.springframework.stereotype.Component;
import org.springframework.web.util.CookieGenerator;
import org.springframework.web.util.WebUtils;

import com.b2soft.bnb.api.account.error.AccountErrorCode;
import com.b2soft.bnb.api.account.vo.AccessToken;
import com.b2soft.common.error.BnbException;

/**
 * CookieOperations
 * 
 * @author BH Jun
 */
@Component
public class CookieOperations {

    private static final Logger LOGGER = LoggerFactory.getLogger(CookieOperations.class);

    @Value("#{config['com.kova.cookie.token.name']}")
    protected String accessTokenName;
    @Value("#{config['com.kova.cookie.token.allow_domain']}")
    protected String allowDomain;

    public AccessToken convertCookieToAccessToken(HttpServletRequest request) throws BnbException {
        AccessToken accessToken = new AccessToken();

        Cookie accessTokenCookie = WebUtils.getCookie(request, accessTokenName);

        LOGGER.debug("request accessTokenCookie : " + accessTokenCookie);

        if(accessTokenCookie != null) {
            String tmpTokenString = accessTokenCookie.getValue();

            LOGGER.debug("tmpTokenString : " + tmpTokenString);

            accessToken.setToken(tmpTokenString);

            try {
                accessToken.setClaim(JwtHelper.decode(tmpTokenString).getClaims());
            } catch(IllegalArgumentException e) {
                throw new BnbException(AccountErrorCode.INVALID_TOKEN);
            }
        } else {
            throw new BnbException(AccountErrorCode.ACCESS_TOKEN_IS_NULL);
        }

        return accessToken;
    }

    public void removeCookieAccessToken(HttpServletResponse response) throws Exception {
        CookieGenerator cookieGenerator = new CookieGenerator();

        cookieGenerator.setCookieHttpOnly(true);
        cookieGenerator.setCookieSecure(false);

        LOGGER.debug("remove Cookie Name = " + accessTokenName);
        cookieGenerator.setCookieDomain(allowDomain);
        cookieGenerator.setCookieName(accessTokenName);
        cookieGenerator.setCookiePath("/");
        LOGGER.debug("cookie: ",cookieGenerator.toString());
        cookieGenerator.removeCookie(response);
    }
}
