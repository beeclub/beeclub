package cn.h.beeclub.core.auth.shiro;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.Filter;

import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
public class ShiroConfig {

	/**
	 * 管理shirobean的生命周期
	 * @description 
	 * @return
	 */
	@Bean
	public static LifecycleBeanPostProcessor getLifecycleBeanPostProcessor() {
		return new LifecycleBeanPostProcessor();
	}
	
	/**
	 * 创建securityManager
	 * @description 
	 * @return
	 */
	@Bean(name="securityManager")
	public SecurityManager securityManager() {
		DefaultWebSecurityManager defaultSecurityManager = new DefaultWebSecurityManager();
		//设置Realm
		defaultSecurityManager.setRealm(realm());
		//记住我
		//自定义缓存
		//自定义session
		return defaultSecurityManager;
	}

	@Value("${spring.shiro.excludes}")
	private String[] excludes;

	@Bean
	public ShiroFilterFactoryBean shiroFilterFactoryBean(SecurityManager securityManager) {
		log.info("config ShiroFilterFactoryBean");
		ShiroFilterFactoryBean factoryBean = new ShiroFilterFactoryBean();
		factoryBean.setSecurityManager(securityManager);

		Map<String, Filter> filters = new HashMap<>();
		System.out.println(Arrays.toString(excludes));
		JwtFilter jwtFilter = new JwtFilter();
		jwtFilter.setExcludes(excludes);
		filters.put("jwt", jwtFilter);
		factoryBean.setFilters(filters);

//		factoryBean.setLoginUrl("/noAuth");
//		factoryBean.setUnauthorizedUrl("/authFail");

		Map<String, String> filterChainDefinitionMap = new LinkedHashMap<>();

//		filterChainDefinitionMap.put("/login", "anon");
//		filterChainDefinitionMap.put("/noAuth", "anon");
//		filterChainDefinitionMap.put("/authFail", "anon");
		filterChainDefinitionMap.put("/**", "jwt");

		log.info("filterChainDefinitionMap:{}", filterChainDefinitionMap);
		factoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);

		return factoryBean;
	}

	@Bean
	public Realm realm() {
		return new BeeClubRealm();
	}

	

	/**
	 * 开启shiro aop注解支持.
     * 使用代理方式;所以需要开启代码支持;
	 * @description 
	 * @param securityManager
	 * @return
	 */
    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager) {
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
        return authorizationAttributeSourceAdvisor;
    }
}
