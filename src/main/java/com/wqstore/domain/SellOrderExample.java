package com.wqstore.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.wqstore.result.BaseVo;

public class SellOrderExample extends BaseVo{
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SellOrderExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andEndUserIdIsNull() {
            addCriterion("end_user_id is null");
            return (Criteria) this;
        }

        public Criteria andEndUserIdIsNotNull() {
            addCriterion("end_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andEndUserIdEqualTo(Long value) {
            addCriterion("end_user_id =", value, "endUserId");
            return (Criteria) this;
        }

        public Criteria andEndUserIdNotEqualTo(Long value) {
            addCriterion("end_user_id <>", value, "endUserId");
            return (Criteria) this;
        }

        public Criteria andEndUserIdGreaterThan(Long value) {
            addCriterion("end_user_id >", value, "endUserId");
            return (Criteria) this;
        }

        public Criteria andEndUserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("end_user_id >=", value, "endUserId");
            return (Criteria) this;
        }

        public Criteria andEndUserIdLessThan(Long value) {
            addCriterion("end_user_id <", value, "endUserId");
            return (Criteria) this;
        }

        public Criteria andEndUserIdLessThanOrEqualTo(Long value) {
            addCriterion("end_user_id <=", value, "endUserId");
            return (Criteria) this;
        }

        public Criteria andEndUserIdIn(List<Long> values) {
            addCriterion("end_user_id in", values, "endUserId");
            return (Criteria) this;
        }

        public Criteria andEndUserIdNotIn(List<Long> values) {
            addCriterion("end_user_id not in", values, "endUserId");
            return (Criteria) this;
        }

        public Criteria andEndUserIdBetween(Long value1, Long value2) {
            addCriterion("end_user_id between", value1, value2, "endUserId");
            return (Criteria) this;
        }

        public Criteria andEndUserIdNotBetween(Long value1, Long value2) {
            addCriterion("end_user_id not between", value1, value2, "endUserId");
            return (Criteria) this;
        }

        public Criteria andOrderCodeIsNull() {
            addCriterion("order_code is null");
            return (Criteria) this;
        }

        public Criteria andOrderCodeIsNotNull() {
            addCriterion("order_code is not null");
            return (Criteria) this;
        }

        public Criteria andOrderCodeEqualTo(String value) {
            addCriterion("order_code =", value, "orderCode");
            return (Criteria) this;
        }

        public Criteria andOrderCodeNotEqualTo(String value) {
            addCriterion("order_code <>", value, "orderCode");
            return (Criteria) this;
        }

        public Criteria andOrderCodeGreaterThan(String value) {
            addCriterion("order_code >", value, "orderCode");
            return (Criteria) this;
        }

        public Criteria andOrderCodeGreaterThanOrEqualTo(String value) {
            addCriterion("order_code >=", value, "orderCode");
            return (Criteria) this;
        }

        public Criteria andOrderCodeLessThan(String value) {
            addCriterion("order_code <", value, "orderCode");
            return (Criteria) this;
        }

        public Criteria andOrderCodeLessThanOrEqualTo(String value) {
            addCriterion("order_code <=", value, "orderCode");
            return (Criteria) this;
        }

        public Criteria andOrderCodeLike(String value) {
            addCriterion("order_code like", value, "orderCode");
            return (Criteria) this;
        }

        public Criteria andOrderCodeNotLike(String value) {
            addCriterion("order_code not like", value, "orderCode");
            return (Criteria) this;
        }

        public Criteria andOrderCodeIn(List<String> values) {
            addCriterion("order_code in", values, "orderCode");
            return (Criteria) this;
        }

        public Criteria andOrderCodeNotIn(List<String> values) {
            addCriterion("order_code not in", values, "orderCode");
            return (Criteria) this;
        }

        public Criteria andOrderCodeBetween(String value1, String value2) {
            addCriterion("order_code between", value1, value2, "orderCode");
            return (Criteria) this;
        }

        public Criteria andOrderCodeNotBetween(String value1, String value2) {
            addCriterion("order_code not between", value1, value2, "orderCode");
            return (Criteria) this;
        }

        public Criteria andOrderAmountIsNull() {
            addCriterion("order_amount is null");
            return (Criteria) this;
        }

        public Criteria andOrderAmountIsNotNull() {
            addCriterion("order_amount is not null");
            return (Criteria) this;
        }

        public Criteria andOrderAmountEqualTo(BigDecimal value) {
            addCriterion("order_amount =", value, "orderAmount");
            return (Criteria) this;
        }

        public Criteria andOrderAmountNotEqualTo(BigDecimal value) {
            addCriterion("order_amount <>", value, "orderAmount");
            return (Criteria) this;
        }

        public Criteria andOrderAmountGreaterThan(BigDecimal value) {
            addCriterion("order_amount >", value, "orderAmount");
            return (Criteria) this;
        }

