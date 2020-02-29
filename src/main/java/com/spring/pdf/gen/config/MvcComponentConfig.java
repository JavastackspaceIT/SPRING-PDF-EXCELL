package com.spring.pdf.gen.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.ResourceBundleViewResolver;

@ComponentScan(basePackages = "com.spring.pdf.*")
@Configuration
@EnableWebMvc
// @PropertySource("classpath:views.properties")
public class MvcComponentConfig extends WebMvcConfigurerAdapter {

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/*").addResourceLocations("/");
	}

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/home").setViewName("home");
	}

	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {

		ResourceBundleViewResolver viewResolver2 = new ResourceBundleViewResolver();
		viewResolver2.setOrder(1);
		viewResolver2.setBasename("views");
		registry.viewResolver(viewResolver2);

		InternalResourceViewResolver viewResolver1 = new InternalResourceViewResolver();
		viewResolver1.setViewClass(JstlView.class);
		viewResolver1.setPrefix("/WEB-INF/views/");
		viewResolver1.setSuffix(".jsp");
		viewResolver1.setOrder(2);
		registry.viewResolver(viewResolver1);
	}

}
