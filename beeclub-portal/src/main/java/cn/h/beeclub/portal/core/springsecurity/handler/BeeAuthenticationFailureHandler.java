package cn.h.beeclub.portal.core.springsecurity.handler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import cn.h.beeclub.common.base.result.SimpleResult;
import cn.h.beeclub.portal.common.util.WebUtils;
import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;

/**
 * 认证失败后的处理
 * @description 
 * @author hao.huang
 * @date 2019年11月19日
 */
@Slf4j
@Component
public class BeeAuthenticationFailureHandler implements AuthenticationFailureHandler {
	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception) throws IOException, ServletException {
		log.info("BeeAuthenticationFailureHandler ==> start");
		log.info("exception: {}", JSONUtil.toJsonStr(exception));
		WebUtils.writeJson2Response(JSONUtil.toJsonStr(SimpleResult.fail(exception.getMessage())), response);
		log.info("BeeAuthenticationFailureHandler ==> end");

	}

}
