package com.kulu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.kulu.service.UserService;

@SpringBootApplication
public class WebApplicaton {
	public static void main(String[] args) {
		// 這邊的返回值，就包含Spring容器物件
		ConfigurableApplicationContext context =  SpringApplication.run(WebApplicaton.class, args);
		/* 1. 透過調過容器getBean(傳入Bean類)方法，獲得自解碼物件
		 * 2. 自解碼物件再使用getClass()方法，獲得自解碼文件物件
		 * 3. 自解碼文件物件再使用getName()方法，獲得自解碼文件名稱(這邊會獲得一個全類名)
		 */
		System.out.println(context.getBean(UserService.class).getClass().getName());
		/*
		 *  com.kulu.service.impl.UserServiceImpl$$EnhancerBySpringCGLIB$$fe637dff
		 *  其中 代表使用 cglib 動態代理						   ↑↑↑↑↑
		 *  
		 *  com.sun.proxy.$Proxy66
		 *  這代表 jdk 動態代理
		 */
	}

}
