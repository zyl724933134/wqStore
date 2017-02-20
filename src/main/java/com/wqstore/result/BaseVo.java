package com.wqstore.result;


public class BaseVo{
	
	/**
     * 分页参数
     */
    protected Integer startPage;
    
    protected Integer pageSize;
    
	public Integer getStartPage() {
		return startPage;
	}

	public void setStartPage(Integer startPage) {
		this.startPage = startPage;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

}
