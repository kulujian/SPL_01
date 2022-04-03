package com.kulu.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import com.kulu.utils.JwtUtil;

import io.jsonwebtoken.Claims;

/**
 * 
 *  HandlerInterceptor 介面

 *  
 *  @Configuration 注入Spring後，為全域設定
 *  
 * @author user
 *
 */
// 注入容器
@Component
public class LoginInterceptor implements HandlerInterceptor{

	// 在handler方法執行之前會被調用攔截
	@Override
	public boolean preHandle(HttpServletRequest request, 
						HttpServletResponse response, 
						Object handler) throws Exception {
		// 獲取請求頭中的token
		String token = request.getHeader("token");
		// 判斷token是否為空，如果為空也代表未登錄，提醒重新登錄(401)
		if (!StringUtils.hasText(token)) {
//			response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
			throw new RuntimeException("未登錄，請登錄後重試");
//			return false;
		}
		// 解析token看看是否成功
		try {
			//如果解析過程中沒有出現異常說明token是合法的(登錄狀態)
			Claims claims = JwtUtil.parseJWT(token);
			System.out.println(claims.getSubject());
		} catch (Exception e) {
			e.printStackTrace();  // 雖然自訂了返回信息，但是保留系統異常信息，方便未來debug
			// 如果出現了異常，說明未登錄，提醒重新登入(401)
			throw new RuntimeException("未登錄，請登錄後重試");
//			response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
//			return false;
		}
		
		
		// 返回值代表是否放行，如果為true則放行，如果為false則攔截，目標方法執行不到
		return true;
	}

//	@Override
//	public void postHandle(HttpServletRequest request, 
//						HttpServletResponse response, 
//						Object handler, 
//						ModelAndView modelAndView) throws Exception {
//		System.out.println("postHandle");
//	}
//
//	@Override
//	public void afterCompletion(HttpServletRequest request, 
//						HttpServletResponse response, 
//						Object handler, Exception ex) throws Exception {
//		System.out.println("afterCompletion");
//	}
	
	
	
}