        public Criteria andOrderAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("order_amount >=", value, "orderAmount");
            return (Criteria) this;
        }

        public Criteria andOrderAmountLessThan(BigDecimal value) {
            addCriterion("order_amount <", value, "orderAmount");
            return (Criteria) this;
        }

        public Criteria andOrderAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("order_amount <=", value, "orderAmount");
            return (Criteria) this;
        }

        public Criteria andOrderAmountIn(List<BigDecimal> values) {
            addCriterion("order_amount in", values, "orderAmount");
            return (Criteria) this;
        }

        public Criteria andOrderAmountNotIn(List<BigDecimal> values) {
            addCriterion("order_amount not in", values, "orderAmount");
            return (Criteria) this;
        }

        public Criteria andOrderAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("order_amount between", value1, value2, "orderAmount");
            return (Criteria) this;
        }

        public Criteria andOrderAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("order_amount not between", value1, value2, "orderAmount");
            return (Criteria) this;
        }

        public Criteria andOrderDealAmountIsNull() {
            addCriterion("order_deal_amount is null");
            return (Criteria) this;
        }

        public Criteria andOrderDealAmountIsNotNull() {
            addCriterion("order_deal_amount is not null");
            return (Criteria) this;
        }

        public Criteria andOrderDealAmountEqualTo(BigDecimal value) {
            addCriterion("order_deal_amount =", value, "orderDealAmount");
            return (Criteria) this;
        }

        public Criteria andOrderDealAmountNotEqualTo(BigDecimal value) {
            addCriterion("order_deal_amount <>", value, "orderDealAmount");
            return (Criteria) this;
        }

        public Criteria andOrderDealAmountGreaterThan(BigDecimal value) {
            addCriterion("order_deal_amount >", value, "orderDealAmount");
            return (Criteria) this;
        }

        public Criteria andOrderDealAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("order_deal_amount >=", value, "orderDealAmount");
            return (Criteria) this;
        }

        public Criteria andOrderDealAmountLessThan(BigDecimal value) {
            addCriterion("order_deal_amount <", value, "orderDealAmount");
            return (Criteria) this;
        }

        public Criteria andOrderDealAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("order_deal_amount <=", value, "orderDealAmount");
            return (Criteria) this;
        }

        public Criteria andOrderDealAmountIn(List<BigDecimal> values) {
            addCriterion("order_deal_amount in", values, "orderDealAmount");
            return (Criteria) this;
        }

        public Criteria andOrderDealAmountNotIn(List<BigDecimal> values) {
            addCriterion("order_deal_amount not in", values, "orderDealAmount");
            return (Criteria) this;
        }

        public Criteria andOrderDealAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("order_deal_amount between", value1, value2, "orderDealAmount");
            return (Criteria) this;
        }

        public Criteria andOrderDealAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("order_deal_amount not between", value1, value2, "orderDealAmount");
            return (Criteria) this;
        }

        public Criteria andProductAmountIsNull() {
            addCriterion("product_amount is null");
            return (Criteria) this;
        }

        public Criteria andProductAmountIsNotNull() {
            addCriterion("product_amount is not null");
            return (Criteria) this;
        }

        public Criteria andProductAmountEqualTo(BigDecimal value) {
            addCriterion("product_amount =", value, "productAmount");
            return (Criteria) this;
        }

        public Criteria andProductAmountNotEqualTo(BigDecimal value) {
            addCriterion("product_amount <>", value, "productAmount");
            return (Criteria) this;
        }

        public Criteria andProductAmountGreaterThan(BigDecimal value) {
            addCriterion("product_amount >", value, "productAmount");
            return (Criteria) this;
        }

        public Criteria andProductAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("product_amount >=", value, "productAmount");
            return (Criteria) this;
        }

        public Criteria andProductAmountLessThan(BigDecimal value) {
            addCriterion("product_amount <", value, "productAmount");
            return (Criteria) this;
        }

        public Criteria andProductAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("product_amount <=", value, "productAmount");
            return (Criteria) this;
        }

        public Criteria andProductAmountIn(List<BigDecimal> values) {
            addCriterion("product_amount in", values, "productAmount");
            return (Criteria) this;
        }

        public Criteria andProductAmountNotIn(List<BigDecimal> values) {
            addCriterion("product_amount not in", values, "productAmount");
            return (Criteria) this;
        }

        public Criteria andProductAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("product_amount between", value1, value2, "productAmount");
            return (Criteria) this;
        }

        public Criteria andProductAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("product_amount not between", value1, value2, "productAmount");
            return (Criteria) this;
        }

        public Criteria andOrderDeliveryFeeIsNull() {
            addCriterion("order_delivery_fee is null");
            return (Criteria) this;
        }

        public Criteria andOrderDeliveryFeeIsNotNull() {
            addCriterion("order_delivery_fee is not null");
            return (Criteria) this;
        }

        public Criteria andOrderDeliveryFeeEqualTo(BigDecimal value) {
            addCriterion("order_delivery_fee =", value, "orderDeliveryFee");
            return (Criteria) this;
        }

        public Criteria andOrderDeliveryFeeNotEqualTo(BigDecimal value) {
            addCriterion("order_delivery_fee <>", value, "orderDeliveryFee");
            return (Criteria) this;
        }

        public Criteria andOrderDeliveryFeeGreaterThan(BigDecimal value) {
            addCriterion("order_delivery_fee >", value, "orderDeliveryFee");
            return (Criteria) this;
        }

        public Criteria andOrderDeliveryFeeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("order_delivery_fee >=", value, "orderDeliveryFee");
            return (Criteria) this;
        }

        public Criteria andOrderDeliveryFeeLessThan(BigDecimal value) {
            addCriterion("order_delivery_fee <", value, "orderDeliveryFee");
            return (Criteria) this;
        }

        public Criteria andOrderDeliveryFeeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("order_delivery_fee <=", value, "orderDeliveryFee");
            return (Criteria) this;
        }

        public Criteria andOrderDeliveryFeeIn(List<BigDecimal> values) {
            addCriterion("order_delivery_fee in", values, "orderDeliveryFee");
            return (Criteria) this;
        }

        public Criteria andOrderDeliveryFeeNotIn(List<BigDecimal> values) {
            addCriterion("order_delivery_fee not in", values, "orderDeliveryFee");
            return (Criteria) this;
        }

        public Criteria andOrderDeliveryFeeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("order_delivery_fee between", value1, value2, "orderDeliveryFee");
            return (Criteria) this;
        }

        public Criteria andOrderDeliveryFeeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("order_delivery_fee not between", value1, value2, "orderDeliveryFee");
            return (Criteria) this;
        }

        public Criteria andOrderRemarkIsNull() {
            addCriterion("order_remark is null");
            return (Criteria) this;
        }

        public Criteria andOrderRemarkIsNotNull() {
            addCriterion("order_remark is not null");
            return (Criteria) this;
        }

        public Criteria andOrderRemarkEqualTo(String value) {
            addCriterion("order_remark =", value, "orderRemark");
            return (Criteria) this;
        }

        public Criteria andOrderRemarkNotEqualTo(String value) {
            addCriterion("order_remark <>", value, "orderRemark");
            return (Criteria) this;
        }

        public Criteria andOrderRemarkGreaterThan(String value) {
            addCriterion("order_remark >", value, "orderRemark");
            return (Criteria) this;
        }

        public Criteria andOrderRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("order_remark >=", value, "orderRemark");
            return (Criteria) this;
        }

        public Criteria andOrderRemarkLessThan(String value) {
            addCriterion("order_remark <", value, "orderRemark");
            return (Criteria) this;
        }

        public Criteria andOrderRemarkLessThanOrEqualTo(String value) {
            addCriterion("order_remark <=", value, "orderRemark");
            return (Criteria) this;
        }

        public Criteria andOrderRemarkLike(String value) {
            addCriterion("order_remark like", value, "orderRemark");
            return (Criteria) this;
        }

        public Criteria andOrderRemarkNotLike(String value) {
            addCriterion("order_remark not like", value, "orderRemark");
            return (Criteria) this;
        }

        public Criteria andOrderRemarkIn(List<String> values) {
            addCriterion("order_remark in", values, "orderRemark");
            return (Criteria) this;
        }

        public Criteria andOrderRemarkNotIn(List<String> values) {
            addCriterion("order_remark not in", values, "orderRemark");
            return (Criteria) this;
        }

        public Criteria andOrderRemarkBetween(String value1, String value2) {
            addCriterion("order_remark between", value1, value2, "orderRemark");
            return (Criteria) this;
        }

        public Criteria andOrderRemarkNotBetween(String value1, String value2) {
            addCriterion("order_remark not between", value1, value2, "orderRemark");
            return (Criteria) this;
        }

        public Criteria andGoodReceiverNameIsNull() {
            addCriterion("good_receiver_name is null");
            return (Criteria) this;
        }

        public Criteria andGoodReceiverNameIsNotNull() {
            addCriterion("good_receiver_name is not null");
            return (Criteria) this;
        }

        public Criteria andGoodReceiverNameEqualTo(String value) {
            addCriterion("good_receiver_name =", value, "goodReceiverName");
            return (Criteria) this;
        }

        public Criteria andGoodReceiverNameNotEqualTo(String value) {
            addCriterion("good_receiver_name <>", value, "goodReceiverName");
            return (Criteria) this;
        }

        public Criteria andGoodReceiverNameGreaterThan(String value) {
            addCriterion("good_receiver_name >", value, "goodReceiverName");
            return (Criteria) this;
        }

        public Criteria andGoodReceiverNameGreaterThanOrEqualTo(String value) {
            addCriterion("good_receiver_name >=", value, "goodReceiverName");
            return (Criteria) this;
        }

        public Criteria andGoodReceiverNameLessThan(String value) {
            addCriterion("good_receiver_name <", value, "goodReceiverName");
            return (Criteria) this;
        }

        public Criteria andGoodReceiverNameLessThanOrEqualTo(String value) {
            addCriterion("good_receiver_name <=", value, "goodReceiverName");
            return (Criteria) this;
        }

        public Criteria andGoodReceiverNameLike(String value) {
            addCriterion("good_receiver_name like", value, "goodReceiverName");
            return (Criteria) this;
        }

        public Criteria andGoodReceiverNameNotLike(String value) {
            addCriterion("good_receiver_name not like", value, "goodReceiverName");
            return (Criteria) this;
        }

        public Criteria andGoodReceiverNameIn(List<String> values) {
            addCriterion("good_receiver_name in", values, "goodReceiverName");
            return (Criteria) this;
        }

        public Criteria andGoodReceiverNameNotIn(List<String> values) {
            addCriterion("good_receiver_name not in", values, "goodReceiverName");
            return (Criteria) this;
        }

        public Criteria andGoodReceiverNameBetween(String value1, String value2) {
            addCriterion("good_receiver_name between", value1, value2, "goodReceiverName");
            return (Criteria) this;
        }

        public Criteria andGoodReceiverNameNotBetween(String value1, String value2) {
            addCriterion("good_receiver_name not between", value1, value2, "goodReceiverName");
            return (Criteria) this;
        }

        public Criteria andGoodReceiverPhoneIsNull() {
            addCriterion("good_receiver_phone is null");
            return (Criteria) this;
        }

        public Criteria andGoodReceiverPhoneIsNotNull() {
            addCriterion("good_receiver_phone is not null");
            return (Criteria) this;
        }

        public Criteria andGoodReceiverPhoneEqualTo(String value) {
            addCriterion("good_receiver_phone =", value, "goodReceiverPhone");
            return (Criteria) this;
        }

        public Criteria andGoodReceiverPhoneNotEqualTo(String value) {
            addCriterion("good_receiver_phone <>", value, "goodReceiverPhone");
            return (Criteria) this;
        }

        public Criteria andGoodReceiverPhoneGreaterThan(String value) {
            addCriterion("good_receiver_phone >", value, "goodReceiverPhone");
            return (Criteria) this;
        }

        public Criteria andGoodReceiverPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("good_receiver_phone >=", value, "goodReceiverPhone");
            return (Criteria) this;
        }

        public Criteria andGoodReceiverPhoneLessThan(String value) {
            addCriterion("good_receiver_phone <", value, "goodReceiverPhone");
            return (Criteria) this;
        }

        public Criteria andGoodReceiverPhoneLessThanOrEqualTo(String value) {
            addCriterion("good_receiver_phone <=", value, "goodReceiverPhone");
            return (Criteria) this;
        }

        public Criteria andGoodReceiverPhoneLike(String value) {
            addCriterion("good_receiver_phone like", value, "goodReceiverPhone");
            return (Criteria) this;
        }

        public Criteria andGoodReceiverPhoneNotLike(String value) {
            addCriterion("good_receiver_phone not like", value, "goodReceiverPhone");
            return (Criteria) this;
        }

        public Criteria andGoodReceiverPhoneIn(List<String> values) {
            addCriterion("good_receiver_phone in", values, "goodReceiverPhone");
            return (Criteria) this;
        }

        public Criteria andGoodReceiverPhoneNotIn(List<String> values) {
            addCriterion("good_receiver_phone not in", values, "goodReceiverPhone");
            return (Criteria) this;
        }

        public Criteria andGoodReceiverPhoneBetween(String value1, String value2) {
            addCriterion("good_receiver_phone between", value1, value2, "goodReceiverPhone");
            return (Criteria) this;
        }

        public Criteria andGoodReceiverPhoneNotBetween(String value1, String value2) {
            addCriterion("good_receiver_phone not between", value1, value2, "goodReceiverPhone");
            return (Criteria) this;
        }

        public Criteria andGoodReceiverProvinceIsNull() {
            addCriterion("good_receiver_province is null");
            return (Criteria) this;
        }

        public Criteria andGoodReceiverProvinceIsNotNull() {
            addCriterion("good_receiver_province is not null");
            return (Criteria) this;
        }

        public Criteria andGoodReceiverProvinceEqualTo(String value) {
            addCriterion("good_receiver_province =", value, "goodReceiverProvince");
            return (Criteria) this;
        }

        public Criteria andGoodReceiverProvinceNotEqualTo(String value) {
            addCriterion("good_receiver_province <>", value, "goodReceiverProvince");
            return (Criteria) this;
        }

        public Criteria andGoodReceiverProvinceGreaterThan(String value) {
            addCriterion("good_receiver_province >", value, "goodReceiverProvince");
            return (Criteria) this;
        }

        public Criteria andGoodReceiverProvinceGreaterThanOrEqualTo(String value) {
            addCriterion("good_receiver_province >=", value, "goodReceiverProvince");
            return (Criteria) this;
        }

        public Criteria andGoodReceiverProvinceLessThan(String value) {
            addCriterion("good_receiver_province <", value, "goodReceiverProvince");
            return (Criteria) this;
        }

        public Criteria andGoodReceiverProvinceLessThanOrEqualTo(String value) {
            addCriterion("good_receiver_province <=", value, "goodReceiverProvince");
            return (Criteria) this;
        }

        public Criteria andGoodReceiverProvinceLike(String value) {
            addCriterion("good_receiver_province like", value, "goodReceiverProvince");
            return (Criteria) this;
        }

        public Criteria andGoodReceiverProvinceNotLike(String value) {
            addCriterion("good_receiver_province not like", value, "goodReceiverProvince");
            return (Criteria) this;
        }

        public Criteria andGoodReceiverProvinceIn(List<String> values) {
            addCriterion("good_receiver_province in", values, "goodReceiverProvince");
            return (Criteria) this;
        }

        public Criteria andGoodReceiverProvinceNotIn(List<String> values) {
            addCriterion("good_receiver_province not in", values, "goodReceiverProvince");
            return (Criteria) this;
        }

        public Criteria andGoodReceiverProvinceBetween(String value1, String value2) {
            addCriterion("good_receiver_province between", value1, value2, "goodReceiverProvince");
            return (Criteria) this;
        }

        public Criteria andGoodReceiverProvinceNotBetween(String value1, String value2) {
            addCriterion("good_receiver_province not between", value1, value2, "goodReceiverProvince");
            return (Criteria) this;
        }

        public Criteria andGoodReceiverCityIsNull() {
            addCriterion("good_receiver_city is null");
            return (Criteria) this;
        }

        public Criteria andGoodReceiverCityIsNotNull() {
            addCriterion("good_receiver_city is not null");
            return (Criteria) this;
        }

        public Criteria andGoodReceiverCityEqualTo(String value) {
            addCriterion("good_receiver_city =", value, "goodReceiverCity");
            return (Criteria) this;
        }

        public Criteria andGoodReceiverCityNotEqualTo(String value) {
            addCriterion("good_receiver_city <>", value, "goodReceiverCity");
            return (Criteria) this;
        }

        public Criteria andGoodReceiverCityGreaterThan(String value) {
            addCriterion("good_receiver_city >", value, "goodReceiverCity");
            return (Criteria) this;
        }

        public Criteria andGoodReceiverCityGreaterThanOrEqualTo(String value) {
            addCriterion("good_receiver_city >=", value, "goodReceiverCity");
            return (Criteria) this;
        }

        public Criteria andGoodReceiverCityLessThan(String value) {
            addCriterion("good_receiver_city <", value, "goodReceiverCity");
            return (Criteria) this;
        }

        public Criteria andGoodReceiverCityLessThanOrEqualTo(String value) {
            addCriterion("good_receiver_city <=", value, "goodReceiverCity");
            return (Criteria) this;
        }

        public Criteria andGoodReceiverCityLike(String value) {
            addCriterion("good_receiver_city like", value, "goodReceiverCity");
            return (Criteria) this;
        }

        public Criteria andGoodReceiverCityNotLike(String value) {
            addCriterion("good_receiver_city not like", value, "goodReceiverCity");
            return (Criteria) this;
        }

        public Criteria andGoodReceiverCityIn(List<String> values) {
            addCriterion("good_receiver_city in", values, "goodReceiverCity");
            return (Criteria) this;
        }

        public Criteria andGoodReceiverCityNotIn(List<String> values) {
            addCriterion("good_receiver_city not in", values, "goodReceiverCity");
            return (Criteria) this;
        }

        public Criteria andGoodReceiverCityBetween(String value1, String value2) {
            addCriterion("good_receiver_city between", value1, value2, "goodReceiverCity");
            return (Criteria) this;
        }

        public Criteria andGoodReceiverCityNotBetween(String value1, String value2) {
            addCriterion("good_receiver_city not between", value1, value2, "goodReceiverCity");
            return (Criteria) this;
        }

        public Criteria andGoodReceiverCountyIsNull() {
            addCriterion("good_receiver_county is null");
            return (Criteria) this;
        }

        public Criteria andGoodReceiverCountyIsNotNull() {
            addCriterion("good_receiver_county is not null");
            return (Criteria) this;
        }

        public Criteria andGoodReceiverCountyEqualTo(String value) {
            addCriterion("good_receiver_county =", value, "goodReceiverCounty");
            return (Criteria) this;
        }

        public Criteria andGoodReceiverCountyNotEqualTo(String value) {
            addCriterion("good_receiver_county <>", value, "goodReceiverCounty");
            return (Criteria) this;
        }

        public Criteria andGoodReceiverCountyGreaterThan(String value) {
            addCriterion("good_receiver_county >", value, "goodReceiverCounty");
            return (Criteria) this;
        }

        public Criteria andGoodReceiverCountyGreaterThanOrEqualTo(String value) {
            addCriterion("good_receiver_county >=", value, "goodReceiverCounty");
            return (Criteria) this;
        }

        public Criteria andGoodReceiverCountyLessThan(String value) {
            addCriterion("good_receiver_county <", value, "goodReceiverCounty");
            return (Criteria) this;
        }

        public Criteria andGoodReceiverCountyLessThanOrEqualTo(String value) {
            addCriterion("good_receiver_county <=", value, "goodReceiverCounty");
            return (Criteria) this;
        }

        public Criteria andGoodReceiverCountyLike(String value) {
            addCriterion("good_receiver_county like", value, "goodReceiverCounty");
            return (Criteria) this;
        }

        public Criteria andGoodReceiverCountyNotLike(String value) {
            addCriterion("good_receiver_county not like", value, "goodReceiverCounty");
            return (Criteria) this;
        }

        public Criteria andGoodReceiverCountyIn(List<String> values) {
            addCriterion("good_receiver_county in", values, "goodReceiverCounty");
            return (Criteria) this;
        }

        public Criteria andGoodReceiverCountyNotIn(List<String> values) {
            addCriterion("good_receiver_county not in", values, "goodReceiverCounty");
            return (Criteria) this;
        }

        public Criteria andGoodReceiverCountyBetween(String value1, String value2) {
            addCriterion("good_receiver_county between", value1, value2, "goodReceiverCounty");
            return (Criteria) this;
        }

        public Criteria andGoodReceiverCountyNotBetween(String value1, String value2) {
            addCriterion("good_receiver_county not between", value1, value2, "goodReceiverCounty");
            return (Criteria) this;
        }

        public Criteria andGoodReceiverAddressIsNull() {
            addCriterion("good_receiver_address is null");
            return (Criteria) this;
        }

        public Criteria andGoodReceiverAddressIsNotNull() {
            addCriterion("good_receiver_address is not null");
            return (Criteria) this;
        }

        public Criteria andGoodReceiverAddressEqualTo(String value) {
            addCriterion("good_receiver_address =", value, "goodReceiverAddress");
            return (Criteria) this;
        }

        public Criteria andGoodReceiverAddressNotEqualTo(String value) {
            addCriterion("good_receiver_address <>", value, "goodReceiverAddress");
            return (Criteria) this;
        }

        public Criteria andGoodReceiverAddressGreaterThan(String value) {
            addCriterion("good_receiver_address >", value, "goodReceiverAddress");
            return (Criteria) this;
        }

        public Criteria andGoodReceiverAddressGreaterThanOrEqualTo(String value) {
            addCriterion("good_receiver_address >=", value, "goodReceiverAddress");
            return (Criteria) this;
        }

        public Criteria andGoodReceiverAddressLessThan(String value) {
            addCriterion("good_receiver_address <", value, "goodReceiverAddress");
            return (Criteria) this;
        }

        public Criteria andGoodReceiverAddressLessThanOrEqualTo(String value) {
            addCriterion("good_receiver_address <=", value, "goodReceiverAddress");
            return (Criteria) this;
        }

        public Criteria andGoodReceiverAddressLike(String value) {
            addCriterion("good_receiver_address like", value, "goodReceiverAddress");
            return (Criteria) this;
        }

        public Criteria andGoodReceiverAddressNotLike(String value) {
            addCriterion("good_receiver_address not like", value, "goodReceiverAddress");
            return (Criteria) this;
        }

        public Criteria andGoodReceiverAddressIn(List<String> values) {
            addCriterion("good_receiver_address in", values, "goodReceiverAddress");
            return (Criteria) this;
        }

        public Criteria andGoodReceiverAddressNotIn(List<String> values) {
            addCriterion("good_receiver_address not in", values, "goodReceiverAddress");
            return (Criteria) this;
        }

        public Criteria andGoodReceiverAddressBetween(String value1, String value2) {
            addCriterion("good_receiver_address between", value1, value2, "goodReceiverAddress");
            return (Criteria) this;
        }

        public Criteria andGoodReceiverAddressNotBetween(String value1, String value2) {
            addCriterion("good_receiver_address not between", value1, value2, "goodReceiverAddress");
            return (Criteria) this;
        }

        public Criteria andGoodReceiverPostCodeIsNull() {
            addCriterion("good_receiver_post_code is null");
            return (Criteria) this;
        }

        public Criteria andGoodReceiverPostCodeIsNotNull() {
            addCriterion("good_receiver_post_code is not null");
            return (Criteria) this;
        }

        public Criteria andGoodReceiverPostCodeEqualTo(String value) {
            addCriterion("good_receiver_post_code =", value, "goodReceiverPostCode");
            return (Criteria) this;
        }

        public Criteria andGoodReceiverPostCodeNotEqualTo(String value) {
            addCriterion("good_receiver_post_code <>", value, "goodReceiverPostCode");
            return (Criteria) this;
        }

        public Criteria andGoodReceiverPostCodeGreaterThan(String value) {
            addCriterion("good_receiver_post_code >", value, "goodReceiverPostCode");
            return (Criteria) this;
        }

        public Criteria andGoodReceiverPostCodeGreaterThanOrEqualTo(String value) {
            addCriterion("good_receiver_post_code >=", value, "goodReceiverPostCode");
            return (Criteria) this;
        }

        public Criteria andGoodReceiverPostCodeLessThan(String value) {
            addCriterion("good_receiver_post_code <", value, "goodReceiverPostCode");
            return (Criteria) this;
        }

        public Criteria andGoodReceiverPostCodeLessThanOrEqualTo(String value) {
            addCriterion("good_receiver_post_code <=", value, "goodReceiverPostCode");
            return (Criteria) this;
        }

        public Criteria andGoodReceiverPostCodeLike(String value) {
            addCriterion("good_receiver_post_code like", value, "goodReceiverPostCode");
            return (Criteria) this;
        }

        public Criteria andGoodReceiverPostCodeNotLike(String value) {
            addCriterion("good_receiver_post_code not like", value, "goodReceiverPostCode");
            return (Criteria) this;
        }

        public Criteria andGoodReceiverPostCodeIn(List<String> values) {
            addCriterion("good_receiver_post_code in", values, "goodReceiverPostCode");
            return (Criteria) this;
        }

        public Criteria andGoodReceiverPostCodeNotIn(List<String> values) {
            addCriterion("good_receiver_post_code not in", values, "goodReceiverPostCode");
            return (Criteria) this;
        }

        public Criteria andGoodReceiverPostCodeBetween(String value1, String value2) {
            addCriterion("good_receiver_post_code between", value1, value2, "goodReceiverPostCode");
            return (Criteria) this;
        }

        public Criteria andGoodReceiverPostCodeNotBetween(String value1, String value2) {
            addCriterion("good_receiver_post_code not between", value1, value2, "goodReceiverPostCode");
            return (Criteria) this;
        }

        public Criteria andGoodReceiverCountryIdIsNull() {
            addCriterion("good_receiver_country_id is null");
            return (Criteria) this;
        }

        public Criteria andGoodReceiverCountryIdIsNotNull() {
            addCriterion("good_receiver_country_id is not null");
            return (Criteria) this;
        }

        public Criteria andGoodReceiverCountryIdEqualTo(Long value) {
            addCriterion("good_receiver_country_id =", value, "goodReceiverCountryId");
            return (Criteria) this;
        }

        public Criteria andGoodReceiverCountryIdNotEqualTo(Long value) {
            addCriterion("good_receiver_country_id <>", value, "goodReceiverCountryId");
            return (Criteria) this;
        }

        public Criteria andGoodReceiverCountryIdGreaterThan(Long value) {
            addCriterion("good_receiver_country_id >", value, "goodReceiverCountryId");
            return (Criteria) this;
        }

        public Criteria andGoodReceiverCountryIdGreaterThanOrEqualTo(Long value) {
            addCriterion("good_receiver_country_id >=", value, "goodReceiverCountryId");
            return (Criteria) this;
        }

        public Criteria andGoodReceiverCountryIdLessThan(Long value) {
            addCriterion("good_receiver_country_id <", value, "goodReceiverCountryId");
            return (Criteria) this;
        }

        public Criteria andGoodReceiverCountryIdLessThanOrEqualTo(Long value) {
            addCriterion("good_receiver_country_id <=", value, "goodReceiverCountryId");
            return (Criteria) this;
        }

        public Criteria andGoodReceiverCountryIdIn(List<Long> values) {
            addCriterion("good_receiver_country_id in", values, "goodReceiverCountryId");
            return (Criteria) this;
        }

        public Criteria andGoodReceiverCountryIdNotIn(List<Long> values) {
            addCriterion("good_receiver_country_id not in", values, "goodReceiverCountryId");
            return (Criteria) this;
        }

        public Criteria andGoodReceiverCountryIdBetween(Long value1, Long value2) {
            addCriterion("good_receiver_country_id between", value1, value2, "goodReceiverCountryId");
            return (Criteria) this;
        }

        public Criteria andGoodReceiverCountryIdNotBetween(Long value1, Long value2) {
            addCriterion("good_receiver_country_id not between", value1, value2, "goodReceiverCountryId");
            return (Criteria) this;
        }

        public Criteria andGoodReceiverProvinceIdIsNull() {
            addCriterion("good_receiver_province_id is null");
            return (Criteria) this;
        }

        public Criteria andGoodReceiverProvinceIdIsNotNull() {
            addCriterion("good_receiver_province_id is not null");
            return (Criteria) this;
        }

        public Criteria andGoodReceiverProvinceIdEqualTo(Long value) {
            addCriterion("good_receiver_province_id =", value, "goodReceiverProvinceId");
            return (Criteria) this;
        }

        public Criteria andGoodReceiverProvinceIdNotEqualTo(Long value) {
            addCriterion("good_receiver_province_id <>", value, "goodReceiverProvinceId");
            return (Criteria) this;
        }

        public Criteria andGoodReceiverProvinceIdGreaterThan(Long value) {
            addCriterion("good_receiver_province_id >", value, "goodReceiverProvinceId");
            return (Criteria) this;
        }

        public Criteria andGoodReceiverProvinceIdGreaterThanOrEqualTo(Long value) {
            addCriterion("good_receiver_province_id >=", value, "goodReceiverProvinceId");
            return (Criteria) this;
        }

        public Criteria andGoodReceiverProvinceIdLessThan(Long value) {
            addCriterion("good_receiver_province_id <", value, "goodReceiverProvinceId");
            return (Criteria) this;
        }

        public Criteria andGoodReceiverProvinceIdLessThanOrEqualTo(Long value) {
            addCriterion("good_receiver_province_id <=", value, "goodReceiverProvinceId");
            return (Criteria) this;
        }

        public Criteria andGoodReceiverProvinceIdIn(List<Long> values) {
            addCriterion("good_receiver_province_id in", values, "goodReceiverProvinceId");
            return (Criteria) this;
        }

        public Criteria andGoodReceiverProvinceIdNotIn(List<Long> values) {
            addCriterion("good_receiver_province_id not in", values, "goodReceiverProvinceId");
            return (Criteria) this;
        }

        public Criteria andGoodReceiverProvinceIdBetween(Long value1, Long value2) {
            addCriterion("good_receiver_province_id between", value1, value2, "goodReceiverProvinceId");
            return (Criteria) this;
        }

        public Criteria andGoodReceiverProvinceIdNotBetween(Long value1, Long value2) {
            addCriterion("good_receiver_province_id not between", value1, value2, "goodReceiverProvinceId");
            return (Criteria) this;
        }

        public Criteria andGoodReceiverCityIdIsNull() {
            addCriterion("good_receiver_city_id is null");
            return (Criteria) this;
        }

        public Criteria andGoodReceiverCityIdIsNotNull() {
            addCriterion("good_receiver_city_id is not null");
            return (Criteria) this;
        }

        public Criteria andGoodReceiverCityIdEqualTo(Long value) {
            addCriterion("good_receiver_city_id =", value, "goodReceiverCityId");
            return (Criteria) this;
        }

        public Criteria andGoodReceiverCityIdNotEqualTo(Long value) {
            addCriterion("good_receiver_city_id <>", value, "goodReceiverCityId");
            return (Criteria) this;
        }

        public Criteria andGoodReceiverCityIdGreaterThan(Long value) {
            addCriterion("good_receiver_city_id >", value, "goodReceiverCityId");
            return (Criteria) this;
        }

        public Criteria andGoodReceiverCityIdGreaterThanOrEqualTo(Long value) {
            addCriterion("good_receiver_city_id >=", value, "goodReceiverCityId");
            return (Criteria) this;
        }

        public Criteria andGoodReceiverCityIdLessThan(Long value) {
            addCriterion("good_receiver_city_id <", value, "goodReceiverCityId");
            return (Criteria) this;
        }

        public Criteria andGoodReceiverCityIdLessThanOrEqualTo(Long value) {
            addCriterion("good_receiver_city_id <=", value, "goodReceiverCityId");
            return (Criteria) this;
        }

        public Criteria andGoodReceiverCityIdIn(List<Long> values) {
            addCriterion("good_receiver_city_id in", values, "goodReceiverCityId");
            return (Criteria) this;
        }

        public Criteria andGoodReceiverCityIdNotIn(List<Long> values) {
            addCriterion("good_receiver_city_id not in", values, "goodReceiverCityId");
            return (Criteria) this;
        }

        public Criteria andGoodReceiverCityIdBetween(Long value1, Long value2) {
            addCriterion("good_receiver_city_id between", value1, value2, "goodReceiverCityId");
            return (Criteria) this;
        }

        public Criteria andGoodReceiverCityIdNotBetween(Long value1, Long value2) {
            addCriterion("good_receiver_city_id not between", value1, value2, "goodReceiverCityId");
            return (Criteria) this;
        }

        public Criteria andGoodReceiverCountyIdIsNull() {
            addCriterion("good_receiver_county_id is null");
            return (Criteria) this;
        }

        public Criteria andGoodReceiverCountyIdIsNotNull() {
            addCriterion("good_receiver_county_id is not null");
            return (Criteria) this;
        }

        public Criteria andGoodReceiverCountyIdEqualTo(Long value) {
            addCriterion("good_receiver_county_id =", value, "goodReceiverCountyId");
            return (Criteria) this;
        }

        public Criteria andGoodReceiverCountyIdNotEqualTo(Long value) {
            addCriterion("good_receiver_county_id <>", value, "goodReceiverCountyId");
            return (Criteria) this;
        }

        public Criteria andGoodReceiverCountyIdGreaterThan(Long value) {
            addCriterion("good_receiver_county_id >", value, "goodReceiverCountyId");
            return (Criteria) this;
        }

        public Criteria andGoodReceiverCountyIdGreaterThanOrEqualTo(Long value) {
            addCriterion("good_receiver_county_id >=", value, "goodReceiverCountyId");
            return (Criteria) this;
        }

        public Criteria andGoodReceiverCountyIdLessThan(Long value) {
            addCriterion("good_receiver_county_id <", value, "goodReceiverCountyId");
            return (Criteria) this;
        }

        public Criteria andGoodReceiverCountyIdLessThanOrEqualTo(Long value) {
            addCriterion("good_receiver_county_id <=", value, "goodReceiverCountyId");
            return (Criteria) this;
        }

        public Criteria andGoodReceiverCountyIdIn(List<Long> values) {
            addCriterion("good_receiver_county_id in", values, "goodReceiverCountyId");
            return (Criteria) this;
        }

        public Criteria andGoodReceiverCountyIdNotIn(List<Long> values) {
            addCriterion("good_receiver_county_id not in", values, "goodReceiverCountyId");
            return (Criteria) this;
        }

        public Criteria andGoodReceiverCountyIdBetween(Long value1, Long value2) {
            addCriterion("good_receiver_county_id between", value1, value2, "goodReceiverCountyId");
            return (Criteria) this;
        }

        public Criteria andGoodReceiverCountyIdNotBetween(Long value1, Long value2) {
            addCriterion("good_receiver_county_id not between", value1, value2, "goodReceiverCountyId");
            return (Criteria) this;
        }

        public Criteria andCancelReasonIdIsNull() {
            addCriterion("cancel_reason_id is null");
            return (Criteria) this;
        }

        public Criteria andCancelReasonIdIsNotNull() {
            addCriterion("cancel_reason_id is not null");
            return (Criteria) this;
        }

        public Criteria andCancelReasonIdEqualTo(Integer value) {
            addCriterion("cancel_reason_id =", value, "cancelReasonId");
            return (Criteria) this;
        }

        public Criteria andCancelReasonIdNotEqualTo(Integer value) {
            addCriterion("cancel_reason_id <>", value, "cancelReasonId");
            return (Criteria) this;
        }

        public Criteria andCancelReasonIdGreaterThan(Integer value) {
            addCriterion("cancel_reason_id >", value, "cancelReasonId");
            return (Criteria) this;
        }

        public Criteria andCancelReasonIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("cancel_reason_id >=", value, "cancelReasonId");
            return (Criteria) this;
        }

        public Criteria andCancelReasonIdLessThan(Integer value) {
            addCriterion("cancel_reason_id <", value, "cancelReasonId");
            return (Criteria) this;
        }

        public Criteria andCancelReasonIdLessThanOrEqualTo(Integer value) {
            addCriterion("cancel_reason_id <=", value, "cancelReasonId");
            return (Criteria) this;
        }

        public Criteria andCancelReasonIdIn(List<Integer> values) {
            addCriterion("cancel_reason_id in", values, "cancelReasonId");
            return (Criteria) this;
        }

        public Criteria andCancelReasonIdNotIn(List<Integer> values) {
            addCriterion("cancel_reason_id not in", values, "cancelReasonId");
            return (Criteria) this;
        }

        public Criteria andCancelReasonIdBetween(Integer value1, Integer value2) {
            addCriterion("cancel_reason_id between", value1, value2, "cancelReasonId");
            return (Criteria) this;
        }

        public Criteria andCancelReasonIdNotBetween(Integer value1, Integer value2) {
            addCriterion("cancel_reason_id not between", value1, value2, "cancelReasonId");
            return (Criteria) this;
        }

        public Criteria andCancelDateIsNull() {
            addCriterion("cancel_date is null");
            return (Criteria) this;
        }

        public Criteria andCancelDateIsNotNull() {
            addCriterion("cancel_date is not null");
            return (Criteria) this;
        }

        public Criteria andCancelDateEqualTo(Date value) {
            addCriterion("cancel_date =", value, "cancelDate");
            return (Criteria) this;
        }

        public Criteria andCancelDateNotEqualTo(Date value) {
            addCriterion("cancel_date <>", value, "cancelDate");
            return (Criteria) this;
        }

        public Criteria andCancelDateGreaterThan(Date value) {
            addCriterion("cancel_date >", value, "cancelDate");
            return (Criteria) this;
        }

        public Criteria andCancelDateGreaterThanOrEqualTo(Date value) {
            addCriterion("cancel_date >=", value, "cancelDate");
            return (Criteria) this;
        }

        public Criteria andCancelDateLessThan(Date value) {
            addCriterion("cancel_date <", value, "cancelDate");
            return (Criteria) this;
        }

        public Criteria andCancelDateLessThanOrEqualTo(Date value) {
            addCriterion("cancel_date <=", value, "cancelDate");
            return (Criteria) this;
        }

        public Criteria andCancelDateIn(List<Date> values) {
            addCriterion("cancel_date in", values, "cancelDate");
            return (Criteria) this;
        }

        public Criteria andCancelDateNotIn(List<Date> values) {
            addCriterion("cancel_date not in", values, "cancelDate");
            return (Criteria) this;
        }

        public Criteria andCancelDateBetween(Date value1, Date value2) {
            addCriterion("cancel_date between", value1, value2, "cancelDate");
            return (Criteria) this;
        }

        public Criteria andCancelDateNotBetween(Date value1, Date value2) {
            addCriterion("cancel_date not between", value1, value2, "cancelDate");
            return (Criteria) this;
        }

        public Criteria andCancelOperatorIdIsNull() {
            addCriterion("cancel_operator_id is null");
            return (Criteria) this;
        }

        public Criteria andCancelOperatorIdIsNotNull() {
            addCriterion("cancel_operator_id is not null");
            return (Criteria) this;
        }

        public Criteria andCancelOperatorIdEqualTo(Long value) {
            addCriterion("cancel_operator_id =", value, "cancelOperatorId");
            return (Criteria) this;
        }

        public Criteria andCancelOperatorIdNotEqualTo(Long value) {
            addCriterion("cancel_operator_id <>", value, "cancelOperatorId");
            return (Criteria) this;
        }

        public Criteria andCancelOperatorIdGreaterThan(Long value) {
            addCriterion("cancel_operator_id >", value, "cancelOperatorId");
            return (Criteria) this;
        }

        public Criteria andCancelOperatorIdGreaterThanOrEqualTo(Long value) {
            addCriterion("cancel_operator_id >=", value, "cancelOperatorId");
            return (Criteria) this;
        }

        public Criteria andCancelOperatorIdLessThan(Long value) {
            addCriterion("cancel_operator_id <", value, "cancelOperatorId");
            return (Criteria) this;
        }

        public Criteria andCancelOperatorIdLessThanOrEqualTo(Long value) {
            addCriterion("cancel_operator_id <=", value, "cancelOperatorId");
            return (Criteria) this;
        }

        public Criteria andCancelOperatorIdIn(List<Long> values) {
            addCriterion("cancel_operator_id in", values, "cancelOperatorId");
            return (Criteria) this;
        }

        public Criteria andCancelOperatorIdNotIn(List<Long> values) {
            addCriterion("cancel_operator_id not in", values, "cancelOperatorId");
            return (Criteria) this;
        }

        public Criteria andCancelOperatorIdBetween(Long value1, Long value2) {
            addCriterion("cancel_operator_id between", value1, value2, "cancelOperatorId");
            return (Criteria) this;
        }

        public Criteria andCancelOperatorIdNotBetween(Long value1, Long value2) {
            addCriterion("cancel_operator_id not between", value1, value2, "cancelOperatorId");
            return (Criteria) this;
        }

        public Criteria andPaymentConfirmDateIsNull() {
            addCriterion("payment_confirm_date is null");
            return (Criteria) this;
        }

        public Criteria andPaymentConfirmDateIsNotNull() {
            addCriterion("payment_confirm_date is not null");
            return (Criteria) this;
        }

        public Criteria andPaymentConfirmDateEqualTo(Date value) {
            addCriterion("payment_confirm_date =", value, "paymentConfirmDate");
            return (Criteria) this;
        }

        public Criteria andPaymentConfirmDateNotEqualTo(Date value) {
            addCriterion("payment_confirm_date <>", value, "paymentConfirmDate");
            return (Criteria) this;
        }

        public Criteria andPaymentConfirmDateGreaterThan(Date value) {
            addCriterion("payment_confirm_date >", value, "paymentConfirmDate");
            return (Criteria) this;
        }

        public Criteria andPaymentConfirmDateGreaterThanOrEqualTo(Date value) {
            addCriterion("payment_confirm_date >=", value, "paymentConfirmDate");
            return (Criteria) this;
        }

        public Criteria andPaymentConfirmDateLessThan(Date value) {
            addCriterion("payment_confirm_date <", value, "paymentConfirmDate");
            return (Criteria) this;
        }

        public Criteria andPaymentConfirmDateLessThanOrEqualTo(Date value) {
            addCriterion("payment_confirm_date <=", value, "paymentConfirmDate");
            return (Criteria) this;
        }

        public Criteria andPaymentConfirmDateIn(List<Date> values) {
            addCriterion("payment_confirm_date in", values, "paymentConfirmDate");
            return (Criteria) this;
        }

        public Criteria andPaymentConfirmDateNotIn(List<Date> values) {
            addCriterion("payment_confirm_date not in", values, "paymentConfirmDate");
            return (Criteria) this;
        }

        public Criteria andPaymentConfirmDateBetween(Date value1, Date value2) {
            addCriterion("payment_confirm_date between", value1, value2, "paymentConfirmDate");
            return (Criteria) this;
        }

        public Criteria andPaymentConfirmDateNotBetween(Date value1, Date value2) {
            addCriterion("payment_confirm_date not between", value1, value2, "paymentConfirmDate");
            return (Criteria) this;
        }

        public Criteria andPaymentStateIsNull() {
            addCriterion("payment_state is null");
            return (Criteria) this;
        }

        public Criteria andPaymentStateIsNotNull() {
            addCriterion("payment_state is not null");
            return (Criteria) this;
        }

        public Criteria andPaymentStateEqualTo(Integer value) {
            addCriterion("payment_state =", value, "paymentState");
            return (Criteria) this;
        }

        public Criteria andPaymentStateNotEqualTo(Integer value) {
            addCriterion("payment_state <>", value, "paymentState");
            return (Criteria) this;
        }

        public Criteria andPaymentStateGreaterThan(Integer value) {
            addCriterion("payment_state >", value, "paymentState");
            return (Criteria) this;
        }

        public Criteria andPaymentStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("payment_state >=", value, "paymentState");
            return (Criteria) this;
        }

        public Criteria andPaymentStateLessThan(Integer value) {
            addCriterion("payment_state <", value, "paymentState");
            return (Criteria) this;
        }

        public Criteria andPaymentStateLessThanOrEqualTo(Integer value) {
            addCriterion("payment_state <=", value, "paymentState");
            return (Criteria) this;
        }

        public Criteria andPaymentStateIn(List<Integer> values) {
            addCriterion("payment_state in", values, "paymentState");
            return (Criteria) this;
        }

        public Criteria andPaymentStateNotIn(List<Integer> values) {
            addCriterion("payment_state not in", values, "paymentState");
            return (Criteria) this;
        }

        public Criteria andPaymentStateBetween(Integer value1, Integer value2) {
            addCriterion("payment_state between", value1, value2, "paymentState");
            return (Criteria) this;
        }

        public Criteria andPaymentStateNotBetween(Integer value1, Integer value2) {
            addCriterion("payment_state not between", value1, value2, "paymentState");
            return (Criteria) this;
        }

        public Criteria andPaymentTypeIsNull() {
            addCriterion("payment_type is null");
            return (Criteria) this;
        }

        public Criteria andPaymentTypeIsNotNull() {
            addCriterion("payment_type is not null");
            return (Criteria) this;
        }

        public Criteria andPaymentTypeEqualTo(Integer value) {
            addCriterion("payment_type =", value, "paymentType");
            return (Criteria) this;
        }

        public Criteria andPaymentTypeNotEqualTo(Integer value) {
            addCriterion("payment_type <>", value, "paymentType");
            return (Criteria) this;
        }

        public Criteria andPaymentTypeGreaterThan(Integer value) {
            addCriterion("payment_type >", value, "paymentType");
            return (Criteria) this;
        }

        public Criteria andPaymentTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("payment_type >=", value, "paymentType");
            return (Criteria) this;
        }

        public Criteria andPaymentTypeLessThan(Integer value) {
            addCriterion("payment_type <", value, "paymentType");
            return (Criteria) this;
        }

        public Criteria andPaymentTypeLessThanOrEqualTo(Integer value) {
            addCriterion("payment_type <=", value, "paymentType");
            return (Criteria) this;
        }

        public Criteria andPaymentTypeIn(List<Integer> values) {
            addCriterion("payment_type in", values, "paymentType");
            return (Criteria) this;
        }

        public Criteria andPaymentTypeNotIn(List<Integer> values) {
            addCriterion("payment_type not in", values, "paymentType");
            return (Criteria) this;
        }

        public Criteria andPaymentTypeBetween(Integer value1, Integer value2) {
            addCriterion("payment_type between", value1, value2, "paymentType");
            return (Criteria) this;
        }

        public Criteria andPaymentTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("payment_type not between", value1, value2, "paymentType");
            return (Criteria) this;
        }

        public Criteria andPaymentCodeIsNull() {
            addCriterion("payment_code is null");
            return (Criteria) this;
        }

        public Criteria andPaymentCodeIsNotNull() {
            addCriterion("payment_code is not null");
            return (Criteria) this;
        }

        public Criteria andPaymentCodeEqualTo(String value) {
            addCriterion("payment_code =", value, "paymentCode");
            return (Criteria) this;
        }

        public Criteria andPaymentCodeNotEqualTo(String value) {
            addCriterion("payment_code <>", value, "paymentCode");
            return (Criteria) this;
        }

        public Criteria andPaymentCodeGreaterThan(String value) {
            addCriterion("payment_code >", value, "paymentCode");
            return (Criteria) this;
        }

        public Criteria andPaymentCodeGreaterThanOrEqualTo(String value) {
            addCriterion("payment_code >=", value, "paymentCode");
            return (Criteria) this;
        }

        public Criteria andPaymentCodeLessThan(String value) {
            addCriterion("payment_code <", value, "paymentCode");
            return (Criteria) this;
        }

        public Criteria andPaymentCodeLessThanOrEqualTo(String value) {
            addCriterion("payment_code <=", value, "paymentCode");
            return (Criteria) this;
        }

        public Criteria andPaymentCodeLike(String value) {
            addCriterion("payment_code like", value, "paymentCode");
            return (Criteria) this;
        }

        public Criteria andPaymentCodeNotLike(String value) {
            addCriterion("payment_code not like", value, "paymentCode");
            return (Criteria) this;
        }

        public Criteria andPaymentCodeIn(List<String> values) {
            addCriterion("payment_code in", values, "paymentCode");
            return (Criteria) this;
        }

        public Criteria andPaymentCodeNotIn(List<String> values) {
            addCriterion("payment_code not in", values, "paymentCode");
            return (Criteria) this;
        }

        public Criteria andPaymentCodeBetween(String value1, String value2) {
            addCriterion("payment_code between", value1, value2, "paymentCode");
            return (Criteria) this;
        }

        public Criteria andPaymentCodeNotBetween(String value1, String value2) {
            addCriterion("payment_code not between", value1, value2, "paymentCode");
            return (Criteria) this;
        }

        public Criteria andPaymentGatewayIdIsNull() {
            addCriterion("payment_gateway_id is null");
            return (Criteria) this;
        }

        public Criteria andPaymentGatewayIdIsNotNull() {
            addCriterion("payment_gateway_id is not null");
            return (Criteria) this;
        }

        public Criteria andPaymentGatewayIdEqualTo(Long value) {
            addCriterion("payment_gateway_id =", value, "paymentGatewayId");
            return (Criteria) this;
        }

        public Criteria andPaymentGatewayIdNotEqualTo(Long value) {
            addCriterion("payment_gateway_id <>", value, "paymentGatewayId");
            return (Criteria) this;
        }

        public Criteria andPaymentGatewayIdGreaterThan(Long value) {
            addCriterion("payment_gateway_id >", value, "paymentGatewayId");
            return (Criteria) this;
        }

        public Criteria andPaymentGatewayIdGreaterThanOrEqualTo(Long value) {
            addCriterion("payment_gateway_id >=", value, "paymentGatewayId");
            return (Criteria) this;
        }

        public Criteria andPaymentGatewayIdLessThan(Long value) {
            addCriterion("payment_gateway_id <", value, "paymentGatewayId");
            return (Criteria) this;
        }

        public Criteria andPaymentGatewayIdLessThanOrEqualTo(Long value) {
            addCriterion("payment_gateway_id <=", value, "paymentGatewayId");
            return (Criteria) this;
        }

        public Criteria andPaymentGatewayIdIn(List<Long> values) {
            addCriterion("payment_gateway_id in", values, "paymentGatewayId");
            return (Criteria) this;
        }

        public Criteria andPaymentGatewayIdNotIn(List<Long> values) {
            addCriterion("payment_gateway_id not in", values, "paymentGatewayId");
            return (Criteria) this;
        }

        public Criteria andPaymentGatewayIdBetween(Long value1, Long value2) {
            addCriterion("payment_gateway_id between", value1, value2, "paymentGatewayId");
            return (Criteria) this;
        }

        public Criteria andPaymentGatewayIdNotBetween(Long value1, Long value2) {
            addCriterion("payment_gateway_id not between", value1, value2, "paymentGatewayId");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andOrderStateIsNull() {
            addCriterion("order_state is null");
            return (Criteria) this;
        }

        public Criteria andOrderStateIsNotNull() {
            addCriterion("order_state is not null");
            return (Criteria) this;
        }

        public Criteria andOrderStateEqualTo(Integer value) {
            addCriterion("order_state =", value, "orderState");
            return (Criteria) this;
        }

        public Criteria andOrderStateNotEqualTo(Integer value) {
            addCriterion("order_state <>", value, "orderState");
            return (Criteria) this;
        }

        public Criteria andOrderStateGreaterThan(Integer value) {
            addCriterion("order_state >", value, "orderState");
            return (Criteria) this;
        }

        public Criteria andOrderStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("order_state >=", value, "orderState");
            return (Criteria) this;
        }

        public Criteria andOrderStateLessThan(Integer value) {
            addCriterion("order_state <", value, "orderState");
            return (Criteria) this;
        }

        public Criteria andOrderStateLessThanOrEqualTo(Integer value) {
            addCriterion("order_state <=", value, "orderState");
            return (Criteria) this;
        }

        public Criteria andOrderStateIn(List<Integer> values) {
            addCriterion("order_state in", values, "orderState");
            return (Criteria) this;
        }

        public Criteria andOrderStateNotIn(List<Integer> values) {
            addCriterion("order_state not in", values, "orderState");
            return (Criteria) this;
        }

        public Criteria andOrderStateBetween(Integer value1, Integer value2) {
            addCriterion("order_state between", value1, value2, "orderState");
            return (Criteria) this;
        }

        public Criteria andOrderStateNotBetween(Integer value1, Integer value2) {
            addCriterion("order_state not between", value1, value2, "orderState");
            return (Criteria) this;
        }

        public Criteria andOrderNeedInvoiceIsNull() {
            addCriterion("order_need_invoice is null");
            return (Criteria) this;
        }

        public Criteria andOrderNeedInvoiceIsNotNull() {
            addCriterion("order_need_invoice is not null");
            return (Criteria) this;
        }

        public Criteria andOrderNeedInvoiceEqualTo(Integer value) {
            addCriterion("order_need_invoice =", value, "orderNeedInvoice");
            return (Criteria) this;
        }

        public Criteria andOrderNeedInvoiceNotEqualTo(Integer value) {
            addCriterion("order_need_invoice <>", value, "orderNeedInvoice");
            return (Criteria) this;
        }

        public Criteria andOrderNeedInvoiceGreaterThan(Integer value) {
            addCriterion("order_need_invoice >", value, "orderNeedInvoice");
            return (Criteria) this;
        }

        public Criteria andOrderNeedInvoiceGreaterThanOrEqualTo(Integer value) {
            addCriterion("order_need_invoice >=", value, "orderNeedInvoice");
            return (Criteria) this;
        }

        public Criteria andOrderNeedInvoiceLessThan(Integer value) {
            addCriterion("order_need_invoice <", value, "orderNeedInvoice");
            return (Criteria) this;
        }

        public Criteria andOrderNeedInvoiceLessThanOrEqualTo(Integer value) {
            addCriterion("order_need_invoice <=", value, "orderNeedInvoice");
            return (Criteria) this;
        }

        public Criteria andOrderNeedInvoiceIn(List<Integer> values) {
            addCriterion("order_need_invoice in", values, "orderNeedInvoice");
            return (Criteria) this;
        }

        public Criteria andOrderNeedInvoiceNotIn(List<Integer> values) {
            addCriterion("order_need_invoice not in", values, "orderNeedInvoice");
            return (Criteria) this;
        }

        public Criteria andOrderNeedInvoiceBetween(Integer value1, Integer value2) {
            addCriterion("order_need_invoice between", value1, value2, "orderNeedInvoice");
            return (Criteria) this;
        }

        public Criteria andOrderNeedInvoiceNotBetween(Integer value1, Integer value2) {
            addCriterion("order_need_invoice not between", value1, value2, "orderNeedInvoice");
            return (Criteria) this;
        }

        public Criteria andInvoiceStateIsNull() {
            addCriterion("invoice_state is null");
            return (Criteria) this;
        }

        public Criteria andInvoiceStateIsNotNull() {
            addCriterion("invoice_state is not null");
            return (Criteria) this;
        }

        public Criteria andInvoiceStateEqualTo(Integer value) {
            addCriterion("invoice_state =", value, "invoiceState");
            return (Criteria) this;
        }

        public Criteria andInvoiceStateNotEqualTo(Integer value) {
            addCriterion("invoice_state <>", value, "invoiceState");
            return (Criteria) this;
        }

        public Criteria andInvoiceStateGreaterThan(Integer value) {
            addCriterion("invoice_state >", value, "invoiceState");
            return (Criteria) this;
        }

        public Criteria andInvoiceStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("invoice_state >=", value, "invoiceState");
            return (Criteria) this;
        }

        public Criteria andInvoiceStateLessThan(Integer value) {
            addCriterion("invoice_state <", value, "invoiceState");
            return (Criteria) this;
        }

        public Criteria andInvoiceStateLessThanOrEqualTo(Integer value) {
            addCriterion("invoice_state <=", value, "invoiceState");
            return (Criteria) this;
        }

        public Criteria andInvoiceStateIn(List<Integer> values) {
            addCriterion("invoice_state in", values, "invoiceState");
            return (Criteria) this;
        }

        public Criteria andInvoiceStateNotIn(List<Integer> values) {
            addCriterion("invoice_state not in", values, "invoiceState");
            return (Criteria) this;
        }

        public Criteria andInvoiceStateBetween(Integer value1, Integer value2) {
            addCriterion("invoice_state between", value1, value2, "invoiceState");
            return (Criteria) this;
        }

        public Criteria andInvoiceStateNotBetween(Integer value1, Integer value2) {
            addCriterion("invoice_state not between", value1, value2, "invoiceState");
            return (Criteria) this;
        }

        public Criteria andDeliveryDateIsNull() {
            addCriterion("delivery_date is null");
            return (Criteria) this;
        }

        public Criteria andDeliveryDateIsNotNull() {
            addCriterion("delivery_date is not null");
            return (Criteria) this;
        }

        public Criteria andDeliveryDateEqualTo(Date value) {
            addCriterion("delivery_date =", value, "deliveryDate");
            return (Criteria) this;
        }

        public Criteria andDeliveryDateNotEqualTo(Date value) {
            addCriterion("delivery_date <>", value, "deliveryDate");
            return (Criteria) this;
        }

        public Criteria andDeliveryDateGreaterThan(Date value) {
            addCriterion("delivery_date >", value, "deliveryDate");
            return (Criteria) this;
        }

        public Criteria andDeliveryDateGreaterThanOrEqualTo(Date value) {
            addCriterion("delivery_date >=", value, "deliveryDate");
            return (Criteria) this;
        }

        public Criteria andDeliveryDateLessThan(Date value) {
            addCriterion("delivery_date <", value, "deliveryDate");
            return (Criteria) this;
        }

        public Criteria andDeliveryDateLessThanOrEqualTo(Date value) {
            addCriterion("delivery_date <=", value, "deliveryDate");
            return (Criteria) this;
        }

        public Criteria andDeliveryDateIn(List<Date> values) {
            addCriterion("delivery_date in", values, "deliveryDate");
            return (Criteria) this;
        }

        public Criteria andDeliveryDateNotIn(List<Date> values) {
            addCriterion("delivery_date not in", values, "deliveryDate");
            return (Criteria) this;
        }

        public Criteria andDeliveryDateBetween(Date value1, Date value2) {
            addCriterion("delivery_date between", value1, value2, "deliveryDate");
            return (Criteria) this;
        }

        public Criteria andDeliveryDateNotBetween(Date value1, Date value2) {
            addCriterion("delivery_date not between", value1, value2, "deliveryDate");
            return (Criteria) this;
        }

        public Criteria andReceiveDateIsNull() {
            addCriterion("receive_date is null");
            return (Criteria) this;
        }

        public Criteria andReceiveDateIsNotNull() {
            addCriterion("receive_date is not null");
            return (Criteria) this;
        }

        public Criteria andReceiveDateEqualTo(Date value) {
            addCriterion("receive_date =", value, "receiveDate");
            return (Criteria) this;
        }

        public Criteria andReceiveDateNotEqualTo(Date value) {
            addCriterion("receive_date <>", value, "receiveDate");
            return (Criteria) this;
        }

        public Criteria andReceiveDateGreaterThan(Date value) {
            addCriterion("receive_date >", value, "receiveDate");
            return (Criteria) this;
        }

        public Criteria andReceiveDateGreaterThanOrEqualTo(Date value) {
            addCriterion("receive_date >=", value, "receiveDate");
            return (Criteria) this;
        }

        public Criteria andReceiveDateLessThan(Date value) {
            addCriterion("receive_date <", value, "receiveDate");
            return (Criteria) this;
        }

        public Criteria andReceiveDateLessThanOrEqualTo(Date value) {
            addCriterion("receive_date <=", value, "receiveDate");
            return (Criteria) this;
        }

        public Criteria andReceiveDateIn(List<Date> values) {
            addCriterion("receive_date in", values, "receiveDate");
            return (Criteria) this;
        }

        public Criteria andReceiveDateNotIn(List<Date> values) {
            addCriterion("receive_date not in", values, "receiveDate");
            return (Criteria) this;
        }

        public Criteria andReceiveDateBetween(Date value1, Date value2) {
            addCriterion("receive_date between", value1, value2, "receiveDate");
            return (Criteria) this;
        }

        public Criteria andReceiveDateNotBetween(Date value1, Date value2) {
            addCriterion("receive_date not between", value1, value2, "receiveDate");
            return (Criteria) this;
        }

        public Criteria andDeliveryTypeIsNull() {
            addCriterion("delivery_type is null");
            return (Criteria) this;
        }

        public Criteria andDeliveryTypeIsNotNull() {
            addCriterion("delivery_type is not null");
            return (Criteria) this;
        }

        public Criteria andDeliveryTypeEqualTo(Long value) {
            addCriterion("delivery_type =", value, "deliveryType");
            return (Criteria) this;
        }

        public Criteria andDeliveryTypeNotEqualTo(Long value) {
            addCriterion("delivery_type <>", value, "deliveryType");
            return (Criteria) this;
        }

        public Criteria andDeliveryTypeGreaterThan(Long value) {
            addCriterion("delivery_type >", value, "deliveryType");
            return (Criteria) this;
        }

        public Criteria andDeliveryTypeGreaterThanOrEqualTo(Long value) {
            addCriterion("delivery_type >=", value, "deliveryType");
            return (Criteria) this;
        }

        public Criteria andDeliveryTypeLessThan(Long value) {
            addCriterion("delivery_type <", value, "deliveryType");
            return (Criteria) this;
        }

        public Criteria andDeliveryTypeLessThanOrEqualTo(Long value) {
            addCriterion("delivery_type <=", value, "deliveryType");
            return (Criteria) this;
        }

        public Criteria andDeliveryTypeIn(List<Long> values) {
            addCriterion("delivery_type in", values, "deliveryType");
            return (Criteria) this;
        }

        public Criteria andDeliveryTypeNotIn(List<Long> values) {
            addCriterion("delivery_type not in", values, "deliveryType");
            return (Criteria) this;
        }

        public Criteria andDeliveryTypeBetween(Long value1, Long value2) {
            addCriterion("delivery_type between", value1, value2, "deliveryType");
            return (Criteria) this;
        }

        public Criteria andDeliveryTypeNotBetween(Long value1, Long value2) {
            addCriterion("delivery_type not between", value1, value2, "deliveryType");
            return (Criteria) this;
        }

        public Criteria andBoughtTimesIsNull() {
            addCriterion("bought_times is null");
            return (Criteria) this;
        }

        public Criteria andBoughtTimesIsNotNull() {
            addCriterion("bought_times is not null");
            return (Criteria) this;
        }

        public Criteria andBoughtTimesEqualTo(Long value) {
            addCriterion("bought_times =", value, "boughtTimes");
            return (Criteria) this;
        }

        public Criteria andBoughtTimesNotEqualTo(Long value) {
            addCriterion("bought_times <>", value, "boughtTimes");
            return (Criteria) this;
        }

        public Criteria andBoughtTimesGreaterThan(Long value) {
            addCriterion("bought_times >", value, "boughtTimes");
            return (Criteria) this;
        }

        public Criteria andBoughtTimesGreaterThanOrEqualTo(Long value) {
            addCriterion("bought_times >=", value, "boughtTimes");
            return (Criteria) this;
        }

        public Criteria andBoughtTimesLessThan(Long value) {
            addCriterion("bought_times <", value, "boughtTimes");
            return (Criteria) this;
        }

        public Criteria andBoughtTimesLessThanOrEqualTo(Long value) {
            addCriterion("bought_times <=", value, "boughtTimes");
            return (Criteria) this;
        }

        public Criteria andBoughtTimesIn(List<Long> values) {
            addCriterion("bought_times in", values, "boughtTimes");
            return (Criteria) this;
        }

        public Criteria andBoughtTimesNotIn(List<Long> values) {
            addCriterion("bought_times not in", values, "boughtTimes");
            return (Criteria) this;
        }

        public Criteria andBoughtTimesBetween(Long value1, Long value2) {
            addCriterion("bought_times between", value1, value2, "boughtTimes");
            return (Criteria) this;
        }

        public Criteria andBoughtTimesNotBetween(Long value1, Long value2) {
            addCriterion("bought_times not between", value1, value2, "boughtTimes");
            return (Criteria) this;
        }

        public Criteria andDeliveryRemarkIsNull() {
            addCriterion("delivery_remark is null");
            return (Criteria) this;
        }

        public Criteria andDeliveryRemarkIsNotNull() {
            addCriterion("delivery_remark is not null");
            return (Criteria) this;
        }

        public Criteria andDeliveryRemarkEqualTo(String value) {
            addCriterion("delivery_remark =", value, "deliveryRemark");
            return (Criteria) this;
        }

        public Criteria andDeliveryRemarkNotEqualTo(String value) {
            addCriterion("delivery_remark <>", value, "deliveryRemark");
            return (Criteria) this;
        }

        public Criteria andDeliveryRemarkGreaterThan(String value) {
            addCriterion("delivery_remark >", value, "deliveryRemark");
            return (Criteria) this;
        }

        public Criteria andDeliveryRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("delivery_remark >=", value, "deliveryRemark");
            return (Criteria) this;
        }

        public Criteria andDeliveryRemarkLessThan(String value) {
            addCriterion("delivery_remark <", value, "deliveryRemark");
            return (Criteria) this;
        }

        public Criteria andDeliveryRemarkLessThanOrEqualTo(String value) {
            addCriterion("delivery_remark <=", value, "deliveryRemark");
            return (Criteria) this;
        }

        public Criteria andDeliveryRemarkLike(String value) {
            addCriterion("delivery_remark like", value, "deliveryRemark");
            return (Criteria) this;
        }

        public Criteria andDeliveryRemarkNotLike(String value) {
            addCriterion("delivery_remark not like", value, "deliveryRemark");
            return (Criteria) this;
        }

        public Criteria andDeliveryRemarkIn(List<String> values) {
            addCriterion("delivery_remark in", values, "deliveryRemark");
            return (Criteria) this;
        }

        public Criteria andDeliveryRemarkNotIn(List<String> values) {
            addCriterion("delivery_remark not in", values, "deliveryRemark");
            return (Criteria) this;
        }

        public Criteria andDeliveryRemarkBetween(String value1, String value2) {
            addCriterion("delivery_remark between", value1, value2, "deliveryRemark");
            return (Criteria) this;
        }

        public Criteria andDeliveryRemarkNotBetween(String value1, String value2) {
            addCriterion("delivery_remark not between", value1, value2, "deliveryRemark");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andOrderWeightIsNull() {
            addCriterion("order_weight is null");
            return (Criteria) this;
        }

        public Criteria andOrderWeightIsNotNull() {
            addCriterion("order_weight is not null");
            return (Criteria) this;
        }

        public Criteria andOrderWeightEqualTo(BigDecimal value) {
            addCriterion("order_weight =", value, "orderWeight");
            return (Criteria) this;
        }

        public Criteria andOrderWeightNotEqualTo(BigDecimal value) {
            addCriterion("order_weight <>", value, "orderWeight");
            return (Criteria) this;
        }

        public Criteria andOrderWeightGreaterThan(BigDecimal value) {
            addCriterion("order_weight >", value, "orderWeight");
            return (Criteria) this;
        }

        public Criteria andOrderWeightGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("order_weight >=", value, "orderWeight");
            return (Criteria) this;
        }

        public Criteria andOrderWeightLessThan(BigDecimal value) {
            addCriterion("order_weight <", value, "orderWeight");
            return (Criteria) this;
        }

        public Criteria andOrderWeightLessThanOrEqualTo(BigDecimal value) {
            addCriterion("order_weight <=", value, "orderWeight");
            return (Criteria) this;
        }

        public Criteria andOrderWeightIn(List<BigDecimal> values) {
            addCriterion("order_weight in", values, "orderWeight");
            return (Criteria) this;
        }

        public Criteria andOrderWeightNotIn(List<BigDecimal> values) {
            addCriterion("order_weight not in", values, "orderWeight");
            return (Criteria) this;
        }

        public Criteria andOrderWeightBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("order_weight between", value1, value2, "orderWeight");
            return (Criteria) this;
        }

        public Criteria andOrderWeightNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("order_weight not between", value1, value2, "orderWeight");
            return (Criteria) this;
        }

        public Criteria andMerchantIdIsNull() {
            addCriterion("merchant_id is null");
            return (Criteria) this;
        }

        public Criteria andMerchantIdIsNotNull() {
            addCriterion("merchant_id is not null");
            return (Criteria) this;
        }

        public Criteria andMerchantIdEqualTo(Long value) {
            addCriterion("merchant_id =", value, "merchantId");
            return (Criteria) this;
        }

        public Criteria andMerchantIdNotEqualTo(Long value) {
            addCriterion("merchant_id <>", value, "merchantId");
            return (Criteria) this;
        }

        public Criteria andMerchantIdGreaterThan(Long value) {
            addCriterion("merchant_id >", value, "merchantId");
            return (Criteria) this;
        }

        public Criteria andMerchantIdGreaterThanOrEqualTo(Long value) {
            addCriterion("merchant_id >=", value, "merchantId");
            return (Criteria) this;
        }

        public Criteria andMerchantIdLessThan(Long value) {
            addCriterion("merchant_id <", value, "merchantId");
            return (Criteria) this;
        }

        public Criteria andMerchantIdLessThanOrEqualTo(Long value) {
            addCriterion("merchant_id <=", value, "merchantId");
            return (Criteria) this;
        }

        public Criteria andMerchantIdIn(List<Long> values) {
            addCriterion("merchant_id in", values, "merchantId");
            return (Criteria) this;
        }

        public Criteria andMerchantIdNotIn(List<Long> values) {
            addCriterion("merchant_id not in", values, "merchantId");
            return (Criteria) this;
        }

        public Criteria andMerchantIdBetween(Long value1, Long value2) {
            addCriterion("merchant_id between", value1, value2, "merchantId");
            return (Criteria) this;
        }

        public Criteria andMerchantIdNotBetween(Long value1, Long value2) {
            addCriterion("merchant_id not between", value1, value2, "merchantId");
            return (Criteria) this;
        }

        public Criteria andVersionNoIsNull() {
            addCriterion("version_no is null");
            return (Criteria) this;
        }

        public Criteria andVersionNoIsNotNull() {
            addCriterion("version_no is not null");
            return (Criteria) this;
        }

        public Criteria andVersionNoEqualTo(Long value) {
            addCriterion("version_no =", value, "versionNo");
            return (Criteria) this;
        }

        public Criteria andVersionNoNotEqualTo(Long value) {
            addCriterion("version_no <>", value, "versionNo");
            return (Criteria) this;
        }

        public Criteria andVersionNoGreaterThan(Long value) {
            addCriterion("version_no >", value, "versionNo");
            return (Criteria) this;
        }

        public Criteria andVersionNoGreaterThanOrEqualTo(Long value) {
            addCriterion("version_no >=", value, "versionNo");
            return (Criteria) this;
        }

        public Criteria andVersionNoLessThan(Long value) {
            addCriterion("version_no <", value, "versionNo");
            return (Criteria) this;
        }

        public Criteria andVersionNoLessThanOrEqualTo(Long value) {
            addCriterion("version_no <=", value, "versionNo");
            return (Criteria) this;
        }

        public Criteria andVersionNoIn(List<Long> values) {
            addCriterion("version_no in", values, "versionNo");
            return (Criteria) this;
        }

        public Criteria andVersionNoNotIn(List<Long> values) {
            addCriterion("version_no not in", values, "versionNo");
            return (Criteria) this;
        }

        public Criteria andVersionNoBetween(Long value1, Long value2) {
            addCriterion("version_no between", value1, value2, "versionNo");
            return (Criteria) this;
        }

        public Criteria andVersionNoNotBetween(Long value1, Long value2) {
            addCriterion("version_no not between", value1, value2, "versionNo");
            return (Criteria) this;
        }

        public Criteria andIsDeletedIsNull() {
            addCriterion("is_deleted is null");
            return (Criteria) this;
        }

        public Criteria andIsDeletedIsNotNull() {
            addCriterion("is_deleted is not null");
            return (Criteria) this;
        }

        public Criteria andIsDeletedEqualTo(Integer value) {
            addCriterion("is_deleted =", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedNotEqualTo(Integer value) {
            addCriterion("is_deleted <>", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedGreaterThan(Integer value) {
            addCriterion("is_deleted >", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_deleted >=", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedLessThan(Integer value) {
            addCriterion("is_deleted <", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedLessThanOrEqualTo(Integer value) {
            addCriterion("is_deleted <=", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedIn(List<Integer> values) {
            addCriterion("is_deleted in", values, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedNotIn(List<Integer> values) {
            addCriterion("is_deleted not in", values, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedBetween(Integer value1, Integer value2) {
            addCriterion("is_deleted between", value1, value2, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedNotBetween(Integer value1, Integer value2) {
            addCriterion("is_deleted not between", value1, value2, "isDeleted");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}