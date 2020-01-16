package com.qlu.netbar_1.pojo;

import java.util.Date;

public class MebAddRec {
    private int addRecordId;
    private Date addTime;
    private int interimId;
    private int addMoney;
    private int adminId;

    public MebAddRec( int addRecordId, Date addTime, int interimId, int addMoney, int adminId) {
        this.addRecordId = addRecordId;
        this.addTime = addTime;
        this.interimId = interimId;
        this.addMoney = addMoney;
        this.adminId = adminId;
    }

    public MebAddRec(Date addTime, int interimId, int addMoney, int adminId) {
        this.addTime = addTime;
        this.interimId = interimId;
        this.addMoney = addMoney;
        this.adminId = adminId;
    }

    public int getAddRecordId() {
        return addRecordId;
    }

    public void setAddRecordId(int addRecordId) {
        this.addRecordId = addRecordId;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public int getInterimId() {
        return interimId;
    }

    public void setInterimId(int interimId) {
        this.interimId = interimId;
    }

    public int getAddMoney() {
        return addMoney;
    }

    public void setAddMoney(int addMoney) {
        this.addMoney = addMoney;
    }

    public int getAdminId() {
        return adminId;
    }

    public void setAdminId(int adminId) {
        this.adminId = adminId;
    }
}