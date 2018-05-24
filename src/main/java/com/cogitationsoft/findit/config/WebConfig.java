package com.cogitationsoft.findit.config;

import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.google.code.kaptcha.util.Config;
import freemarker.cache.WebappTemplateLoader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Locale;
import java.util.Properties;

import static freemarker.template.Configuration.VERSION_2_3_23;

/**
 * @author: Andy
 * @date: 5/2/2018 2:20 PM
 * @description: SpringMVC starter
 * @version: 1.0
 */
@EnableWebMvc
@ComponentScan("com.cogitationsoft.findit")
public class WebConfig extends WebMvcConfigurerAdapter {

	/**
	 * Method Description:
	 * 〈配置jsp视图解析器〉
	 *
	 * @param: null
	 * @return: ViewResolver
	 * @author: Andy
	 * @date: 5/3/2018 4:05 PM
	 */
	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setContentType("text/html;charset=UTF-8");
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		resolver.setExposeContextBeansAsAttributes(true);
		resolver.setOrder(0);
		return resolver;
	}

	/**
	 * Method Description:
	 * 〈配置所有的视图解析器〉
	 *
	 * @param: null
	 * @return:
	 * @author: Andy
	 * @date: 5/3/2018 4:07 PM
	 */
	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		registry.enableContentNegotiation(new MappingJackson2JsonView());
		registry.freeMarker();
	}

	/**
	 * Method Description:
	 * 〈FreeMarkerConfigurer〉
	 *
	 * @param: null
	 * @return: FreeMarkerConfigurer
	 * @author: Andy
	 * @date: 5/9/2018 12:47 AM
	 */
	@Bean
	public FreeMarkerConfigurer freemarkerConfig(ServletContext servletContext) {
		FreeMarkerConfigurer freemarkerConfig = new FreeMarkerConfigurer();
		freemarker.template.Configuration configuration = new freemarker.template.Configuration(VERSION_2_3_23);
		configuration.setTagSyntax(freemarker.template.Configuration.AUTO_DETECT_TAG_SYNTAX);
		configuration.setAutoFlush(true);
		configuration.setTemplateUpdateDelayMilliseconds(1000L);
		configuration.setDefaultEncoding("UTF-8");
		configuration.setEncoding(Locale.SIMPLIFIED_CHINESE,"utf-8");
		System.out.println(Locale.SIMPLIFIED_CHINESE);
		configuration.setOutputEncoding("UTF-8");
		configuration.setDateFormat("yyyy-MM-dd");
		configuration.setTimeFormat("HH:mm:ss");
		configuration.setDateTimeFormat("yyyy-MM-dd HH:mm:ss");
		configuration.setTemplateLoader(new WebappTemplateLoader(servletContext, "/WEB-INF/views/"));
		freemarkerConfig.setConfiguration(configuration);
		return freemarkerConfig;
	}

	/**
	 * Method Description:
	 * 〈FreeMarkerViewResolver〉
	 *
	 * @param: null
	 * @return: FreeMarkerViewResolver
	 * @author: Andy
	 * @date: 5/9/2018 12:47 AM
	 */
	@Bean
	public FreeMarkerViewResolver viewResolverFtl() {
		FreeMarkerViewResolver viewResolverFtl = new FreeMarkerViewResolver();
		viewResolverFtl.setCache(false);
		viewResolverFtl.setContentType("text/html;charset=UTF-8");
		viewResolverFtl.setPrefix("/WEB-INF/views/");
		viewResolverFtl.setSuffix(".ftl");
		viewResolverFtl.setExposeContextBeansAsAttributes(true);
		viewResolverFtl.setExposeRequestAttributes(true);
		viewResolverFtl.setExposeSessionAttributes(true);
		viewResolverFtl.setOrder(1);
		return viewResolverFtl;
	}

	/**
	 * Method Description:
	 * 〈配置文件上传视图解析器〉
	 *
	 * @param:      null
	 * @return:
	 * @author:     Andy
	 * @date:       5/11/2018 2:11 PM
	 */
	@Bean
	public CommonsMultipartResolver multipartResolver() {
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();

		multipartResolver.setDefaultEncoding("utf-8");
		multipartResolver.setMaxUploadSize(-1);
		multipartResolver.setMaxInMemorySize(2048);
		return multipartResolver;
	}

	/**
	 * Method Description:
	 * 〈静态资源位置〉
	 *
	 * @param: ResourceHandlerRegistry 静态资源处理器注册
	 * @return: void
	 * @author: Andy
	 * @date: 5/3/2018 4:45 PM
	 */
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/public-resources/**").addResourceLocations("/public-resources/");
	}


}
