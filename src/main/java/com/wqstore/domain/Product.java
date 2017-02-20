package com.wqstore.domain;

import java.util.Date;

public class Product {
    private Integer id;

    private String productName;

    private Double productPrice;

    private Integer categoryId;

    private Date createTime;

    private Date updateDate;

    private Integer createUserId;

    private Integer updateUserId;

    private Integer stockamount;

    private String productEname;

    private Integer productCanBeChange;

    private Integer productChangeDay;

    private Integer productNeedInstallation;

    private String ean13;

    private Integer length;

    private Integer width;

    private Integer height;

    private Integer weight;

    private Integer isDeleted;

    private Integer volume;

    private Integer canReturnAndChange;

    private Integer isVta;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName == null ? null : productName.trim();
    }

    public Double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Double productPrice) {
        this.productPrice = productPrice;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
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

    public Integer getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(Integer createUserId) {
        this.createUserId = createUserId;
    }

    public Integer getUpdateUserId() {
        return updateUserId;
    }

    public void setUpdateUserId(Integer updateUserId) {
        this.updateUserId = updateUserId;
    }

    public Integer getStockamount() {
        return stockamount;
    }

    public void setStockamount(Integer stockamount) {
        this.stockamount = stockamount;
    }

    public String getProductEname() {
        return productEname;
    }

    public void setProductEname(String productEname) {
        this.productEname = productEname == null ? null : productEname.trim();
    }

    public Integer getProductCanBeChange() {
        return productCanBeChange;
    }

    public void setProductCanBeChange(Integer productCanBeChange) {
        this.productCanBeChange = productCanBeChange;
    }

    public Integer getProductChangeDay() {
        return productChangeDay;
    }

    public void setProductChangeDay(Integer productChangeDay) {
        this.productChangeDay = productChangeDay;
    }

    public Integer getProductNeedInstallation() {
        return productNeedInstallation;
    }

    public void setProductNeedInstallation(Integer productNeedInstallation) {
        this.productNeedInstallation = productNeedInstallation;
    }

    public String getEan13() {
        return ean13;
    }

    public void setEan13(String ean13) {
        this.ean13 = ean13 == null ? null : ean13.trim();
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Integer getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }

    public Integer getVolume() {
        return volume;
    }

    public void setVolume(Integer volume) {
        this.volume = volume;
    }

    public Integer getCanReturnAndChange() {
        return canReturnAndChange;
    }

    public void setCanReturnAndChange(Integer canReturnAndChange) {
        this.canReturnAndChange = canReturnAndChange;
    }

    public Integer getIsVta() {
        return isVta;
    }

    public void setIsVta(Integer isVta) {
        this.isVta = isVta;
    }
}