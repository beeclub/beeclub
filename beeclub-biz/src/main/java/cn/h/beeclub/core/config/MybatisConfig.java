package cn.h.beeclub.core.config;

import java.util.Properties;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInterceptor;
import com.github.pagehelper.dialect.helper.MySqlDialect;

@SpringBootConfiguration
@MapperScan(basePackages = {"cn.h.beeclub.**.dao", "cn.h.beeclub.**.mapper"})
@EnableTransactionManagement(proxyTargetClass = true)
public class MybatisConfig {
	
	
	
	/*
	 * @Bean public PageInterceptor pageInterceptor() { PageInterceptor page = new
	 * PageInterceptor(); Properties properties = new Properties();
	 * properties.put("dialect", MySqlDialect.class.getName());
	 * page.setProperties(properties); return page; }
	 */
	
//	@Bean
    public PageHelper pageHelper() {
        System.out.println("MyBatisConfiguration.pageHelper()");
        PageHelper pageHelper = new PageHelper();
        Properties p = new Properties();
        p.setProperty("offsetAsPageNum", "true");
        p.setProperty("rowBoundsWithCount", "true");
        p.setProperty("reasonable", "true");
        pageHelper.setProperties(p);
        return pageHelper;
    }
    
    @Bean
    public PaginationInterceptor paginationInterceptor() {
    	PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
    	// 设置请求的页面大于最大页后操作， true调回到首页，false 继续请求  默认false
        // paginationInterceptor.setOverflow(false);
        // 设置最大单页限制数量，默认 500 条，-1 不受限制
        // paginationInterceptor.setLimit(500);
    	return paginationInterceptor;
    }
}
