package cn.h.beeclub.common.base;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import com.alibaba.fastjson.JSON;

import cn.h.beeclub.admin.common.constant.AdminConstant;
import cn.h.beeclub.admin.system.domain.SysAdmin;
import cn.h.beeclub.common.base.dto.OperationContext;
import cn.h.beeclub.core.util.JWTUtils;
import cn.hutool.json.JSONUtil;

public class BaseController {
	
	private RedisTemplate<String,String> redisTemplate;
	
	@Autowired
	public void setRedisTemplate(RedisTemplate<String,String> redisTemplate) {
		this.redisTemplate = redisTemplate;
	}


	protected SysAdmin getCurrentUser() {
		String token = (String) SecurityUtils.getSubject().getPrincipal();
		if(token == null) {
			return null;
		}
		String username = JWTUtils.getUsername(token);
		String jsonString = (String) redisTemplate.opsForValue().get(AdminConstant.USER_KEY  + username);
		if(jsonString == null) {
			return null;
		}
		SysAdmin admin = JSONUtil.toBean(jsonString, SysAdmin.class);
		System.err.println(JSON.toJSONString(admin));
		return admin;
	}
	
	protected Long getCurrentUserId() {
		SysAdmin admin = getCurrentUser();
		if(admin == null) {
			return null;
		}
		return admin.getId();
	}
	
	protected OperationContext getContext() {
		OperationContext context = new OperationContext();
		Long currentUserId = getCurrentUserId();
		context.setOperator(currentUserId);
		return context;
	}
}
