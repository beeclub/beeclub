package cn.h.beeclub.portal.core.springsecurity.support;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.web.authentication.WebAuthenticationDetails;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 用来接收数据
 * @description 
 * @author hao.huang
 * @date 2019年9月27日
 */
@Data
@EqualsAndHashCode(callSuper=false)
public class BeeLoginWebAuthenticationDetails extends WebAuthenticationDetails{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1111975579726500105L;
	private boolean isWeek;
	private String email;
	private String account;
	private String mobile;
	private String authCode;
	private SignInTypeEnum signInType;
	private String password;

	public BeeLoginWebAuthenticationDetails(HttpServletRequest request) {
		super(request);
		//需要设置特殊
//		request.getParameter("isWeek")
        email = request.getParameter("email");
        account = request.getParameter("account");
        mobile = request.getParameter("mobile");
        authCode = request.getParameter("authCode");
        signInType = SignInTypeEnum.valueOf(request.getParameter("signInType"));
        password = request.getParameter("password");
    }

}
