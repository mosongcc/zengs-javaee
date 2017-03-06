package com.unionlive.app.entity;

import java.util.ArrayList;
import java.util.List;

public class WmOrderInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public WmOrderInfoExample() {
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

        public Criteria andOrgIdIsNull() {
            addCriterion("ORG_ID is null");
            return (Criteria) this;
        }

        public Criteria andOrgIdIsNotNull() {
            addCriterion("ORG_ID is not null");
            return (Criteria) this;
        }

        public Criteria andOrgIdEqualTo(String value) {
            addCriterion("ORG_ID =", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdNotEqualTo(String value) {
            addCriterion("ORG_ID <>", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdGreaterThan(String value) {
            addCriterion("ORG_ID >", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdGreaterThanOrEqualTo(String value) {
            addCriterion("ORG_ID >=", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdLessThan(String value) {
            addCriterion("ORG_ID <", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdLessThanOrEqualTo(String value) {
            addCriterion("ORG_ID <=", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdLike(String value) {
            addCriterion("ORG_ID like", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdNotLike(String value) {
            addCriterion("ORG_ID not like", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdIn(List<String> values) {
            addCriterion("ORG_ID in", values, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdNotIn(List<String> values) {
            addCriterion("ORG_ID not in", values, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdBetween(String value1, String value2) {
            addCriterion("ORG_ID between", value1, value2, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdNotBetween(String value1, String value2) {
            addCriterion("ORG_ID not between", value1, value2, "orgId");
            return (Criteria) this;
        }

        public Criteria andMercIdIsNull() {
            addCriterion("MERC_ID is null");
            return (Criteria) this;
        }

        public Criteria andMercIdIsNotNull() {
            addCriterion("MERC_ID is not null");
            return (Criteria) this;
        }

        public Criteria andMercIdEqualTo(String value) {
            addCriterion("MERC_ID =", value, "mercId");
            return (Criteria) this;
        }

        public Criteria andMercIdNotEqualTo(String value) {
            addCriterion("MERC_ID <>", value, "mercId");
            return (Criteria) this;
        }

        public Criteria andMercIdGreaterThan(String value) {
            addCriterion("MERC_ID >", value, "mercId");
            return (Criteria) this;
        }

        public Criteria andMercIdGreaterThanOrEqualTo(String value) {
            addCriterion("MERC_ID >=", value, "mercId");
            return (Criteria) this;
        }

        public Criteria andMercIdLessThan(String value) {
            addCriterion("MERC_ID <", value, "mercId");
            return (Criteria) this;
        }

        public Criteria andMercIdLessThanOrEqualTo(String value) {
            addCriterion("MERC_ID <=", value, "mercId");
            return (Criteria) this;
        }

        public Criteria andMercIdLike(String value) {
            addCriterion("MERC_ID like", value, "mercId");
            return (Criteria) this;
        }

        public Criteria andMercIdNotLike(String value) {
            addCriterion("MERC_ID not like", value, "mercId");
            return (Criteria) this;
        }

        public Criteria andMercIdIn(List<String> values) {
            addCriterion("MERC_ID in", values, "mercId");
            return (Criteria) this;
        }

        public Criteria andMercIdNotIn(List<String> values) {
            addCriterion("MERC_ID not in", values, "mercId");
            return (Criteria) this;
        }

        public Criteria andMercIdBetween(String value1, String value2) {
            addCriterion("MERC_ID between", value1, value2, "mercId");
            return (Criteria) this;
        }

        public Criteria andMercIdNotBetween(String value1, String value2) {
            addCriterion("MERC_ID not between", value1, value2, "mercId");
            return (Criteria) this;
        }

        public Criteria andShopIdIsNull() {
            addCriterion("SHOP_ID is null");
            return (Criteria) this;
        }

        public Criteria andShopIdIsNotNull() {
            addCriterion("SHOP_ID is not null");
            return (Criteria) this;
        }

        public Criteria andShopIdEqualTo(String value) {
            addCriterion("SHOP_ID =", value, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdNotEqualTo(String value) {
            addCriterion("SHOP_ID <>", value, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdGreaterThan(String value) {
            addCriterion("SHOP_ID >", value, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdGreaterThanOrEqualTo(String value) {
            addCriterion("SHOP_ID >=", value, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdLessThan(String value) {
            addCriterion("SHOP_ID <", value, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdLessThanOrEqualTo(String value) {
            addCriterion("SHOP_ID <=", value, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdLike(String value) {
            addCriterion("SHOP_ID like", value, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdNotLike(String value) {
            addCriterion("SHOP_ID not like", value, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdIn(List<String> values) {
            addCriterion("SHOP_ID in", values, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdNotIn(List<String> values) {
            addCriterion("SHOP_ID not in", values, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdBetween(String value1, String value2) {
            addCriterion("SHOP_ID between", value1, value2, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdNotBetween(String value1, String value2) {
            addCriterion("SHOP_ID not between", value1, value2, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopNameIsNull() {
            addCriterion("SHOP_NAME is null");
            return (Criteria) this;
        }

        public Criteria andShopNameIsNotNull() {
            addCriterion("SHOP_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andShopNameEqualTo(String value) {
            addCriterion("SHOP_NAME =", value, "shopName");
            return (Criteria) this;
        }

        public Criteria andShopNameNotEqualTo(String value) {
            addCriterion("SHOP_NAME <>", value, "shopName");
            return (Criteria) this;
        }

        public Criteria andShopNameGreaterThan(String value) {
            addCriterion("SHOP_NAME >", value, "shopName");
            return (Criteria) this;
        }

        public Criteria andShopNameGreaterThanOrEqualTo(String value) {
            addCriterion("SHOP_NAME >=", value, "shopName");
            return (Criteria) this;
        }

        public Criteria andShopNameLessThan(String value) {
            addCriterion("SHOP_NAME <", value, "shopName");
            return (Criteria) this;
        }

        public Criteria andShopNameLessThanOrEqualTo(String value) {
            addCriterion("SHOP_NAME <=", value, "shopName");
            return (Criteria) this;
        }

        public Criteria andShopNameLike(String value) {
            addCriterion("SHOP_NAME like", value, "shopName");
            return (Criteria) this;
        }

        public Criteria andShopNameNotLike(String value) {
            addCriterion("SHOP_NAME not like", value, "shopName");
            return (Criteria) this;
        }

        public Criteria andShopNameIn(List<String> values) {
            addCriterion("SHOP_NAME in", values, "shopName");
            return (Criteria) this;
        }

        public Criteria andShopNameNotIn(List<String> values) {
            addCriterion("SHOP_NAME not in", values, "shopName");
            return (Criteria) this;
        }

        public Criteria andShopNameBetween(String value1, String value2) {
            addCriterion("SHOP_NAME between", value1, value2, "shopName");
            return (Criteria) this;
        }

        public Criteria andShopNameNotBetween(String value1, String value2) {
            addCriterion("SHOP_NAME not between", value1, value2, "shopName");
            return (Criteria) this;
        }

        public Criteria andChannelOrderidIsNull() {
            addCriterion("CHANNEL_ORDERID is null");
            return (Criteria) this;
        }

        public Criteria andChannelOrderidIsNotNull() {
            addCriterion("CHANNEL_ORDERID is not null");
            return (Criteria) this;
        }

        public Criteria andChannelOrderidEqualTo(String value) {
            addCriterion("CHANNEL_ORDERID =", value, "channelOrderid");
            return (Criteria) this;
        }

        public Criteria andChannelOrderidNotEqualTo(String value) {
            addCriterion("CHANNEL_ORDERID <>", value, "channelOrderid");
            return (Criteria) this;
        }

        public Criteria andChannelOrderidGreaterThan(String value) {
            addCriterion("CHANNEL_ORDERID >", value, "channelOrderid");
            return (Criteria) this;
        }

        public Criteria andChannelOrderidGreaterThanOrEqualTo(String value) {
            addCriterion("CHANNEL_ORDERID >=", value, "channelOrderid");
            return (Criteria) this;
        }

        public Criteria andChannelOrderidLessThan(String value) {
            addCriterion("CHANNEL_ORDERID <", value, "channelOrderid");
            return (Criteria) this;
        }

        public Criteria andChannelOrderidLessThanOrEqualTo(String value) {
            addCriterion("CHANNEL_ORDERID <=", value, "channelOrderid");
            return (Criteria) this;
        }

        public Criteria andChannelOrderidLike(String value) {
            addCriterion("CHANNEL_ORDERID like", value, "channelOrderid");
            return (Criteria) this;
        }

        public Criteria andChannelOrderidNotLike(String value) {
            addCriterion("CHANNEL_ORDERID not like", value, "channelOrderid");
            return (Criteria) this;
        }

        public Criteria andChannelOrderidIn(List<String> values) {
            addCriterion("CHANNEL_ORDERID in", values, "channelOrderid");
            return (Criteria) this;
        }

        public Criteria andChannelOrderidNotIn(List<String> values) {
            addCriterion("CHANNEL_ORDERID not in", values, "channelOrderid");
            return (Criteria) this;
        }

        public Criteria andChannelOrderidBetween(String value1, String value2) {
            addCriterion("CHANNEL_ORDERID between", value1, value2, "channelOrderid");
            return (Criteria) this;
        }

        public Criteria andChannelOrderidNotBetween(String value1, String value2) {
            addCriterion("CHANNEL_ORDERID not between", value1, value2, "channelOrderid");
            return (Criteria) this;
        }

        public Criteria andOrderIdIsNull() {
            addCriterion("ORDER_ID is null");
            return (Criteria) this;
        }

        public Criteria andOrderIdIsNotNull() {
            addCriterion("ORDER_ID is not null");
            return (Criteria) this;
        }

        public Criteria andOrderIdEqualTo(String value) {
            addCriterion("ORDER_ID =", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotEqualTo(String value) {
            addCriterion("ORDER_ID <>", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThan(String value) {
            addCriterion("ORDER_ID >", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThanOrEqualTo(String value) {
            addCriterion("ORDER_ID >=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThan(String value) {
            addCriterion("ORDER_ID <", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThanOrEqualTo(String value) {
            addCriterion("ORDER_ID <=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLike(String value) {
            addCriterion("ORDER_ID like", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotLike(String value) {
            addCriterion("ORDER_ID not like", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdIn(List<String> values) {
            addCriterion("ORDER_ID in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotIn(List<String> values) {
            addCriterion("ORDER_ID not in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdBetween(String value1, String value2) {
            addCriterion("ORDER_ID between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotBetween(String value1, String value2) {
            addCriterion("ORDER_ID not between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andViewOrderIdIsNull() {
            addCriterion("VIEW_ORDER_ID is null");
            return (Criteria) this;
        }

        public Criteria andViewOrderIdIsNotNull() {
            addCriterion("VIEW_ORDER_ID is not null");
            return (Criteria) this;
        }

        public Criteria andViewOrderIdEqualTo(String value) {
            addCriterion("VIEW_ORDER_ID =", value, "viewOrderId");
            return (Criteria) this;
        }

        public Criteria andViewOrderIdNotEqualTo(String value) {
            addCriterion("VIEW_ORDER_ID <>", value, "viewOrderId");
            return (Criteria) this;
        }

        public Criteria andViewOrderIdGreaterThan(String value) {
            addCriterion("VIEW_ORDER_ID >", value, "viewOrderId");
            return (Criteria) this;
        }

        public Criteria andViewOrderIdGreaterThanOrEqualTo(String value) {
            addCriterion("VIEW_ORDER_ID >=", value, "viewOrderId");
            return (Criteria) this;
        }

        public Criteria andViewOrderIdLessThan(String value) {
            addCriterion("VIEW_ORDER_ID <", value, "viewOrderId");
            return (Criteria) this;
        }

        public Criteria andViewOrderIdLessThanOrEqualTo(String value) {
            addCriterion("VIEW_ORDER_ID <=", value, "viewOrderId");
            return (Criteria) this;
        }

        public Criteria andViewOrderIdLike(String value) {
            addCriterion("VIEW_ORDER_ID like", value, "viewOrderId");
            return (Criteria) this;
        }

        public Criteria andViewOrderIdNotLike(String value) {
            addCriterion("VIEW_ORDER_ID not like", value, "viewOrderId");
            return (Criteria) this;
        }

        public Criteria andViewOrderIdIn(List<String> values) {
            addCriterion("VIEW_ORDER_ID in", values, "viewOrderId");
            return (Criteria) this;
        }

        public Criteria andViewOrderIdNotIn(List<String> values) {
            addCriterion("VIEW_ORDER_ID not in", values, "viewOrderId");
            return (Criteria) this;
        }

        public Criteria andViewOrderIdBetween(String value1, String value2) {
            addCriterion("VIEW_ORDER_ID between", value1, value2, "viewOrderId");
            return (Criteria) this;
        }

        public Criteria andViewOrderIdNotBetween(String value1, String value2) {
            addCriterion("VIEW_ORDER_ID not between", value1, value2, "viewOrderId");
            return (Criteria) this;
        }

        public Criteria andTimestampIsNull() {
            addCriterion("TIMESTAMP is null");
            return (Criteria) this;
        }

        public Criteria andTimestampIsNotNull() {
            addCriterion("TIMESTAMP is not null");
            return (Criteria) this;
        }

        public Criteria andTimestampEqualTo(String value) {
            addCriterion("TIMESTAMP =", value, "timestamp");
            return (Criteria) this;
        }

        public Criteria andTimestampNotEqualTo(String value) {
            addCriterion("TIMESTAMP <>", value, "timestamp");
            return (Criteria) this;
        }

        public Criteria andTimestampGreaterThan(String value) {
            addCriterion("TIMESTAMP >", value, "timestamp");
            return (Criteria) this;
        }

        public Criteria andTimestampGreaterThanOrEqualTo(String value) {
            addCriterion("TIMESTAMP >=", value, "timestamp");
            return (Criteria) this;
        }

        public Criteria andTimestampLessThan(String value) {
            addCriterion("TIMESTAMP <", value, "timestamp");
            return (Criteria) this;
        }

        public Criteria andTimestampLessThanOrEqualTo(String value) {
            addCriterion("TIMESTAMP <=", value, "timestamp");
            return (Criteria) this;
        }

        public Criteria andTimestampLike(String value) {
            addCriterion("TIMESTAMP like", value, "timestamp");
            return (Criteria) this;
        }

        public Criteria andTimestampNotLike(String value) {
            addCriterion("TIMESTAMP not like", value, "timestamp");
            return (Criteria) this;
        }

        public Criteria andTimestampIn(List<String> values) {
            addCriterion("TIMESTAMP in", values, "timestamp");
            return (Criteria) this;
        }

        public Criteria andTimestampNotIn(List<String> values) {
            addCriterion("TIMESTAMP not in", values, "timestamp");
            return (Criteria) this;
        }

        public Criteria andTimestampBetween(String value1, String value2) {
            addCriterion("TIMESTAMP between", value1, value2, "timestamp");
            return (Criteria) this;
        }

        public Criteria andTimestampNotBetween(String value1, String value2) {
            addCriterion("TIMESTAMP not between", value1, value2, "timestamp");
            return (Criteria) this;
        }

        public Criteria andOrderDateIsNull() {
            addCriterion("ORDER_DATE is null");
            return (Criteria) this;
        }

        public Criteria andOrderDateIsNotNull() {
            addCriterion("ORDER_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andOrderDateEqualTo(String value) {
            addCriterion("ORDER_DATE =", value, "orderDate");
            return (Criteria) this;
        }

        public Criteria andOrderDateNotEqualTo(String value) {
            addCriterion("ORDER_DATE <>", value, "orderDate");
            return (Criteria) this;
        }

        public Criteria andOrderDateGreaterThan(String value) {
            addCriterion("ORDER_DATE >", value, "orderDate");
            return (Criteria) this;
        }

        public Criteria andOrderDateGreaterThanOrEqualTo(String value) {
            addCriterion("ORDER_DATE >=", value, "orderDate");
            return (Criteria) this;
        }

        public Criteria andOrderDateLessThan(String value) {
            addCriterion("ORDER_DATE <", value, "orderDate");
            return (Criteria) this;
        }

        public Criteria andOrderDateLessThanOrEqualTo(String value) {
            addCriterion("ORDER_DATE <=", value, "orderDate");
            return (Criteria) this;
        }

        public Criteria andOrderDateLike(String value) {
            addCriterion("ORDER_DATE like", value, "orderDate");
            return (Criteria) this;
        }

        public Criteria andOrderDateNotLike(String value) {
            addCriterion("ORDER_DATE not like", value, "orderDate");
            return (Criteria) this;
        }

        public Criteria andOrderDateIn(List<String> values) {
            addCriterion("ORDER_DATE in", values, "orderDate");
            return (Criteria) this;
        }

        public Criteria andOrderDateNotIn(List<String> values) {
            addCriterion("ORDER_DATE not in", values, "orderDate");
            return (Criteria) this;
        }

        public Criteria andOrderDateBetween(String value1, String value2) {
            addCriterion("ORDER_DATE between", value1, value2, "orderDate");
            return (Criteria) this;
        }

        public Criteria andOrderDateNotBetween(String value1, String value2) {
            addCriterion("ORDER_DATE not between", value1, value2, "orderDate");
            return (Criteria) this;
        }

        public Criteria andOrderTimeIsNull() {
            addCriterion("ORDER_TIME is null");
            return (Criteria) this;
        }

        public Criteria andOrderTimeIsNotNull() {
            addCriterion("ORDER_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andOrderTimeEqualTo(String value) {
            addCriterion("ORDER_TIME =", value, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrderTimeNotEqualTo(String value) {
            addCriterion("ORDER_TIME <>", value, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrderTimeGreaterThan(String value) {
            addCriterion("ORDER_TIME >", value, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrderTimeGreaterThanOrEqualTo(String value) {
            addCriterion("ORDER_TIME >=", value, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrderTimeLessThan(String value) {
            addCriterion("ORDER_TIME <", value, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrderTimeLessThanOrEqualTo(String value) {
            addCriterion("ORDER_TIME <=", value, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrderTimeLike(String value) {
            addCriterion("ORDER_TIME like", value, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrderTimeNotLike(String value) {
            addCriterion("ORDER_TIME not like", value, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrderTimeIn(List<String> values) {
            addCriterion("ORDER_TIME in", values, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrderTimeNotIn(List<String> values) {
            addCriterion("ORDER_TIME not in", values, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrderTimeBetween(String value1, String value2) {
            addCriterion("ORDER_TIME between", value1, value2, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrderTimeNotBetween(String value1, String value2) {
            addCriterion("ORDER_TIME not between", value1, value2, "orderTime");
            return (Criteria) this;
        }

        public Criteria andConfirmDateIsNull() {
            addCriterion("CONFIRM_DATE is null");
            return (Criteria) this;
        }

        public Criteria andConfirmDateIsNotNull() {
            addCriterion("CONFIRM_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andConfirmDateEqualTo(String value) {
            addCriterion("CONFIRM_DATE =", value, "confirmDate");
            return (Criteria) this;
        }

        public Criteria andConfirmDateNotEqualTo(String value) {
            addCriterion("CONFIRM_DATE <>", value, "confirmDate");
            return (Criteria) this;
        }

        public Criteria andConfirmDateGreaterThan(String value) {
            addCriterion("CONFIRM_DATE >", value, "confirmDate");
            return (Criteria) this;
        }

        public Criteria andConfirmDateGreaterThanOrEqualTo(String value) {
            addCriterion("CONFIRM_DATE >=", value, "confirmDate");
            return (Criteria) this;
        }

        public Criteria andConfirmDateLessThan(String value) {
            addCriterion("CONFIRM_DATE <", value, "confirmDate");
            return (Criteria) this;
        }

        public Criteria andConfirmDateLessThanOrEqualTo(String value) {
            addCriterion("CONFIRM_DATE <=", value, "confirmDate");
            return (Criteria) this;
        }

        public Criteria andConfirmDateLike(String value) {
            addCriterion("CONFIRM_DATE like", value, "confirmDate");
            return (Criteria) this;
        }

        public Criteria andConfirmDateNotLike(String value) {
            addCriterion("CONFIRM_DATE not like", value, "confirmDate");
            return (Criteria) this;
        }

        public Criteria andConfirmDateIn(List<String> values) {
            addCriterion("CONFIRM_DATE in", values, "confirmDate");
            return (Criteria) this;
        }

        public Criteria andConfirmDateNotIn(List<String> values) {
            addCriterion("CONFIRM_DATE not in", values, "confirmDate");
            return (Criteria) this;
        }

        public Criteria andConfirmDateBetween(String value1, String value2) {
            addCriterion("CONFIRM_DATE between", value1, value2, "confirmDate");
            return (Criteria) this;
        }

        public Criteria andConfirmDateNotBetween(String value1, String value2) {
            addCriterion("CONFIRM_DATE not between", value1, value2, "confirmDate");
            return (Criteria) this;
        }

        public Criteria andConfirmTimeIsNull() {
            addCriterion("CONFIRM_TIME is null");
            return (Criteria) this;
        }

        public Criteria andConfirmTimeIsNotNull() {
            addCriterion("CONFIRM_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andConfirmTimeEqualTo(String value) {
            addCriterion("CONFIRM_TIME =", value, "confirmTime");
            return (Criteria) this;
        }

        public Criteria andConfirmTimeNotEqualTo(String value) {
            addCriterion("CONFIRM_TIME <>", value, "confirmTime");
            return (Criteria) this;
        }

        public Criteria andConfirmTimeGreaterThan(String value) {
            addCriterion("CONFIRM_TIME >", value, "confirmTime");
            return (Criteria) this;
        }

        public Criteria andConfirmTimeGreaterThanOrEqualTo(String value) {
            addCriterion("CONFIRM_TIME >=", value, "confirmTime");
            return (Criteria) this;
        }

        public Criteria andConfirmTimeLessThan(String value) {
            addCriterion("CONFIRM_TIME <", value, "confirmTime");
            return (Criteria) this;
        }

        public Criteria andConfirmTimeLessThanOrEqualTo(String value) {
            addCriterion("CONFIRM_TIME <=", value, "confirmTime");
            return (Criteria) this;
        }

        public Criteria andConfirmTimeLike(String value) {
            addCriterion("CONFIRM_TIME like", value, "confirmTime");
            return (Criteria) this;
        }

        public Criteria andConfirmTimeNotLike(String value) {
            addCriterion("CONFIRM_TIME not like", value, "confirmTime");
            return (Criteria) this;
        }

        public Criteria andConfirmTimeIn(List<String> values) {
            addCriterion("CONFIRM_TIME in", values, "confirmTime");
            return (Criteria) this;
        }

        public Criteria andConfirmTimeNotIn(List<String> values) {
            addCriterion("CONFIRM_TIME not in", values, "confirmTime");
            return (Criteria) this;
        }

        public Criteria andConfirmTimeBetween(String value1, String value2) {
            addCriterion("CONFIRM_TIME between", value1, value2, "confirmTime");
            return (Criteria) this;
        }

        public Criteria andConfirmTimeNotBetween(String value1, String value2) {
            addCriterion("CONFIRM_TIME not between", value1, value2, "confirmTime");
            return (Criteria) this;
        }

        public Criteria andTraceNoIsNull() {
            addCriterion("TRACE_NO is null");
            return (Criteria) this;
        }

        public Criteria andTraceNoIsNotNull() {
            addCriterion("TRACE_NO is not null");
            return (Criteria) this;
        }

        public Criteria andTraceNoEqualTo(String value) {
            addCriterion("TRACE_NO =", value, "traceNo");
            return (Criteria) this;
        }

        public Criteria andTraceNoNotEqualTo(String value) {
            addCriterion("TRACE_NO <>", value, "traceNo");
            return (Criteria) this;
        }

        public Criteria andTraceNoGreaterThan(String value) {
            addCriterion("TRACE_NO >", value, "traceNo");
            return (Criteria) this;
        }

        public Criteria andTraceNoGreaterThanOrEqualTo(String value) {
            addCriterion("TRACE_NO >=", value, "traceNo");
            return (Criteria) this;
        }

        public Criteria andTraceNoLessThan(String value) {
            addCriterion("TRACE_NO <", value, "traceNo");
            return (Criteria) this;
        }

        public Criteria andTraceNoLessThanOrEqualTo(String value) {
            addCriterion("TRACE_NO <=", value, "traceNo");
            return (Criteria) this;
        }

        public Criteria andTraceNoLike(String value) {
            addCriterion("TRACE_NO like", value, "traceNo");
            return (Criteria) this;
        }

        public Criteria andTraceNoNotLike(String value) {
            addCriterion("TRACE_NO not like", value, "traceNo");
            return (Criteria) this;
        }

        public Criteria andTraceNoIn(List<String> values) {
            addCriterion("TRACE_NO in", values, "traceNo");
            return (Criteria) this;
        }

        public Criteria andTraceNoNotIn(List<String> values) {
            addCriterion("TRACE_NO not in", values, "traceNo");
            return (Criteria) this;
        }

        public Criteria andTraceNoBetween(String value1, String value2) {
            addCriterion("TRACE_NO between", value1, value2, "traceNo");
            return (Criteria) this;
        }

        public Criteria andTraceNoNotBetween(String value1, String value2) {
            addCriterion("TRACE_NO not between", value1, value2, "traceNo");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("STATUS is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Short value) {
            addCriterion("STATUS =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Short value) {
            addCriterion("STATUS <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Short value) {
            addCriterion("STATUS >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Short value) {
            addCriterion("STATUS >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Short value) {
            addCriterion("STATUS <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Short value) {
            addCriterion("STATUS <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Short> values) {
            addCriterion("STATUS in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Short> values) {
            addCriterion("STATUS not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Short value1, Short value2) {
            addCriterion("STATUS between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Short value1, Short value2) {
            addCriterion("STATUS not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andSendImmediatelyIsNull() {
            addCriterion("SEND_IMMEDIATELY is null");
            return (Criteria) this;
        }

        public Criteria andSendImmediatelyIsNotNull() {
            addCriterion("SEND_IMMEDIATELY is not null");
            return (Criteria) this;
        }

        public Criteria andSendImmediatelyEqualTo(String value) {
            addCriterion("SEND_IMMEDIATELY =", value, "sendImmediately");
            return (Criteria) this;
        }

        public Criteria andSendImmediatelyNotEqualTo(String value) {
            addCriterion("SEND_IMMEDIATELY <>", value, "sendImmediately");
            return (Criteria) this;
        }

        public Criteria andSendImmediatelyGreaterThan(String value) {
            addCriterion("SEND_IMMEDIATELY >", value, "sendImmediately");
            return (Criteria) this;
        }

        public Criteria andSendImmediatelyGreaterThanOrEqualTo(String value) {
            addCriterion("SEND_IMMEDIATELY >=", value, "sendImmediately");
            return (Criteria) this;
        }

        public Criteria andSendImmediatelyLessThan(String value) {
            addCriterion("SEND_IMMEDIATELY <", value, "sendImmediately");
            return (Criteria) this;
        }

        public Criteria andSendImmediatelyLessThanOrEqualTo(String value) {
            addCriterion("SEND_IMMEDIATELY <=", value, "sendImmediately");
            return (Criteria) this;
        }

        public Criteria andSendImmediatelyLike(String value) {
            addCriterion("SEND_IMMEDIATELY like", value, "sendImmediately");
            return (Criteria) this;
        }

        public Criteria andSendImmediatelyNotLike(String value) {
            addCriterion("SEND_IMMEDIATELY not like", value, "sendImmediately");
            return (Criteria) this;
        }

        public Criteria andSendImmediatelyIn(List<String> values) {
            addCriterion("SEND_IMMEDIATELY in", values, "sendImmediately");
            return (Criteria) this;
        }

        public Criteria andSendImmediatelyNotIn(List<String> values) {
            addCriterion("SEND_IMMEDIATELY not in", values, "sendImmediately");
            return (Criteria) this;
        }

        public Criteria andSendImmediatelyBetween(String value1, String value2) {
            addCriterion("SEND_IMMEDIATELY between", value1, value2, "sendImmediately");
            return (Criteria) this;
        }

        public Criteria andSendImmediatelyNotBetween(String value1, String value2) {
            addCriterion("SEND_IMMEDIATELY not between", value1, value2, "sendImmediately");
            return (Criteria) this;
        }

        public Criteria andExpectDateIsNull() {
            addCriterion("EXPECT_DATE is null");
            return (Criteria) this;
        }

        public Criteria andExpectDateIsNotNull() {
            addCriterion("EXPECT_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andExpectDateEqualTo(String value) {
            addCriterion("EXPECT_DATE =", value, "expectDate");
            return (Criteria) this;
        }

        public Criteria andExpectDateNotEqualTo(String value) {
            addCriterion("EXPECT_DATE <>", value, "expectDate");
            return (Criteria) this;
        }

        public Criteria andExpectDateGreaterThan(String value) {
            addCriterion("EXPECT_DATE >", value, "expectDate");
            return (Criteria) this;
        }

        public Criteria andExpectDateGreaterThanOrEqualTo(String value) {
            addCriterion("EXPECT_DATE >=", value, "expectDate");
            return (Criteria) this;
        }

        public Criteria andExpectDateLessThan(String value) {
            addCriterion("EXPECT_DATE <", value, "expectDate");
            return (Criteria) this;
        }

        public Criteria andExpectDateLessThanOrEqualTo(String value) {
            addCriterion("EXPECT_DATE <=", value, "expectDate");
            return (Criteria) this;
        }

        public Criteria andExpectDateLike(String value) {
            addCriterion("EXPECT_DATE like", value, "expectDate");
            return (Criteria) this;
        }

        public Criteria andExpectDateNotLike(String value) {
            addCriterion("EXPECT_DATE not like", value, "expectDate");
            return (Criteria) this;
        }

        public Criteria andExpectDateIn(List<String> values) {
            addCriterion("EXPECT_DATE in", values, "expectDate");
            return (Criteria) this;
        }

        public Criteria andExpectDateNotIn(List<String> values) {
            addCriterion("EXPECT_DATE not in", values, "expectDate");
            return (Criteria) this;
        }

        public Criteria andExpectDateBetween(String value1, String value2) {
            addCriterion("EXPECT_DATE between", value1, value2, "expectDate");
            return (Criteria) this;
        }

        public Criteria andExpectDateNotBetween(String value1, String value2) {
            addCriterion("EXPECT_DATE not between", value1, value2, "expectDate");
            return (Criteria) this;
        }

        public Criteria andExpectTimeIsNull() {
            addCriterion("EXPECT_TIME is null");
            return (Criteria) this;
        }

        public Criteria andExpectTimeIsNotNull() {
            addCriterion("EXPECT_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andExpectTimeEqualTo(String value) {
            addCriterion("EXPECT_TIME =", value, "expectTime");
            return (Criteria) this;
        }

        public Criteria andExpectTimeNotEqualTo(String value) {
            addCriterion("EXPECT_TIME <>", value, "expectTime");
            return (Criteria) this;
        }

        public Criteria andExpectTimeGreaterThan(String value) {
            addCriterion("EXPECT_TIME >", value, "expectTime");
            return (Criteria) this;
        }

        public Criteria andExpectTimeGreaterThanOrEqualTo(String value) {
            addCriterion("EXPECT_TIME >=", value, "expectTime");
            return (Criteria) this;
        }

        public Criteria andExpectTimeLessThan(String value) {
            addCriterion("EXPECT_TIME <", value, "expectTime");
            return (Criteria) this;
        }

        public Criteria andExpectTimeLessThanOrEqualTo(String value) {
            addCriterion("EXPECT_TIME <=", value, "expectTime");
            return (Criteria) this;
        }

        public Criteria andExpectTimeLike(String value) {
            addCriterion("EXPECT_TIME like", value, "expectTime");
            return (Criteria) this;
        }

        public Criteria andExpectTimeNotLike(String value) {
            addCriterion("EXPECT_TIME not like", value, "expectTime");
            return (Criteria) this;
        }

        public Criteria andExpectTimeIn(List<String> values) {
            addCriterion("EXPECT_TIME in", values, "expectTime");
            return (Criteria) this;
        }

        public Criteria andExpectTimeNotIn(List<String> values) {
            addCriterion("EXPECT_TIME not in", values, "expectTime");
            return (Criteria) this;
        }

        public Criteria andExpectTimeBetween(String value1, String value2) {
            addCriterion("EXPECT_TIME between", value1, value2, "expectTime");
            return (Criteria) this;
        }

        public Criteria andExpectTimeNotBetween(String value1, String value2) {
            addCriterion("EXPECT_TIME not between", value1, value2, "expectTime");
            return (Criteria) this;
        }

        public Criteria andDeliverAmountIsNull() {
            addCriterion("DELIVER_AMOUNT is null");
            return (Criteria) this;
        }

        public Criteria andDeliverAmountIsNotNull() {
            addCriterion("DELIVER_AMOUNT is not null");
            return (Criteria) this;
        }

        public Criteria andDeliverAmountEqualTo(Long value) {
            addCriterion("DELIVER_AMOUNT =", value, "deliverAmount");
            return (Criteria) this;
        }

        public Criteria andDeliverAmountNotEqualTo(Long value) {
            addCriterion("DELIVER_AMOUNT <>", value, "deliverAmount");
            return (Criteria) this;
        }

        public Criteria andDeliverAmountGreaterThan(Long value) {
            addCriterion("DELIVER_AMOUNT >", value, "deliverAmount");
            return (Criteria) this;
        }

        public Criteria andDeliverAmountGreaterThanOrEqualTo(Long value) {
            addCriterion("DELIVER_AMOUNT >=", value, "deliverAmount");
            return (Criteria) this;
        }

        public Criteria andDeliverAmountLessThan(Long value) {
            addCriterion("DELIVER_AMOUNT <", value, "deliverAmount");
            return (Criteria) this;
        }

        public Criteria andDeliverAmountLessThanOrEqualTo(Long value) {
            addCriterion("DELIVER_AMOUNT <=", value, "deliverAmount");
            return (Criteria) this;
        }

        public Criteria andDeliverAmountIn(List<Long> values) {
            addCriterion("DELIVER_AMOUNT in", values, "deliverAmount");
            return (Criteria) this;
        }

        public Criteria andDeliverAmountNotIn(List<Long> values) {
            addCriterion("DELIVER_AMOUNT not in", values, "deliverAmount");
            return (Criteria) this;
        }

        public Criteria andDeliverAmountBetween(Long value1, Long value2) {
            addCriterion("DELIVER_AMOUNT between", value1, value2, "deliverAmount");
            return (Criteria) this;
        }

        public Criteria andDeliverAmountNotBetween(Long value1, Long value2) {
            addCriterion("DELIVER_AMOUNT not between", value1, value2, "deliverAmount");
            return (Criteria) this;
        }

        public Criteria andPackageAmountIsNull() {
            addCriterion("PACKAGE_AMOUNT is null");
            return (Criteria) this;
        }

        public Criteria andPackageAmountIsNotNull() {
            addCriterion("PACKAGE_AMOUNT is not null");
            return (Criteria) this;
        }

        public Criteria andPackageAmountEqualTo(Long value) {
            addCriterion("PACKAGE_AMOUNT =", value, "packageAmount");
            return (Criteria) this;
        }

        public Criteria andPackageAmountNotEqualTo(Long value) {
            addCriterion("PACKAGE_AMOUNT <>", value, "packageAmount");
            return (Criteria) this;
        }

        public Criteria andPackageAmountGreaterThan(Long value) {
            addCriterion("PACKAGE_AMOUNT >", value, "packageAmount");
            return (Criteria) this;
        }

        public Criteria andPackageAmountGreaterThanOrEqualTo(Long value) {
            addCriterion("PACKAGE_AMOUNT >=", value, "packageAmount");
            return (Criteria) this;
        }

        public Criteria andPackageAmountLessThan(Long value) {
            addCriterion("PACKAGE_AMOUNT <", value, "packageAmount");
            return (Criteria) this;
        }

        public Criteria andPackageAmountLessThanOrEqualTo(Long value) {
            addCriterion("PACKAGE_AMOUNT <=", value, "packageAmount");
            return (Criteria) this;
        }

        public Criteria andPackageAmountIn(List<Long> values) {
            addCriterion("PACKAGE_AMOUNT in", values, "packageAmount");
            return (Criteria) this;
        }

        public Criteria andPackageAmountNotIn(List<Long> values) {
            addCriterion("PACKAGE_AMOUNT not in", values, "packageAmount");
            return (Criteria) this;
        }

        public Criteria andPackageAmountBetween(Long value1, Long value2) {
            addCriterion("PACKAGE_AMOUNT between", value1, value2, "packageAmount");
            return (Criteria) this;
        }

        public Criteria andPackageAmountNotBetween(Long value1, Long value2) {
            addCriterion("PACKAGE_AMOUNT not between", value1, value2, "packageAmount");
            return (Criteria) this;
        }

        public Criteria andDiscountAmountIsNull() {
            addCriterion("DISCOUNT_AMOUNT is null");
            return (Criteria) this;
        }

        public Criteria andDiscountAmountIsNotNull() {
            addCriterion("DISCOUNT_AMOUNT is not null");
            return (Criteria) this;
        }

        public Criteria andDiscountAmountEqualTo(Long value) {
            addCriterion("DISCOUNT_AMOUNT =", value, "discountAmount");
            return (Criteria) this;
        }

        public Criteria andDiscountAmountNotEqualTo(Long value) {
            addCriterion("DISCOUNT_AMOUNT <>", value, "discountAmount");
            return (Criteria) this;
        }

        public Criteria andDiscountAmountGreaterThan(Long value) {
            addCriterion("DISCOUNT_AMOUNT >", value, "discountAmount");
            return (Criteria) this;
        }

        public Criteria andDiscountAmountGreaterThanOrEqualTo(Long value) {
            addCriterion("DISCOUNT_AMOUNT >=", value, "discountAmount");
            return (Criteria) this;
        }

        public Criteria andDiscountAmountLessThan(Long value) {
            addCriterion("DISCOUNT_AMOUNT <", value, "discountAmount");
            return (Criteria) this;
        }

        public Criteria andDiscountAmountLessThanOrEqualTo(Long value) {
            addCriterion("DISCOUNT_AMOUNT <=", value, "discountAmount");
            return (Criteria) this;
        }

        public Criteria andDiscountAmountIn(List<Long> values) {
            addCriterion("DISCOUNT_AMOUNT in", values, "discountAmount");
            return (Criteria) this;
        }

        public Criteria andDiscountAmountNotIn(List<Long> values) {
            addCriterion("DISCOUNT_AMOUNT not in", values, "discountAmount");
            return (Criteria) this;
        }

        public Criteria andDiscountAmountBetween(Long value1, Long value2) {
            addCriterion("DISCOUNT_AMOUNT between", value1, value2, "discountAmount");
            return (Criteria) this;
        }

        public Criteria andDiscountAmountNotBetween(Long value1, Long value2) {
            addCriterion("DISCOUNT_AMOUNT not between", value1, value2, "discountAmount");
            return (Criteria) this;
        }

        public Criteria andShopAmountIsNull() {
            addCriterion("SHOP_AMOUNT is null");
            return (Criteria) this;
        }

        public Criteria andShopAmountIsNotNull() {
            addCriterion("SHOP_AMOUNT is not null");
            return (Criteria) this;
        }

        public Criteria andShopAmountEqualTo(Long value) {
            addCriterion("SHOP_AMOUNT =", value, "shopAmount");
            return (Criteria) this;
        }

        public Criteria andShopAmountNotEqualTo(Long value) {
            addCriterion("SHOP_AMOUNT <>", value, "shopAmount");
            return (Criteria) this;
        }

        public Criteria andShopAmountGreaterThan(Long value) {
            addCriterion("SHOP_AMOUNT >", value, "shopAmount");
            return (Criteria) this;
        }

        public Criteria andShopAmountGreaterThanOrEqualTo(Long value) {
            addCriterion("SHOP_AMOUNT >=", value, "shopAmount");
            return (Criteria) this;
        }

        public Criteria andShopAmountLessThan(Long value) {
            addCriterion("SHOP_AMOUNT <", value, "shopAmount");
            return (Criteria) this;
        }

        public Criteria andShopAmountLessThanOrEqualTo(Long value) {
            addCriterion("SHOP_AMOUNT <=", value, "shopAmount");
            return (Criteria) this;
        }

        public Criteria andShopAmountIn(List<Long> values) {
            addCriterion("SHOP_AMOUNT in", values, "shopAmount");
            return (Criteria) this;
        }

        public Criteria andShopAmountNotIn(List<Long> values) {
            addCriterion("SHOP_AMOUNT not in", values, "shopAmount");
            return (Criteria) this;
        }

        public Criteria andShopAmountBetween(Long value1, Long value2) {
            addCriterion("SHOP_AMOUNT between", value1, value2, "shopAmount");
            return (Criteria) this;
        }

        public Criteria andShopAmountNotBetween(Long value1, Long value2) {
            addCriterion("SHOP_AMOUNT not between", value1, value2, "shopAmount");
            return (Criteria) this;
        }

        public Criteria andOrderAmountIsNull() {
            addCriterion("ORDER_AMOUNT is null");
            return (Criteria) this;
        }

        public Criteria andOrderAmountIsNotNull() {
            addCriterion("ORDER_AMOUNT is not null");
            return (Criteria) this;
        }

        public Criteria andOrderAmountEqualTo(Long value) {
            addCriterion("ORDER_AMOUNT =", value, "orderAmount");
            return (Criteria) this;
        }

        public Criteria andOrderAmountNotEqualTo(Long value) {
            addCriterion("ORDER_AMOUNT <>", value, "orderAmount");
            return (Criteria) this;
        }

        public Criteria andOrderAmountGreaterThan(Long value) {
            addCriterion("ORDER_AMOUNT >", value, "orderAmount");
            return (Criteria) this;
        }

        public Criteria andOrderAmountGreaterThanOrEqualTo(Long value) {
            addCriterion("ORDER_AMOUNT >=", value, "orderAmount");
            return (Criteria) this;
        }

        public Criteria andOrderAmountLessThan(Long value) {
            addCriterion("ORDER_AMOUNT <", value, "orderAmount");
            return (Criteria) this;
        }

        public Criteria andOrderAmountLessThanOrEqualTo(Long value) {
            addCriterion("ORDER_AMOUNT <=", value, "orderAmount");
            return (Criteria) this;
        }

        public Criteria andOrderAmountIn(List<Long> values) {
            addCriterion("ORDER_AMOUNT in", values, "orderAmount");
            return (Criteria) this;
        }

        public Criteria andOrderAmountNotIn(List<Long> values) {
            addCriterion("ORDER_AMOUNT not in", values, "orderAmount");
            return (Criteria) this;
        }

        public Criteria andOrderAmountBetween(Long value1, Long value2) {
            addCriterion("ORDER_AMOUNT between", value1, value2, "orderAmount");
            return (Criteria) this;
        }

        public Criteria andOrderAmountNotBetween(Long value1, Long value2) {
            addCriterion("ORDER_AMOUNT not between", value1, value2, "orderAmount");
            return (Criteria) this;
        }

        public Criteria andUserAmountIsNull() {
            addCriterion("USER_AMOUNT is null");
            return (Criteria) this;
        }

        public Criteria andUserAmountIsNotNull() {
            addCriterion("USER_AMOUNT is not null");
            return (Criteria) this;
        }

        public Criteria andUserAmountEqualTo(Long value) {
            addCriterion("USER_AMOUNT =", value, "userAmount");
            return (Criteria) this;
        }

        public Criteria andUserAmountNotEqualTo(Long value) {
            addCriterion("USER_AMOUNT <>", value, "userAmount");
            return (Criteria) this;
        }

        public Criteria andUserAmountGreaterThan(Long value) {
            addCriterion("USER_AMOUNT >", value, "userAmount");
            return (Criteria) this;
        }

        public Criteria andUserAmountGreaterThanOrEqualTo(Long value) {
            addCriterion("USER_AMOUNT >=", value, "userAmount");
            return (Criteria) this;
        }

        public Criteria andUserAmountLessThan(Long value) {
            addCriterion("USER_AMOUNT <", value, "userAmount");
            return (Criteria) this;
        }

        public Criteria andUserAmountLessThanOrEqualTo(Long value) {
            addCriterion("USER_AMOUNT <=", value, "userAmount");
            return (Criteria) this;
        }

        public Criteria andUserAmountIn(List<Long> values) {
            addCriterion("USER_AMOUNT in", values, "userAmount");
            return (Criteria) this;
        }

        public Criteria andUserAmountNotIn(List<Long> values) {
            addCriterion("USER_AMOUNT not in", values, "userAmount");
            return (Criteria) this;
        }

        public Criteria andUserAmountBetween(Long value1, Long value2) {
            addCriterion("USER_AMOUNT between", value1, value2, "userAmount");
            return (Criteria) this;
        }

        public Criteria andUserAmountNotBetween(Long value1, Long value2) {
            addCriterion("USER_AMOUNT not between", value1, value2, "userAmount");
            return (Criteria) this;
        }

        public Criteria andPatTypeIsNull() {
            addCriterion("PAT_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andPatTypeIsNotNull() {
            addCriterion("PAT_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andPatTypeEqualTo(String value) {
            addCriterion("PAT_TYPE =", value, "patType");
            return (Criteria) this;
        }

        public Criteria andPatTypeNotEqualTo(String value) {
            addCriterion("PAT_TYPE <>", value, "patType");
            return (Criteria) this;
        }

        public Criteria andPatTypeGreaterThan(String value) {
            addCriterion("PAT_TYPE >", value, "patType");
            return (Criteria) this;
        }

        public Criteria andPatTypeGreaterThanOrEqualTo(String value) {
            addCriterion("PAT_TYPE >=", value, "patType");
            return (Criteria) this;
        }

        public Criteria andPatTypeLessThan(String value) {
            addCriterion("PAT_TYPE <", value, "patType");
            return (Criteria) this;
        }

        public Criteria andPatTypeLessThanOrEqualTo(String value) {
            addCriterion("PAT_TYPE <=", value, "patType");
            return (Criteria) this;
        }

        public Criteria andPatTypeLike(String value) {
            addCriterion("PAT_TYPE like", value, "patType");
            return (Criteria) this;
        }

        public Criteria andPatTypeNotLike(String value) {
            addCriterion("PAT_TYPE not like", value, "patType");
            return (Criteria) this;
        }

        public Criteria andPatTypeIn(List<String> values) {
            addCriterion("PAT_TYPE in", values, "patType");
            return (Criteria) this;
        }

        public Criteria andPatTypeNotIn(List<String> values) {
            addCriterion("PAT_TYPE not in", values, "patType");
            return (Criteria) this;
        }

        public Criteria andPatTypeBetween(String value1, String value2) {
            addCriterion("PAT_TYPE between", value1, value2, "patType");
            return (Criteria) this;
        }

        public Criteria andPatTypeNotBetween(String value1, String value2) {
            addCriterion("PAT_TYPE not between", value1, value2, "patType");
            return (Criteria) this;
        }

        public Criteria andInvoiceTypeIsNull() {
            addCriterion("INVOICE_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andInvoiceTypeIsNotNull() {
            addCriterion("INVOICE_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andInvoiceTypeEqualTo(Short value) {
            addCriterion("INVOICE_TYPE =", value, "invoiceType");
            return (Criteria) this;
        }

        public Criteria andInvoiceTypeNotEqualTo(Short value) {
            addCriterion("INVOICE_TYPE <>", value, "invoiceType");
            return (Criteria) this;
        }

        public Criteria andInvoiceTypeGreaterThan(Short value) {
            addCriterion("INVOICE_TYPE >", value, "invoiceType");
            return (Criteria) this;
        }

        public Criteria andInvoiceTypeGreaterThanOrEqualTo(Short value) {
            addCriterion("INVOICE_TYPE >=", value, "invoiceType");
            return (Criteria) this;
        }

        public Criteria andInvoiceTypeLessThan(Short value) {
            addCriterion("INVOICE_TYPE <", value, "invoiceType");
            return (Criteria) this;
        }

        public Criteria andInvoiceTypeLessThanOrEqualTo(Short value) {
            addCriterion("INVOICE_TYPE <=", value, "invoiceType");
            return (Criteria) this;
        }

        public Criteria andInvoiceTypeIn(List<Short> values) {
            addCriterion("INVOICE_TYPE in", values, "invoiceType");
            return (Criteria) this;
        }

        public Criteria andInvoiceTypeNotIn(List<Short> values) {
            addCriterion("INVOICE_TYPE not in", values, "invoiceType");
            return (Criteria) this;
        }

        public Criteria andInvoiceTypeBetween(Short value1, Short value2) {
            addCriterion("INVOICE_TYPE between", value1, value2, "invoiceType");
            return (Criteria) this;
        }

        public Criteria andInvoiceTypeNotBetween(Short value1, Short value2) {
            addCriterion("INVOICE_TYPE not between", value1, value2, "invoiceType");
            return (Criteria) this;
        }

        public Criteria andInvoiceTitleIsNull() {
            addCriterion("INVOICE_TITLE is null");
            return (Criteria) this;
        }

        public Criteria andInvoiceTitleIsNotNull() {
            addCriterion("INVOICE_TITLE is not null");
            return (Criteria) this;
        }

        public Criteria andInvoiceTitleEqualTo(String value) {
            addCriterion("INVOICE_TITLE =", value, "invoiceTitle");
            return (Criteria) this;
        }

        public Criteria andInvoiceTitleNotEqualTo(String value) {
            addCriterion("INVOICE_TITLE <>", value, "invoiceTitle");
            return (Criteria) this;
        }

        public Criteria andInvoiceTitleGreaterThan(String value) {
            addCriterion("INVOICE_TITLE >", value, "invoiceTitle");
            return (Criteria) this;
        }

        public Criteria andInvoiceTitleGreaterThanOrEqualTo(String value) {
            addCriterion("INVOICE_TITLE >=", value, "invoiceTitle");
            return (Criteria) this;
        }

        public Criteria andInvoiceTitleLessThan(String value) {
            addCriterion("INVOICE_TITLE <", value, "invoiceTitle");
            return (Criteria) this;
        }

        public Criteria andInvoiceTitleLessThanOrEqualTo(String value) {
            addCriterion("INVOICE_TITLE <=", value, "invoiceTitle");
            return (Criteria) this;
        }

        public Criteria andInvoiceTitleLike(String value) {
            addCriterion("INVOICE_TITLE like", value, "invoiceTitle");
            return (Criteria) this;
        }

        public Criteria andInvoiceTitleNotLike(String value) {
            addCriterion("INVOICE_TITLE not like", value, "invoiceTitle");
            return (Criteria) this;
        }

        public Criteria andInvoiceTitleIn(List<String> values) {
            addCriterion("INVOICE_TITLE in", values, "invoiceTitle");
            return (Criteria) this;
        }

        public Criteria andInvoiceTitleNotIn(List<String> values) {
            addCriterion("INVOICE_TITLE not in", values, "invoiceTitle");
            return (Criteria) this;
        }

        public Criteria andInvoiceTitleBetween(String value1, String value2) {
            addCriterion("INVOICE_TITLE between", value1, value2, "invoiceTitle");
            return (Criteria) this;
        }

        public Criteria andInvoiceTitleNotBetween(String value1, String value2) {
            addCriterion("INVOICE_TITLE not between", value1, value2, "invoiceTitle");
            return (Criteria) this;
        }

        public Criteria andDeliveryTypeIsNull() {
            addCriterion("DELIVERY_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andDeliveryTypeIsNotNull() {
            addCriterion("DELIVERY_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andDeliveryTypeEqualTo(Short value) {
            addCriterion("DELIVERY_TYPE =", value, "deliveryType");
            return (Criteria) this;
        }

        public Criteria andDeliveryTypeNotEqualTo(Short value) {
            addCriterion("DELIVERY_TYPE <>", value, "deliveryType");
            return (Criteria) this;
        }

        public Criteria andDeliveryTypeGreaterThan(Short value) {
            addCriterion("DELIVERY_TYPE >", value, "deliveryType");
            return (Criteria) this;
        }

        public Criteria andDeliveryTypeGreaterThanOrEqualTo(Short value) {
            addCriterion("DELIVERY_TYPE >=", value, "deliveryType");
            return (Criteria) this;
        }

        public Criteria andDeliveryTypeLessThan(Short value) {
            addCriterion("DELIVERY_TYPE <", value, "deliveryType");
            return (Criteria) this;
        }

        public Criteria andDeliveryTypeLessThanOrEqualTo(Short value) {
            addCriterion("DELIVERY_TYPE <=", value, "deliveryType");
            return (Criteria) this;
        }

        public Criteria andDeliveryTypeIn(List<Short> values) {
            addCriterion("DELIVERY_TYPE in", values, "deliveryType");
            return (Criteria) this;
        }

        public Criteria andDeliveryTypeNotIn(List<Short> values) {
            addCriterion("DELIVERY_TYPE not in", values, "deliveryType");
            return (Criteria) this;
        }

        public Criteria andDeliveryTypeBetween(Short value1, Short value2) {
            addCriterion("DELIVERY_TYPE between", value1, value2, "deliveryType");
            return (Criteria) this;
        }

        public Criteria andDeliveryTypeNotBetween(Short value1, Short value2) {
            addCriterion("DELIVERY_TYPE not between", value1, value2, "deliveryType");
            return (Criteria) this;
        }

        public Criteria andUserNameIsNull() {
            addCriterion("USER_NAME is null");
            return (Criteria) this;
        }

        public Criteria andUserNameIsNotNull() {
            addCriterion("USER_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andUserNameEqualTo(String value) {
            addCriterion("USER_NAME =", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotEqualTo(String value) {
            addCriterion("USER_NAME <>", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThan(String value) {
            addCriterion("USER_NAME >", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("USER_NAME >=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThan(String value) {
            addCriterion("USER_NAME <", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThanOrEqualTo(String value) {
            addCriterion("USER_NAME <=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLike(String value) {
            addCriterion("USER_NAME like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotLike(String value) {
            addCriterion("USER_NAME not like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameIn(List<String> values) {
            addCriterion("USER_NAME in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotIn(List<String> values) {
            addCriterion("USER_NAME not in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameBetween(String value1, String value2) {
            addCriterion("USER_NAME between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotBetween(String value1, String value2) {
            addCriterion("USER_NAME not between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andUserPhoneIsNull() {
            addCriterion("USER_PHONE is null");
            return (Criteria) this;
        }

        public Criteria andUserPhoneIsNotNull() {
            addCriterion("USER_PHONE is not null");
            return (Criteria) this;
        }

        public Criteria andUserPhoneEqualTo(String value) {
            addCriterion("USER_PHONE =", value, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneNotEqualTo(String value) {
            addCriterion("USER_PHONE <>", value, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneGreaterThan(String value) {
            addCriterion("USER_PHONE >", value, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("USER_PHONE >=", value, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneLessThan(String value) {
            addCriterion("USER_PHONE <", value, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneLessThanOrEqualTo(String value) {
            addCriterion("USER_PHONE <=", value, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneLike(String value) {
            addCriterion("USER_PHONE like", value, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneNotLike(String value) {
            addCriterion("USER_PHONE not like", value, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneIn(List<String> values) {
            addCriterion("USER_PHONE in", values, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneNotIn(List<String> values) {
            addCriterion("USER_PHONE not in", values, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneBetween(String value1, String value2) {
            addCriterion("USER_PHONE between", value1, value2, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneNotBetween(String value1, String value2) {
            addCriterion("USER_PHONE not between", value1, value2, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserSexIsNull() {
            addCriterion("USER_SEX is null");
            return (Criteria) this;
        }

        public Criteria andUserSexIsNotNull() {
            addCriterion("USER_SEX is not null");
            return (Criteria) this;
        }

        public Criteria andUserSexEqualTo(Short value) {
            addCriterion("USER_SEX =", value, "userSex");
            return (Criteria) this;
        }

        public Criteria andUserSexNotEqualTo(Short value) {
            addCriterion("USER_SEX <>", value, "userSex");
            return (Criteria) this;
        }

        public Criteria andUserSexGreaterThan(Short value) {
            addCriterion("USER_SEX >", value, "userSex");
            return (Criteria) this;
        }

        public Criteria andUserSexGreaterThanOrEqualTo(Short value) {
            addCriterion("USER_SEX >=", value, "userSex");
            return (Criteria) this;
        }

        public Criteria andUserSexLessThan(Short value) {
            addCriterion("USER_SEX <", value, "userSex");
            return (Criteria) this;
        }

        public Criteria andUserSexLessThanOrEqualTo(Short value) {
            addCriterion("USER_SEX <=", value, "userSex");
            return (Criteria) this;
        }

        public Criteria andUserSexIn(List<Short> values) {
            addCriterion("USER_SEX in", values, "userSex");
            return (Criteria) this;
        }

        public Criteria andUserSexNotIn(List<Short> values) {
            addCriterion("USER_SEX not in", values, "userSex");
            return (Criteria) this;
        }

        public Criteria andUserSexBetween(Short value1, Short value2) {
            addCriterion("USER_SEX between", value1, value2, "userSex");
            return (Criteria) this;
        }

        public Criteria andUserSexNotBetween(Short value1, Short value2) {
            addCriterion("USER_SEX not between", value1, value2, "userSex");
            return (Criteria) this;
        }

        public Criteria andUserAddrIsNull() {
            addCriterion("USER_ADDR is null");
            return (Criteria) this;
        }

        public Criteria andUserAddrIsNotNull() {
            addCriterion("USER_ADDR is not null");
            return (Criteria) this;
        }

        public Criteria andUserAddrEqualTo(String value) {
            addCriterion("USER_ADDR =", value, "userAddr");
            return (Criteria) this;
        }

        public Criteria andUserAddrNotEqualTo(String value) {
            addCriterion("USER_ADDR <>", value, "userAddr");
            return (Criteria) this;
        }

        public Criteria andUserAddrGreaterThan(String value) {
            addCriterion("USER_ADDR >", value, "userAddr");
            return (Criteria) this;
        }

        public Criteria andUserAddrGreaterThanOrEqualTo(String value) {
            addCriterion("USER_ADDR >=", value, "userAddr");
            return (Criteria) this;
        }

        public Criteria andUserAddrLessThan(String value) {
            addCriterion("USER_ADDR <", value, "userAddr");
            return (Criteria) this;
        }

        public Criteria andUserAddrLessThanOrEqualTo(String value) {
            addCriterion("USER_ADDR <=", value, "userAddr");
            return (Criteria) this;
        }

        public Criteria andUserAddrLike(String value) {
            addCriterion("USER_ADDR like", value, "userAddr");
            return (Criteria) this;
        }

        public Criteria andUserAddrNotLike(String value) {
            addCriterion("USER_ADDR not like", value, "userAddr");
            return (Criteria) this;
        }

        public Criteria andUserAddrIn(List<String> values) {
            addCriterion("USER_ADDR in", values, "userAddr");
            return (Criteria) this;
        }

        public Criteria andUserAddrNotIn(List<String> values) {
            addCriterion("USER_ADDR not in", values, "userAddr");
            return (Criteria) this;
        }

        public Criteria andUserAddrBetween(String value1, String value2) {
            addCriterion("USER_ADDR between", value1, value2, "userAddr");
            return (Criteria) this;
        }

        public Criteria andUserAddrNotBetween(String value1, String value2) {
            addCriterion("USER_ADDR not between", value1, value2, "userAddr");
            return (Criteria) this;
        }

        public Criteria andLongituedBdIsNull() {
            addCriterion("LONGITUED_BD is null");
            return (Criteria) this;
        }

        public Criteria andLongituedBdIsNotNull() {
            addCriterion("LONGITUED_BD is not null");
            return (Criteria) this;
        }

        public Criteria andLongituedBdEqualTo(String value) {
            addCriterion("LONGITUED_BD =", value, "longituedBd");
            return (Criteria) this;
        }

        public Criteria andLongituedBdNotEqualTo(String value) {
            addCriterion("LONGITUED_BD <>", value, "longituedBd");
            return (Criteria) this;
        }

        public Criteria andLongituedBdGreaterThan(String value) {
            addCriterion("LONGITUED_BD >", value, "longituedBd");
            return (Criteria) this;
        }

        public Criteria andLongituedBdGreaterThanOrEqualTo(String value) {
            addCriterion("LONGITUED_BD >=", value, "longituedBd");
            return (Criteria) this;
        }

        public Criteria andLongituedBdLessThan(String value) {
            addCriterion("LONGITUED_BD <", value, "longituedBd");
            return (Criteria) this;
        }

        public Criteria andLongituedBdLessThanOrEqualTo(String value) {
            addCriterion("LONGITUED_BD <=", value, "longituedBd");
            return (Criteria) this;
        }

        public Criteria andLongituedBdLike(String value) {
            addCriterion("LONGITUED_BD like", value, "longituedBd");
            return (Criteria) this;
        }

        public Criteria andLongituedBdNotLike(String value) {
            addCriterion("LONGITUED_BD not like", value, "longituedBd");
            return (Criteria) this;
        }

        public Criteria andLongituedBdIn(List<String> values) {
            addCriterion("LONGITUED_BD in", values, "longituedBd");
            return (Criteria) this;
        }

        public Criteria andLongituedBdNotIn(List<String> values) {
            addCriterion("LONGITUED_BD not in", values, "longituedBd");
            return (Criteria) this;
        }

        public Criteria andLongituedBdBetween(String value1, String value2) {
            addCriterion("LONGITUED_BD between", value1, value2, "longituedBd");
            return (Criteria) this;
        }

        public Criteria andLongituedBdNotBetween(String value1, String value2) {
            addCriterion("LONGITUED_BD not between", value1, value2, "longituedBd");
            return (Criteria) this;
        }

        public Criteria andLatituedBdIsNull() {
            addCriterion("LATITUED_BD is null");
            return (Criteria) this;
        }

        public Criteria andLatituedBdIsNotNull() {
            addCriterion("LATITUED_BD is not null");
            return (Criteria) this;
        }

        public Criteria andLatituedBdEqualTo(String value) {
            addCriterion("LATITUED_BD =", value, "latituedBd");
            return (Criteria) this;
        }

        public Criteria andLatituedBdNotEqualTo(String value) {
            addCriterion("LATITUED_BD <>", value, "latituedBd");
            return (Criteria) this;
        }

        public Criteria andLatituedBdGreaterThan(String value) {
            addCriterion("LATITUED_BD >", value, "latituedBd");
            return (Criteria) this;
        }

        public Criteria andLatituedBdGreaterThanOrEqualTo(String value) {
            addCriterion("LATITUED_BD >=", value, "latituedBd");
            return (Criteria) this;
        }

        public Criteria andLatituedBdLessThan(String value) {
            addCriterion("LATITUED_BD <", value, "latituedBd");
            return (Criteria) this;
        }

        public Criteria andLatituedBdLessThanOrEqualTo(String value) {
            addCriterion("LATITUED_BD <=", value, "latituedBd");
            return (Criteria) this;
        }

        public Criteria andLatituedBdLike(String value) {
            addCriterion("LATITUED_BD like", value, "latituedBd");
            return (Criteria) this;
        }

        public Criteria andLatituedBdNotLike(String value) {
            addCriterion("LATITUED_BD not like", value, "latituedBd");
            return (Criteria) this;
        }

        public Criteria andLatituedBdIn(List<String> values) {
            addCriterion("LATITUED_BD in", values, "latituedBd");
            return (Criteria) this;
        }

        public Criteria andLatituedBdNotIn(List<String> values) {
            addCriterion("LATITUED_BD not in", values, "latituedBd");
            return (Criteria) this;
        }

        public Criteria andLatituedBdBetween(String value1, String value2) {
            addCriterion("LATITUED_BD between", value1, value2, "latituedBd");
            return (Criteria) this;
        }

        public Criteria andLatituedBdNotBetween(String value1, String value2) {
            addCriterion("LATITUED_BD not between", value1, value2, "latituedBd");
            return (Criteria) this;
        }

        public Criteria andLongituedGdIsNull() {
            addCriterion("LONGITUED_GD is null");
            return (Criteria) this;
        }

        public Criteria andLongituedGdIsNotNull() {
            addCriterion("LONGITUED_GD is not null");
            return (Criteria) this;
        }

        public Criteria andLongituedGdEqualTo(String value) {
            addCriterion("LONGITUED_GD =", value, "longituedGd");
            return (Criteria) this;
        }

        public Criteria andLongituedGdNotEqualTo(String value) {
            addCriterion("LONGITUED_GD <>", value, "longituedGd");
            return (Criteria) this;
        }

        public Criteria andLongituedGdGreaterThan(String value) {
            addCriterion("LONGITUED_GD >", value, "longituedGd");
            return (Criteria) this;
        }

        public Criteria andLongituedGdGreaterThanOrEqualTo(String value) {
            addCriterion("LONGITUED_GD >=", value, "longituedGd");
            return (Criteria) this;
        }

        public Criteria andLongituedGdLessThan(String value) {
            addCriterion("LONGITUED_GD <", value, "longituedGd");
            return (Criteria) this;
        }

        public Criteria andLongituedGdLessThanOrEqualTo(String value) {
            addCriterion("LONGITUED_GD <=", value, "longituedGd");
            return (Criteria) this;
        }

        public Criteria andLongituedGdLike(String value) {
            addCriterion("LONGITUED_GD like", value, "longituedGd");
            return (Criteria) this;
        }

        public Criteria andLongituedGdNotLike(String value) {
            addCriterion("LONGITUED_GD not like", value, "longituedGd");
            return (Criteria) this;
        }

        public Criteria andLongituedGdIn(List<String> values) {
            addCriterion("LONGITUED_GD in", values, "longituedGd");
            return (Criteria) this;
        }

        public Criteria andLongituedGdNotIn(List<String> values) {
            addCriterion("LONGITUED_GD not in", values, "longituedGd");
            return (Criteria) this;
        }

        public Criteria andLongituedGdBetween(String value1, String value2) {
            addCriterion("LONGITUED_GD between", value1, value2, "longituedGd");
            return (Criteria) this;
        }

        public Criteria andLongituedGdNotBetween(String value1, String value2) {
            addCriterion("LONGITUED_GD not between", value1, value2, "longituedGd");
            return (Criteria) this;
        }

        public Criteria andLatituedGdIsNull() {
            addCriterion("LATITUED_GD is null");
            return (Criteria) this;
        }

        public Criteria andLatituedGdIsNotNull() {
            addCriterion("LATITUED_GD is not null");
            return (Criteria) this;
        }

        public Criteria andLatituedGdEqualTo(String value) {
            addCriterion("LATITUED_GD =", value, "latituedGd");
            return (Criteria) this;
        }

        public Criteria andLatituedGdNotEqualTo(String value) {
            addCriterion("LATITUED_GD <>", value, "latituedGd");
            return (Criteria) this;
        }

        public Criteria andLatituedGdGreaterThan(String value) {
            addCriterion("LATITUED_GD >", value, "latituedGd");
            return (Criteria) this;
        }

        public Criteria andLatituedGdGreaterThanOrEqualTo(String value) {
            addCriterion("LATITUED_GD >=", value, "latituedGd");
            return (Criteria) this;
        }

        public Criteria andLatituedGdLessThan(String value) {
            addCriterion("LATITUED_GD <", value, "latituedGd");
            return (Criteria) this;
        }

        public Criteria andLatituedGdLessThanOrEqualTo(String value) {
            addCriterion("LATITUED_GD <=", value, "latituedGd");
            return (Criteria) this;
        }

        public Criteria andLatituedGdLike(String value) {
            addCriterion("LATITUED_GD like", value, "latituedGd");
            return (Criteria) this;
        }

        public Criteria andLatituedGdNotLike(String value) {
            addCriterion("LATITUED_GD not like", value, "latituedGd");
            return (Criteria) this;
        }

        public Criteria andLatituedGdIn(List<String> values) {
            addCriterion("LATITUED_GD in", values, "latituedGd");
            return (Criteria) this;
        }

        public Criteria andLatituedGdNotIn(List<String> values) {
            addCriterion("LATITUED_GD not in", values, "latituedGd");
            return (Criteria) this;
        }

        public Criteria andLatituedGdBetween(String value1, String value2) {
            addCriterion("LATITUED_GD between", value1, value2, "latituedGd");
            return (Criteria) this;
        }

        public Criteria andLatituedGdNotBetween(String value1, String value2) {
            addCriterion("LATITUED_GD not between", value1, value2, "latituedGd");
            return (Criteria) this;
        }

        public Criteria andShipperPhoneIsNull() {
            addCriterion("SHIPPER_PHONE is null");
            return (Criteria) this;
        }

        public Criteria andShipperPhoneIsNotNull() {
            addCriterion("SHIPPER_PHONE is not null");
            return (Criteria) this;
        }

        public Criteria andShipperPhoneEqualTo(String value) {
            addCriterion("SHIPPER_PHONE =", value, "shipperPhone");
            return (Criteria) this;
        }

        public Criteria andShipperPhoneNotEqualTo(String value) {
            addCriterion("SHIPPER_PHONE <>", value, "shipperPhone");
            return (Criteria) this;
        }

        public Criteria andShipperPhoneGreaterThan(String value) {
            addCriterion("SHIPPER_PHONE >", value, "shipperPhone");
            return (Criteria) this;
        }

        public Criteria andShipperPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("SHIPPER_PHONE >=", value, "shipperPhone");
            return (Criteria) this;
        }

        public Criteria andShipperPhoneLessThan(String value) {
            addCriterion("SHIPPER_PHONE <", value, "shipperPhone");
            return (Criteria) this;
        }

        public Criteria andShipperPhoneLessThanOrEqualTo(String value) {
            addCriterion("SHIPPER_PHONE <=", value, "shipperPhone");
            return (Criteria) this;
        }

        public Criteria andShipperPhoneLike(String value) {
            addCriterion("SHIPPER_PHONE like", value, "shipperPhone");
            return (Criteria) this;
        }

        public Criteria andShipperPhoneNotLike(String value) {
            addCriterion("SHIPPER_PHONE not like", value, "shipperPhone");
            return (Criteria) this;
        }

        public Criteria andShipperPhoneIn(List<String> values) {
            addCriterion("SHIPPER_PHONE in", values, "shipperPhone");
            return (Criteria) this;
        }

        public Criteria andShipperPhoneNotIn(List<String> values) {
            addCriterion("SHIPPER_PHONE not in", values, "shipperPhone");
            return (Criteria) this;
        }

        public Criteria andShipperPhoneBetween(String value1, String value2) {
            addCriterion("SHIPPER_PHONE between", value1, value2, "shipperPhone");
            return (Criteria) this;
        }

        public Criteria andShipperPhoneNotBetween(String value1, String value2) {
            addCriterion("SHIPPER_PHONE not between", value1, value2, "shipperPhone");
            return (Criteria) this;
        }

        public Criteria andShipperNameIsNull() {
            addCriterion("SHIPPER_NAME is null");
            return (Criteria) this;
        }

        public Criteria andShipperNameIsNotNull() {
            addCriterion("SHIPPER_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andShipperNameEqualTo(String value) {
            addCriterion("SHIPPER_NAME =", value, "shipperName");
            return (Criteria) this;
        }

        public Criteria andShipperNameNotEqualTo(String value) {
            addCriterion("SHIPPER_NAME <>", value, "shipperName");
            return (Criteria) this;
        }

        public Criteria andShipperNameGreaterThan(String value) {
            addCriterion("SHIPPER_NAME >", value, "shipperName");
            return (Criteria) this;
        }

        public Criteria andShipperNameGreaterThanOrEqualTo(String value) {
            addCriterion("SHIPPER_NAME >=", value, "shipperName");
            return (Criteria) this;
        }

        public Criteria andShipperNameLessThan(String value) {
            addCriterion("SHIPPER_NAME <", value, "shipperName");
            return (Criteria) this;
        }

        public Criteria andShipperNameLessThanOrEqualTo(String value) {
            addCriterion("SHIPPER_NAME <=", value, "shipperName");
            return (Criteria) this;
        }

        public Criteria andShipperNameLike(String value) {
            addCriterion("SHIPPER_NAME like", value, "shipperName");
            return (Criteria) this;
        }

        public Criteria andShipperNameNotLike(String value) {
            addCriterion("SHIPPER_NAME not like", value, "shipperName");
            return (Criteria) this;
        }

        public Criteria andShipperNameIn(List<String> values) {
            addCriterion("SHIPPER_NAME in", values, "shipperName");
            return (Criteria) this;
        }

        public Criteria andShipperNameNotIn(List<String> values) {
            addCriterion("SHIPPER_NAME not in", values, "shipperName");
            return (Criteria) this;
        }

        public Criteria andShipperNameBetween(String value1, String value2) {
            addCriterion("SHIPPER_NAME between", value1, value2, "shipperName");
            return (Criteria) this;
        }

        public Criteria andShipperNameNotBetween(String value1, String value2) {
            addCriterion("SHIPPER_NAME not between", value1, value2, "shipperName");
            return (Criteria) this;
        }

        public Criteria andChannelIdIsNull() {
            addCriterion("CHANNEL_ID is null");
            return (Criteria) this;
        }

        public Criteria andChannelIdIsNotNull() {
            addCriterion("CHANNEL_ID is not null");
            return (Criteria) this;
        }

        public Criteria andChannelIdEqualTo(String value) {
            addCriterion("CHANNEL_ID =", value, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdNotEqualTo(String value) {
            addCriterion("CHANNEL_ID <>", value, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdGreaterThan(String value) {
            addCriterion("CHANNEL_ID >", value, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdGreaterThanOrEqualTo(String value) {
            addCriterion("CHANNEL_ID >=", value, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdLessThan(String value) {
            addCriterion("CHANNEL_ID <", value, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdLessThanOrEqualTo(String value) {
            addCriterion("CHANNEL_ID <=", value, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdLike(String value) {
            addCriterion("CHANNEL_ID like", value, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdNotLike(String value) {
            addCriterion("CHANNEL_ID not like", value, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdIn(List<String> values) {
            addCriterion("CHANNEL_ID in", values, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdNotIn(List<String> values) {
            addCriterion("CHANNEL_ID not in", values, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdBetween(String value1, String value2) {
            addCriterion("CHANNEL_ID between", value1, value2, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdNotBetween(String value1, String value2) {
            addCriterion("CHANNEL_ID not between", value1, value2, "channelId");
            return (Criteria) this;
        }

        public Criteria andDeliverDateIsNull() {
            addCriterion("DELIVER_DATE is null");
            return (Criteria) this;
        }

        public Criteria andDeliverDateIsNotNull() {
            addCriterion("DELIVER_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andDeliverDateEqualTo(String value) {
            addCriterion("DELIVER_DATE =", value, "deliverDate");
            return (Criteria) this;
        }

        public Criteria andDeliverDateNotEqualTo(String value) {
            addCriterion("DELIVER_DATE <>", value, "deliverDate");
            return (Criteria) this;
        }

        public Criteria andDeliverDateGreaterThan(String value) {
            addCriterion("DELIVER_DATE >", value, "deliverDate");
            return (Criteria) this;
        }

        public Criteria andDeliverDateGreaterThanOrEqualTo(String value) {
            addCriterion("DELIVER_DATE >=", value, "deliverDate");
            return (Criteria) this;
        }

        public Criteria andDeliverDateLessThan(String value) {
            addCriterion("DELIVER_DATE <", value, "deliverDate");
            return (Criteria) this;
        }

        public Criteria andDeliverDateLessThanOrEqualTo(String value) {
            addCriterion("DELIVER_DATE <=", value, "deliverDate");
            return (Criteria) this;
        }

        public Criteria andDeliverDateLike(String value) {
            addCriterion("DELIVER_DATE like", value, "deliverDate");
            return (Criteria) this;
        }

        public Criteria andDeliverDateNotLike(String value) {
            addCriterion("DELIVER_DATE not like", value, "deliverDate");
            return (Criteria) this;
        }

        public Criteria andDeliverDateIn(List<String> values) {
            addCriterion("DELIVER_DATE in", values, "deliverDate");
            return (Criteria) this;
        }

        public Criteria andDeliverDateNotIn(List<String> values) {
            addCriterion("DELIVER_DATE not in", values, "deliverDate");
            return (Criteria) this;
        }

        public Criteria andDeliverDateBetween(String value1, String value2) {
            addCriterion("DELIVER_DATE between", value1, value2, "deliverDate");
            return (Criteria) this;
        }

        public Criteria andDeliverDateNotBetween(String value1, String value2) {
            addCriterion("DELIVER_DATE not between", value1, value2, "deliverDate");
            return (Criteria) this;
        }

        public Criteria andDeliverTimeIsNull() {
            addCriterion("DELIVER_TIME is null");
            return (Criteria) this;
        }

        public Criteria andDeliverTimeIsNotNull() {
            addCriterion("DELIVER_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andDeliverTimeEqualTo(String value) {
            addCriterion("DELIVER_TIME =", value, "deliverTime");
            return (Criteria) this;
        }

        public Criteria andDeliverTimeNotEqualTo(String value) {
            addCriterion("DELIVER_TIME <>", value, "deliverTime");
            return (Criteria) this;
        }

        public Criteria andDeliverTimeGreaterThan(String value) {
            addCriterion("DELIVER_TIME >", value, "deliverTime");
            return (Criteria) this;
        }

        public Criteria andDeliverTimeGreaterThanOrEqualTo(String value) {
            addCriterion("DELIVER_TIME >=", value, "deliverTime");
            return (Criteria) this;
        }

        public Criteria andDeliverTimeLessThan(String value) {
            addCriterion("DELIVER_TIME <", value, "deliverTime");
            return (Criteria) this;
        }

        public Criteria andDeliverTimeLessThanOrEqualTo(String value) {
            addCriterion("DELIVER_TIME <=", value, "deliverTime");
            return (Criteria) this;
        }

        public Criteria andDeliverTimeLike(String value) {
            addCriterion("DELIVER_TIME like", value, "deliverTime");
            return (Criteria) this;
        }

        public Criteria andDeliverTimeNotLike(String value) {
            addCriterion("DELIVER_TIME not like", value, "deliverTime");
            return (Criteria) this;
        }

        public Criteria andDeliverTimeIn(List<String> values) {
            addCriterion("DELIVER_TIME in", values, "deliverTime");
            return (Criteria) this;
        }

        public Criteria andDeliverTimeNotIn(List<String> values) {
            addCriterion("DELIVER_TIME not in", values, "deliverTime");
            return (Criteria) this;
        }

        public Criteria andDeliverTimeBetween(String value1, String value2) {
            addCriterion("DELIVER_TIME between", value1, value2, "deliverTime");
            return (Criteria) this;
        }

        public Criteria andDeliverTimeNotBetween(String value1, String value2) {
            addCriterion("DELIVER_TIME not between", value1, value2, "deliverTime");
            return (Criteria) this;
        }

        public Criteria andCancelTypeIsNull() {
            addCriterion("CANCEL_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andCancelTypeIsNotNull() {
            addCriterion("CANCEL_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andCancelTypeEqualTo(Short value) {
            addCriterion("CANCEL_TYPE =", value, "cancelType");
            return (Criteria) this;
        }

        public Criteria andCancelTypeNotEqualTo(Short value) {
            addCriterion("CANCEL_TYPE <>", value, "cancelType");
            return (Criteria) this;
        }

        public Criteria andCancelTypeGreaterThan(Short value) {
            addCriterion("CANCEL_TYPE >", value, "cancelType");
            return (Criteria) this;
        }

        public Criteria andCancelTypeGreaterThanOrEqualTo(Short value) {
            addCriterion("CANCEL_TYPE >=", value, "cancelType");
            return (Criteria) this;
        }

        public Criteria andCancelTypeLessThan(Short value) {
            addCriterion("CANCEL_TYPE <", value, "cancelType");
            return (Criteria) this;
        }

        public Criteria andCancelTypeLessThanOrEqualTo(Short value) {
            addCriterion("CANCEL_TYPE <=", value, "cancelType");
            return (Criteria) this;
        }

        public Criteria andCancelTypeIn(List<Short> values) {
            addCriterion("CANCEL_TYPE in", values, "cancelType");
            return (Criteria) this;
        }

        public Criteria andCancelTypeNotIn(List<Short> values) {
            addCriterion("CANCEL_TYPE not in", values, "cancelType");
            return (Criteria) this;
        }

        public Criteria andCancelTypeBetween(Short value1, Short value2) {
            addCriterion("CANCEL_TYPE between", value1, value2, "cancelType");
            return (Criteria) this;
        }

        public Criteria andCancelTypeNotBetween(Short value1, Short value2) {
            addCriterion("CANCEL_TYPE not between", value1, value2, "cancelType");
            return (Criteria) this;
        }

        public Criteria andCancelReasonIsNull() {
            addCriterion("CANCEL_REASON is null");
            return (Criteria) this;
        }

        public Criteria andCancelReasonIsNotNull() {
            addCriterion("CANCEL_REASON is not null");
            return (Criteria) this;
        }

        public Criteria andCancelReasonEqualTo(String value) {
            addCriterion("CANCEL_REASON =", value, "cancelReason");
            return (Criteria) this;
        }

        public Criteria andCancelReasonNotEqualTo(String value) {
            addCriterion("CANCEL_REASON <>", value, "cancelReason");
            return (Criteria) this;
        }

        public Criteria andCancelReasonGreaterThan(String value) {
            addCriterion("CANCEL_REASON >", value, "cancelReason");
            return (Criteria) this;
        }

        public Criteria andCancelReasonGreaterThanOrEqualTo(String value) {
            addCriterion("CANCEL_REASON >=", value, "cancelReason");
            return (Criteria) this;
        }

        public Criteria andCancelReasonLessThan(String value) {
            addCriterion("CANCEL_REASON <", value, "cancelReason");
            return (Criteria) this;
        }

        public Criteria andCancelReasonLessThanOrEqualTo(String value) {
            addCriterion("CANCEL_REASON <=", value, "cancelReason");
            return (Criteria) this;
        }

        public Criteria andCancelReasonLike(String value) {
            addCriterion("CANCEL_REASON like", value, "cancelReason");
            return (Criteria) this;
        }

        public Criteria andCancelReasonNotLike(String value) {
            addCriterion("CANCEL_REASON not like", value, "cancelReason");
            return (Criteria) this;
        }

        public Criteria andCancelReasonIn(List<String> values) {
            addCriterion("CANCEL_REASON in", values, "cancelReason");
            return (Criteria) this;
        }

        public Criteria andCancelReasonNotIn(List<String> values) {
            addCriterion("CANCEL_REASON not in", values, "cancelReason");
            return (Criteria) this;
        }

        public Criteria andCancelReasonBetween(String value1, String value2) {
            addCriterion("CANCEL_REASON between", value1, value2, "cancelReason");
            return (Criteria) this;
        }

        public Criteria andCancelReasonNotBetween(String value1, String value2) {
            addCriterion("CANCEL_REASON not between", value1, value2, "cancelReason");
            return (Criteria) this;
        }

        public Criteria andCancelDateIsNull() {
            addCriterion("CANCEL_DATE is null");
            return (Criteria) this;
        }

        public Criteria andCancelDateIsNotNull() {
            addCriterion("CANCEL_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andCancelDateEqualTo(String value) {
            addCriterion("CANCEL_DATE =", value, "cancelDate");
            return (Criteria) this;
        }

        public Criteria andCancelDateNotEqualTo(String value) {
            addCriterion("CANCEL_DATE <>", value, "cancelDate");
            return (Criteria) this;
        }

        public Criteria andCancelDateGreaterThan(String value) {
            addCriterion("CANCEL_DATE >", value, "cancelDate");
            return (Criteria) this;
        }

        public Criteria andCancelDateGreaterThanOrEqualTo(String value) {
            addCriterion("CANCEL_DATE >=", value, "cancelDate");
            return (Criteria) this;
        }

        public Criteria andCancelDateLessThan(String value) {
            addCriterion("CANCEL_DATE <", value, "cancelDate");
            return (Criteria) this;
        }

        public Criteria andCancelDateLessThanOrEqualTo(String value) {
            addCriterion("CANCEL_DATE <=", value, "cancelDate");
            return (Criteria) this;
        }

        public Criteria andCancelDateLike(String value) {
            addCriterion("CANCEL_DATE like", value, "cancelDate");
            return (Criteria) this;
        }

        public Criteria andCancelDateNotLike(String value) {
            addCriterion("CANCEL_DATE not like", value, "cancelDate");
            return (Criteria) this;
        }

        public Criteria andCancelDateIn(List<String> values) {
            addCriterion("CANCEL_DATE in", values, "cancelDate");
            return (Criteria) this;
        }

        public Criteria andCancelDateNotIn(List<String> values) {
            addCriterion("CANCEL_DATE not in", values, "cancelDate");
            return (Criteria) this;
        }

        public Criteria andCancelDateBetween(String value1, String value2) {
            addCriterion("CANCEL_DATE between", value1, value2, "cancelDate");
            return (Criteria) this;
        }

        public Criteria andCancelDateNotBetween(String value1, String value2) {
            addCriterion("CANCEL_DATE not between", value1, value2, "cancelDate");
            return (Criteria) this;
        }

        public Criteria andCancelTimeIsNull() {
            addCriterion("CANCEL_TIME is null");
            return (Criteria) this;
        }

        public Criteria andCancelTimeIsNotNull() {
            addCriterion("CANCEL_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andCancelTimeEqualTo(String value) {
            addCriterion("CANCEL_TIME =", value, "cancelTime");
            return (Criteria) this;
        }

        public Criteria andCancelTimeNotEqualTo(String value) {
            addCriterion("CANCEL_TIME <>", value, "cancelTime");
            return (Criteria) this;
        }

        public Criteria andCancelTimeGreaterThan(String value) {
            addCriterion("CANCEL_TIME >", value, "cancelTime");
            return (Criteria) this;
        }

        public Criteria andCancelTimeGreaterThanOrEqualTo(String value) {
            addCriterion("CANCEL_TIME >=", value, "cancelTime");
            return (Criteria) this;
        }

        public Criteria andCancelTimeLessThan(String value) {
            addCriterion("CANCEL_TIME <", value, "cancelTime");
            return (Criteria) this;
        }

        public Criteria andCancelTimeLessThanOrEqualTo(String value) {
            addCriterion("CANCEL_TIME <=", value, "cancelTime");
            return (Criteria) this;
        }

        public Criteria andCancelTimeLike(String value) {
            addCriterion("CANCEL_TIME like", value, "cancelTime");
            return (Criteria) this;
        }

        public Criteria andCancelTimeNotLike(String value) {
            addCriterion("CANCEL_TIME not like", value, "cancelTime");
            return (Criteria) this;
        }

        public Criteria andCancelTimeIn(List<String> values) {
            addCriterion("CANCEL_TIME in", values, "cancelTime");
            return (Criteria) this;
        }

        public Criteria andCancelTimeNotIn(List<String> values) {
            addCriterion("CANCEL_TIME not in", values, "cancelTime");
            return (Criteria) this;
        }

        public Criteria andCancelTimeBetween(String value1, String value2) {
            addCriterion("CANCEL_TIME between", value1, value2, "cancelTime");
            return (Criteria) this;
        }

        public Criteria andCancelTimeNotBetween(String value1, String value2) {
            addCriterion("CANCEL_TIME not between", value1, value2, "cancelTime");
            return (Criteria) this;
        }

        public Criteria andCompleteDateIsNull() {
            addCriterion("COMPLETE_DATE is null");
            return (Criteria) this;
        }

        public Criteria andCompleteDateIsNotNull() {
            addCriterion("COMPLETE_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andCompleteDateEqualTo(String value) {
            addCriterion("COMPLETE_DATE =", value, "completeDate");
            return (Criteria) this;
        }

        public Criteria andCompleteDateNotEqualTo(String value) {
            addCriterion("COMPLETE_DATE <>", value, "completeDate");
            return (Criteria) this;
        }

        public Criteria andCompleteDateGreaterThan(String value) {
            addCriterion("COMPLETE_DATE >", value, "completeDate");
            return (Criteria) this;
        }

        public Criteria andCompleteDateGreaterThanOrEqualTo(String value) {
            addCriterion("COMPLETE_DATE >=", value, "completeDate");
            return (Criteria) this;
        }

        public Criteria andCompleteDateLessThan(String value) {
            addCriterion("COMPLETE_DATE <", value, "completeDate");
            return (Criteria) this;
        }

        public Criteria andCompleteDateLessThanOrEqualTo(String value) {
            addCriterion("COMPLETE_DATE <=", value, "completeDate");
            return (Criteria) this;
        }

        public Criteria andCompleteDateLike(String value) {
            addCriterion("COMPLETE_DATE like", value, "completeDate");
            return (Criteria) this;
        }

        public Criteria andCompleteDateNotLike(String value) {
            addCriterion("COMPLETE_DATE not like", value, "completeDate");
            return (Criteria) this;
        }

        public Criteria andCompleteDateIn(List<String> values) {
            addCriterion("COMPLETE_DATE in", values, "completeDate");
            return (Criteria) this;
        }

        public Criteria andCompleteDateNotIn(List<String> values) {
            addCriterion("COMPLETE_DATE not in", values, "completeDate");
            return (Criteria) this;
        }

        public Criteria andCompleteDateBetween(String value1, String value2) {
            addCriterion("COMPLETE_DATE between", value1, value2, "completeDate");
            return (Criteria) this;
        }

        public Criteria andCompleteDateNotBetween(String value1, String value2) {
            addCriterion("COMPLETE_DATE not between", value1, value2, "completeDate");
            return (Criteria) this;
        }

        public Criteria andCompleteTimeIsNull() {
            addCriterion("COMPLETE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andCompleteTimeIsNotNull() {
            addCriterion("COMPLETE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andCompleteTimeEqualTo(String value) {
            addCriterion("COMPLETE_TIME =", value, "completeTime");
            return (Criteria) this;
        }

        public Criteria andCompleteTimeNotEqualTo(String value) {
            addCriterion("COMPLETE_TIME <>", value, "completeTime");
            return (Criteria) this;
        }

        public Criteria andCompleteTimeGreaterThan(String value) {
            addCriterion("COMPLETE_TIME >", value, "completeTime");
            return (Criteria) this;
        }

        public Criteria andCompleteTimeGreaterThanOrEqualTo(String value) {
            addCriterion("COMPLETE_TIME >=", value, "completeTime");
            return (Criteria) this;
        }

        public Criteria andCompleteTimeLessThan(String value) {
            addCriterion("COMPLETE_TIME <", value, "completeTime");
            return (Criteria) this;
        }

        public Criteria andCompleteTimeLessThanOrEqualTo(String value) {
            addCriterion("COMPLETE_TIME <=", value, "completeTime");
            return (Criteria) this;
        }

        public Criteria andCompleteTimeLike(String value) {
            addCriterion("COMPLETE_TIME like", value, "completeTime");
            return (Criteria) this;
        }

        public Criteria andCompleteTimeNotLike(String value) {
            addCriterion("COMPLETE_TIME not like", value, "completeTime");
            return (Criteria) this;
        }

        public Criteria andCompleteTimeIn(List<String> values) {
            addCriterion("COMPLETE_TIME in", values, "completeTime");
            return (Criteria) this;
        }

        public Criteria andCompleteTimeNotIn(List<String> values) {
            addCriterion("COMPLETE_TIME not in", values, "completeTime");
            return (Criteria) this;
        }

        public Criteria andCompleteTimeBetween(String value1, String value2) {
            addCriterion("COMPLETE_TIME between", value1, value2, "completeTime");
            return (Criteria) this;
        }

        public Criteria andCompleteTimeNotBetween(String value1, String value2) {
            addCriterion("COMPLETE_TIME not between", value1, value2, "completeTime");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("REMARK is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("REMARK is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("REMARK =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("REMARK <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("REMARK >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("REMARK >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("REMARK <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("REMARK <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("REMARK like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("REMARK not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("REMARK in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("REMARK not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("REMARK between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("REMARK not between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andActIdIsNull() {
            addCriterion("ACT_ID is null");
            return (Criteria) this;
        }

        public Criteria andActIdIsNotNull() {
            addCriterion("ACT_ID is not null");
            return (Criteria) this;
        }

        public Criteria andActIdEqualTo(String value) {
            addCriterion("ACT_ID =", value, "actId");
            return (Criteria) this;
        }

        public Criteria andActIdNotEqualTo(String value) {
            addCriterion("ACT_ID <>", value, "actId");
            return (Criteria) this;
        }

        public Criteria andActIdGreaterThan(String value) {
            addCriterion("ACT_ID >", value, "actId");
            return (Criteria) this;
        }

        public Criteria andActIdGreaterThanOrEqualTo(String value) {
            addCriterion("ACT_ID >=", value, "actId");
            return (Criteria) this;
        }

        public Criteria andActIdLessThan(String value) {
            addCriterion("ACT_ID <", value, "actId");
            return (Criteria) this;
        }

        public Criteria andActIdLessThanOrEqualTo(String value) {
            addCriterion("ACT_ID <=", value, "actId");
            return (Criteria) this;
        }

        public Criteria andActIdLike(String value) {
            addCriterion("ACT_ID like", value, "actId");
            return (Criteria) this;
        }

        public Criteria andActIdNotLike(String value) {
            addCriterion("ACT_ID not like", value, "actId");
            return (Criteria) this;
        }

        public Criteria andActIdIn(List<String> values) {
            addCriterion("ACT_ID in", values, "actId");
            return (Criteria) this;
        }

        public Criteria andActIdNotIn(List<String> values) {
            addCriterion("ACT_ID not in", values, "actId");
            return (Criteria) this;
        }

        public Criteria andActIdBetween(String value1, String value2) {
            addCriterion("ACT_ID between", value1, value2, "actId");
            return (Criteria) this;
        }

        public Criteria andActIdNotBetween(String value1, String value2) {
            addCriterion("ACT_ID not between", value1, value2, "actId");
            return (Criteria) this;
        }

        public Criteria andDiscountTypeIsNull() {
            addCriterion("DISCOUNT_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andDiscountTypeIsNotNull() {
            addCriterion("DISCOUNT_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andDiscountTypeEqualTo(String value) {
            addCriterion("DISCOUNT_TYPE =", value, "discountType");
            return (Criteria) this;
        }

        public Criteria andDiscountTypeNotEqualTo(String value) {
            addCriterion("DISCOUNT_TYPE <>", value, "discountType");
            return (Criteria) this;
        }

        public Criteria andDiscountTypeGreaterThan(String value) {
            addCriterion("DISCOUNT_TYPE >", value, "discountType");
            return (Criteria) this;
        }

        public Criteria andDiscountTypeGreaterThanOrEqualTo(String value) {
            addCriterion("DISCOUNT_TYPE >=", value, "discountType");
            return (Criteria) this;
        }

        public Criteria andDiscountTypeLessThan(String value) {
            addCriterion("DISCOUNT_TYPE <", value, "discountType");
            return (Criteria) this;
        }

        public Criteria andDiscountTypeLessThanOrEqualTo(String value) {
            addCriterion("DISCOUNT_TYPE <=", value, "discountType");
            return (Criteria) this;
        }

        public Criteria andDiscountTypeLike(String value) {
            addCriterion("DISCOUNT_TYPE like", value, "discountType");
            return (Criteria) this;
        }

        public Criteria andDiscountTypeNotLike(String value) {
            addCriterion("DISCOUNT_TYPE not like", value, "discountType");
            return (Criteria) this;
        }

        public Criteria andDiscountTypeIn(List<String> values) {
            addCriterion("DISCOUNT_TYPE in", values, "discountType");
            return (Criteria) this;
        }

        public Criteria andDiscountTypeNotIn(List<String> values) {
            addCriterion("DISCOUNT_TYPE not in", values, "discountType");
            return (Criteria) this;
        }

        public Criteria andDiscountTypeBetween(String value1, String value2) {
            addCriterion("DISCOUNT_TYPE between", value1, value2, "discountType");
            return (Criteria) this;
        }

        public Criteria andDiscountTypeNotBetween(String value1, String value2) {
            addCriterion("DISCOUNT_TYPE not between", value1, value2, "discountType");
            return (Criteria) this;
        }

        public Criteria andChannelRateIsNull() {
            addCriterion("CHANNEL_RATE is null");
            return (Criteria) this;
        }

        public Criteria andChannelRateIsNotNull() {
            addCriterion("CHANNEL_RATE is not null");
            return (Criteria) this;
        }

        public Criteria andChannelRateEqualTo(Long value) {
            addCriterion("CHANNEL_RATE =", value, "channelRate");
            return (Criteria) this;
        }

        public Criteria andChannelRateNotEqualTo(Long value) {
            addCriterion("CHANNEL_RATE <>", value, "channelRate");
            return (Criteria) this;
        }

        public Criteria andChannelRateGreaterThan(Long value) {
            addCriterion("CHANNEL_RATE >", value, "channelRate");
            return (Criteria) this;
        }

        public Criteria andChannelRateGreaterThanOrEqualTo(Long value) {
            addCriterion("CHANNEL_RATE >=", value, "channelRate");
            return (Criteria) this;
        }

        public Criteria andChannelRateLessThan(Long value) {
            addCriterion("CHANNEL_RATE <", value, "channelRate");
            return (Criteria) this;
        }

        public Criteria andChannelRateLessThanOrEqualTo(Long value) {
            addCriterion("CHANNEL_RATE <=", value, "channelRate");
            return (Criteria) this;
        }

        public Criteria andChannelRateIn(List<Long> values) {
            addCriterion("CHANNEL_RATE in", values, "channelRate");
            return (Criteria) this;
        }

        public Criteria andChannelRateNotIn(List<Long> values) {
            addCriterion("CHANNEL_RATE not in", values, "channelRate");
            return (Criteria) this;
        }

        public Criteria andChannelRateBetween(Long value1, Long value2) {
            addCriterion("CHANNEL_RATE between", value1, value2, "channelRate");
            return (Criteria) this;
        }

        public Criteria andChannelRateNotBetween(Long value1, Long value2) {
            addCriterion("CHANNEL_RATE not between", value1, value2, "channelRate");
            return (Criteria) this;
        }

        public Criteria andShopRateIsNull() {
            addCriterion("SHOP_RATE is null");
            return (Criteria) this;
        }

        public Criteria andShopRateIsNotNull() {
            addCriterion("SHOP_RATE is not null");
            return (Criteria) this;
        }

        public Criteria andShopRateEqualTo(Long value) {
            addCriterion("SHOP_RATE =", value, "shopRate");
            return (Criteria) this;
        }

        public Criteria andShopRateNotEqualTo(Long value) {
            addCriterion("SHOP_RATE <>", value, "shopRate");
            return (Criteria) this;
        }

        public Criteria andShopRateGreaterThan(Long value) {
            addCriterion("SHOP_RATE >", value, "shopRate");
            return (Criteria) this;
        }

        public Criteria andShopRateGreaterThanOrEqualTo(Long value) {
            addCriterion("SHOP_RATE >=", value, "shopRate");
            return (Criteria) this;
        }

        public Criteria andShopRateLessThan(Long value) {
            addCriterion("SHOP_RATE <", value, "shopRate");
            return (Criteria) this;
        }

        public Criteria andShopRateLessThanOrEqualTo(Long value) {
            addCriterion("SHOP_RATE <=", value, "shopRate");
            return (Criteria) this;
        }

        public Criteria andShopRateIn(List<Long> values) {
            addCriterion("SHOP_RATE in", values, "shopRate");
            return (Criteria) this;
        }

        public Criteria andShopRateNotIn(List<Long> values) {
            addCriterion("SHOP_RATE not in", values, "shopRate");
            return (Criteria) this;
        }

        public Criteria andShopRateBetween(Long value1, Long value2) {
            addCriterion("SHOP_RATE between", value1, value2, "shopRate");
            return (Criteria) this;
        }

        public Criteria andShopRateNotBetween(Long value1, Long value2) {
            addCriterion("SHOP_RATE not between", value1, value2, "shopRate");
            return (Criteria) this;
        }

        public Criteria andAgentRateIsNull() {
            addCriterion("AGENT_RATE is null");
            return (Criteria) this;
        }

        public Criteria andAgentRateIsNotNull() {
            addCriterion("AGENT_RATE is not null");
            return (Criteria) this;
        }

        public Criteria andAgentRateEqualTo(Long value) {
            addCriterion("AGENT_RATE =", value, "agentRate");
            return (Criteria) this;
        }

        public Criteria andAgentRateNotEqualTo(Long value) {
            addCriterion("AGENT_RATE <>", value, "agentRate");
            return (Criteria) this;
        }

        public Criteria andAgentRateGreaterThan(Long value) {
            addCriterion("AGENT_RATE >", value, "agentRate");
            return (Criteria) this;
        }

        public Criteria andAgentRateGreaterThanOrEqualTo(Long value) {
            addCriterion("AGENT_RATE >=", value, "agentRate");
            return (Criteria) this;
        }

        public Criteria andAgentRateLessThan(Long value) {
            addCriterion("AGENT_RATE <", value, "agentRate");
            return (Criteria) this;
        }

        public Criteria andAgentRateLessThanOrEqualTo(Long value) {
            addCriterion("AGENT_RATE <=", value, "agentRate");
            return (Criteria) this;
        }

        public Criteria andAgentRateIn(List<Long> values) {
            addCriterion("AGENT_RATE in", values, "agentRate");
            return (Criteria) this;
        }

        public Criteria andAgentRateNotIn(List<Long> values) {
            addCriterion("AGENT_RATE not in", values, "agentRate");
            return (Criteria) this;
        }

        public Criteria andAgentRateBetween(Long value1, Long value2) {
            addCriterion("AGENT_RATE between", value1, value2, "agentRate");
            return (Criteria) this;
        }

        public Criteria andAgentRateNotBetween(Long value1, Long value2) {
            addCriterion("AGENT_RATE not between", value1, value2, "agentRate");
            return (Criteria) this;
        }

        public Criteria andLogisticsRateIsNull() {
            addCriterion("LOGISTICS_RATE is null");
            return (Criteria) this;
        }

        public Criteria andLogisticsRateIsNotNull() {
            addCriterion("LOGISTICS_RATE is not null");
            return (Criteria) this;
        }

        public Criteria andLogisticsRateEqualTo(Long value) {
            addCriterion("LOGISTICS_RATE =", value, "logisticsRate");
            return (Criteria) this;
        }

        public Criteria andLogisticsRateNotEqualTo(Long value) {
            addCriterion("LOGISTICS_RATE <>", value, "logisticsRate");
            return (Criteria) this;
        }

        public Criteria andLogisticsRateGreaterThan(Long value) {
            addCriterion("LOGISTICS_RATE >", value, "logisticsRate");
            return (Criteria) this;
        }

        public Criteria andLogisticsRateGreaterThanOrEqualTo(Long value) {
            addCriterion("LOGISTICS_RATE >=", value, "logisticsRate");
            return (Criteria) this;
        }

        public Criteria andLogisticsRateLessThan(Long value) {
            addCriterion("LOGISTICS_RATE <", value, "logisticsRate");
            return (Criteria) this;
        }

        public Criteria andLogisticsRateLessThanOrEqualTo(Long value) {
            addCriterion("LOGISTICS_RATE <=", value, "logisticsRate");
            return (Criteria) this;
        }

        public Criteria andLogisticsRateIn(List<Long> values) {
            addCriterion("LOGISTICS_RATE in", values, "logisticsRate");
            return (Criteria) this;
        }

        public Criteria andLogisticsRateNotIn(List<Long> values) {
            addCriterion("LOGISTICS_RATE not in", values, "logisticsRate");
            return (Criteria) this;
        }

        public Criteria andLogisticsRateBetween(Long value1, Long value2) {
            addCriterion("LOGISTICS_RATE between", value1, value2, "logisticsRate");
            return (Criteria) this;
        }

        public Criteria andLogisticsRateNotBetween(Long value1, Long value2) {
            addCriterion("LOGISTICS_RATE not between", value1, value2, "logisticsRate");
            return (Criteria) this;
        }

        public Criteria andOrderTypeIsNull() {
            addCriterion("ORDER_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andOrderTypeIsNotNull() {
            addCriterion("ORDER_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andOrderTypeEqualTo(Short value) {
            addCriterion("ORDER_TYPE =", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeNotEqualTo(Short value) {
            addCriterion("ORDER_TYPE <>", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeGreaterThan(Short value) {
            addCriterion("ORDER_TYPE >", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeGreaterThanOrEqualTo(Short value) {
            addCriterion("ORDER_TYPE >=", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeLessThan(Short value) {
            addCriterion("ORDER_TYPE <", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeLessThanOrEqualTo(Short value) {
            addCriterion("ORDER_TYPE <=", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeIn(List<Short> values) {
            addCriterion("ORDER_TYPE in", values, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeNotIn(List<Short> values) {
            addCriterion("ORDER_TYPE not in", values, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeBetween(Short value1, Short value2) {
            addCriterion("ORDER_TYPE between", value1, value2, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeNotBetween(Short value1, Short value2) {
            addCriterion("ORDER_TYPE not between", value1, value2, "orderType");
            return (Criteria) this;
        }

        public Criteria andUmqProfitTypeIsNull() {
            addCriterion("UMQ_PROFIT_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andUmqProfitTypeIsNotNull() {
            addCriterion("UMQ_PROFIT_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andUmqProfitTypeEqualTo(Short value) {
            addCriterion("UMQ_PROFIT_TYPE =", value, "umqProfitType");
            return (Criteria) this;
        }

        public Criteria andUmqProfitTypeNotEqualTo(Short value) {
            addCriterion("UMQ_PROFIT_TYPE <>", value, "umqProfitType");
            return (Criteria) this;
        }

        public Criteria andUmqProfitTypeGreaterThan(Short value) {
            addCriterion("UMQ_PROFIT_TYPE >", value, "umqProfitType");
            return (Criteria) this;
        }

        public Criteria andUmqProfitTypeGreaterThanOrEqualTo(Short value) {
            addCriterion("UMQ_PROFIT_TYPE >=", value, "umqProfitType");
            return (Criteria) this;
        }

        public Criteria andUmqProfitTypeLessThan(Short value) {
            addCriterion("UMQ_PROFIT_TYPE <", value, "umqProfitType");
            return (Criteria) this;
        }

        public Criteria andUmqProfitTypeLessThanOrEqualTo(Short value) {
            addCriterion("UMQ_PROFIT_TYPE <=", value, "umqProfitType");
            return (Criteria) this;
        }

        public Criteria andUmqProfitTypeIn(List<Short> values) {
            addCriterion("UMQ_PROFIT_TYPE in", values, "umqProfitType");
            return (Criteria) this;
        }

        public Criteria andUmqProfitTypeNotIn(List<Short> values) {
            addCriterion("UMQ_PROFIT_TYPE not in", values, "umqProfitType");
            return (Criteria) this;
        }

        public Criteria andUmqProfitTypeBetween(Short value1, Short value2) {
            addCriterion("UMQ_PROFIT_TYPE between", value1, value2, "umqProfitType");
            return (Criteria) this;
        }

        public Criteria andUmqProfitTypeNotBetween(Short value1, Short value2) {
            addCriterion("UMQ_PROFIT_TYPE not between", value1, value2, "umqProfitType");
            return (Criteria) this;
        }

        public Criteria andUmqProfitAmountIsNull() {
            addCriterion("UMQ_PROFIT_AMOUNT is null");
            return (Criteria) this;
        }

        public Criteria andUmqProfitAmountIsNotNull() {
            addCriterion("UMQ_PROFIT_AMOUNT is not null");
            return (Criteria) this;
        }

        public Criteria andUmqProfitAmountEqualTo(Long value) {
            addCriterion("UMQ_PROFIT_AMOUNT =", value, "umqProfitAmount");
            return (Criteria) this;
        }

        public Criteria andUmqProfitAmountNotEqualTo(Long value) {
            addCriterion("UMQ_PROFIT_AMOUNT <>", value, "umqProfitAmount");
            return (Criteria) this;
        }

        public Criteria andUmqProfitAmountGreaterThan(Long value) {
            addCriterion("UMQ_PROFIT_AMOUNT >", value, "umqProfitAmount");
            return (Criteria) this;
        }

        public Criteria andUmqProfitAmountGreaterThanOrEqualTo(Long value) {
            addCriterion("UMQ_PROFIT_AMOUNT >=", value, "umqProfitAmount");
            return (Criteria) this;
        }

        public Criteria andUmqProfitAmountLessThan(Long value) {
            addCriterion("UMQ_PROFIT_AMOUNT <", value, "umqProfitAmount");
            return (Criteria) this;
        }

        public Criteria andUmqProfitAmountLessThanOrEqualTo(Long value) {
            addCriterion("UMQ_PROFIT_AMOUNT <=", value, "umqProfitAmount");
            return (Criteria) this;
        }

        public Criteria andUmqProfitAmountIn(List<Long> values) {
            addCriterion("UMQ_PROFIT_AMOUNT in", values, "umqProfitAmount");
            return (Criteria) this;
        }

        public Criteria andUmqProfitAmountNotIn(List<Long> values) {
            addCriterion("UMQ_PROFIT_AMOUNT not in", values, "umqProfitAmount");
            return (Criteria) this;
        }

        public Criteria andUmqProfitAmountBetween(Long value1, Long value2) {
            addCriterion("UMQ_PROFIT_AMOUNT between", value1, value2, "umqProfitAmount");
            return (Criteria) this;
        }

        public Criteria andUmqProfitAmountNotBetween(Long value1, Long value2) {
            addCriterion("UMQ_PROFIT_AMOUNT not between", value1, value2, "umqProfitAmount");
            return (Criteria) this;
        }

        public Criteria andChannelShopIdIsNull() {
            addCriterion("CHANNEL_SHOP_ID is null");
            return (Criteria) this;
        }

        public Criteria andChannelShopIdIsNotNull() {
            addCriterion("CHANNEL_SHOP_ID is not null");
            return (Criteria) this;
        }

        public Criteria andChannelShopIdEqualTo(String value) {
            addCriterion("CHANNEL_SHOP_ID =", value, "channelShopId");
            return (Criteria) this;
        }

        public Criteria andChannelShopIdNotEqualTo(String value) {
            addCriterion("CHANNEL_SHOP_ID <>", value, "channelShopId");
            return (Criteria) this;
        }

        public Criteria andChannelShopIdGreaterThan(String value) {
            addCriterion("CHANNEL_SHOP_ID >", value, "channelShopId");
            return (Criteria) this;
        }

        public Criteria andChannelShopIdGreaterThanOrEqualTo(String value) {
            addCriterion("CHANNEL_SHOP_ID >=", value, "channelShopId");
            return (Criteria) this;
        }

        public Criteria andChannelShopIdLessThan(String value) {
            addCriterion("CHANNEL_SHOP_ID <", value, "channelShopId");
            return (Criteria) this;
        }

        public Criteria andChannelShopIdLessThanOrEqualTo(String value) {
            addCriterion("CHANNEL_SHOP_ID <=", value, "channelShopId");
            return (Criteria) this;
        }

        public Criteria andChannelShopIdLike(String value) {
            addCriterion("CHANNEL_SHOP_ID like", value, "channelShopId");
            return (Criteria) this;
        }

        public Criteria andChannelShopIdNotLike(String value) {
            addCriterion("CHANNEL_SHOP_ID not like", value, "channelShopId");
            return (Criteria) this;
        }

        public Criteria andChannelShopIdIn(List<String> values) {
            addCriterion("CHANNEL_SHOP_ID in", values, "channelShopId");
            return (Criteria) this;
        }

        public Criteria andChannelShopIdNotIn(List<String> values) {
            addCriterion("CHANNEL_SHOP_ID not in", values, "channelShopId");
            return (Criteria) this;
        }

        public Criteria andChannelShopIdBetween(String value1, String value2) {
            addCriterion("CHANNEL_SHOP_ID between", value1, value2, "channelShopId");
            return (Criteria) this;
        }

        public Criteria andChannelShopIdNotBetween(String value1, String value2) {
            addCriterion("CHANNEL_SHOP_ID not between", value1, value2, "channelShopId");
            return (Criteria) this;
        }

        public Criteria andAutoOrderIsNull() {
            addCriterion("AUTO_ORDER is null");
            return (Criteria) this;
        }

        public Criteria andAutoOrderIsNotNull() {
            addCriterion("AUTO_ORDER is not null");
            return (Criteria) this;
        }

        public Criteria andAutoOrderEqualTo(Short value) {
            addCriterion("AUTO_ORDER =", value, "autoOrder");
            return (Criteria) this;
        }

        public Criteria andAutoOrderNotEqualTo(Short value) {
            addCriterion("AUTO_ORDER <>", value, "autoOrder");
            return (Criteria) this;
        }

        public Criteria andAutoOrderGreaterThan(Short value) {
            addCriterion("AUTO_ORDER >", value, "autoOrder");
            return (Criteria) this;
        }

        public Criteria andAutoOrderGreaterThanOrEqualTo(Short value) {
            addCriterion("AUTO_ORDER >=", value, "autoOrder");
            return (Criteria) this;
        }

        public Criteria andAutoOrderLessThan(Short value) {
            addCriterion("AUTO_ORDER <", value, "autoOrder");
            return (Criteria) this;
        }

        public Criteria andAutoOrderLessThanOrEqualTo(Short value) {
            addCriterion("AUTO_ORDER <=", value, "autoOrder");
            return (Criteria) this;
        }

        public Criteria andAutoOrderIn(List<Short> values) {
            addCriterion("AUTO_ORDER in", values, "autoOrder");
            return (Criteria) this;
        }

        public Criteria andAutoOrderNotIn(List<Short> values) {
            addCriterion("AUTO_ORDER not in", values, "autoOrder");
            return (Criteria) this;
        }

        public Criteria andAutoOrderBetween(Short value1, Short value2) {
            addCriterion("AUTO_ORDER between", value1, value2, "autoOrder");
            return (Criteria) this;
        }

        public Criteria andAutoOrderNotBetween(Short value1, Short value2) {
            addCriterion("AUTO_ORDER not between", value1, value2, "autoOrder");
            return (Criteria) this;
        }

        public Criteria andOrderSeqIsNull() {
            addCriterion("ORDER_SEQ is null");
            return (Criteria) this;
        }

        public Criteria andOrderSeqIsNotNull() {
            addCriterion("ORDER_SEQ is not null");
            return (Criteria) this;
        }

        public Criteria andOrderSeqEqualTo(Integer value) {
            addCriterion("ORDER_SEQ =", value, "orderSeq");
            return (Criteria) this;
        }

        public Criteria andOrderSeqNotEqualTo(Integer value) {
            addCriterion("ORDER_SEQ <>", value, "orderSeq");
            return (Criteria) this;
        }

        public Criteria andOrderSeqGreaterThan(Integer value) {
            addCriterion("ORDER_SEQ >", value, "orderSeq");
            return (Criteria) this;
        }

        public Criteria andOrderSeqGreaterThanOrEqualTo(Integer value) {
            addCriterion("ORDER_SEQ >=", value, "orderSeq");
            return (Criteria) this;
        }

        public Criteria andOrderSeqLessThan(Integer value) {
            addCriterion("ORDER_SEQ <", value, "orderSeq");
            return (Criteria) this;
        }

        public Criteria andOrderSeqLessThanOrEqualTo(Integer value) {
            addCriterion("ORDER_SEQ <=", value, "orderSeq");
            return (Criteria) this;
        }

        public Criteria andOrderSeqIn(List<Integer> values) {
            addCriterion("ORDER_SEQ in", values, "orderSeq");
            return (Criteria) this;
        }

        public Criteria andOrderSeqNotIn(List<Integer> values) {
            addCriterion("ORDER_SEQ not in", values, "orderSeq");
            return (Criteria) this;
        }

        public Criteria andOrderSeqBetween(Integer value1, Integer value2) {
            addCriterion("ORDER_SEQ between", value1, value2, "orderSeq");
            return (Criteria) this;
        }

        public Criteria andOrderSeqNotBetween(Integer value1, Integer value2) {
            addCriterion("ORDER_SEQ not between", value1, value2, "orderSeq");
            return (Criteria) this;
        }

        public Criteria andDeliveryStatusIsNull() {
            addCriterion("DELIVERY_STATUS is null");
            return (Criteria) this;
        }

        public Criteria andDeliveryStatusIsNotNull() {
            addCriterion("DELIVERY_STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andDeliveryStatusEqualTo(Short value) {
            addCriterion("DELIVERY_STATUS =", value, "deliveryStatus");
            return (Criteria) this;
        }

        public Criteria andDeliveryStatusNotEqualTo(Short value) {
            addCriterion("DELIVERY_STATUS <>", value, "deliveryStatus");
            return (Criteria) this;
        }

        public Criteria andDeliveryStatusGreaterThan(Short value) {
            addCriterion("DELIVERY_STATUS >", value, "deliveryStatus");
            return (Criteria) this;
        }

        public Criteria andDeliveryStatusGreaterThanOrEqualTo(Short value) {
            addCriterion("DELIVERY_STATUS >=", value, "deliveryStatus");
            return (Criteria) this;
        }

        public Criteria andDeliveryStatusLessThan(Short value) {
            addCriterion("DELIVERY_STATUS <", value, "deliveryStatus");
            return (Criteria) this;
        }

        public Criteria andDeliveryStatusLessThanOrEqualTo(Short value) {
            addCriterion("DELIVERY_STATUS <=", value, "deliveryStatus");
            return (Criteria) this;
        }

        public Criteria andDeliveryStatusIn(List<Short> values) {
            addCriterion("DELIVERY_STATUS in", values, "deliveryStatus");
            return (Criteria) this;
        }

        public Criteria andDeliveryStatusNotIn(List<Short> values) {
            addCriterion("DELIVERY_STATUS not in", values, "deliveryStatus");
            return (Criteria) this;
        }

        public Criteria andDeliveryStatusBetween(Short value1, Short value2) {
            addCriterion("DELIVERY_STATUS between", value1, value2, "deliveryStatus");
            return (Criteria) this;
        }

        public Criteria andDeliveryStatusNotBetween(Short value1, Short value2) {
            addCriterion("DELIVERY_STATUS not between", value1, value2, "deliveryStatus");
            return (Criteria) this;
        }

        public Criteria andDeliveryCnlReasonIsNull() {
            addCriterion("DELIVERY_CNL_REASON is null");
            return (Criteria) this;
        }

        public Criteria andDeliveryCnlReasonIsNotNull() {
            addCriterion("DELIVERY_CNL_REASON is not null");
            return (Criteria) this;
        }

        public Criteria andDeliveryCnlReasonEqualTo(Short value) {
            addCriterion("DELIVERY_CNL_REASON =", value, "deliveryCnlReason");
            return (Criteria) this;
        }

        public Criteria andDeliveryCnlReasonNotEqualTo(Short value) {
            addCriterion("DELIVERY_CNL_REASON <>", value, "deliveryCnlReason");
            return (Criteria) this;
        }

        public Criteria andDeliveryCnlReasonGreaterThan(Short value) {
            addCriterion("DELIVERY_CNL_REASON >", value, "deliveryCnlReason");
            return (Criteria) this;
        }

        public Criteria andDeliveryCnlReasonGreaterThanOrEqualTo(Short value) {
            addCriterion("DELIVERY_CNL_REASON >=", value, "deliveryCnlReason");
            return (Criteria) this;
        }

        public Criteria andDeliveryCnlReasonLessThan(Short value) {
            addCriterion("DELIVERY_CNL_REASON <", value, "deliveryCnlReason");
            return (Criteria) this;
        }

        public Criteria andDeliveryCnlReasonLessThanOrEqualTo(Short value) {
            addCriterion("DELIVERY_CNL_REASON <=", value, "deliveryCnlReason");
            return (Criteria) this;
        }

        public Criteria andDeliveryCnlReasonIn(List<Short> values) {
            addCriterion("DELIVERY_CNL_REASON in", values, "deliveryCnlReason");
            return (Criteria) this;
        }

        public Criteria andDeliveryCnlReasonNotIn(List<Short> values) {
            addCriterion("DELIVERY_CNL_REASON not in", values, "deliveryCnlReason");
            return (Criteria) this;
        }

        public Criteria andDeliveryCnlReasonBetween(Short value1, Short value2) {
            addCriterion("DELIVERY_CNL_REASON between", value1, value2, "deliveryCnlReason");
            return (Criteria) this;
        }

        public Criteria andDeliveryCnlReasonNotBetween(Short value1, Short value2) {
            addCriterion("DELIVERY_CNL_REASON not between", value1, value2, "deliveryCnlReason");
            return (Criteria) this;
        }

        public Criteria andLastTransDateIsNull() {
            addCriterion("LAST_TRANS_DATE is null");
            return (Criteria) this;
        }

        public Criteria andLastTransDateIsNotNull() {
            addCriterion("LAST_TRANS_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andLastTransDateEqualTo(String value) {
            addCriterion("LAST_TRANS_DATE =", value, "lastTransDate");
            return (Criteria) this;
        }

        public Criteria andLastTransDateNotEqualTo(String value) {
            addCriterion("LAST_TRANS_DATE <>", value, "lastTransDate");
            return (Criteria) this;
        }

        public Criteria andLastTransDateGreaterThan(String value) {
            addCriterion("LAST_TRANS_DATE >", value, "lastTransDate");
            return (Criteria) this;
        }

        public Criteria andLastTransDateGreaterThanOrEqualTo(String value) {
            addCriterion("LAST_TRANS_DATE >=", value, "lastTransDate");
            return (Criteria) this;
        }

        public Criteria andLastTransDateLessThan(String value) {
            addCriterion("LAST_TRANS_DATE <", value, "lastTransDate");
            return (Criteria) this;
        }

        public Criteria andLastTransDateLessThanOrEqualTo(String value) {
            addCriterion("LAST_TRANS_DATE <=", value, "lastTransDate");
            return (Criteria) this;
        }

        public Criteria andLastTransDateLike(String value) {
            addCriterion("LAST_TRANS_DATE like", value, "lastTransDate");
            return (Criteria) this;
        }

        public Criteria andLastTransDateNotLike(String value) {
            addCriterion("LAST_TRANS_DATE not like", value, "lastTransDate");
            return (Criteria) this;
        }

        public Criteria andLastTransDateIn(List<String> values) {
            addCriterion("LAST_TRANS_DATE in", values, "lastTransDate");
            return (Criteria) this;
        }

        public Criteria andLastTransDateNotIn(List<String> values) {
            addCriterion("LAST_TRANS_DATE not in", values, "lastTransDate");
            return (Criteria) this;
        }

        public Criteria andLastTransDateBetween(String value1, String value2) {
            addCriterion("LAST_TRANS_DATE between", value1, value2, "lastTransDate");
            return (Criteria) this;
        }

        public Criteria andLastTransDateNotBetween(String value1, String value2) {
            addCriterion("LAST_TRANS_DATE not between", value1, value2, "lastTransDate");
            return (Criteria) this;
        }

        public Criteria andLastTransTimeIsNull() {
            addCriterion("LAST_TRANS_TIME is null");
            return (Criteria) this;
        }

        public Criteria andLastTransTimeIsNotNull() {
            addCriterion("LAST_TRANS_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andLastTransTimeEqualTo(String value) {
            addCriterion("LAST_TRANS_TIME =", value, "lastTransTime");
            return (Criteria) this;
        }

        public Criteria andLastTransTimeNotEqualTo(String value) {
            addCriterion("LAST_TRANS_TIME <>", value, "lastTransTime");
            return (Criteria) this;
        }

        public Criteria andLastTransTimeGreaterThan(String value) {
            addCriterion("LAST_TRANS_TIME >", value, "lastTransTime");
            return (Criteria) this;
        }

        public Criteria andLastTransTimeGreaterThanOrEqualTo(String value) {
            addCriterion("LAST_TRANS_TIME >=", value, "lastTransTime");
            return (Criteria) this;
        }

        public Criteria andLastTransTimeLessThan(String value) {
            addCriterion("LAST_TRANS_TIME <", value, "lastTransTime");
            return (Criteria) this;
        }

        public Criteria andLastTransTimeLessThanOrEqualTo(String value) {
            addCriterion("LAST_TRANS_TIME <=", value, "lastTransTime");
            return (Criteria) this;
        }

        public Criteria andLastTransTimeLike(String value) {
            addCriterion("LAST_TRANS_TIME like", value, "lastTransTime");
            return (Criteria) this;
        }

        public Criteria andLastTransTimeNotLike(String value) {
            addCriterion("LAST_TRANS_TIME not like", value, "lastTransTime");
            return (Criteria) this;
        }

        public Criteria andLastTransTimeIn(List<String> values) {
            addCriterion("LAST_TRANS_TIME in", values, "lastTransTime");
            return (Criteria) this;
        }

        public Criteria andLastTransTimeNotIn(List<String> values) {
            addCriterion("LAST_TRANS_TIME not in", values, "lastTransTime");
            return (Criteria) this;
        }

        public Criteria andLastTransTimeBetween(String value1, String value2) {
            addCriterion("LAST_TRANS_TIME between", value1, value2, "lastTransTime");
            return (Criteria) this;
        }

        public Criteria andLastTransTimeNotBetween(String value1, String value2) {
            addCriterion("LAST_TRANS_TIME not between", value1, value2, "lastTransTime");
            return (Criteria) this;
        }

        public Criteria andNoticeStatusIsNull() {
            addCriterion("NOTICE_STATUS is null");
            return (Criteria) this;
        }

        public Criteria andNoticeStatusIsNotNull() {
            addCriterion("NOTICE_STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andNoticeStatusEqualTo(Short value) {
            addCriterion("NOTICE_STATUS =", value, "noticeStatus");
            return (Criteria) this;
        }

        public Criteria andNoticeStatusNotEqualTo(Short value) {
            addCriterion("NOTICE_STATUS <>", value, "noticeStatus");
            return (Criteria) this;
        }

        public Criteria andNoticeStatusGreaterThan(Short value) {
            addCriterion("NOTICE_STATUS >", value, "noticeStatus");
            return (Criteria) this;
        }

        public Criteria andNoticeStatusGreaterThanOrEqualTo(Short value) {
            addCriterion("NOTICE_STATUS >=", value, "noticeStatus");
            return (Criteria) this;
        }

        public Criteria andNoticeStatusLessThan(Short value) {
            addCriterion("NOTICE_STATUS <", value, "noticeStatus");
            return (Criteria) this;
        }

        public Criteria andNoticeStatusLessThanOrEqualTo(Short value) {
            addCriterion("NOTICE_STATUS <=", value, "noticeStatus");
            return (Criteria) this;
        }

        public Criteria andNoticeStatusIn(List<Short> values) {
            addCriterion("NOTICE_STATUS in", values, "noticeStatus");
            return (Criteria) this;
        }

        public Criteria andNoticeStatusNotIn(List<Short> values) {
            addCriterion("NOTICE_STATUS not in", values, "noticeStatus");
            return (Criteria) this;
        }

        public Criteria andNoticeStatusBetween(Short value1, Short value2) {
            addCriterion("NOTICE_STATUS between", value1, value2, "noticeStatus");
            return (Criteria) this;
        }

        public Criteria andNoticeStatusNotBetween(Short value1, Short value2) {
            addCriterion("NOTICE_STATUS not between", value1, value2, "noticeStatus");
            return (Criteria) this;
        }

        public Criteria andShopAutoOrderIsNull() {
            addCriterion("SHOP_AUTO_ORDER is null");
            return (Criteria) this;
        }

        public Criteria andShopAutoOrderIsNotNull() {
            addCriterion("SHOP_AUTO_ORDER is not null");
            return (Criteria) this;
        }

        public Criteria andShopAutoOrderEqualTo(String value) {
            addCriterion("SHOP_AUTO_ORDER =", value, "shopAutoOrder");
            return (Criteria) this;
        }

        public Criteria andShopAutoOrderNotEqualTo(String value) {
            addCriterion("SHOP_AUTO_ORDER <>", value, "shopAutoOrder");
            return (Criteria) this;
        }

        public Criteria andShopAutoOrderGreaterThan(String value) {
            addCriterion("SHOP_AUTO_ORDER >", value, "shopAutoOrder");
            return (Criteria) this;
        }

        public Criteria andShopAutoOrderGreaterThanOrEqualTo(String value) {
            addCriterion("SHOP_AUTO_ORDER >=", value, "shopAutoOrder");
            return (Criteria) this;
        }

        public Criteria andShopAutoOrderLessThan(String value) {
            addCriterion("SHOP_AUTO_ORDER <", value, "shopAutoOrder");
            return (Criteria) this;
        }

        public Criteria andShopAutoOrderLessThanOrEqualTo(String value) {
            addCriterion("SHOP_AUTO_ORDER <=", value, "shopAutoOrder");
            return (Criteria) this;
        }

        public Criteria andShopAutoOrderLike(String value) {
            addCriterion("SHOP_AUTO_ORDER like", value, "shopAutoOrder");
            return (Criteria) this;
        }

        public Criteria andShopAutoOrderNotLike(String value) {
            addCriterion("SHOP_AUTO_ORDER not like", value, "shopAutoOrder");
            return (Criteria) this;
        }

        public Criteria andShopAutoOrderIn(List<String> values) {
            addCriterion("SHOP_AUTO_ORDER in", values, "shopAutoOrder");
            return (Criteria) this;
        }

        public Criteria andShopAutoOrderNotIn(List<String> values) {
            addCriterion("SHOP_AUTO_ORDER not in", values, "shopAutoOrder");
            return (Criteria) this;
        }

        public Criteria andShopAutoOrderBetween(String value1, String value2) {
            addCriterion("SHOP_AUTO_ORDER between", value1, value2, "shopAutoOrder");
            return (Criteria) this;
        }

        public Criteria andShopAutoOrderNotBetween(String value1, String value2) {
            addCriterion("SHOP_AUTO_ORDER not between", value1, value2, "shopAutoOrder");
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