package com.kulu.aop;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/*
 * 	Annotation 自訂義註解的建構
 * 
 *  1.檔案宣告方式為  @interface
 *  2.必需加上原註解  @Target({ElementType.XXXXXX, ...})，此功能為_宣告定義好的註解在哪種型態下發生作用(作用範圍)
 *  	ex1. PARAMETER：方法的傳入參數
 *  	ex2. METHOD：方法上
 *  	ex3. TYPE：類別上
 *  	etc .. 自己看 DOC
 *  3.必需加上原註解  @Retention(RetentionPolicy)，此功能為_宣告定義好的註解保留範圍
 *  	ex1. SOURCE	：編譯後不保留
 *  	ex2. CLASS	：編譯後記錄在類文件內(預設)
 *  	ex3. RUNTIME：編譯後記錄在類文件內，並在運行時由VM保留(可即時讀取使用)
 */

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface InvokeLog {

}
