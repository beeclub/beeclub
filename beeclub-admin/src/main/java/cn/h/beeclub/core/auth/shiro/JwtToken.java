package cn.h.beeclub.core.auth.shiro;

import org.apache.shiro.authc.AuthenticationToken;

import cn.h.beeclub.admin.system.domain.SysAdmin;

public class JwtToken implements AuthenticationToken{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6885308216923549692L;
	private String token;
	private String expireAt;
	
	public JwtToken(String token, String expireAt) {
		this.token = token;
		this.expireAt = expireAt;
	}

	public JwtToken(String token) {
		this.token = token;
	}

	@Override
	public Object getPrincipal() {
		return token;
	}

	@Override
	public Object getCredentials() {
		return token;
	}

}
