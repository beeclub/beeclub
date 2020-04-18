package cn.h.beeclub.portal.core.springsecurity.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import cn.h.beeclub.portal.common.util.TokenUtils;
import cn.h.beeclub.portal.core.springsecurity.support.BeeUser;
import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {

	@Autowired
	private RedisTemplate redisTemplate;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		log.info("JwtAuthenticationTokenFilter===>");
		String token = request.getHeader("Authorization");
		log.info("token===>{}", token);
		if(StringUtils.isNotBlank(token) && TokenUtils.verify(token)) {
			log.info(token);
				String username = TokenUtils.getUsernameFromToken(token);
				log.info("username:{}",username );
				if(StringUtils.isNotBlank(username) && SecurityContextHolder.getContext().getAuthentication() == null) {
					BeeUser user = (BeeUser) redisTemplate.opsForValue().get(TokenUtils.PC_TOKEN_PRE + username);
					if(user != null && token.equals(user.getToken())) {
						//
						UsernamePasswordAuthenticationToken authentication = 
								new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
						SecurityContextHolder.getContext().setAuthentication(authentication);
					}
				}
		}
		filterChain.doFilter(request, response);
	}

}
