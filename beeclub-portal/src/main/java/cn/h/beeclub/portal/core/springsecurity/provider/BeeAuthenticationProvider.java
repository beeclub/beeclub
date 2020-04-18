package cn.h.beeclub.portal.core.springsecurity.provider;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import cn.h.beeclub.portal.common.util.TokenUtils;
import cn.h.beeclub.portal.core.springsecurity.support.BeeLoginWebAuthenticationDetails;
import cn.h.beeclub.portal.core.springsecurity.support.BeeUser;
import cn.h.beeclub.portal.core.springsecurity.support.BeeUserDetailsService;
import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;

/**
 * 
 * @description 
 * @author hao.huang
 * @date 2019年11月19日
 */
@Slf4j
@Component
public class BeeAuthenticationProvider implements AuthenticationProvider{

	@Autowired
	private BeeUserDetailsService userDetailsService;
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private RedisTemplate redisTemplate;
	
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		log.info(JSONUtil.toJsonStr(authentication));
		log.info("authentication{}",JSONUtil.toJsonStr(authentication.getDetails()));
		String pwd = (String) authentication.getCredentials();
		String account = (String) authentication.getPrincipal();
		BeeLoginWebAuthenticationDetails details= (BeeLoginWebAuthenticationDetails) authentication.getDetails();
		boolean isWeek = details.isWeek();
		if(isWeek) {
			//设置失效时间
		}

        switch (details.getSignInType()) {
            case accountPwd:

                break;

                default:break;
        }
        account = details.getAccount();
		if(StringUtils.isBlank(account) || StringUtils.isBlank(pwd)) {
			throw new BadCredentialsException("账号和密码不能为空");
		}
		BeeUser user = (BeeUser) userDetailsService.loadUserByUsername(account);
		if(!passwordEncoder.matches(pwd, user.getPassword())) {
			throw new BadCredentialsException("密码不正确");
		}
		user.setPassword(null);
		redisTemplate.opsForValue().set(TokenUtils.PC_TOKEN_PRE + user.getUsername(), user);
		return new UsernamePasswordAuthenticationToken(user, user.getPassword(), user.getAuthorities());
	}

	/**
	 * 支持用户密码token认证
	 */
	@Override
	public boolean supports(Class<?> authentication) {
		return UsernamePasswordAuthenticationToken.class.equals(authentication);
	}

}
