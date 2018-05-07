package com.cogitationsoft.findit.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author: Andy
 * @date: 5/3/2018 5:57 PM
 * @description: Mybatis 配置信息
 * @version: 1.0
 */
@Configuration
@EnableTransactionManagement
@MapperScan("com.cogitationsoft.findit.mapper")
public class MyBatisConfig {
	@Autowired(required = false)
	public Environment env;

	@Autowired
	private DruidConfig druid;

	@Bean(initMethod = "init", destroyMethod = "close")
	public DruidDataSource dataSource() {
		DruidDataSource dataSource = new DruidDataSource();
		// 基本属性 url、user、password
		dataSource.setDriverClassName(druid.getDriver());
		dataSource.setUrl(druid.getUrl());
		dataSource.setUsername(druid.getUsername());
		dataSource.setPassword(druid.getPassword());

		// 配置初始化大小、最小、最大
		dataSource.setInitialSize(druid.getInitialSize());
		dataSource.setMinIdle(druid.getMinIdle());
		dataSource.setMaxActive(druid.getMaxActive());

		// 配置获取连接等待超时的时间
		dataSource.setMaxWait(druid.getMaxWait());

		// 配置间隔多久才进行一次检测，检测需要关闭的空闲连接，单位是毫秒
		dataSource.setTimeBetweenEvictionRunsMillis(druid.getTimeBetweenEvictionRunsMillis());

		// 配置一个连接在池中最小生存的时间，单位是毫秒
		dataSource.setMinEvictableIdleTimeMillis(druid.getMinEvictableIdleTimeMillis());

		dataSource.setValidationQuery(druid.getValidationQuery());
		dataSource.setTestWhileIdle(druid.isTestWhileIdle());
		dataSource.setTestOnBorrow(druid.isTestOnBorrow());
		dataSource.setTestOnReturn(druid.isTestOnReturn());

		// 是否打开PSCache，并且指定每个连接上PSCache的大小
		dataSource.setPoolPreparedStatements(druid.isPoolPreparedStatements());
		dataSource.setMaxPoolPreparedStatementPerConnectionSize(druid.getMaxPoolPreparedStatementPerConnectionSize());
		return dataSource;
	}

	@Bean
	public SqlSessionFactory sqlSessionFactory(ApplicationContext applicationContext) throws Exception {
		SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
		sessionFactory.setDataSource(dataSource());
		// 设置 mapper xml
		//sessionFactory.setMapperLocations(applicationContext.getResources("classpath:mapper/**/*.xml"));
		return sessionFactory.getObject();
	}

	@Bean
	public PlatformTransactionManager txManager() {
		return new DataSourceTransactionManager(dataSource());
	}
}
