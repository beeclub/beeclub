package cn.h.beeclub.portal.core.springsecurity.handler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.stereotype.Component;

import cn.h.beeclub.common.base.result.SimpleResult;
import cn.h.beeclub.portal.common.util.TokenUtils;
import cn.h.beeclub.portal.common.util.WebUtils;
import cn.h.beeclub.portal.core.springsecurity.support.BeeUser;
import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;

/**
 * 登出成功的数据
 * @description 
 * @author hao.huang
 * @date 2019年11月19日
 */
@Slf4j
@Component
public class BeeLogoutSuccessHandler implements LogoutSuccessHandler {
	
	@Autowired
	private RedisTemplate redisTemplate;
	
	@Override
	public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
			throws IOException, ServletException {
		log.info("BeeLogoutSuccessHandler ==> start");
		log.info("authentication: {}", JSONUtil.toJsonStr(authentication));
		log.info("BeeLogoutSuccessHandler ==> end");
		String token = request.getHeader("Authorization");
		if(StringUtils.isNotBlank(token)) {
			String username = TokenUtils.getUsernameFromToken(token);
			System.out.println(username);
			if(username != null) {
				redisTemplate.delete(TokenUtils.PC_TOKEN_PRE + username);
			}
			log.info("logout token:{}", token);
		}
		
		WebUtils.writeJson2Response(JSONUtil.toJsonStr(SimpleResult.ok("登出成功")), response);
	}

}
