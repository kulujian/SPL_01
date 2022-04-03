package com.kulu.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


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
public class CorsConfig implements WebMvcConfigurer{

	// TODO 跨域訪問相關設定
	/*
	 *  	CORS是一個W3C標準，全稱是【跨域資源共享】(Cross-origin resource sharing)，
	 *  允許瀏覽器向跨源服務器發出XMLHttpRequest請求，從而克服了AJAX只能同源使用的限制。
	 *  	它通過服務器增加一個特殊的Header[Access-control-allow-Origin]來告訴客戶端
	 *  跨域的限制，如果瀏覽器支持CORS、並且判斷Origin通過的話，就會允許XMLHttpRequest
	 *  發起跨域請求。
	 *  
	 *  當收到跨域請求時會經過Spring的CorsInterceptor攔截器
	 *  攔截器會讀取WebMvcConfigurer的addCorsMappings方法配置信息
	 */
	@Override
	public void addCorsMappings(CorsRegistry registry) {
				// 設置允許跨域請求的路徑
		registry.addMapping("/**")
				// 設定允許跨域請求的域名
				.allowedOriginPatterns("*")
				// 是否允許 cookie
				.allowCredentials(true)
				// 設置允許的請求方式
				.allowedMethods("GET","POST","DELETE","PUT")
				// 設定允許的 header 屬性
				.allowedHeaders("*")
				// 跨域允許時間
				.maxAge(3600);
	}
}
