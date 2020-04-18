package cn.h.beeclub.core.auth.shiro;

import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import com.alibaba.fastjson.JSON;

import cn.h.beeclub.admin.common.constant.AdminConstant;
import cn.h.beeclub.admin.system.domain.SysAdmin;
import cn.h.beeclub.admin.system.service.SysAdminService;
import cn.h.beeclub.admin.system.service.SysResourceService;
import cn.h.beeclub.core.util.JWTUtils;
import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;

/**
 * 
 * @description 自定义认证领域
 * @author hao.huang
 * @date 2019年9月4日
 */
@Slf4j
public class BeeClubRealm extends AuthorizingRealm{
	
	@Autowired
	private RedisTemplate<String, String> redisTemplate;
	
	@Override
	public boolean supports(AuthenticationToken token) {
		return token instanceof JwtToken;
	}
	
	/**
	 * 鉴权
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		
		log.info("doGetAuthorizationInfo ====> ");
		String token = (String) principals.getPrimaryPrincipal();
		String username = JWTUtils.getUsername(token);
		String userInfo = redisTemplate.opsForValue().get(AdminConstant.USER_KEY + username);
		if(StringUtils.isBlank(userInfo)) {
			return null;
		}
		SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
		SysAdmin admin = JSON.parseObject(userInfo, SysAdmin.class);
		authorizationInfo.addStringPermissions(admin.getPermissions());

		return authorizationInfo;
	}

	/**
	 * 认证
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		log.info("doGetAuthenticationInfo ===> ");
		String tokenStr = (String) token.getPrincipal();
//		SysAdmin admin = sysAdminService.getAdminByMoible(username);
		String username = JWTUtils.getUsername(tokenStr);
		if(StringUtils.isBlank(username)) {
			throw new AuthenticationException("token校验不通过");
		}
		String userInfo = redisTemplate.opsForValue().get(AdminConstant.USER_KEY +  username);
		if(StringUtils.isBlank(userInfo)) {
			throw new AuthenticationException("token已经过期");
		}
		
		
		SysAdmin admin = JSON.parseObject(userInfo, SysAdmin.class);
		String loginIp = JWTUtils.getLoginIp(tokenStr);
		if(StringUtils.isBlank(loginIp) || !loginIp.equals(admin.getLoginIp())) {
			throw new AuthenticationException("账户已在其他设备登录，请重新登录");
		}
		
		redisTemplate.expire(AdminConstant.USER_KEY + username, 7 * 24 * 60 , TimeUnit.MINUTES);
//		if(StringUtils.isNotBlank(accessToken)) {
//			
//		}
		SecurityUtils.getSubject().getSession().setAttribute("userInfo", admin);
		log.info("doGetAuthorizationInfo====> {}",SecurityUtils.getSubject().getSession().getAttribute("userInfo"));
		SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(tokenStr, token.getCredentials(), getName());
		
		return authenticationInfo;
	}

	
	
	
	
}
