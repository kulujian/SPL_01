package com.kulu.controller;

import java.util.Arrays;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kulu.domain.User;

/*
 * ResponseBody
 */
@Controller
@RequestMapping("/response")
public class ResponseController {

	//SpringMVC提供了@ResponseBody非常方便的就可將Json格式數值放到響應體(RequestBody)中(可加到方法上也可加到類上)
	//SpringMVC可以幫我們進行Json的轉換，但需進行相應配置(不使用SpringBoot整合情況下，需引入依賴jackson、開啟mvc註解驅動)
	//不過SpringBoot的Web啟動器已經默認導入Jackson Databian，因此不用額外添加依賴
	@RequestMapping(value = "/user/{id}")
	@ResponseBody
	public User findById(@PathVariable("id")Integer id) {
		User user = new User(id,"kulu",15,null);
		return user;
	}
	@RequestMapping(value = "/user/name")
	@ResponseBody
	public User findByName(String name) {
		User user = new User(10,name,38,null);
		return user;
	}
}
