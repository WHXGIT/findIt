package com.cogitationsoft.findit.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @author: Andy
 * @date: 5/7/2018 5:25 PM
 * @description: druid配置
 * @version: 1.0
 */
@Component
@PropertySource("classpath:config/druid.properties")
public class DruidConfig {
	@Value("${druid.driverClassName}")
	private String driver;

	@Value("${druid.url}")
	private String url;

	@Value("${druid.username}")
	private String username;

	@Value("${druid.password}")
	private String password;

	@Value("${druid.initialSize}")
	private int initialSize;

	@Value("${druid.minIdle}")
	private int minIdle;

	@Value("${druid.maxActive}")
	private int maxActive;

	@Value("${druid.maxWait}")
	private int maxWait;

	@Value("${druid.timeBetweenEvictionRunsMillis}")
	private int timeBetweenEvictionRunsMillis;

	@Value("${druid.minEvictableIdleTimeMillis}")
	private int minEvictableIdleTimeMillis;

	@Value("${druid.validationQuery}")
	private String validationQuery;

	@Value("${druid.testWhileIdle}")
	private boolean testWhileIdle;

	@Value("${druid.testOnBorrow}")
	private boolean testOnBorrow;

	@Value("${druid.testOnReturn}")
	private boolean testOnReturn;

	@Value("${druid.poolPreparedStatements}")
	private boolean poolPreparedStatements;

	@Value("${druid.maxPoolPreparedStatementPerConnectionSize}")
	private int maxPoolPreparedStatementPerConnectionSize;

	@Value("${druid.filters}")
	private String filters;

	public String getDriver() {
		return driver;
	}

	public String getUrl() {
		return url;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public int getInitialSize() {
		return initialSize;
	}

	public int getMinIdle() {
		return minIdle;
	}

	public int getMaxActive() {
		return maxActive;
	}

	public int getMaxWait() {
		return maxWait;
	}

	public int getTimeBetweenEvictionRunsMillis() {
		return timeBetweenEvictionRunsMillis;
	}

	public int getMinEvictableIdleTimeMillis() {
		return minEvictableIdleTimeMillis;
	}

	public String getValidationQuery() {
		return validationQuery;
	}

	public boolean isTestWhileIdle() {
		return testWhileIdle;
	}

	public boolean isTestOnBorrow() {
		return testOnBorrow;
	}

	public boolean isTestOnReturn() {
		return testOnReturn;
	}

	public boolean isPoolPreparedStatements() {
		return poolPreparedStatements;
	}

	public int getMaxPoolPreparedStatementPerConnectionSize() {
		return maxPoolPreparedStatementPerConnectionSize;
	}

	public String getFilters() {
		return filters;
	}
}
