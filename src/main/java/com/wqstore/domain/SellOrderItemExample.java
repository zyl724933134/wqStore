package com.wqstore.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SellOrderItemExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SellOrderItemExample() {
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

        public Criteria andSoIdIsNull() {
            addCriterion("so_id is null");
            return (Criteria) this;
        }

        public Criteria andSoIdIsNotNull() {
            addCriterion("so_id is not null");
            return (Criteria) this;
        }

        public Criteria andSoIdEqualTo(Long value) {
            addCriterion("so_id =", value, "soId");
            return (Criteria) this;
        }

        public Criteria andSoIdNotEqualTo(Long value) {
            addCriterion("so_id <>", value, "soId");
            return (Criteria) this;
        }

        public Criteria andSoIdGreaterThan(Long value) {
            addCriterion("so_id >", value, "soId");
            return (Criteria) this;
        }

        public Criteria andSoIdGreaterThanOrEqualTo(Long value) {
            addCriterion("so_id >=", value, "soId");
            return (Criteria) this;
        }

        public Criteria andSoIdLessThan(Long value) {
            addCriterion("so_id <", value, "soId");
            return (Criteria) this;
        }

        public Criteria andSoIdLessThanOrEqualTo(Long value) {
            addCriterion("so_id <=", value, "soId");
            return (Criteria) this;
        }

        public Criteria andSoIdIn(List<Long> values) {
            addCriterion("so_id in", values, "soId");
            return (Criteria) this;
        }

        public Criteria andSoIdNotIn(List<Long> values) {
            addCriterion("so_id not in", values, "soId");
            return (Criteria) this;
        }

        public Criteria andSoIdBetween(Long value1, Long value2) {
            addCriterion("so_id between", value1, value2, "soId");
            return (Criteria) this;
        }

        public Criteria andSoIdNotBetween(Long value1, Long value2) {
            addCriterion("so_id not between", value1, value2, "soId");
            return (Criteria) this;
        }

        public Criteria andProductIdIsNull() {
            addCriterion("product_id is null");
            return (Criteria) this;
        }

        public Criteria andProductIdIsNotNull() {
            addCriterion("product_id is not null");
            return (Criteria) this;
        }

        public Criteria andProductIdEqualTo(Long value) {
            addCriterion("product_id =", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdNotEqualTo(Long value) {
            addCriterion("product_id <>", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdGreaterThan(Long value) {
            addCriterion("product_id >", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdGreaterThanOrEqualTo(Long value) {
            addCriterion("product_id >=", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdLessThan(Long value) {
            addCriterion("product_id <", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdLessThanOrEqualTo(Long value) {
            addCriterion("product_id <=", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdIn(List<Long> values) {
            addCriterion("product_id in", values, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdNotIn(List<Long> values) {
            addCriterion("product_id not in", values, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdBetween(Long value1, Long value2) {
            addCriterion("product_id between", value1, value2, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdNotBetween(Long value1, Long value2) {
            addCriterion("product_id not between", value1, value2, "productId");
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

        public Criteria andItemAmountIsNull() {
            addCriterion("item_amount is null");
            return (Criteria) this;
        }

        public Criteria andItemAmountIsNotNull() {
            addCriterion("item_amount is not null");
            return (Criteria) this;
        }

        public Criteria andItemAmountEqualTo(BigDecimal value) {
            addCriterion("item_amount =", value, "itemAmount");
            return (Criteria) this;
        }

        public Criteria andItemAmountNotEqualTo(BigDecimal value) {
            addCriterion("item_amount <>", value, "itemAmount");
            return (Criteria) this;
        }

        public Criteria andItemAmountGreaterThan(BigDecimal value) {
            addCriterion("item_amount >", value, "itemAmount");
            return (Criteria) this;
        }

        public Criteria andItemAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("item_amount >=", value, "itemAmount");
            return (Criteria) this;
        }

        public Criteria andItemAmountLessThan(BigDecimal value) {
            addCriterion("item_amount <", value, "itemAmount");
            return (Criteria) this;
        }

        public Criteria andItemAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("item_amount <=", value, "itemAmount");
            return (Criteria) this;
        }

        public Criteria andItemAmountIn(List<BigDecimal> values) {
            addCriterion("item_amount in", values, "itemAmount");
            return (Criteria) this;
        }

        public Criteria andItemAmountNotIn(List<BigDecimal> values) {
            addCriterion("item_amount not in", values, "itemAmount");
            return (Criteria) this;
        }

        public Criteria andItemAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("item_amount between", value1, value2, "itemAmount");
            return (Criteria) this;
        }

        public Criteria andItemAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("item_amount not between", value1, value2, "itemAmount");
            return (Criteria) this;
        }

        public Criteria andItemDealAmountIsNull() {
            addCriterion("item_deal_amount is null");
            return (Criteria) this;
        }

        public Criteria andItemDealAmountIsNotNull() {
            addCriterion("item_deal_amount is not null");
            return (Criteria) this;
        }

        public Criteria andItemDealAmountEqualTo(BigDecimal value) {
            addCriterion("item_deal_amount =", value, "itemDealAmount");
            return (Criteria) this;
        }

        public Criteria andItemDealAmountNotEqualTo(BigDecimal value) {
            addCriterion("item_deal_amount <>", value, "itemDealAmount");
            return (Criteria) this;
        }

        public Criteria andItemDealAmountGreaterThan(BigDecimal value) {
            addCriterion("item_deal_amount >", value, "itemDealAmount");
            return (Criteria) this;
        }

        public Criteria andItemDealAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("item_deal_amount >=", value, "itemDealAmount");
            return (Criteria) this;
        }

        public Criteria andItemDealAmountLessThan(BigDecimal value) {
            addCriterion("item_deal_amount <", value, "itemDealAmount");
            return (Criteria) this;
        }

        public Criteria andItemDealAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("item_deal_amount <=", value, "itemDealAmount");
            return (Criteria) this;
        }

        public Criteria andItemDealAmountIn(List<BigDecimal> values) {
            addCriterion("item_deal_amount in", values, "itemDealAmount");
            return (Criteria) this;
        }

        public Criteria andItemDealAmountNotIn(List<BigDecimal> values) {
            addCriterion("item_deal_amount not in", values, "itemDealAmount");
            return (Criteria) this;
        }

        public Criteria andItemDealAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("item_deal_amount between", value1, value2, "itemDealAmount");
            return (Criteria) this;
        }

        public Criteria andItemDealAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("item_deal_amount not between", value1, value2, "itemDealAmount");
            return (Criteria) this;
        }

        public Criteria andMarketPriceIsNull() {
            addCriterion("market_price is null");
            return (Criteria) this;
        }

        public Criteria andMarketPriceIsNotNull() {
            addCriterion("market_price is not null");
            return (Criteria) this;
        }

        public Criteria andMarketPriceEqualTo(BigDecimal value) {
            addCriterion("market_price =", value, "marketPrice");
            return (Criteria) this;
        }

        public Criteria andMarketPriceNotEqualTo(BigDecimal value) {
            addCriterion("market_price <>", value, "marketPrice");
            return (Criteria) this;
        }

        public Criteria andMarketPriceGreaterThan(BigDecimal value) {
            addCriterion("market_price >", value, "marketPrice");
            return (Criteria) this;
        }

        public Criteria andMarketPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("market_price >=", value, "marketPrice");
            return (Criteria) this;
        }

        public Criteria andMarketPriceLessThan(BigDecimal value) {
            addCriterion("market_price <", value, "marketPrice");
            return (Criteria) this;
        }

        public Criteria andMarketPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("market_price <=", value, "marketPrice");
            return (Criteria) this;
        }

        public Criteria andMarketPriceIn(List<BigDecimal> values) {
            addCriterion("market_price in", values, "marketPrice");
            return (Criteria) this;
        }

        public Criteria andMarketPriceNotIn(List<BigDecimal> values) {
            addCriterion("market_price not in", values, "marketPrice");
            return (Criteria) this;
        }

        public Criteria andMarketPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("market_price between", value1, value2, "marketPrice");
            return (Criteria) this;
        }

        public Criteria andMarketPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("market_price not between", value1, value2, "marketPrice");
            return (Criteria) this;
        }

        public Criteria andItemSalePriceIsNull() {
            addCriterion("item_sale_price is null");
            return (Criteria) this;
        }

        public Criteria andItemSalePriceIsNotNull() {
            addCriterion("item_sale_price is not null");
            return (Criteria) this;
        }

        public Criteria andItemSalePriceEqualTo(BigDecimal value) {
            addCriterion("item_sale_price =", value, "itemSalePrice");
            return (Criteria) this;
        }

        public Criteria andItemSalePriceNotEqualTo(BigDecimal value) {
            addCriterion("item_sale_price <>", value, "itemSalePrice");
            return (Criteria) this;
        }

        public Criteria andItemSalePriceGreaterThan(BigDecimal value) {
            addCriterion("item_sale_price >", value, "itemSalePrice");
            return (Criteria) this;
        }

        public Criteria andItemSalePriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("item_sale_price >=", value, "itemSalePrice");
            return (Criteria) this;
        }

        public Criteria andItemSalePriceLessThan(BigDecimal value) {
            addCriterion("item_sale_price <", value, "itemSalePrice");
            return (Criteria) this;
        }

        public Criteria andItemSalePriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("item_sale_price <=", value, "itemSalePrice");
            return (Criteria) this;
        }

        public Criteria andItemSalePriceIn(List<BigDecimal> values) {
            addCriterion("item_sale_price in", values, "itemSalePrice");
            return (Criteria) this;
        }

        public Criteria andItemSalePriceNotIn(List<BigDecimal> values) {
            addCriterion("item_sale_price not in", values, "itemSalePrice");
            return (Criteria) this;
        }

        public Criteria andItemSalePriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("item_sale_price between", value1, value2, "itemSalePrice");
            return (Criteria) this;
        }

        public Criteria andItemSalePriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("item_sale_price not between", value1, value2, "itemSalePrice");
            return (Criteria) this;
        }

        public Criteria andItemNumIsNull() {
            addCriterion("item_num is null");
            return (Criteria) this;
        }

        public Criteria andItemNumIsNotNull() {
            addCriterion("item_num is not null");
            return (Criteria) this;
        }

        public Criteria andItemNumEqualTo(Long value) {
            addCriterion("item_num =", value, "itemNum");
            return (Criteria) this;
        }

        public Criteria andItemNumNotEqualTo(Long value) {
            addCriterion("item_num <>", value, "itemNum");
            return (Criteria) this;
        }

        public Criteria andItemNumGreaterThan(Long value) {
            addCriterion("item_num >", value, "itemNum");
            return (Criteria) this;
        }

        public Criteria andItemNumGreaterThanOrEqualTo(Long value) {
            addCriterion("item_num >=", value, "itemNum");
            return (Criteria) this;
        }

        public Criteria andItemNumLessThan(Long value) {
            addCriterion("item_num <", value, "itemNum");
            return (Criteria) this;
        }

        public Criteria andItemNumLessThanOrEqualTo(Long value) {
            addCriterion("item_num <=", value, "itemNum");
            return (Criteria) this;
        }

        public Criteria andItemNumIn(List<Long> values) {
            addCriterion("item_num in", values, "itemNum");
            return (Criteria) this;
        }

        public Criteria andItemNumNotIn(List<Long> values) {
            addCriterion("item_num not in", values, "itemNum");
            return (Criteria) this;
        }

        public Criteria andItemNumBetween(Long value1, Long value2) {
            addCriterion("item_num between", value1, value2, "itemNum");
            return (Criteria) this;
        }

        public Criteria andItemNumNotBetween(Long value1, Long value2) {
            addCriterion("item_num not between", value1, value2, "itemNum");
            return (Criteria) this;
        }

        public Criteria andProductCnameIsNull() {
            addCriterion("product_cname is null");
            return (Criteria) this;
        }

        public Criteria andProductCnameIsNotNull() {
            addCriterion("product_cname is not null");
            return (Criteria) this;
        }

        public Criteria andProductCnameEqualTo(String value) {
            addCriterion("product_cname =", value, "productCname");
            return (Criteria) this;
        }

        public Criteria andProductCnameNotEqualTo(String value) {
            addCriterion("product_cname <>", value, "productCname");
            return (Criteria) this;
        }

        public Criteria andProductCnameGreaterThan(String value) {
            addCriterion("product_cname >", value, "productCname");
            return (Criteria) this;
        }

        public Criteria andProductCnameGreaterThanOrEqualTo(String value) {
            addCriterion("product_cname >=", value, "productCname");
            return (Criteria) this;
        }

        public Criteria andProductCnameLessThan(String value) {
            addCriterion("product_cname <", value, "productCname");
            return (Criteria) this;
        }

        public Criteria andProductCnameLessThanOrEqualTo(String value) {
            addCriterion("product_cname <=", value, "productCname");
            return (Criteria) this;
        }

        public Criteria andProductCnameLike(String value) {
            addCriterion("product_cname like", value, "productCname");
            return (Criteria) this;
        }

        public Criteria andProductCnameNotLike(String value) {
            addCriterion("product_cname not like", value, "productCname");
            return (Criteria) this;
        }

        public Criteria andProductCnameIn(List<String> values) {
            addCriterion("product_cname in", values, "productCname");
            return (Criteria) this;
        }

        public Criteria andProductCnameNotIn(List<String> values) {
            addCriterion("product_cname not in", values, "productCname");
            return (Criteria) this;
        }

        public Criteria andProductCnameBetween(String value1, String value2) {
            addCriterion("product_cname between", value1, value2, "productCname");
            return (Criteria) this;
        }

        public Criteria andProductCnameNotBetween(String value1, String value2) {
            addCriterion("product_cname not between", value1, value2, "productCname");
            return (Criteria) this;
        }

        public Criteria andProductEnameIsNull() {
            addCriterion("product_ename is null");
            return (Criteria) this;
        }

        public Criteria andProductEnameIsNotNull() {
            addCriterion("product_ename is not null");
            return (Criteria) this;
        }

        public Criteria andProductEnameEqualTo(String value) {
            addCriterion("product_ename =", value, "productEname");
            return (Criteria) this;
        }

        public Criteria andProductEnameNotEqualTo(String value) {
            addCriterion("product_ename <>", value, "productEname");
            return (Criteria) this;
        }

        public Criteria andProductEnameGreaterThan(String value) {
            addCriterion("product_ename >", value, "productEname");
            return (Criteria) this;
        }

        public Criteria andProductEnameGreaterThanOrEqualTo(String value) {
            addCriterion("product_ename >=", value, "productEname");
            return (Criteria) this;
        }

        public Criteria andProductEnameLessThan(String value) {
            addCriterion("product_ename <", value, "productEname");
            return (Criteria) this;
        }

        public Criteria andProductEnameLessThanOrEqualTo(String value) {
            addCriterion("product_ename <=", value, "productEname");
            return (Criteria) this;
        }

        public Criteria andProductEnameLike(String value) {
            addCriterion("product_ename like", value, "productEname");
            return (Criteria) this;
        }

        public Criteria andProductEnameNotLike(String value) {
            addCriterion("product_ename not like", value, "productEname");
            return (Criteria) this;
        }

        public Criteria andProductEnameIn(List<String> values) {
            addCriterion("product_ename in", values, "productEname");
            return (Criteria) this;
        }

        public Criteria andProductEnameNotIn(List<String> values) {
            addCriterion("product_ename not in", values, "productEname");
            return (Criteria) this;
        }

        public Criteria andProductEnameBetween(String value1, String value2) {
            addCriterion("product_ename between", value1, value2, "productEname");
            return (Criteria) this;
        }

        public Criteria andProductEnameNotBetween(String value1, String value2) {
            addCriterion("product_ename not between", value1, value2, "productEname");
            return (Criteria) this;
        }

        public Criteria andProductPicUrlIsNull() {
            addCriterion("product_pic_url is null");
            return (Criteria) this;
        }

        public Criteria andProductPicUrlIsNotNull() {
            addCriterion("product_pic_url is not null");
            return (Criteria) this;
        }

        public Criteria andProductPicUrlEqualTo(String value) {
            addCriterion("product_pic_url =", value, "productPicUrl");
            return (Criteria) this;
        }

        public Criteria andProductPicUrlNotEqualTo(String value) {
            addCriterion("product_pic_url <>", value, "productPicUrl");
            return (Criteria) this;
        }

        public Criteria andProductPicUrlGreaterThan(String value) {
            addCriterion("product_pic_url >", value, "productPicUrl");
            return (Criteria) this;
        }

        public Criteria andProductPicUrlGreaterThanOrEqualTo(String value) {
            addCriterion("product_pic_url >=", value, "productPicUrl");
            return (Criteria) this;
        }

        public Criteria andProductPicUrlLessThan(String value) {
            addCriterion("product_pic_url <", value, "productPicUrl");
            return (Criteria) this;
        }

        public Criteria andProductPicUrlLessThanOrEqualTo(String value) {
            addCriterion("product_pic_url <=", value, "productPicUrl");
            return (Criteria) this;
        }

        public Criteria andProductPicUrlLike(String value) {
            addCriterion("product_pic_url like", value, "productPicUrl");
            return (Criteria) this;
        }

        public Criteria andProductPicUrlNotLike(String value) {
            addCriterion("product_pic_url not like", value, "productPicUrl");
            return (Criteria) this;
        }

        public Criteria andProductPicUrlIn(List<String> values) {
            addCriterion("product_pic_url in", values, "productPicUrl");
            return (Criteria) this;
        }

        public Criteria andProductPicUrlNotIn(List<String> values) {
            addCriterion("product_pic_url not in", values, "productPicUrl");
            return (Criteria) this;
        }

        public Criteria andProductPicUrlBetween(String value1, String value2) {
            addCriterion("product_pic_url between", value1, value2, "productPicUrl");
            return (Criteria) this;
        }

        public Criteria andProductPicUrlNotBetween(String value1, String value2) {
            addCriterion("product_pic_url not between", value1, value2, "productPicUrl");
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