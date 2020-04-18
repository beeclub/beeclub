package cn.h.beeclub.portal.core.config;

import cn.h.beeclub.common.mail.MailHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Portal 公共设置
 * @description 
 * @author hao.huang
 * @date 2019年11月19日
 */
@Configuration
public class BeeClubPortalConfig {
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Autowired
	private JavaMailSender javaMailSender;
	
	@Bean
	public MailHandler mailHandler(){
		return new MailHandler(javaMailSender);
	}
	
}
