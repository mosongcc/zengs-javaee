package com.unionlive.app.entity;

import java.io.Serializable;

public class WmOrderInfo implements Serializable {
    private String orgId;

    private String mercId;

    private String shopId;

    private String shopName;

    private String channelOrderid;

    private String orderId;

    private String viewOrderId;

    private String timestamp;

    private String orderDate;

    private String orderTime;

    private String confirmDate;

    private String confirmTime;

    private String traceNo;

    private Short status;

    private String sendImmediately;

    private String expectDate;

    private String expectTime;

    private Long deliverAmount;

    private Long packageAmount;

    private Long discountAmount;

    private Long shopAmount;

    private Long orderAmount;

    private Long userAmount;

    private String patType;

    private Short invoiceType;

    private String invoiceTitle;

    private Short deliveryType;

    private String userName;

    private String userPhone;

    private Short userSex;

    private String userAddr;

    private String longituedBd;

    private String latituedBd;

    private String longituedGd;

    private String latituedGd;

    private String shipperPhone;

    private String shipperName;

    private String channelId;

    private String deliverDate;

    private String deliverTime;

    private Short cancelType;

    private String cancelReason;

    private String cancelDate;

    private String cancelTime;

    private String completeDate;

    private String completeTime;

    private String remark;

    private String actId;

    private String discountType;

    private Long channelRate;

    private Long shopRate;

    private Long agentRate;

    private Long logisticsRate;

    private Short orderType;

    private Short umqProfitType;

    private Long umqProfitAmount;

    private String channelShopId;

    private Short autoOrder;

    private Integer orderSeq;

    private Short deliveryStatus;

    private Short deliveryCnlReason;

    private String lastTransDate;

    private String lastTransTime;

    private Short noticeStatus;

    private String shopAutoOrder;

