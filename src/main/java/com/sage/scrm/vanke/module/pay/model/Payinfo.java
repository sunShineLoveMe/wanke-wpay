package com.sage.scrm.vanke.module.pay.model;

import java.math.BigDecimal;
import java.util.Date;

public class Payinfo {
    private BigDecimal id;

    private BigDecimal activityid;

    private String mobile;

    private BigDecimal memberid;

    private BigDecimal personnumber;

    private BigDecimal paymoney;

    private String paystatus;

    private String ordernumber;

    private Date paytime;

    private String transactionid;

    private Date checktime;

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getActivityid() {
        return activityid;
    }

    public void setActivityid(BigDecimal activityid) {
        this.activityid = activityid;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public BigDecimal getMemberid() {
        return memberid;
    }

    public void setMemberid(BigDecimal memberid) {
        this.memberid = memberid;
    }

    public BigDecimal getPersonnumber() {
        return personnumber;
    }

    public void setPersonnumber(BigDecimal personnumber) {
        this.personnumber = personnumber;
    }

    public BigDecimal getPaymoney() {
        return paymoney;
    }

    public void setPaymoney(BigDecimal paymoney) {
        this.paymoney = paymoney;
    }

    public String getPaystatus() {
        return paystatus;
    }

    public void setPaystatus(String paystatus) {
        this.paystatus = paystatus;
    }

    public String getOrdernumber() {
        return ordernumber;
    }

    public void setOrdernumber(String ordernumber) {
        this.ordernumber = ordernumber;
    }

    public Date getPaytime() {
        return paytime;
    }

    public void setPaytime(Date paytime) {
        this.paytime = paytime;
    }

    public String getTransactionid() {
        return transactionid;
    }

    public void setTransactionid(String transactionid) {
        this.transactionid = transactionid;
    }

    public Date getChecktime() {
        return checktime;
    }

    public void setChecktime(Date checktime) {
        this.checktime = checktime;
    }
}