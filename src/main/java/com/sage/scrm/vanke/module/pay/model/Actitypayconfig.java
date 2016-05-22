package com.sage.scrm.vanke.module.pay.model;

import java.math.BigDecimal;

public class Actitypayconfig {
    private BigDecimal activityid;

    private String activitytype;

    private String activityname;

    private BigDecimal personlimit;

    private BigDecimal activitymoney;

    private String status;

    public BigDecimal getActivityid() {
        return activityid;
    }

    public void setActivityid(BigDecimal activityid) {
        this.activityid = activityid;
    }

    public String getActivitytype() {
        return activitytype;
    }

    public void setActivitytype(String activitytype) {
        this.activitytype = activitytype;
    }

    public String getActivityname() {
        return activityname;
    }

    public void setActivityname(String activityname) {
        this.activityname = activityname;
    }

    public BigDecimal getPersonlimit() {
        return personlimit;
    }

    public void setPersonlimit(BigDecimal personlimit) {
        this.personlimit = personlimit;
    }

    public BigDecimal getActivitymoney() {
        return activitymoney;
    }

    public void setActivitymoney(BigDecimal activitymoney) {
        this.activitymoney = activitymoney;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}