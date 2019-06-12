package com.sly.seata.business.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.seata.spring.annotation.GlobalTransactionScanner;

/**
 * seata配置
 * 
 * @author sly
 * @time 2019年6月11日
 */
@Configuration
public class SeataAutoConfig {

	/**
	 * 初始化全局事务扫描
	 * 
	 * @return
	 * @author sly
	 * @time 2019年6月11日
	 */
	@Bean
	public GlobalTransactionScanner globalTransactionScanner() {
		return new GlobalTransactionScanner("seata-springcloud-business", "my_test_tx_group");
	}
}
