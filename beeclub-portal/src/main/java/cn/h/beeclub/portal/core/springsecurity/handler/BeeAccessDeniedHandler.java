package cn.h.beeclub.portal.core.springsecurity.handler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import cn.h.beeclub.common.base.result.SimpleResult;
import cn.h.beeclub.portal.common.util.WebUtils;
import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;

/**
 * 未登录访问被拒绝
 * @description 
 * @author hao.huang
 * @date 2019年11月19日
 */
@Slf4j
@Component
public class BeeAccessDeniedHandler implements AccessDeniedHandler {

	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response,
			AccessDeniedException accessDeniedException) throws IOException, ServletException {
		log.info("BeeAccessDeniedHandler ==> start");
		log.info("accessDeniedException: {}", JSONUtil.toJsonStr(accessDeniedException));
		WebUtils.writeJson2Response(JSONUtil.toJsonStr(SimpleResult.noAuth("请先登录")), response);
		log.info("BeeAccessDeniedHandler ==> end");

	}

}
