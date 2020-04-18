package cn.h.beeclub.portal.core.springsecurity.support;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.authentication.AuthenticationDetailsSource;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Component;

@Component
public class BeeAuthenticationDetailsSource implements AuthenticationDetailsSource<HttpServletRequest, WebAuthenticationDetails>{

	@Override
	public WebAuthenticationDetails buildDetails(HttpServletRequest context) {
		return new BeeLoginWebAuthenticationDetails(context);
	}

}
