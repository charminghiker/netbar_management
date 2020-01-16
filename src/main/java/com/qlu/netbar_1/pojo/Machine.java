package com.qlu.netbar_1.pojo;

public class Machine {
    private int machineId;
    private String area;
    private int price;
    private int machineState;

    public Machine() {
    }
    public Machine(int machineId, String area, int price, int machineState) {
        this.machineId = machineId;
        this.area = area;
        this.price = price;
        this.machineState = machineState;
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getMachineState() {
        return machineState;
    }

    public void setMachineState(int machineState) {
        this.machineState = machineState;
    }
}
