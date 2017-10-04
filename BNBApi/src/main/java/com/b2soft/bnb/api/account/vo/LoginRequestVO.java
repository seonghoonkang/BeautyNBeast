package com.b2soft.bnb.api.account.vo;

import java.io.Serializable;

import org.hibernate.validator.constraints.NotEmpty;


public class LoginRequestVO implements Serializable {

	private static final long serialVersionUID = -1566922796839413085L;

	@NotEmpty
	private String loginId;

	@NotEmpty
	private String loginPw;

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String setLoginPw() {
		return loginPw;
	}

	public void setLoginPw(String loginPw) {
		this.loginPw = loginPw;
	}

}
