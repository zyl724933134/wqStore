package com.wqstore.result;


public abstract interface BaseResultCode {

	public abstract String getCode();

	public abstract String getMsg();

	public abstract String getDetail();

	public abstract String getDetail(String[] paramArrayOfString);

	public abstract String getName();
}
