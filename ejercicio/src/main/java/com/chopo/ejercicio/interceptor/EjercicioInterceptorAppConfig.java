package com.chopo.ejercicio.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class EjercicioInterceptorAppConfig implements WebMvcConfigurer {

	@Autowired
	private EjercicioInterceptor interceptor;

	public EjercicioInterceptorAppConfig() {
		super();
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(interceptor);
	}

}
