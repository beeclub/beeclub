package cn.h.beeclub.portal.core.springsecurity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import cn.h.beeclub.portal.core.springsecurity.filter.JwtAuthenticationTokenFilter;
import cn.h.beeclub.portal.core.springsecurity.handler.BeeAccessDeniedHandler;
import cn.h.beeclub.portal.core.springsecurity.handler.BeeAuthenticationFailureHandler;
import cn.h.beeclub.portal.core.springsecurity.handler.BeeAuthenticationSuccessHandler;
import cn.h.beeclub.portal.core.springsecurity.handler.BeeLogoutSuccessHandler;
import cn.h.beeclub.portal.core.springsecurity.provider.BeeAuthenticationProvider;
import cn.h.beeclub.portal.core.springsecurity.support.BeeAuthenticationDetailsSource;
import cn.h.beeclub.portal.core.springsecurity.support.BeeAuthenticationEntryPoint;
import cn.h.beeclub.portal.core.springsecurity.support.BeeUserDetailsService;
import lombok.extern.slf4j.Slf4j;

/**
 * spring security 配置
 * @description 
 * @author hao.huang
 * @date 2019年11月19日
 */
@Slf4j
@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {
	
	
	@Autowired
	private BeeAuthenticationSuccessHandler authenticationSuccessHandler;
	@Autowired
	private BeeAuthenticationFailureHandler authenticationFailureHandler;
	
	@Autowired
	private BeeLogoutSuccessHandler logoutSuccessHandler;
	
	@Autowired
	private BeeAccessDeniedHandler accessDeniedHandler;
	@Autowired
	private BeeUserDetailsService userDetailsService;
	
	@Autowired
	private JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter;
	@Autowired
	private BeeAuthenticationEntryPoint authenticationEntryPoint;
	@Autowired
	private BeeAuthenticationProvider authenticationProvider;
	@Autowired
	private BeeAuthenticationDetailsSource authenticationDetailsSource;
	
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authenticationProvider);
	}



	@Override
	protected void configure(HttpSecurity http) throws Exception {
		log.info("正在配置HttpSecuriry=== > ");
		http
			.csrf().disable()
			.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
			.and()
			.cors()
		.and()
			.httpBasic().authenticationEntryPoint(authenticationEntryPoint)
		
			
		.and()
		//配置登录吗
//		.addFilterBefore(filter, beforeFilter)
		.authorizeRequests()
		.antMatchers("/sign-up","/sendCodeToEmailForSignUp","/api/public/v1/**").permitAll()//.anonymous()
		.and()
			.authorizeRequests().anyRequest()//.access("@rbacauthorityservice.hasPermission(request,authentication)") // RBAC 动态 url 认证
			.authenticated()
			.and()
			.formLogin()
			.loginProcessingUrl("/sign-in")

			.authenticationDetailsSource(authenticationDetailsSource)
			.successHandler(authenticationSuccessHandler)
			.failureHandler(authenticationFailureHandler)

			.permitAll()
		.and()
			.logout()
			.logoutUrl("/sign-out")
			.logoutSuccessHandler(logoutSuccessHandler)
			.permitAll()
		.and()
			.exceptionHandling()
			.accessDeniedHandler(accessDeniedHandler)
            .authenticationEntryPoint(authenticationEntryPoint)
			;
		//自定义过滤器
		http.addFilterBefore(jwtAuthenticationTokenFilter, UsernamePasswordAuthenticationFilter.class);
	}


	@Override
	protected UserDetailsService userDetailsService() {
		return userDetailsService;
	}



}
