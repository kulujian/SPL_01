package com.kulu.comtroller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kulu.domain.ResponseResult;

@RestController
public class TestController {

	@RequestMapping("/test")
	public String test() {
		return "Web_test";
	}
	
	@RequestMapping("/getRequestAndResponse")
	public ResponseResult getRequestAndResponse (HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		System.out.println(request);
		return new ResponseResult(200, "成功");
	}
}
