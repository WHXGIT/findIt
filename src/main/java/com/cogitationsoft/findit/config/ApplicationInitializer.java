package com.cogitationsoft.findit.config;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;

/**
 * @author: Andy
 * @date: 5/2/2018 11:34 AM
 * @description: BaseConfig WebApplicationInitializer
 * @version: 1.0
 */
public class ApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
	@Override
	protected Filter[] getServletFilters() {
		return new Filter[]{new HiddenHttpMethodFilter(), new CharacterEncodingFilter("utf-8")};
	}

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[]{RootConfig.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[]{WebConfig.class};
	}

	@Override
	protected String[] getServletMappings() {
		return new String[]{"/"};
	}
}
