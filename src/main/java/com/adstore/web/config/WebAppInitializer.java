package com.adstore.web.config;

import javax.servlet.Filter;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
	private static final String DISPATCHER_SERVLET_MAPPING = "/services/*";

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] { ApplicationContext.class };
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return null;
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] { DISPATCHER_SERVLET_MAPPING };
	}

	@Override
	protected Filter[] getServletFilters() {
		Filter[] singleton = { new CorsFilters() };
		return singleton;
	}

}
