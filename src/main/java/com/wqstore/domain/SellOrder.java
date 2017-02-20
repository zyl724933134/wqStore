package com.wqstore.domain;

import java.math.BigDecimal;
import java.util.Date;

public class SellOrder {
    private Long id;

    private Long endUserId;

    private String orderCode;

    private BigDecimal orderAmount;

    private BigDecimal orderDealAmount;

    private BigDecimal productAmount;

    private BigDecimal orderDeliveryFee;

    private String orderRemark;

    private String goodReceiverName;

    private String goodReceiverPhone;

    private String goodReceiverProvince;

    private String goodReceiverCity;

    private String goodReceiverCounty;

    private String goodReceiverAddress;

    private String goodReceiverPostCode;

    private Long goodReceiverCountryId;

    private Long goodReceiverProvinceId;

    private Long goodReceiverCityId;

    private Long goodReceiverCountyId;

    private Integer cancelReasonId;

    private Date cancelDate;

    private Long cancelOperatorId;

    private Date paymentConfirmDate;

    private Integer paymentState;

    private Integer paymentType;

    private String paymentCode;

    private Long paymentGatewayId;

    private Date createTime;

    private Integer orderState;

    private Integer orderNeedInvoice;

    private Integer invoiceState;

    private Date deliveryDate;

    private Date receiveDate;

    private Long deliveryType;

    private Long boughtTimes;

    private String deliveryRemark;

    private Date updateTime;

    private BigDecimal orderWeight;

    private Long merchantId;

