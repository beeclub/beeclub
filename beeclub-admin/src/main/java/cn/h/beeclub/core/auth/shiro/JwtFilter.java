package cn.h.beeclub.core.auth.shiro;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.hutool.json.JSON;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.AntPathMatcher;
import org.apache.shiro.web.filter.authc.BasicHttpAuthenticationFilter;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.h.beeclub.common.base.result.SimpleResult;
import cn.h.beeclub.core.util.JWTUtils;
import cn.h.beeclub.core.util.JwtUtil;
import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class JwtFilter extends BasicHttpAuthenticationFilter {

	private AntPathMatcher antPathMatcher = new AntPathMatcher();
	private String[] excludes;

	public String[] getExcludes() {
		return excludes;
	}

	public void setExcludes(String[] excludes) {
		this.excludes = excludes;
	}

	@Override
	protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) {
		log.info("isAccessAllowed===>");
		HttpServletRequest req = (HttpServletRequest) request;
		String uri = req.getRequestURI();
		System.out.println(uri);
		for (String exclude : excludes) {
			if (antPathMatcher.match(exclude, uri)) {
				log.info("return exclude");
				return true;
			}
		}
		if (isLoginAttempt(request, response)) {
			try {
				return this.executeLogin(request, response);
			} catch (Exception e) {
				response401(response);
				log.info("return false");
				return false;
			}
		} else {
			log.info("return false");
			response401(response);
			return false;
		}
	}

	@Override
	protected boolean executeLogin(ServletRequest request, ServletResponse response) throws Exception {
		HttpServletRequest req = (HttpServletRequest) request;
		String token = req.getHeader("token");// Authorization
		log.info("executeLogin ===> ");

		JwtToken jwtToken = new JwtToken(token);

		try {
			Subject subject = getSubject(request, response);
			subject.login(jwtToken);
//			Session session = subject.getSession();
//			session.setAttribute("userInfo", "用户信息");
//			log.info("executeLogin session:{}", subject.getSession());
			return true;
		} catch (Exception e) {
			log.info(e.getMessage());
			response401(response);
			return false;
		}
	}

	@Override
	protected boolean preHandle(ServletRequest request, ServletResponse response) throws Exception {
//		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
//        HttpServletResponse httpServletResponse = (HttpServletResponse) response;

		HttpServletRequest httpRequest = WebUtils.toHttp(request);
		HttpServletResponse httpResponse = WebUtils.toHttp(response);
		httpResponse.setHeader("Access-control-Allow-Origin", httpRequest.getHeader("Origin"));
		httpResponse.setHeader("Access-Control-Allow-Methods", "GET,POST,OPTIONS,PUT,DELETE");
		httpResponse.setHeader("Access-Control-Allow-Headers", httpRequest.getHeader("Access-Control-Request-Headers"));
		// 跨域时会首先发送一个 option请求，这里我们给 option请求直接返回正常状态
		System.err.println(httpRequest.getMethod());
		if (httpRequest.getMethod().equals(RequestMethod.OPTIONS.name())) {
			httpResponse.setStatus(HttpStatus.OK.value());
			return false;
		}

		return super.preHandle(request, response);
//        		super.preHandle(request, response);
	}

	private void response401(ServletResponse response) {
		PrintWriter out = null;
		try {
			response.setContentType("application/json;charset=utf-8");
			SimpleResult<Integer> res = SimpleResult.noAuth("");
			out = response.getWriter();
			out.write(JSONUtil.toJsonStr(res));
			out.flush();
		} catch (IOException e) {
			log.info(e.getMessage());

		} finally {
			if (out != null) {
				out.close();
			}
		}
	}

	@Override
	protected boolean isLoginAttempt(ServletRequest request, ServletResponse response) {
		log.info("isLoginAttempt===>");
		HttpServletRequest req = (HttpServletRequest) request;
		String token = req.getHeader("token");// Authorization
//		return super.isLoginAttempt(request, response);
		return token != null;
	}

}
