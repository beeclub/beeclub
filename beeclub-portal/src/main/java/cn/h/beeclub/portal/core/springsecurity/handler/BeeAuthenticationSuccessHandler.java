package cn.h.beeclub.portal.core.springsecurity.handler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import cn.h.beeclub.common.base.result.SimpleResult;
import cn.h.beeclub.portal.common.util.TokenUtils;
import cn.h.beeclub.portal.common.util.WebUtils;
import cn.h.beeclub.portal.core.springsecurity.support.BeeUser;
import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;

/**
 * 
 * @description 认证成功的处理
 * @author hao.huang
 * @date 2019年11月19日
 */
@Slf4j
@Component
public class BeeAuthenticationSuccessHandler implements AuthenticationSuccessHandler{
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		log.info("BeeAuthenticationSuccessHandler ==> start");
		log.info("authentication: {}", JSONUtil.toJsonStr(authentication));
		//获取认证成功的用户数据
		BeeUser user = (BeeUser) authentication.getPrincipal();
		//将token返回出去
		WebUtils.writeJson2Response(JSONUtil.toJsonStr(SimpleResult.ok(user.getToken())), response);
		log.info("BeeAuthenticationSuccessHandler ==> end");
		
	}

}
