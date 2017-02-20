package com.wqstore.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class ProductExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ProductExample() {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andProductNameIsNull() {
            addCriterion("product_name is null");
            return (Criteria) this;
        }

        public Criteria andProductNameIsNotNull() {
            addCriterion("product_name is not null");
            return (Criteria) this;
        }

        public Criteria andProductNameEqualTo(String value) {
            addCriterion("product_name =", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameNotEqualTo(String value) {
            addCriterion("product_name <>", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameGreaterThan(String value) {
            addCriterion("product_name >", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameGreaterThanOrEqualTo(String value) {
            addCriterion("product_name >=", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameLessThan(String value) {
            addCriterion("product_name <", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameLessThanOrEqualTo(String value) {
            addCriterion("product_name <=", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameLike(String value) {
            addCriterion("product_name like", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameNotLike(String value) {
            addCriterion("product_name not like", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameIn(List<String> values) {
            addCriterion("product_name in", values, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameNotIn(List<String> values) {
            addCriterion("product_name not in", values, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameBetween(String value1, String value2) {
            addCriterion("product_name between", value1, value2, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameNotBetween(String value1, String value2) {
            addCriterion("product_name not between", value1, value2, "productName");
            return (Criteria) this;
        }

        public Criteria andProductPriceIsNull() {
            addCriterion("product_price is null");
            return (Criteria) this;
        }

        public Criteria andProductPriceIsNotNull() {
            addCriterion("product_price is not null");
            return (Criteria) this;
        }

        public Criteria andProductPriceEqualTo(Double value) {
            addCriterion("product_price =", value, "productPrice");
            return (Criteria) this;
        }

        public Criteria andProductPriceNotEqualTo(Double value) {
            addCriterion("product_price <>", value, "productPrice");
            return (Criteria) this;
        }

        public Criteria andProductPriceGreaterThan(Double value) {
            addCriterion("product_price >", value, "productPrice");
            return (Criteria) this;
        }

        public Criteria andProductPriceGreaterThanOrEqualTo(Double value) {
            addCriterion("product_price >=", value, "productPrice");
            return (Criteria) this;
        }

        public Criteria andProductPriceLessThan(Double value) {
            addCriterion("product_price <", value, "productPrice");
            return (Criteria) this;
        }

        public Criteria andProductPriceLessThanOrEqualTo(Double value) {
            addCriterion("product_price <=", value, "productPrice");
            return (Criteria) this;
        }

        public Criteria andProductPriceIn(List<Double> values) {
            addCriterion("product_price in", values, "productPrice");
            return (Criteria) this;
        }

        public Criteria andProductPriceNotIn(List<Double> values) {
            addCriterion("product_price not in", values, "productPrice");
            return (Criteria) this;
        }

        public Criteria andProductPriceBetween(Double value1, Double value2) {
            addCriterion("product_price between", value1, value2, "productPrice");
            return (Criteria) this;
        }

        public Criteria andProductPriceNotBetween(Double value1, Double value2) {
            addCriterion("product_price not between", value1, value2, "productPrice");
            return (Criteria) this;
        }

        public Criteria andCategoryIdIsNull() {
            addCriterion("category_id is null");
            return (Criteria) this;
        }

        public Criteria andCategoryIdIsNotNull() {
            addCriterion("category_id is not null");
            return (Criteria) this;
        }

        public Criteria andCategoryIdEqualTo(Integer value) {
            addCriterion("category_id =", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdNotEqualTo(Integer value) {
            addCriterion("category_id <>", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdGreaterThan(Integer value) {
            addCriterion("category_id >", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("category_id >=", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdLessThan(Integer value) {
            addCriterion("category_id <", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdLessThanOrEqualTo(Integer value) {
            addCriterion("category_id <=", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdIn(List<Integer> values) {
            addCriterion("category_id in", values, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdNotIn(List<Integer> values) {
            addCriterion("category_id not in", values, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdBetween(Integer value1, Integer value2) {
            addCriterion("category_id between", value1, value2, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdNotBetween(Integer value1, Integer value2) {
            addCriterion("category_id not between", value1, value2, "categoryId");
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
            addCriterionForJDBCDate("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterionForJDBCDate("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterionForJDBCDate("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andUpdateDateIsNull() {
            addCriterion("update_date is null");
            return (Criteria) this;
        }

        public Criteria andUpdateDateIsNotNull() {
            addCriterion("update_date is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateDateEqualTo(Date value) {
            addCriterionForJDBCDate("update_date =", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("update_date <>", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateGreaterThan(Date value) {
            addCriterionForJDBCDate("update_date >", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("update_date >=", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateLessThan(Date value) {
            addCriterionForJDBCDate("update_date <", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("update_date <=", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateIn(List<Date> values) {
            addCriterionForJDBCDate("update_date in", values, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("update_date not in", values, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("update_date between", value1, value2, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("update_date not between", value1, value2, "updateDate");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdIsNull() {
            addCriterion("create_user_id is null");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdIsNotNull() {
            addCriterion("create_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdEqualTo(Integer value) {
            addCriterion("create_user_id =", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdNotEqualTo(Integer value) {
            addCriterion("create_user_id <>", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdGreaterThan(Integer value) {
            addCriterion("create_user_id >", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("create_user_id >=", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdLessThan(Integer value) {
            addCriterion("create_user_id <", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("create_user_id <=", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdIn(List<Integer> values) {
            addCriterion("create_user_id in", values, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdNotIn(List<Integer> values) {
            addCriterion("create_user_id not in", values, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdBetween(Integer value1, Integer value2) {
            addCriterion("create_user_id between", value1, value2, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("create_user_id not between", value1, value2, "createUserId");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdIsNull() {
            addCriterion("update_user_id is null");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdIsNotNull() {
            addCriterion("update_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdEqualTo(Integer value) {
            addCriterion("update_user_id =", value, "updateUserId");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdNotEqualTo(Integer value) {
            addCriterion("update_user_id <>", value, "updateUserId");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdGreaterThan(Integer value) {
            addCriterion("update_user_id >", value, "updateUserId");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("update_user_id >=", value, "updateUserId");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdLessThan(Integer value) {
            addCriterion("update_user_id <", value, "updateUserId");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("update_user_id <=", value, "updateUserId");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdIn(List<Integer> values) {
            addCriterion("update_user_id in", values, "updateUserId");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdNotIn(List<Integer> values) {
            addCriterion("update_user_id not in", values, "updateUserId");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdBetween(Integer value1, Integer value2) {
            addCriterion("update_user_id between", value1, value2, "updateUserId");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("update_user_id not between", value1, value2, "updateUserId");
            return (Criteria) this;
        }

        public Criteria andStockamountIsNull() {
            addCriterion("stockAmount is null");
            return (Criteria) this;
        }

        public Criteria andStockamountIsNotNull() {
            addCriterion("stockAmount is not null");
            return (Criteria) this;
        }

        public Criteria andStockamountEqualTo(Integer value) {
            addCriterion("stockAmount =", value, "stockamount");
            return (Criteria) this;
        }

        public Criteria andStockamountNotEqualTo(Integer value) {
            addCriterion("stockAmount <>", value, "stockamount");
            return (Criteria) this;
        }

        public Criteria andStockamountGreaterThan(Integer value) {
            addCriterion("stockAmount >", value, "stockamount");
            return (Criteria) this;
        }

        public Criteria andStockamountGreaterThanOrEqualTo(Integer value) {
            addCriterion("stockAmount >=", value, "stockamount");
            return (Criteria) this;
        }

        public Criteria andStockamountLessThan(Integer value) {
            addCriterion("stockAmount <", value, "stockamount");
            return (Criteria) this;
        }

        public Criteria andStockamountLessThanOrEqualTo(Integer value) {
            addCriterion("stockAmount <=", value, "stockamount");
            return (Criteria) this;
        }

        public Criteria andStockamountIn(List<Integer> values) {
            addCriterion("stockAmount in", values, "stockamount");
            return (Criteria) this;
        }

        public Criteria andStockamountNotIn(List<Integer> values) {
            addCriterion("stockAmount not in", values, "stockamount");
            return (Criteria) this;
        }

        public Criteria andStockamountBetween(Integer value1, Integer value2) {
            addCriterion("stockAmount between", value1, value2, "stockamount");
            return (Criteria) this;
        }

        public Criteria andStockamountNotBetween(Integer value1, Integer value2) {
            addCriterion("stockAmount not between", value1, value2, "stockamount");
            return (Criteria) this;
        }

        public Criteria andProductEnameIsNull() {
            addCriterion("PRODUCT_ENAME is null");
            return (Criteria) this;
        }

        public Criteria andProductEnameIsNotNull() {
            addCriterion("PRODUCT_ENAME is not null");
            return (Criteria) this;
        }

        public Criteria andProductEnameEqualTo(String value) {
            addCriterion("PRODUCT_ENAME =", value, "productEname");
            return (Criteria) this;
        }

        public Criteria andProductEnameNotEqualTo(String value) {
            addCriterion("PRODUCT_ENAME <>", value, "productEname");
            return (Criteria) this;
        }

        public Criteria andProductEnameGreaterThan(String value) {
            addCriterion("PRODUCT_ENAME >", value, "productEname");
            return (Criteria) this;
        }

        public Criteria andProductEnameGreaterThanOrEqualTo(String value) {
            addCriterion("PRODUCT_ENAME >=", value, "productEname");
            return (Criteria) this;
        }

        public Criteria andProductEnameLessThan(String value) {
            addCriterion("PRODUCT_ENAME <", value, "productEname");
            return (Criteria) this;
        }

        public Criteria andProductEnameLessThanOrEqualTo(String value) {
            addCriterion("PRODUCT_ENAME <=", value, "productEname");
            return (Criteria) this;
        }

        public Criteria andProductEnameLike(String value) {
            addCriterion("PRODUCT_ENAME like", value, "productEname");
            return (Criteria) this;
        }

        public Criteria andProductEnameNotLike(String value) {
            addCriterion("PRODUCT_ENAME not like", value, "productEname");
            return (Criteria) this;
        }

        public Criteria andProductEnameIn(List<String> values) {
            addCriterion("PRODUCT_ENAME in", values, "productEname");
            return (Criteria) this;
        }

        public Criteria andProductEnameNotIn(List<String> values) {
            addCriterion("PRODUCT_ENAME not in", values, "productEname");
            return (Criteria) this;
        }

        public Criteria andProductEnameBetween(String value1, String value2) {
            addCriterion("PRODUCT_ENAME between", value1, value2, "productEname");
            return (Criteria) this;
        }

        public Criteria andProductEnameNotBetween(String value1, String value2) {
            addCriterion("PRODUCT_ENAME not between", value1, value2, "productEname");
            return (Criteria) this;
        }

        public Criteria andProductCanBeChangeIsNull() {
            addCriterion("PRODUCT_CAN_BE_CHANGE is null");
            return (Criteria) this;
        }

        public Criteria andProductCanBeChangeIsNotNull() {
            addCriterion("PRODUCT_CAN_BE_CHANGE is not null");
            return (Criteria) this;
        }

        public Criteria andProductCanBeChangeEqualTo(Integer value) {
            addCriterion("PRODUCT_CAN_BE_CHANGE =", value, "productCanBeChange");
            return (Criteria) this;
        }

        public Criteria andProductCanBeChangeNotEqualTo(Integer value) {
            addCriterion("PRODUCT_CAN_BE_CHANGE <>", value, "productCanBeChange");
            return (Criteria) this;
        }

        public Criteria andProductCanBeChangeGreaterThan(Integer value) {
            addCriterion("PRODUCT_CAN_BE_CHANGE >", value, "productCanBeChange");
            return (Criteria) this;
        }

        public Criteria andProductCanBeChangeGreaterThanOrEqualTo(Integer value) {
            addCriterion("PRODUCT_CAN_BE_CHANGE >=", value, "productCanBeChange");
            return (Criteria) this;
        }

        public Criteria andProductCanBeChangeLessThan(Integer value) {
            addCriterion("PRODUCT_CAN_BE_CHANGE <", value, "productCanBeChange");
            return (Criteria) this;
        }

        public Criteria andProductCanBeChangeLessThanOrEqualTo(Integer value) {
            addCriterion("PRODUCT_CAN_BE_CHANGE <=", value, "productCanBeChange");
            return (Criteria) this;
        }

        public Criteria andProductCanBeChangeIn(List<Integer> values) {
            addCriterion("PRODUCT_CAN_BE_CHANGE in", values, "productCanBeChange");
            return (Criteria) this;
        }

        public Criteria andProductCanBeChangeNotIn(List<Integer> values) {
            addCriterion("PRODUCT_CAN_BE_CHANGE not in", values, "productCanBeChange");
            return (Criteria) this;
        }

        public Criteria andProductCanBeChangeBetween(Integer value1, Integer value2) {
            addCriterion("PRODUCT_CAN_BE_CHANGE between", value1, value2, "productCanBeChange");
            return (Criteria) this;
        }

        public Criteria andProductCanBeChangeNotBetween(Integer value1, Integer value2) {
            addCriterion("PRODUCT_CAN_BE_CHANGE not between", value1, value2, "productCanBeChange");
            return (Criteria) this;
        }

        public Criteria andProductChangeDayIsNull() {
            addCriterion("PRODUCT_CHANGE_DAY is null");
            return (Criteria) this;
        }

        public Criteria andProductChangeDayIsNotNull() {
            addCriterion("PRODUCT_CHANGE_DAY is not null");
            return (Criteria) this;
        }

        public Criteria andProductChangeDayEqualTo(Integer value) {
            addCriterion("PRODUCT_CHANGE_DAY =", value, "productChangeDay");
            return (Criteria) this;
        }

        public Criteria andProductChangeDayNotEqualTo(Integer value) {
            addCriterion("PRODUCT_CHANGE_DAY <>", value, "productChangeDay");
            return (Criteria) this;
        }

        public Criteria andProductChangeDayGreaterThan(Integer value) {
            addCriterion("PRODUCT_CHANGE_DAY >", value, "productChangeDay");
            return (Criteria) this;
        }

        public Criteria andProductChangeDayGreaterThanOrEqualTo(Integer value) {
            addCriterion("PRODUCT_CHANGE_DAY >=", value, "productChangeDay");
            return (Criteria) this;
        }

        public Criteria andProductChangeDayLessThan(Integer value) {
            addCriterion("PRODUCT_CHANGE_DAY <", value, "productChangeDay");
            return (Criteria) this;
        }

        public Criteria andProductChangeDayLessThanOrEqualTo(Integer value) {
            addCriterion("PRODUCT_CHANGE_DAY <=", value, "productChangeDay");
            return (Criteria) this;
        }

        public Criteria andProductChangeDayIn(List<Integer> values) {
            addCriterion("PRODUCT_CHANGE_DAY in", values, "productChangeDay");
            return (Criteria) this;
        }

        public Criteria andProductChangeDayNotIn(List<Integer> values) {
            addCriterion("PRODUCT_CHANGE_DAY not in", values, "productChangeDay");
            return (Criteria) this;
        }

        public Criteria andProductChangeDayBetween(Integer value1, Integer value2) {
            addCriterion("PRODUCT_CHANGE_DAY between", value1, value2, "productChangeDay");
            return (Criteria) this;
        }

        public Criteria andProductChangeDayNotBetween(Integer value1, Integer value2) {
            addCriterion("PRODUCT_CHANGE_DAY not between", value1, value2, "productChangeDay");
            return (Criteria) this;
        }

        public Criteria andProductNeedInstallationIsNull() {
            addCriterion("PRODUCT_NEED_INSTALLATION is null");
            return (Criteria) this;
        }

        public Criteria andProductNeedInstallationIsNotNull() {
            addCriterion("PRODUCT_NEED_INSTALLATION is not null");
            return (Criteria) this;
        }

        public Criteria andProductNeedInstallationEqualTo(Integer value) {
            addCriterion("PRODUCT_NEED_INSTALLATION =", value, "productNeedInstallation");
            return (Criteria) this;
        }

        public Criteria andProductNeedInstallationNotEqualTo(Integer value) {
            addCriterion("PRODUCT_NEED_INSTALLATION <>", value, "productNeedInstallation");
            return (Criteria) this;
        }

        public Criteria andProductNeedInstallationGreaterThan(Integer value) {
            addCriterion("PRODUCT_NEED_INSTALLATION >", value, "productNeedInstallation");
            return (Criteria) this;
        }

        public Criteria andProductNeedInstallationGreaterThanOrEqualTo(Integer value) {
            addCriterion("PRODUCT_NEED_INSTALLATION >=", value, "productNeedInstallation");
            return (Criteria) this;
        }

        public Criteria andProductNeedInstallationLessThan(Integer value) {
            addCriterion("PRODUCT_NEED_INSTALLATION <", value, "productNeedInstallation");
            return (Criteria) this;
        }

        public Criteria andProductNeedInstallationLessThanOrEqualTo(Integer value) {
            addCriterion("PRODUCT_NEED_INSTALLATION <=", value, "productNeedInstallation");
            return (Criteria) this;
        }

        public Criteria andProductNeedInstallationIn(List<Integer> values) {
            addCriterion("PRODUCT_NEED_INSTALLATION in", values, "productNeedInstallation");
            return (Criteria) this;
        }

        public Criteria andProductNeedInstallationNotIn(List<Integer> values) {
            addCriterion("PRODUCT_NEED_INSTALLATION not in", values, "productNeedInstallation");
            return (Criteria) this;
        }

        public Criteria andProductNeedInstallationBetween(Integer value1, Integer value2) {
            addCriterion("PRODUCT_NEED_INSTALLATION between", value1, value2, "productNeedInstallation");
            return (Criteria) this;
        }

        public Criteria andProductNeedInstallationNotBetween(Integer value1, Integer value2) {
            addCriterion("PRODUCT_NEED_INSTALLATION not between", value1, value2, "productNeedInstallation");
            return (Criteria) this;
        }

        public Criteria andEan13IsNull() {
            addCriterion("EAN13 is null");
            return (Criteria) this;
        }

        public Criteria andEan13IsNotNull() {
            addCriterion("EAN13 is not null");
            return (Criteria) this;
        }

        public Criteria andEan13EqualTo(String value) {
            addCriterion("EAN13 =", value, "ean13");
            return (Criteria) this;
        }

        public Criteria andEan13NotEqualTo(String value) {
            addCriterion("EAN13 <>", value, "ean13");
            return (Criteria) this;
        }

        public Criteria andEan13GreaterThan(String value) {
            addCriterion("EAN13 >", value, "ean13");
            return (Criteria) this;
        }

        public Criteria andEan13GreaterThanOrEqualTo(String value) {
            addCriterion("EAN13 >=", value, "ean13");
            return (Criteria) this;
        }

        public Criteria andEan13LessThan(String value) {
            addCriterion("EAN13 <", value, "ean13");
            return (Criteria) this;
        }

        public Criteria andEan13LessThanOrEqualTo(String value) {
            addCriterion("EAN13 <=", value, "ean13");
            return (Criteria) this;
        }

        public Criteria andEan13Like(String value) {
            addCriterion("EAN13 like", value, "ean13");
            return (Criteria) this;
        }

        public Criteria andEan13NotLike(String value) {
            addCriterion("EAN13 not like", value, "ean13");
            return (Criteria) this;
        }

        public Criteria andEan13In(List<String> values) {
            addCriterion("EAN13 in", values, "ean13");
            return (Criteria) this;
        }

        public Criteria andEan13NotIn(List<String> values) {
            addCriterion("EAN13 not in", values, "ean13");
            return (Criteria) this;
        }

        public Criteria andEan13Between(String value1, String value2) {
            addCriterion("EAN13 between", value1, value2, "ean13");
            return (Criteria) this;
        }

        public Criteria andEan13NotBetween(String value1, String value2) {
            addCriterion("EAN13 not between", value1, value2, "ean13");
            return (Criteria) this;
        }

        public Criteria andLengthIsNull() {
            addCriterion("LENGTH is null");
            return (Criteria) this;
        }

        public Criteria andLengthIsNotNull() {
            addCriterion("LENGTH is not null");
            return (Criteria) this;
        }

        public Criteria andLengthEqualTo(Integer value) {
            addCriterion("LENGTH =", value, "length");
            return (Criteria) this;
        }

        public Criteria andLengthNotEqualTo(Integer value) {
            addCriterion("LENGTH <>", value, "length");
            return (Criteria) this;
        }

        public Criteria andLengthGreaterThan(Integer value) {
            addCriterion("LENGTH >", value, "length");
            return (Criteria) this;
        }

        public Criteria andLengthGreaterThanOrEqualTo(Integer value) {
            addCriterion("LENGTH >=", value, "length");
            return (Criteria) this;
        }

        public Criteria andLengthLessThan(Integer value) {
            addCriterion("LENGTH <", value, "length");
            return (Criteria) this;
        }

        public Criteria andLengthLessThanOrEqualTo(Integer value) {
            addCriterion("LENGTH <=", value, "length");
            return (Criteria) this;
        }

        public Criteria andLengthIn(List<Integer> values) {
            addCriterion("LENGTH in", values, "length");
            return (Criteria) this;
        }

        public Criteria andLengthNotIn(List<Integer> values) {
            addCriterion("LENGTH not in", values, "length");
            return (Criteria) this;
        }

        public Criteria andLengthBetween(Integer value1, Integer value2) {
            addCriterion("LENGTH between", value1, value2, "length");
            return (Criteria) this;
        }

        public Criteria andLengthNotBetween(Integer value1, Integer value2) {
            addCriterion("LENGTH not between", value1, value2, "length");
            return (Criteria) this;
        }

        public Criteria andWidthIsNull() {
            addCriterion("WIDTH is null");
            return (Criteria) this;
        }

        public Criteria andWidthIsNotNull() {
            addCriterion("WIDTH is not null");
            return (Criteria) this;
        }

        public Criteria andWidthEqualTo(Integer value) {
            addCriterion("WIDTH =", value, "width");
            return (Criteria) this;
        }

        public Criteria andWidthNotEqualTo(Integer value) {
            addCriterion("WIDTH <>", value, "width");
            return (Criteria) this;
        }

        public Criteria andWidthGreaterThan(Integer value) {
            addCriterion("WIDTH >", value, "width");
            return (Criteria) this;
        }

        public Criteria andWidthGreaterThanOrEqualTo(Integer value) {
            addCriterion("WIDTH >=", value, "width");
            return (Criteria) this;
        }

        public Criteria andWidthLessThan(Integer value) {
            addCriterion("WIDTH <", value, "width");
            return (Criteria) this;
        }

        public Criteria andWidthLessThanOrEqualTo(Integer value) {
            addCriterion("WIDTH <=", value, "width");
            return (Criteria) this;
        }

        public Criteria andWidthIn(List<Integer> values) {
            addCriterion("WIDTH in", values, "width");
            return (Criteria) this;
        }

        public Criteria andWidthNotIn(List<Integer> values) {
            addCriterion("WIDTH not in", values, "width");
            return (Criteria) this;
        }

        public Criteria andWidthBetween(Integer value1, Integer value2) {
            addCriterion("WIDTH between", value1, value2, "width");
            return (Criteria) this;
        }

        public Criteria andWidthNotBetween(Integer value1, Integer value2) {
            addCriterion("WIDTH not between", value1, value2, "width");
            return (Criteria) this;
        }

        public Criteria andHeightIsNull() {
            addCriterion("HEIGHT is null");
            return (Criteria) this;
        }

        public Criteria andHeightIsNotNull() {
            addCriterion("HEIGHT is not null");
            return (Criteria) this;
        }

        public Criteria andHeightEqualTo(Integer value) {
            addCriterion("HEIGHT =", value, "height");
            return (Criteria) this;
        }

        public Criteria andHeightNotEqualTo(Integer value) {
            addCriterion("HEIGHT <>", value, "height");
            return (Criteria) this;
        }

        public Criteria andHeightGreaterThan(Integer value) {
            addCriterion("HEIGHT >", value, "height");
            return (Criteria) this;
        }

        public Criteria andHeightGreaterThanOrEqualTo(Integer value) {
            addCriterion("HEIGHT >=", value, "height");
            return (Criteria) this;
        }

        public Criteria andHeightLessThan(Integer value) {
            addCriterion("HEIGHT <", value, "height");
            return (Criteria) this;
        }

        public Criteria andHeightLessThanOrEqualTo(Integer value) {
            addCriterion("HEIGHT <=", value, "height");
            return (Criteria) this;
        }

        public Criteria andHeightIn(List<Integer> values) {
            addCriterion("HEIGHT in", values, "height");
            return (Criteria) this;
        }

        public Criteria andHeightNotIn(List<Integer> values) {
            addCriterion("HEIGHT not in", values, "height");
            return (Criteria) this;
        }

        public Criteria andHeightBetween(Integer value1, Integer value2) {
            addCriterion("HEIGHT between", value1, value2, "height");
            return (Criteria) this;
        }

        public Criteria andHeightNotBetween(Integer value1, Integer value2) {
            addCriterion("HEIGHT not between", value1, value2, "height");
            return (Criteria) this;
        }

        public Criteria andWeightIsNull() {
            addCriterion("WEIGHT is null");
            return (Criteria) this;
        }

        public Criteria andWeightIsNotNull() {
            addCriterion("WEIGHT is not null");
            return (Criteria) this;
        }

        public Criteria andWeightEqualTo(Integer value) {
            addCriterion("WEIGHT =", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightNotEqualTo(Integer value) {
            addCriterion("WEIGHT <>", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightGreaterThan(Integer value) {
            addCriterion("WEIGHT >", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightGreaterThanOrEqualTo(Integer value) {
            addCriterion("WEIGHT >=", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightLessThan(Integer value) {
            addCriterion("WEIGHT <", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightLessThanOrEqualTo(Integer value) {
            addCriterion("WEIGHT <=", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightIn(List<Integer> values) {
            addCriterion("WEIGHT in", values, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightNotIn(List<Integer> values) {
            addCriterion("WEIGHT not in", values, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightBetween(Integer value1, Integer value2) {
            addCriterion("WEIGHT between", value1, value2, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightNotBetween(Integer value1, Integer value2) {
            addCriterion("WEIGHT not between", value1, value2, "weight");
            return (Criteria) this;
        }

        public Criteria andIsDeletedIsNull() {
            addCriterion("IS_DELETED is null");
            return (Criteria) this;
        }

        public Criteria andIsDeletedIsNotNull() {
            addCriterion("IS_DELETED is not null");
            return (Criteria) this;
        }

        public Criteria andIsDeletedEqualTo(Integer value) {
            addCriterion("IS_DELETED =", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedNotEqualTo(Integer value) {
            addCriterion("IS_DELETED <>", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedGreaterThan(Integer value) {
            addCriterion("IS_DELETED >", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedGreaterThanOrEqualTo(Integer value) {
            addCriterion("IS_DELETED >=", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedLessThan(Integer value) {
            addCriterion("IS_DELETED <", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedLessThanOrEqualTo(Integer value) {
            addCriterion("IS_DELETED <=", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedIn(List<Integer> values) {
            addCriterion("IS_DELETED in", values, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedNotIn(List<Integer> values) {
            addCriterion("IS_DELETED not in", values, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedBetween(Integer value1, Integer value2) {
            addCriterion("IS_DELETED between", value1, value2, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedNotBetween(Integer value1, Integer value2) {
            addCriterion("IS_DELETED not between", value1, value2, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andVolumeIsNull() {
            addCriterion("VOLUME is null");
            return (Criteria) this;
        }

        public Criteria andVolumeIsNotNull() {
            addCriterion("VOLUME is not null");
            return (Criteria) this;
        }

        public Criteria andVolumeEqualTo(Integer value) {
            addCriterion("VOLUME =", value, "volume");
            return (Criteria) this;
        }

        public Criteria andVolumeNotEqualTo(Integer value) {
            addCriterion("VOLUME <>", value, "volume");
            return (Criteria) this;
        }

        public Criteria andVolumeGreaterThan(Integer value) {
            addCriterion("VOLUME >", value, "volume");
            return (Criteria) this;
        }

        public Criteria andVolumeGreaterThanOrEqualTo(Integer value) {
            addCriterion("VOLUME >=", value, "volume");
            return (Criteria) this;
        }

        public Criteria andVolumeLessThan(Integer value) {
            addCriterion("VOLUME <", value, "volume");
            return (Criteria) this;
        }

        public Criteria andVolumeLessThanOrEqualTo(Integer value) {
            addCriterion("VOLUME <=", value, "volume");
            return (Criteria) this;
        }

        public Criteria andVolumeIn(List<Integer> values) {
            addCriterion("VOLUME in", values, "volume");
            return (Criteria) this;
        }

        public Criteria andVolumeNotIn(List<Integer> values) {
            addCriterion("VOLUME not in", values, "volume");
            return (Criteria) this;
        }

        public Criteria andVolumeBetween(Integer value1, Integer value2) {
            addCriterion("VOLUME between", value1, value2, "volume");
            return (Criteria) this;
        }

        public Criteria andVolumeNotBetween(Integer value1, Integer value2) {
            addCriterion("VOLUME not between", value1, value2, "volume");
            return (Criteria) this;
        }

        public Criteria andCanReturnAndChangeIsNull() {
            addCriterion("CAN_RETURN_AND_CHANGE is null");
            return (Criteria) this;
        }

        public Criteria andCanReturnAndChangeIsNotNull() {
            addCriterion("CAN_RETURN_AND_CHANGE is not null");
            return (Criteria) this;
        }

        public Criteria andCanReturnAndChangeEqualTo(Integer value) {
            addCriterion("CAN_RETURN_AND_CHANGE =", value, "canReturnAndChange");
            return (Criteria) this;
        }

        public Criteria andCanReturnAndChangeNotEqualTo(Integer value) {
            addCriterion("CAN_RETURN_AND_CHANGE <>", value, "canReturnAndChange");
            return (Criteria) this;
        }

        public Criteria andCanReturnAndChangeGreaterThan(Integer value) {
            addCriterion("CAN_RETURN_AND_CHANGE >", value, "canReturnAndChange");
            return (Criteria) this;
        }

        public Criteria andCanReturnAndChangeGreaterThanOrEqualTo(Integer value) {
            addCriterion("CAN_RETURN_AND_CHANGE >=", value, "canReturnAndChange");
            return (Criteria) this;
        }

        public Criteria andCanReturnAndChangeLessThan(Integer value) {
            addCriterion("CAN_RETURN_AND_CHANGE <", value, "canReturnAndChange");
            return (Criteria) this;
        }

        public Criteria andCanReturnAndChangeLessThanOrEqualTo(Integer value) {
            addCriterion("CAN_RETURN_AND_CHANGE <=", value, "canReturnAndChange");
            return (Criteria) this;
        }

        public Criteria andCanReturnAndChangeIn(List<Integer> values) {
            addCriterion("CAN_RETURN_AND_CHANGE in", values, "canReturnAndChange");
            return (Criteria) this;
        }

        public Criteria andCanReturnAndChangeNotIn(List<Integer> values) {
            addCriterion("CAN_RETURN_AND_CHANGE not in", values, "canReturnAndChange");
            return (Criteria) this;
        }

        public Criteria andCanReturnAndChangeBetween(Integer value1, Integer value2) {
            addCriterion("CAN_RETURN_AND_CHANGE between", value1, value2, "canReturnAndChange");
            return (Criteria) this;
        }

        public Criteria andCanReturnAndChangeNotBetween(Integer value1, Integer value2) {
            addCriterion("CAN_RETURN_AND_CHANGE not between", value1, value2, "canReturnAndChange");
            return (Criteria) this;
        }

        public Criteria andIsVtaIsNull() {
            addCriterion("IS_VTA is null");
            return (Criteria) this;
        }

        public Criteria andIsVtaIsNotNull() {
            addCriterion("IS_VTA is not null");
            return (Criteria) this;
        }

        public Criteria andIsVtaEqualTo(Integer value) {
            addCriterion("IS_VTA =", value, "isVta");
            return (Criteria) this;
        }

        public Criteria andIsVtaNotEqualTo(Integer value) {
            addCriterion("IS_VTA <>", value, "isVta");
            return (Criteria) this;
        }

        public Criteria andIsVtaGreaterThan(Integer value) {
            addCriterion("IS_VTA >", value, "isVta");
            return (Criteria) this;
        }

        public Criteria andIsVtaGreaterThanOrEqualTo(Integer value) {
            addCriterion("IS_VTA >=", value, "isVta");
            return (Criteria) this;
        }

        public Criteria andIsVtaLessThan(Integer value) {
            addCriterion("IS_VTA <", value, "isVta");
            return (Criteria) this;
        }

        public Criteria andIsVtaLessThanOrEqualTo(Integer value) {
            addCriterion("IS_VTA <=", value, "isVta");
            return (Criteria) this;
        }

        public Criteria andIsVtaIn(List<Integer> values) {
            addCriterion("IS_VTA in", values, "isVta");
            return (Criteria) this;
        }

        public Criteria andIsVtaNotIn(List<Integer> values) {
            addCriterion("IS_VTA not in", values, "isVta");
            return (Criteria) this;
        }

        public Criteria andIsVtaBetween(Integer value1, Integer value2) {
            addCriterion("IS_VTA between", value1, value2, "isVta");
            return (Criteria) this;
        }

        public Criteria andIsVtaNotBetween(Integer value1, Integer value2) {
            addCriterion("IS_VTA not between", value1, value2, "isVta");
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