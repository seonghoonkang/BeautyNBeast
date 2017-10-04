package com.b2soft.bnb.api.account.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.jwt.Jwt;
import org.springframework.security.jwt.JwtHelper;
import org.springframework.security.jwt.crypto.sign.InvalidSignatureException;
import org.springframework.security.jwt.crypto.sign.MacSigner;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.b2soft.bnb.api.account.UserDataContextHolder;
import com.b2soft.bnb.api.account.error.AccountErrorCode;
import com.b2soft.bnb.api.account.impl.CookieOperations;
import com.b2soft.bnb.api.account.vo.AccessToken;
import com.b2soft.bnb.api.account.vo.UserDataVO;
import com.b2soft.common.datasource.DataSourceContextHolder;
import com.b2soft.common.datasource.type.DataSourceType;
import com.b2soft.common.error.BnbException;
import com.b2soft.common.service.cache.BnbSystemDataAccessor;

import net.sf.json.JSONObject;

/**
 * User access Token의 인증 및 검증 처리 Interceptor.
 * 
 * @author kangpual
 */
public class CertifyInterceptor extends HandlerInterceptorAdapter {

	private static final Logger LOGGER = LoggerFactory.getLogger(CertifyInterceptor.class);

	@Autowired
	private BnbSystemDataAccessor bnbSystemDataAccess;
	@Autowired
	private CookieOperations cookieOperations;

	protected String accessTokenName = null;
	protected String allowDomain = null;
	protected String localeName = null;
	protected String serviceType = null;
	protected int tokenExpireMinuteTime = 0;

	public void setAccessTokenName(String accessTokenName) {
		this.accessTokenName = accessTokenName;
	}

	public void setAllowDomain(String allowDomain) {
		this.allowDomain = allowDomain;
	}

	public void setLocaleName(String localeName) {
		this.localeName = localeName;
	}

	public void setTokenExpireMinuteTime(int tokenExpireMinuteTime) {
		this.tokenExpireMinuteTime = tokenExpireMinuteTime;
	}

	public String getServiceType() {
		return serviceType;
	}

	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		try {
			AccessToken accessToken = cookieOperations.convertCookieToAccessToken(request);

			this.verifyUserAccessToken(response, accessToken);
			this.certifyUserAccessToken(request, response, accessToken);
			// UserDataVO user = UserDataContextHolder.getUserData();
		} catch (Exception ex) {

			LOGGER.debug(request.getRequestURI());
			throw new BnbException(ex);
		}
		return true;
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		DataSourceContextHolder.clearDataSourceType();
		UserDataContextHolder.clearUserData();
	}

	private void verifyUserAccessToken(HttpServletResponse response, AccessToken accessToken) throws Exception {
		LOGGER.debug("verifyUserAccessToken" + accessToken);

		try {
			String secretKey = bnbSystemDataAccess.getSecretKey();
			String requestedToken = accessToken.getToken();

			LOGGER.debug("requested token : " + requestedToken);

			MacSigner signer = new MacSigner(secretKey);
			Jwt verifiedJwt = JwtHelper.decodeAndVerify(requestedToken, signer);

			LOGGER.debug("verifiedJwt : " + verifiedJwt);
		} catch (InvalidSignatureException ise) {
			cookieOperations.removeCookieAccessToken(response);

			throw new BnbException(ise, AccountErrorCode.INVALID_TOKEN);
		} catch (Exception e) {
			throw new Exception(e);
		}
	}

	private void certifyUserAccessToken(HttpServletRequest request, HttpServletResponse response,
			AccessToken accessToken) throws Exception {
		LOGGER.debug("certifyUserAccessToken" + accessToken.toString());

		JSONObject claim = JSONObject.fromObject(accessToken.getClaim());
		// Locale locale = (Locale)
		// request.getAttribute(CookieLocaleResolver.class.getName() + ".LOCALE");

		// long reqExpireTime = new Long((int) claim.get("expireTime"));
		// String reqVersion = (String) claim.get("version");
		// String reqIssueAt = String.valueOf(claim.get("issueAt"));
		// String storedVersion = bnbSystemDataAccess.getTokenVersion();

		// LOGGER.debug("reqVersion : " + reqVersion);
		// LOGGER.debug("storedVersion : " + storedVersion);
		// LOGGER.debug("reqIssueAt : " + reqIssueAt);

		try {
			// this.checkTokenExpireTime(reqExpireTime);
			// this.checkTokenVersion(storedVersion, reqVersion);
			// 캐시에서 사용자 정보를 가져오는 함수를 만드세요
			// 혹은 claim 정보에 들어 있는 userData를 사용하세요
			// UserDataVO userData = getCache.userData();

			UserDataVO userData = new UserDataVO();
			userData.setDeptName((String) claim.get("deptName"));
			userData.setDeptId((String) claim.get("DeptId"));
			userData.setUserId((String) claim.get("userId"));
			userData.setUserName((String) claim.get("userName"));
			DataSourceContextHolder.setDatasourceType(DataSourceType.MARIADB);
			UserDataContextHolder.setUserData(userData);
		} catch (BnbException e1) {
			cookieOperations.removeCookieAccessToken(response);

			throw new BnbException(e1);
		} catch (Exception e2) {
			throw new Exception(e2);
		}
	}

}
