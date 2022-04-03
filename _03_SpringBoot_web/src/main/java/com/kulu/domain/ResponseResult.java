package com.kulu.domain;

import com.fasterxml.jackson.annotation.JsonInclude;

/*
 *  對資料進行統一封裝回覆
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseResult<T> {
	/**
	 *  狀態碼
	 */
	private Integer code;
	/**
	 *  提示訊息，如果有錯誤時，前端可以獲取該字段進行提示
	 */
	private String msg;
	/**
	 *  查詢到的結果數據
	 */
	private T data;
	
	public ResponseResult(Integer code, String msg) {
//		super();
		this.code = code;
		this.msg = msg;
	}

	public ResponseResult(Integer code, T data) {
//		super();
		this.code = code;
		this.data = data;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public ResponseResult(Integer code, String msg, T data) {
//		super();
		this.code = code;
		this.msg = msg;
		this.data = data;
	}
	
	
}
