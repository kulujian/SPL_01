package com.kulu.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kulu.domain.ResponseResult;
// TODO 異常的統一處理方案
/*
 *	總結： 
 *  1. 定義一個 class 並加上【@ControllerAdvice】
 *  2. 按照專案需要定義方法 (返回物件(RespnseResult)依需求設計)
 *  3. 再來在方法上一定要加上 【@ExceptionHandler(RuntimeException)】 @宣告此方法就是要處理異常(我想要處理哪些異常)
 *  4. 若要將返回值放在響應體中就要加上【@ResponseBody】
 *
 */
@ControllerAdvice
public class MyControllerAdvice {

	@ExceptionHandler(RuntimeException.class)
	@ResponseBody
	public ResponseResult handlerException(Exception e) {
		// 獲取異常訊息，存放入 ResponseResult 的 msg 屬性
		String message = e.getMessage();
		ResponseResult result =  new ResponseResult(300, message);
		// 把 ResponseResult 做為返回值返回，要求到時候轉換成json存入響應體中
		return result;
		
	}
}
