package cn.h.beeclub.core.config;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ApplicationStartup implements ApplicationListener<ApplicationEvent>{

	@Override
	public void onApplicationEvent(ApplicationEvent event) {
		// TODO Auto-generated method stub
		log.info("监听"+ event.getSource());
	}

}
