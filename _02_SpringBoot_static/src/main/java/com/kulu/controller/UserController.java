package com.kulu.controller;


import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kulu.domain.User;
/*
 * RequestBody 
 */
@RestController
public class UserController {

	// URL傳送參數(單一), 並獲取參數值
	@RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
	public String findUserById(@PathVariable("id") Integer id) {
		System.out.println("findUserById");
		System.out.println(id);
		return "findUserById";
	}
	// URL傳送參數(多筆), 並獲取參數值
	@RequestMapping(value = "/user/{id}/{name}", method = RequestMethod.GET)
	public String findUser(@PathVariable("id") Integer id, @PathVariable("name") String name) {
		System.out.println("findUser");
		System.out.println(id);
		System.out.println(name);
		return "findUser";
	}
	//獲取請求體(RequestBody)中的Json格式參數(單筆)
	//SpringBoot的Web啟動器已經默認導入Jackson Databian，因此不用額外添加依賴
	//一、獲取參數封裝成實體物件
	@RequestMapping(value = "/user/o", method = RequestMethod.POST)
	public String getUserObject(@RequestBody User user) {
		System.out.println(user);
		return "getUserObject";
	}
	//二、獲取參數封裝成Map物件
	@RequestMapping(value = "/user/m", method = RequestMethod.POST)
	public String getUserMap(@RequestBody Map map) {
		System.out.println(map);
		return "getUserMap";
	}
	//獲取請求體(RequestBody)中的Json格式參數(多筆)
	//一、獲取參數封裝成實體物件
	@RequestMapping(value = "/users/o", method = RequestMethod.POST)
	public String getUsersObject(@RequestBody List<User> users) {
		System.out.println(users);
		return "getUsersObject";
	}
	//如果參數是使用 QueryString 的格式 http://localhost:8080/xxxx/aaa?name=xxx&age=xxx
	//在方法中定義方法參數，方法參數與請求參數名稱一致，這種情況下可以省略"@RequestParam"註解
	@RequestMapping(value = "/testRequestParam/true")
	public String testRequestParam01(Integer id, String name, String[] likes) {
		System.out.println(id);
		System.out.println(name);
		System.out.println(Arrays.toString(likes));
		return "testRequestParam01";
	}
	//方法參數與請求參數名稱不一致，這樣就必須加上註解
	@RequestMapping(value = "/testRequestParam/false")
	public String testRequestParam02(@RequestParam("id")Integer uid,
									 @RequestParam("name")String uName,
									 String[] likes) {
		System.out.println(uid);
		System.out.println(uName);
		System.out.println(Arrays.toString(likes));
		return "testRequestParam02";
	}
	//將 QueryString 的格式，封裝成Bean物件
	@RequestMapping(value = "/testRequestParam/toBean")
	public String testRequestParam03(User user) {
		System.out.println(user);
		return "testRequestParam03";
	}
	
	//相關註解其他的屬性
	//1、required (代表是否必須，默認值為true，就是必須有要對應的參數。沒有會報錯。
	//2、defaultValue (若無取得參數值，會給默認值)
	@RequestMapping(value = "/testRequestParam/Required")
	public String testRequestParam04(@RequestParam(value = "id", required = true)Integer uid,
									 @RequestParam(value = "name", required = false, defaultValue = "kulu.jian")String uName,
									 String[] likes) {
		System.out.println(uid);
		System.out.println(uName);
		System.out.println(Arrays.toString(likes));
		return "testRequestParam04";
	}
	
}
