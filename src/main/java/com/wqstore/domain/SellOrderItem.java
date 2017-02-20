package com.wqstore.domain;

import java.math.BigDecimal;
import java.util.Date;

public class SellOrderItem {
    private Long id;

    private Long endUserId;

    private Long soId;

    private Long productId;

    private Long merchantId;

    private BigDecimal itemAmount;

    private BigDecimal itemDealAmount;

    private BigDecimal marketPrice;

    private BigDecimal itemSalePrice;

    private Long itemNum;

    private String productCname;

    private String productEname;

    private String productPicUrl;

    private Date createTime;

    private Date updateTime;

    private Integer isDeleted;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getEndUserId() {
        return endUserId;
    }

    public void setEndUserId(Long endUserId) {
        this.endUserId = endUserId;
    }

    public Long getSoId() {
        return soId;
    }

    public void setSoId(Long soId) {
        this.soId = soId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(Long merchantId) {
        this.merchantId = merchantId;
    }

    public BigDecimal getItemAmount() {
        return itemAmount;
    }

    public void setItemAmount(BigDecimal itemAmount) {
        this.itemAmount = itemAmount;
    }

    public BigDecimal getItemDealAmount() {
        return itemDealAmount;
    }

    public void setItemDealAmount(BigDecimal itemDealAmount) {
        this.itemDealAmount = itemDealAmount;
    }

    public BigDecimal getMarketPrice() {
        return marketPrice;
    }

    public void setMarketPrice(BigDecimal marketPrice) {
        this.marketPrice = marketPrice;
    }

    public BigDecimal getItemSalePrice() {
        return itemSalePrice;
    }

    public void setItemSalePrice(BigDecimal itemSalePrice) {
        this.itemSalePrice = itemSalePrice;
    }

    public Long getItemNum() {
        return itemNum;
    }

    public void setItemNum(Long itemNum) {
        this.itemNum = itemNum;
    }

    public String getProductCname() {
        return productCname;
    }

    public void setProductCname(String productCname) {
        this.productCname = productCname == null ? null : productCname.trim();
    }

    public String getProductEname() {
        return productEname;
    }

    public void setProductEname(String productEname) {
        this.productEname = productEname == null ? null : productEname.trim();
    }

    public String getProductPicUrl() {
        return productPicUrl;
    }

    public void setProductPicUrl(String productPicUrl) {
        this.productPicUrl = productPicUrl == null ? null : productPicUrl.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }
}