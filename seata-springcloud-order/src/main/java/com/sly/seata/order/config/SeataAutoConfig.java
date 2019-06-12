package com.sly.seata.order.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import com.alibaba.druid.pool.DruidDataSource;
import com.sly.seata.order.filter.SeataXidFilter;

import io.seata.rm.datasource.DataSourceProxy;
import io.seata.spring.annotation.GlobalTransactionScanner;

/**
 * seata配置
 * 
 * @author sly
 * @time 2019年6月11日
 */
@Configuration
public class SeataAutoConfig {
	@Autowired
	private DataSourceProperties dataSourceProperties;

	/**
	 * druid数据源
	 * 
	 * @return
	 * @author sly
	 * @time 2019年6月11日
	 */
	@Bean
	@Primary
	public DruidDataSource druidDataSource() {
		DruidDataSource druidDataSource = new DruidDataSource();
		druidDataSource.setUrl(dataSourceProperties.getUrl());
		druidDataSource.setUsername(dataSourceProperties.getUsername());
		druidDataSource.setPassword(dataSourceProperties.getPassword());
		druidDataSource.setDriverClassName(dataSourceProperties.getDriverClassName());
		druidDataSource.setInitialSize(0);
		druidDataSource.setMaxActive(180);
		druidDataSource.setMaxWait(60000);
		druidDataSource.setMinIdle(0);
		// druidDataSource.setValidationQuery("Select 1 from DUAL");
		druidDataSource.setTestOnBorrow(false);
		druidDataSource.setTestOnReturn(false);
		druidDataSource.setTestWhileIdle(true);
		druidDataSource.setTimeBetweenEvictionRunsMillis(60000);
		druidDataSource.setMinEvictableIdleTimeMillis(25200000);
		druidDataSource.setRemoveAbandoned(true);
		druidDataSource.setRemoveAbandonedTimeout(1800);
		druidDataSource.setLogAbandoned(true);
		return druidDataSource;
	}

	/**
	 * 代理数据源
	 * 
	 * @param druidDataSource
	 * @return
	 * @author sly
	 * @time 2019年6月11日
	 */
	@Bean
	public DataSourceProxy dataSourceProxy(DruidDataSource druidDataSource) {
		return new DataSourceProxy(druidDataSource);
	}

	/**
	 * 初始化mybatis sqlSessionFactory
	 * 
	 * @param dataSourceProxy
	 * @return
	 * @throws Exception
	 * @author sly
	 * @time 2019年6月11日
	 */
	@Bean
	public SqlSessionFactory sqlSessionFactory(DataSourceProxy dataSourceProxy) throws Exception {
		SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
		factoryBean.setDataSource(dataSourceProxy);
		factoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapper/*.xml"));
		factoryBean.setTypeAliasesPackage("com.sly.seata.common.model");
		factoryBean.setTransactionFactory(new JdbcTransactionFactory());
		return factoryBean.getObject();
	}
	
	/**
	 * 初始化seataXid过滤器
	 * 
	 * @return
	 * @author sly
	 * @time 2019年6月12日
	 */
	@Bean
	public SeataXidFilter fescarXidFilter() {
		return new SeataXidFilter();
	}

	/**
	 * 初始化全局事务扫描
	 * 
	 * @return
	 * @author sly
	 * @time 2019年6月11日
	 */
	@Bean
	public GlobalTransactionScanner globalTransactionScanner() {
		return new GlobalTransactionScanner("seata-springcloud-order", "my_test_tx_group");
	}
}
