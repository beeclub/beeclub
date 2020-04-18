package cn.h.beeclub;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import cn.h.beeclub.core.config.ApplicationStartup;

/**
 * @author hao.huang
 */
@SpringBootApplication
public class BeeclubAdminApplication {

    public static void main(String[] args) {
    	SpringApplication application = new SpringApplication(BeeclubAdminApplication.class);
    	application.addListeners(new ApplicationStartup());
    	application.run(args);
    }

}
