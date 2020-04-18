package cn.h.beeclub.portal.core.config;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.h.beeclub.common.base.result.SimpleResult;
import cn.h.beeclub.common.exception.AuthFailException;
import cn.h.beeclub.common.exception.BusinessException;
import lombok.extern.slf4j.Slf4j;

/**
 * 全局异常
 * @description 
 * @author hao.huang
 * @date 2019年11月19日
 */
@Slf4j
@ControllerAdvice
public class GlobalExcetionHandler {

	@ExceptionHandler
	@ResponseBody
	public <T> SimpleResult<T> exceptionHandler(HttpServletRequest request,HttpServletResponse response,Exception e){
		log.info("request:{},response:{},e:{}", request, response, e);
		if(e instanceof AuthFailException) {
			return SimpleResult.authFail("请先登录");
		}
		if(e instanceof BusinessException) {
			return SimpleResult.fail(e.getMessage());
		}
		return SimpleResult.fail(e.getMessage());
	}
}
