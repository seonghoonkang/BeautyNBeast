package com.b2soft.bnb.api.account.vo;

import java.io.Serializable;
import javax.validation.constraints.Size;

public class LoginRequestVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1566922796839413085L;

	@Size(min = 1)
	private String loginId;

	@Size(min = 1, max = 16)
	private String accountPw;

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getAccountPw() {
		return accountPw;
	}

	public void setAccountPw(String accountPw) {
		this.accountPw = accountPw;
	}

}