    private Long versionNo;

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

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode == null ? null : orderCode.trim();
    }

    public BigDecimal getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(BigDecimal orderAmount) {
        this.orderAmount = orderAmount;
    }

    public BigDecimal getOrderDealAmount() {
        return orderDealAmount;
    }

    public void setOrderDealAmount(BigDecimal orderDealAmount) {
        this.orderDealAmount = orderDealAmount;
    }

    public BigDecimal getProductAmount() {
        return productAmount;
    }

    public void setProductAmount(BigDecimal productAmount) {
        this.productAmount = productAmount;
    }

    public BigDecimal getOrderDeliveryFee() {
        return orderDeliveryFee;
    }

    public void setOrderDeliveryFee(BigDecimal orderDeliveryFee) {
        this.orderDeliveryFee = orderDeliveryFee;
    }

    public String getOrderRemark() {
        return orderRemark;
    }

    public void setOrderRemark(String orderRemark) {
        this.orderRemark = orderRemark == null ? null : orderRemark.trim();
    }

    public String getGoodReceiverName() {
        return goodReceiverName;
    }

    public void setGoodReceiverName(String goodReceiverName) {
        this.goodReceiverName = goodReceiverName == null ? null : goodReceiverName.trim();
    }

    public String getGoodReceiverPhone() {
        return goodReceiverPhone;
    }

    public void setGoodReceiverPhone(String goodReceiverPhone) {
        this.goodReceiverPhone = goodReceiverPhone == null ? null : goodReceiverPhone.trim();
    }

    public String getGoodReceiverProvince() {
        return goodReceiverProvince;
    }

    public void setGoodReceiverProvince(String goodReceiverProvince) {
        this.goodReceiverProvince = goodReceiverProvince == null ? null : goodReceiverProvince.trim();
    }

    public String getGoodReceiverCity() {
        return goodReceiverCity;
    }

    public void setGoodReceiverCity(String goodReceiverCity) {
        this.goodReceiverCity = goodReceiverCity == null ? null : goodReceiverCity.trim();
    }

    public String getGoodReceiverCounty() {
        return goodReceiverCounty;
    }

    public void setGoodReceiverCounty(String goodReceiverCounty) {
        this.goodReceiverCounty = goodReceiverCounty == null ? null : goodReceiverCounty.trim();
    }

    public String getGoodReceiverAddress() {
        return goodReceiverAddress;
    }

    public void setGoodReceiverAddress(String goodReceiverAddress) {
        this.goodReceiverAddress = goodReceiverAddress == null ? null : goodReceiverAddress.trim();
    }

    public String getGoodReceiverPostCode() {
        return goodReceiverPostCode;
    }

    public void setGoodReceiverPostCode(String goodReceiverPostCode) {
        this.goodReceiverPostCode = goodReceiverPostCode == null ? null : goodReceiverPostCode.trim();
    }

    public Long getGoodReceiverCountryId() {
        return goodReceiverCountryId;
    }

    public void setGoodReceiverCountryId(Long goodReceiverCountryId) {
        this.goodReceiverCountryId = goodReceiverCountryId;
    }

    public Long getGoodReceiverProvinceId() {
        return goodReceiverProvinceId;
    }

    public void setGoodReceiverProvinceId(Long goodReceiverProvinceId) {
        this.goodReceiverProvinceId = goodReceiverProvinceId;
    }

    public Long getGoodReceiverCityId() {
        return goodReceiverCityId;
    }

    public void setGoodReceiverCityId(Long goodReceiverCityId) {
        this.goodReceiverCityId = goodReceiverCityId;
    }

    public Long getGoodReceiverCountyId() {
        return goodReceiverCountyId;
    }

    public void setGoodReceiverCountyId(Long goodReceiverCountyId) {
        this.goodReceiverCountyId = goodReceiverCountyId;
    }

    public Integer getCancelReasonId() {
        return cancelReasonId;
    }

    public void setCancelReasonId(Integer cancelReasonId) {
        this.cancelReasonId = cancelReasonId;
    }

    public Date getCancelDate() {
        return cancelDate;
    }

    public void setCancelDate(Date cancelDate) {
        this.cancelDate = cancelDate;
    }

    public Long getCancelOperatorId() {
        return cancelOperatorId;
    }

    public void setCancelOperatorId(Long cancelOperatorId) {
        this.cancelOperatorId = cancelOperatorId;
    }

    public Date getPaymentConfirmDate() {
        return paymentConfirmDate;
    }

    public void setPaymentConfirmDate(Date paymentConfirmDate) {
        this.paymentConfirmDate = paymentConfirmDate;
    }

    public Integer getPaymentState() {
        return paymentState;
    }

    public void setPaymentState(Integer paymentState) {
        this.paymentState = paymentState;
    }

    public Integer getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(Integer paymentType) {
        this.paymentType = paymentType;
    }

    public String getPaymentCode() {
        return paymentCode;
    }

    public void setPaymentCode(String paymentCode) {
        this.paymentCode = paymentCode == null ? null : paymentCode.trim();
    }

    public Long getPaymentGatewayId() {
        return paymentGatewayId;
    }

    public void setPaymentGatewayId(Long paymentGatewayId) {
        this.paymentGatewayId = paymentGatewayId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getOrderState() {
        return orderState;
    }

    public void setOrderState(Integer orderState) {
        this.orderState = orderState;
    }

    public Integer getOrderNeedInvoice() {
        return orderNeedInvoice;
    }

    public void setOrderNeedInvoice(Integer orderNeedInvoice) {
        this.orderNeedInvoice = orderNeedInvoice;
    }

    public Integer getInvoiceState() {
        return invoiceState;
    }

    public void setInvoiceState(Integer invoiceState) {
        this.invoiceState = invoiceState;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public Date getReceiveDate() {
        return receiveDate;
    }

    public void setReceiveDate(Date receiveDate) {
        this.receiveDate = receiveDate;
    }

    public Long getDeliveryType() {
        return deliveryType;
    }

    public void setDeliveryType(Long deliveryType) {
        this.deliveryType = deliveryType;
    }

    public Long getBoughtTimes() {
        return boughtTimes;
    }

    public void setBoughtTimes(Long boughtTimes) {
        this.boughtTimes = boughtTimes;
    }

    public String getDeliveryRemark() {
        return deliveryRemark;
    }

    public void setDeliveryRemark(String deliveryRemark) {
        this.deliveryRemark = deliveryRemark == null ? null : deliveryRemark.trim();
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public BigDecimal getOrderWeight() {
        return orderWeight;
    }

    public void setOrderWeight(BigDecimal orderWeight) {
        this.orderWeight = orderWeight;
    }

    public Long getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(Long merchantId) {
        this.merchantId = merchantId;
    }

    public Long getVersionNo() {
        return versionNo;
    }

    public void setVersionNo(Long versionNo) {
        this.versionNo = versionNo;
    }

    public Integer getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }
}