package com.kulu.comtroller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/*
 * 專案實施前後端分離方式
 * 最終方法的返回值都會放到請求體(RequestBody)中
 */

import com.kulu.domain.ResponseResult;
import com.kulu.domain.User;
import com.kulu.resolver.CurrentUserId;
import com.kulu.service.UserService;
import com.kulu.utils.JwtUtil;

import io.jsonwebtoken.Claims;
@RestController
@RequestMapping(path = "/user")
public class UserController {

	@Autowired //使用Annotation從容器獲取
	private UserService userService;
	/* 
	 * 對介面的響應模式進行統一
	 * 使用統一訊息回覆 ResponseResult
	 * 
	 * 使用web原生api(HttpServletRequest)獲取token並解析印出(這種方式要懂，但可以使用自訂定參數解析方式處理)
	 */
	@RequestMapping(path = "/findAll")
//	@CrossOrigin	//加在方法上，只允許加註方法跨域請求(此註解無細部設定，算是快速開啟跨域連線的小撇步)
	public ResponseResult fundAll(HttpServletRequest request) throws Exception{
		//<原生>獲取token
		String token = request.getHeader("token");
		System.out.println("token:  "+token);
		//<原生>token是否為空
		if(StringUtils.hasText(token)) {
			//<原生>解析token獲得所需要的值
			Claims claims = JwtUtil.parseJWT(token);
			System.out.println("Subject  "+claims.getSubject());
			System.out.println("getId    "+claims.getId());
			System.out.println("Issuer   "+claims.getIssuer());
			System.out.println("Audience "+claims.getAudience());
			System.out.println("Expiration "+claims.getExpiration());
			System.out.println("getClass "+claims.getClass());
			System.out.println("IssuedAt "+claims.getIssuedAt());
			System.out.println("Before   "+claims.getNotBefore());
		}
		//調用service查詢數據，進行返回
		List<User> users =  userService.findAll();
		return new ResponseResult<>(200, users);
	}
	
	/*
	 * 使用自定義參數解析(HandlerMethodArgumentResolver)物件生成的【注解】獲取token並解析印出
	 */
	@RequestMapping(path = "/findAll2")
//	@CrossOrigin	//加在方法上，只允許加註方法跨域請求(此註解無細部設定，算是快速開啟跨域連線的小撇步)
	public ResponseResult fundAll2(@CurrentUserId String userId) throws Exception{
//		//<原生>獲取token
//		String token = request.getHeader("token");
//		System.out.println("token:  "+token);
//		//<原生>token是否為空
//		if(StringUtils.hasText(token)) {
//			//<原生>解析token獲得所需要的值
//			Claims claims = JwtUtil.parseJWT(token);
//			System.out.println("Subject  "+claims.getSubject());
//			System.out.println("getId    "+claims.getId());
//			System.out.println("Issuer   "+claims.getIssuer());
//			System.out.println("Audience "+claims.getAudience());
//			System.out.println("Expiration "+claims.getExpiration());
//			System.out.println("getClass "+claims.getClass());
//			System.out.println("IssuedAt "+claims.getIssuedAt());
//			System.out.println("Before   "+claims.getNotBefore());
//		}
		System.out.println(userId);
		
		//調用service查詢數據，進行返回
		List<User> users =  userService.findAll();
		return new ResponseResult<>(200, users);
	}
	
	/*
	 * 
	 */
	@RequestMapping(path = "/insertUser")
	public ResponseResult insertUser() {
		userService.insertUser();
		return new ResponseResult<>(200, "新增成功");
	}
}
