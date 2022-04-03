package com.kulu.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.kulu.resolver.UserIdArgumentResolver;
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
public class ArgumentResolverConfig implements WebMvcConfigurer{

	/*
	 * 	自定義實現類物件注入
	 */
	@Autowired
	private UserIdArgumentResolver userIdArgumentResolver;
	/*
	 * 	增加自定義實現類物件
	 */
	@Override
	public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
		// 透過add方法加入實現類物件，上面為List集合，可新增多筆。
		resolvers.add(userIdArgumentResolver);
	}

	
}
