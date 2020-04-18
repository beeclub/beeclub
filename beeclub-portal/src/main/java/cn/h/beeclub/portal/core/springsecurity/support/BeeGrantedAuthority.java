package cn.h.beeclub.portal.core.springsecurity.support;

import org.springframework.security.core.GrantedAuthority;

public class BeeGrantedAuthority implements GrantedAuthority{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8153123771268049699L;
	private String authority;
	
	@Override
	public String getAuthority() {
		return authority;
	}

}
