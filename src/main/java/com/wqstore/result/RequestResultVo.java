package com.wqstore.result;

import java.io.Serializable;

public class RequestResultVo<T> implements Serializable{
	
	private static final long serialVersionUID = -3715658712929536313L;

	private boolean success = true;
	
	private String errorCode;
	
	private String errorMessage;
	
	private T result;

	public static <T> RequestResultVo<T> success(T result) {
		RequestResultVo<T> vo = new RequestResultVo<T>();
		vo.setResult(result);
		return vo;
	}
	
	public static RequestResultVo<Object> error(String errorCode) {
		RequestResultVo<Object> vo = new RequestResultVo<Object>();
		vo.setSuccess(false);
		vo.setErrorCode(errorCode);
		return vo;
	}
	
	public static RequestResultVo<Object> error(String errorCode, String errorMessage) {
		RequestResultVo<Object> vo = new RequestResultVo<Object>();
		vo.setSuccess(false);
		vo.setErrorCode(errorCode);
		vo.setErrorMessage(errorMessage);		
		return vo;
	}
	
	public static <T> RequestResultVo<T> error(String errorCode, String errorMessage, T result) {
		RequestResultVo<T> vo = new RequestResultVo<T>();
		vo.setSuccess(false);
		vo.setErrorCode(errorCode);
		vo.setErrorMessage(errorMessage);
		vo.setResult(result);
		return vo;
	}
	
	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public T getResult() {
		return result;
	}

	public void setResult(T result) {
		this.result = result;
	}
}