    private static final long serialVersionUID = 1L;

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId == null ? null : orgId.trim();
    }

    public String getMercId() {
        return mercId;
    }

    public void setMercId(String mercId) {
        this.mercId = mercId == null ? null : mercId.trim();
    }

    public String getShopId() {
        return shopId;
    }

    public void setShopId(String shopId) {
        this.shopId = shopId == null ? null : shopId.trim();
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName == null ? null : shopName.trim();
    }

    public String getChannelOrderid() {
        return channelOrderid;
    }

    public void setChannelOrderid(String channelOrderid) {
        this.channelOrderid = channelOrderid == null ? null : channelOrderid.trim();
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId == null ? null : orderId.trim();
    }

    public String getViewOrderId() {
        return viewOrderId;
    }

    public void setViewOrderId(String viewOrderId) {
        this.viewOrderId = viewOrderId == null ? null : viewOrderId.trim();
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp == null ? null : timestamp.trim();
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate == null ? null : orderDate.trim();
    }

    public String getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(String orderTime) {
        this.orderTime = orderTime == null ? null : orderTime.trim();
    }

    public String getConfirmDate() {
        return confirmDate;
    }

    public void setConfirmDate(String confirmDate) {
        this.confirmDate = confirmDate == null ? null : confirmDate.trim();
    }

    public String getConfirmTime() {
        return confirmTime;
    }

    public void setConfirmTime(String confirmTime) {
        this.confirmTime = confirmTime == null ? null : confirmTime.trim();
    }

    public String getTraceNo() {
        return traceNo;
    }

    public void setTraceNo(String traceNo) {
        this.traceNo = traceNo == null ? null : traceNo.trim();
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }

    public String getSendImmediately() {
        return sendImmediately;
    }

    public void setSendImmediately(String sendImmediately) {
        this.sendImmediately = sendImmediately == null ? null : sendImmediately.trim();
    }

    public String getExpectDate() {
        return expectDate;
    }

    public void setExpectDate(String expectDate) {
        this.expectDate = expectDate == null ? null : expectDate.trim();
    }

    public String getExpectTime() {
        return expectTime;
    }

    public void setExpectTime(String expectTime) {
        this.expectTime = expectTime == null ? null : expectTime.trim();
    }

    public Long getDeliverAmount() {
        return deliverAmount;
    }

    public void setDeliverAmount(Long deliverAmount) {
        this.deliverAmount = deliverAmount;
    }

    public Long getPackageAmount() {
        return packageAmount;
    }

    public void setPackageAmount(Long packageAmount) {
        this.packageAmount = packageAmount;
    }

    public Long getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(Long discountAmount) {
        this.discountAmount = discountAmount;
    }

    public Long getShopAmount() {
        return shopAmount;
    }

    public void setShopAmount(Long shopAmount) {
        this.shopAmount = shopAmount;
    }

    public Long getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(Long orderAmount) {
        this.orderAmount = orderAmount;
    }

    public Long getUserAmount() {
        return userAmount;
    }

    public void setUserAmount(Long userAmount) {
        this.userAmount = userAmount;
    }

    public String getPatType() {
        return patType;
    }

    public void setPatType(String patType) {
        this.patType = patType == null ? null : patType.trim();
    }

    public Short getInvoiceType() {
        return invoiceType;
    }

    public void setInvoiceType(Short invoiceType) {
        this.invoiceType = invoiceType;
    }

    public String getInvoiceTitle() {
        return invoiceTitle;
    }

    public void setInvoiceTitle(String invoiceTitle) {
        this.invoiceTitle = invoiceTitle == null ? null : invoiceTitle.trim();
    }

    public Short getDeliveryType() {
        return deliveryType;
    }

    public void setDeliveryType(Short deliveryType) {
        this.deliveryType = deliveryType;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone == null ? null : userPhone.trim();
    }

    public Short getUserSex() {
        return userSex;
    }

    public void setUserSex(Short userSex) {
        this.userSex = userSex;
    }

    public String getUserAddr() {
        return userAddr;
    }

    public void setUserAddr(String userAddr) {
        this.userAddr = userAddr == null ? null : userAddr.trim();
    }

    public String getLongituedBd() {
        return longituedBd;
    }

    public void setLongituedBd(String longituedBd) {
        this.longituedBd = longituedBd == null ? null : longituedBd.trim();
    }

    public String getLatituedBd() {
        return latituedBd;
    }

    public void setLatituedBd(String latituedBd) {
        this.latituedBd = latituedBd == null ? null : latituedBd.trim();
    }

    public String getLongituedGd() {
        return longituedGd;
    }

    public void setLongituedGd(String longituedGd) {
        this.longituedGd = longituedGd == null ? null : longituedGd.trim();
    }

    public String getLatituedGd() {
        return latituedGd;
    }

    public void setLatituedGd(String latituedGd) {
        this.latituedGd = latituedGd == null ? null : latituedGd.trim();
    }

    public String getShipperPhone() {
        return shipperPhone;
    }

    public void setShipperPhone(String shipperPhone) {
        this.shipperPhone = shipperPhone == null ? null : shipperPhone.trim();
    }

    public String getShipperName() {
        return shipperName;
    }

    public void setShipperName(String shipperName) {
        this.shipperName = shipperName == null ? null : shipperName.trim();
    }

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId == null ? null : channelId.trim();
    }

    public String getDeliverDate() {
        return deliverDate;
    }

    public void setDeliverDate(String deliverDate) {
        this.deliverDate = deliverDate == null ? null : deliverDate.trim();
    }

    public String getDeliverTime() {
        return deliverTime;
    }

    public void setDeliverTime(String deliverTime) {
        this.deliverTime = deliverTime == null ? null : deliverTime.trim();
    }

    public Short getCancelType() {
        return cancelType;
    }

    public void setCancelType(Short cancelType) {
        this.cancelType = cancelType;
    }

    public String getCancelReason() {
        return cancelReason;
    }

    public void setCancelReason(String cancelReason) {
        this.cancelReason = cancelReason == null ? null : cancelReason.trim();
    }

    public String getCancelDate() {
        return cancelDate;
    }

    public void setCancelDate(String cancelDate) {
        this.cancelDate = cancelDate == null ? null : cancelDate.trim();
    }

    public String getCancelTime() {
        return cancelTime;
    }

    public void setCancelTime(String cancelTime) {
        this.cancelTime = cancelTime == null ? null : cancelTime.trim();
    }

    public String getCompleteDate() {
        return completeDate;
    }

    public void setCompleteDate(String completeDate) {
        this.completeDate = completeDate == null ? null : completeDate.trim();
    }

    public String getCompleteTime() {
        return completeTime;
    }

    public void setCompleteTime(String completeTime) {
        this.completeTime = completeTime == null ? null : completeTime.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getActId() {
        return actId;
    }

    public void setActId(String actId) {
        this.actId = actId == null ? null : actId.trim();
    }

    public String getDiscountType() {
        return discountType;
    }

    public void setDiscountType(String discountType) {
        this.discountType = discountType == null ? null : discountType.trim();
    }

    public Long getChannelRate() {
        return channelRate;
    }

    public void setChannelRate(Long channelRate) {
        this.channelRate = channelRate;
    }

    public Long getShopRate() {
        return shopRate;
    }

    public void setShopRate(Long shopRate) {
        this.shopRate = shopRate;
    }

    public Long getAgentRate() {
        return agentRate;
    }

    public void setAgentRate(Long agentRate) {
        this.agentRate = agentRate;
    }

    public Long getLogisticsRate() {
        return logisticsRate;
    }

    public void setLogisticsRate(Long logisticsRate) {
        this.logisticsRate = logisticsRate;
    }

    public Short getOrderType() {
        return orderType;
    }

    public void setOrderType(Short orderType) {
        this.orderType = orderType;
    }

    public Short getUmqProfitType() {
        return umqProfitType;
    }

    public void setUmqProfitType(Short umqProfitType) {
        this.umqProfitType = umqProfitType;
    }

    public Long getUmqProfitAmount() {
        return umqProfitAmount;
    }

    public void setUmqProfitAmount(Long umqProfitAmount) {
        this.umqProfitAmount = umqProfitAmount;
    }

    public String getChannelShopId() {
        return channelShopId;
    }

    public void setChannelShopId(String channelShopId) {
        this.channelShopId = channelShopId == null ? null : channelShopId.trim();
    }

    public Short getAutoOrder() {
        return autoOrder;
    }

    public void setAutoOrder(Short autoOrder) {
        this.autoOrder = autoOrder;
    }

    public Integer getOrderSeq() {
        return orderSeq;
    }

    public void setOrderSeq(Integer orderSeq) {
        this.orderSeq = orderSeq;
    }

    public Short getDeliveryStatus() {
        return deliveryStatus;
    }

    public void setDeliveryStatus(Short deliveryStatus) {
        this.deliveryStatus = deliveryStatus;
    }

    public Short getDeliveryCnlReason() {
        return deliveryCnlReason;
    }

    public void setDeliveryCnlReason(Short deliveryCnlReason) {
        this.deliveryCnlReason = deliveryCnlReason;
    }

    public String getLastTransDate() {
        return lastTransDate;
    }

    public void setLastTransDate(String lastTransDate) {
        this.lastTransDate = lastTransDate == null ? null : lastTransDate.trim();
    }

    public String getLastTransTime() {
        return lastTransTime;
    }

    public void setLastTransTime(String lastTransTime) {
        this.lastTransTime = lastTransTime == null ? null : lastTransTime.trim();
    }

    public Short getNoticeStatus() {
        return noticeStatus;
    }

    public void setNoticeStatus(Short noticeStatus) {
        this.noticeStatus = noticeStatus;
    }

    public String getShopAutoOrder() {
        return shopAutoOrder;
    }

    public void setShopAutoOrder(String shopAutoOrder) {
        this.shopAutoOrder = shopAutoOrder == null ? null : shopAutoOrder.trim();
    }
}