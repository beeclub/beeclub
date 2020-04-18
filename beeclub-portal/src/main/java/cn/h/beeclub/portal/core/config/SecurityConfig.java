//package cn.h.beeclub.portal.core.config;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.annotation.Order;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.AuthenticationEntryPoint;
//import org.springframework.security.web.access.AccessDeniedHandler;
//import org.springframework.security.web.authentication.AuthenticationFailureHandler;
//import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
//import org.springframework.web.cors.CorsConfigurationSource;
//import org.springframework.web.cors.CorsUtils;
//
//import lombok.extern.slf4j.Slf4j;
//
///**
// * 
// * @description
// * @author hao.huang
// * @date 2019年8月24日
// */
//@Slf4j
////@Configuration
////@EnableWebSecurity
////@EnableGlobalMethodSecurity(prePostEnabled = true)
////@Order(-1)
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//
//
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		http.cors().and().csrf().disable().authorizeRequests().requestMatchers(CorsUtils::isPreFlightRequest)
//				.permitAll().antMatchers(HttpMethod.GET, // 允许对于网站静态资源的无授权访问
//						"/", "/*.html", "/favicon.ico", "/**/*.html", "/**/*.css", "/**/*.js", "/swagger-resources/**",
//						"/v2/api-docs/**")
//				.permitAll().antMatchers(HttpMethod.OPTIONS)// 跨域请求会先进行一次options请求
//				.permitAll().antMatchers("/home/**", "/common/**", "/sign-up", "/sign-in", "/sign-out").permitAll()
//
//				.anyRequest().authenticated()//除了设置的路径之外，其他路径都要认证
//
////				.and().formLogin().loginProcessingUrl("/sign-in").successHandler(authenticationSuccessHandler)
////				.failureHandler(authenticationFailureHandler).permitAll()
////
////				.and().logout().permitAll().and()
////				// 自定义权限拒绝处理类
////				.exceptionHandling().accessDeniedHandler(accessDeniedHandler)
////				.authenticationEntryPoint(authenticationEntryPoint)
//		//// 添加自定义权限过滤器
//		;
//		log.info("httpConfig:{}", http);
//	}
//
//	
//	
//}
