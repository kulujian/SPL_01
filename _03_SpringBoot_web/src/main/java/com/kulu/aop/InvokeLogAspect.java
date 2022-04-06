package com.kulu.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

/*
 * 	切面類建構
 * 	1.必需加上註解 @Aspect，此功能為_宣告目前所在的類為切面類
 *  2.必需加上註解 @Component，此功能為_將目前所在的類納入SpringBoot管理
 */
@Aspect
@Component
public class InvokeLogAspect {
	/*
	 * 	定義一個方法來承載 @Pointcut()，此功能為_宣告方法為【切入方法】
	 * 	1. @Pointcut(value = "@annotation(自定義注解的全類名)"))
	 * 		通過【注解標示】決定哪些方法需要被切入或增強
	 *  2. @Pointcut(value = "execution(* com.kulu.service.SystemUserServiceImpl.findAll(..))")
	 *  	通過【決對路徑】單獨指向特定方法
	 */
	@Pointcut(value = "@annotation(com.kulu.aop.InvokeLog)")
	public void pt() {}
	
	/*
	 * 	定義一個通知方法
	 * 	1. 使用功能最強的環繞通知【@Around()】
	 *  2. 確認【通知方法】作用於哪些【切入方法】
	 *  	ex. @Around(value = "pt() || pt1()")
	 *  3. 必須加傳入參數【ProceedingJoinPoint joinPoint】
	 *  	此參數代表【正在運行中的且應該被增強的方法】
	 */
	@Around("pt()")
	public Object printInvokeLog(ProceedingJoinPoint joinPoint) {
		// 目標方法調用前
		Object proceed = null;
		/*
		 * Signature此介面通常用於跟踪或記錄應用程序以獲取有關連接點的反射信息
		 * 通過使用子介面MethodSignature來使用getMethod方法，進而獲得切入點的方法名 
		 */
		MethodSignature signature =  (MethodSignature)joinPoint.getSignature(); // 獲取簽名
		String methodName = signature.getMethod().getName();
		System.out.println(methodName + "  即將被調用。");
		try {
			/** 調用被增強方法(即目標方法)
			 * @proced 此為被增強方法執行過後的返回值，並作為返回值進行返回
			 */
			proceed = joinPoint.proceed();
			// 目標方法調用後
			System.out.println(methodName + "  調用完畢");
		} catch (Throwable e) {
			e.printStackTrace();
			// 目標方法出現異常
			System.out.println(methodName + "  出現了異常");
		}
		return proceed;
	}
}
