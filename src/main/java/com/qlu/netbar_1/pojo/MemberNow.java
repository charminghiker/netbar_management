package com.qlu.netbar_1.pojo;

import java.util.Date;

public class MemberNow {
    private int machineId;
    private String area;
    private Date startTime;
    private String strStar;
    private String useTime;
    private int memberId;
    private String memberName;
    private int addMoney;
    private int consumption;
    private int remains;

    public MemberNow(int machineId, String area, Date startTime, String strStar, String useTime, int memberId, String memberName, int addMoney, int consumption, int remains) {
        this.machineId = machineId;
        this.area = area;
        this.startTime = startTime;
        this.useTime = useTime;
        this.memberId = memberId;
        this.memberName = memberName;
        this.addMoney = addMoney;
        this.consumption = consumption;
        this.remains = remains;
    }
    public MemberNow() {
    }

    public int getMachineId() {
        return machineId;
    }

    public void setMachineId(int machineId) {
        this.machineId = machineId;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }
    public String getUseTime() {
        return useTime;
    }

    public void setStrStar(String strStar){ this.strStar = strStar; }
    public String getStrStar(){ return strStar; }

    public void setUseTime(String useTime) {
        this.useTime = useTime;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

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
}
