package com.kulu.resolver;

import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import com.kulu.utils.JwtUtil;

import io.jsonwebtoken.Claims;
/*
 * 	★自定義參數解析：
 * 
 *  程序處理 方法   參數     解析器
 *  Handler  Method Argument Resolver
 *  實現 HandlerMethodArgumentResolver
 *  重寫 supportsParameter
 *  重寫 resolveArgument
 */
@Component // 注入Spring容器
public class UserIdArgumentResolver implements HandlerMethodArgumentResolver{

	/*
	 * 	對內參數進行支持
	 */
	/*
	 * 	判斷方法參數能使用當前的參數解析器進行解析
	 */
	@Override
	public boolean supportsParameter(MethodParameter parameter) {
		// 如果方法參數有加上CurrentUserId註解，就能被我們解析器解析
		return parameter.hasParameterAnnotation(CurrentUserId.class);
	}
	/*
	 * 	進行參數解析的方法，可以在方法中獲取對應的數據，然後把數據作為返回值返回。
	 * 	方法的返回值就會賦值給應的方法參數。
	 */
	@Override
	public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer,
			NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
		// 獲取請求頭中的token
		String token = webRequest.getHeader("token");
		// 確認token是否為空
		if (StringUtils.hasText(token)) {
			// 解析token獲得所需要的值
			Claims claims = JwtUtil.parseJWT(token);
			// 這邊返回 sub ，還有getId、getIssuer
			String userId = claims.getSubject();
			// 返回結果
			return userId;
		}
		return null;
	}

}
