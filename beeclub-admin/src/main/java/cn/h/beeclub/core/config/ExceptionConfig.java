package cn.h.beeclub.core.config;

import cn.h.beeclub.common.base.result.SimpleResult;
import cn.h.beeclub.common.exception.BusinessException;
import lombok.extern.slf4j.Slf4j;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletResponse;

/**
 * 全局异常配置处理
 */
@Slf4j
@ControllerAdvice
@RestControllerAdvice
public class ExceptionConfig {

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public SimpleResult<Object> exceptionHandler(HttpServletResponse response,Exception e){
    	log.info("global exception: {}", e);
        SimpleResult<Object> result = null;
        if(e instanceof UnauthorizedException){
            //没有访问权限
            result = new SimpleResult<>(402, "无权操作");
        } else if(e instanceof AuthenticationException) {
        	result = new SimpleResult<>(401, e.getMessage());
        } else if(e instanceof BusinessException){
            BusinessException busException = (BusinessException) e;
            result = new SimpleResult<Object>(busException.getCode(), e.getMessage(), ((BusinessException) e).getData());
        }
        else{
           result = new SimpleResult<>(500, e.getMessage());
        }
        return result;
    }

}
