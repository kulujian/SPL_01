package com.kulu.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.kulu.interceptor.LoginInterceptor;

/**
 *  
 *  WebMvcConfigurer 介面
 *  可實現與SpringMVC相關配置設定
 *  
 *  @Configuration 注入Spring後，為全域設定
 *  
 * @author user
 *
 */
@Configuration
public class LoginConfig implements WebMvcConfigurer {
	

	// TODO headleInterceptor相關設定
	@Autowired
	private LoginInterceptor loginInterceptor;
	/**
	 * 	headle(標題、頭)Interceptor(攔截器)
	 */
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(loginInterceptor)			// 獲取對應的攔截器的物件(添加攔截器)
				.addPathPatterns("/**")						// 配置攔截器要攔截的路徑
				.excludePathPatterns("/sys_user/login");	// 配置攔截器要排除的路徑
	}
	

}
