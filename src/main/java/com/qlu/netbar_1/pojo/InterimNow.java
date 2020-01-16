package com.qlu.netbar_1.pojo;

import java.sql.Time;
import java.util.Date;

public class InterimNow {
    private int machineId;
    private String area;
    private Date startTime;
    private String strStar;
    private String useTime;
    private int interimId;
    private int addMoney;
    private int consumption;
    private int remains;

    public InterimNow(int machineId, String area, Date startTime, String strStar, String useTime, int interimId, int addMoney, int consumption, int remains) {
        this.machineId = machineId;
        this.area = area;
        this.startTime = startTime;
        this.strStar = strStar;
        this.useTime = useTime;
        this.interimId = interimId;
        this.addMoney = addMoney;
        this.consumption = consumption;
        this.remains = remains;
    }
    public InterimNow() {
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

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }
    public Date getStartTime() {
        return startTime;
    }

    public void setStrStar(String strStar) {
        this.strStar = strStar;
    }
    public String getStrStar() {
        return strStar;
    }

    public String getUseTime() {
        return useTime;
    }
    public void setUseTime(String useTime) {
        this.useTime = useTime;
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
