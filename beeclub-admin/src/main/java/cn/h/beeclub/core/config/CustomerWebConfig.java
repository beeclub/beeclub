package cn.h.beeclub.core.config;

import cn.h.beeclub.core.web.filter.AuthFilter;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

//@SpringBootConfiguration
public class CustomerWebConfig {


//    @Bean
    public FilterRegistrationBean<AuthFilter> filterRegistrationBean(){
        FilterRegistrationBean<AuthFilter> filterRegistrationBean = new FilterRegistrationBean<AuthFilter>();
        filterRegistrationBean.setFilter(new AuthFilter());
        filterRegistrationBean.addUrlPatterns("/*");
        filterRegistrationBean.setName("authFilter");
        return filterRegistrationBean;
    }
}
