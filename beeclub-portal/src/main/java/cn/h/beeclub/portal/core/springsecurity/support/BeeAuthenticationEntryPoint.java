package cn.h.beeclub.portal.core.springsecurity.support;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import cn.h.beeclub.common.base.result.SimpleResult;
import cn.h.beeclub.portal.common.util.WebUtils;
import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class BeeAuthenticationEntryPoint implements AuthenticationEntryPoint {

	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException authException) throws IOException, ServletException {
		log.info("BeeAuthenticationEntryPoint====>");
		WebUtils.writeJson2Response(JSONUtil.toJsonStr(SimpleResult.noAuth("请先登录")), response);
		
	}

}
