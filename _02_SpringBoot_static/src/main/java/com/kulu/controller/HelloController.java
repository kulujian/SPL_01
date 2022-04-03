package com.kulu.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//@Controller
//@ResponseBody // 使所有響應值回覆至body
@RestController
@RequestMapping("/test")
public class HelloController {
	
	@RequestMapping(path = "/hello")
	public String hello() {
		return "hello";
	}
	
	@RequestMapping("/testPath")
	public String testPath() {
		return "testPath";
	}
	
	// 以下的註解等價於: @PostMapping(path = "/testMethod")
	@RequestMapping(value = "/testMethod", method = RequestMethod.POST )
	public String testMethod() {
		System.out.println("testMethod處理了請求");
		return "testMethod";
	}
	// 期望請求參數中必須具有code參數才能執行下面方法，並能夠被下面方法處理(params = "code")
	// 期望請求參數中必須不具有code參數才能執行下面方法(params = "!code")
	// 期望請求參數中必須具有code參數【並且是某一個值】才能執行下面方法(params = "code=abcd")
	// 期望請求參數中必須具有code參數【並且不是某一個值】才能執行下面方法(params = "!code=abcd")
	@RequestMapping(value = "/testParams", method = RequestMethod.GET, params = "code")
	public String testParams() {
		System.out.println("testParams處理了請求");
		return "testParams";
	}
	// 期望請求headers中必須具有Host才能執行下面方法，並能夠被下面方法處理(headers = "Host")
	// 期望請求headers中必須不具有Host才能執行下面方法(headers = "!Host")
	// 期望請求headers中必須具有Host【並且是某一個值】才能執行下面方法(headers = "Host=localhost:8080")
	// 期望請求headers中必須具有Host【並且不是某一個值】才能執行下面方法(headers = "!Host=localhost:8080")
	@RequestMapping(value = "/testHeaders", method = RequestMethod.GET, headers = "Host=localhost:8080")
	public String testHeaders() {
		System.out.println("testHeaders處理了請求");
		return "testHeaders";
	}
	// 期望請求headers中的Content-Type必須是【multipart/from-data】才能執行下面方法(consumes = "multipart/from-data")
	// 期望請求headers中的Content-Type不能是【multipart/from-data】才能執行下面方法(consumes = "!multipart/from-data")
	@RequestMapping(value = "/testConsumes", method = RequestMethod.GET, consumes = "!multipart/from-data")
	public String testConsumes() {
		System.out.println("testConsumes處理了請求");
		return "testConsumes";
	}
}
