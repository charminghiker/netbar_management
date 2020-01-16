package com.qlu.netbar_1.pojo;

import java.util.Date;

public class MebUseRec {
    private int useRecordId;
    private int machineId;
    private Date startTime;
    private Date endTime;
    private int memberId;
    private String memberName;
    private int addMoney;
    private int consumption;
    private int remains;
    private int adminId;

    public MebUseRec(int useRecordId, int machineId,  Date startTime, Date endTime, int memberId, String memberName, int addMoney, int consumption, int remains, int adminId) {
        this.useRecordId = useRecordId;
        this.machineId = machineId;
        this.startTime = startTime;
        this.endTime = endTime;
        this.memberId = memberId;
        this.memberName = memberName;
        this.addMoney = addMoney;
        this.consumption = consumption;
        this.remains = remains;
        this.adminId = adminId;
    }
    public MebUseRec() {
    }

    public int getUseRecordId() {
        return useRecordId;
    }

    public void setUseRecordId(int useRecordId) {
        this.useRecordId = useRecordId;
    }

    public int getMachineId() {
        return machineId;
    }

    public void setMachineId(int machineId) {
        this.machineId = machineId;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public String getMemberName(){ return memberName; }

    public void setMemberName(String memberName){this.memberName = memberName;}

    public int getAddMoney() {
        return addMoney;
    }

    public void setAddMoney(int addMoney) {
        this.addMoney = addMoney;
    }

    public int getConsumption() {
        return consumption;
    }

    public void setConsumption(int consumption) {
        this.consumption = consumption;
    }

    public int getRemains() {
        return remains;
    }

    public void setRemains(int remains) {
        this.remains = remains;
    }

    public int getAdminId() {
        return adminId;
    }

    public void setAdminId(int adminId) {
        this.adminId = adminId;
    }
}
