package in.srini91.learn.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import in.srini91.learn.interceptor.HeaderInterceptor;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

	@Autowired
	private HeaderInterceptor headInters;

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(headInters);
		WebMvcConfigurer.super.addInterceptors(registry);
	}
}
