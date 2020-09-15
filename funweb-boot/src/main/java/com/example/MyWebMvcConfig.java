package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.example.interceptor.MemberLoginCheckInterceptor;


@Configuration
public class MyWebMvcConfig implements WebMvcConfigurer {
	
	@Autowired
	private MemberLoginCheckInterceptor memberLoginCheckInterceptor;

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		
		InterceptorRegistration reg = registry.addInterceptor(memberLoginCheckInterceptor);
		reg.addPathPatterns("/board/file*")
		.excludePathPatterns("/board/fileList");
		
		//.excludePathPatterns("/css/**", "/fonts/**", "/images/**", "/script/**");
	}

	
}
