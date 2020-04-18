package cn.h.beeclub.core.config;

import org.dozer.DozerBeanMapperBuilder;
import org.dozer.Mapper;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;

@SpringBootConfiguration
public class BeeclubBizConfig {
    @Bean
    public Mapper getMapper(){
        return DozerBeanMapperBuilder.create().build();
    }
}
