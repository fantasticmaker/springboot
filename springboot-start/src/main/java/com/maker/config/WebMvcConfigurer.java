package com.maker.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import com.maker.controller.interceptor.OneInterceptor;
import com.maker.controller.interceptor.TwoInterceptor;
/**
 *
 * 拦截器
 * 使用@Configuration注解表明该类为拦截器
 * 继承WebMvcConfigurationSupport
 * 重写addInterceptors方法添加需要的拦截器地址
 *
 */
@Configuration//适配器
public class WebMvcConfigurer extends WebMvcConfigurationSupport{//
	
	@Override
	protected void addInterceptors(InterceptorRegistry registry) {
		/**
		 * 
		 * 拦截器按顺序执行
		 * 拦截器的创建
		 * 添加路径，进行拦截权限的控制
		 */
		
		registry.addInterceptor(new OneInterceptor()).addPathPatterns("/one/**");//如果访问带有one的访问地址，将会被拦截
		//registry.addInterceptor(new OneInterceptor()).addPathPatterns("/*/**");//拦截所有用户请求
		registry.addInterceptor(new TwoInterceptor()).addPathPatterns("/two/**").addPathPatterns("/one/**");
		
		super.addInterceptors(registry);
	}

}
