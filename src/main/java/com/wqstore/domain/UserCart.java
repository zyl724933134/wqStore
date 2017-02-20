package com.wqstore.domain;

import java.util.Date;

public class UserCart {
    private Integer id;

    private Integer userId;

    private String cartValues;

    private Date createTime;

    private Date updateDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getCartValues() {
        return cartValues;
    }

    public void setCartValues(String cartValues) {
        this.cartValues = cartValues == null ? null : cartValues.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }
}