package com.qlu.netbar_1.pojo;

public class Admin {

  private int adminId;
  private String adminPass;
  private String adminName;

  public Admin() {
  }
  public Admin(int adminId, String adminPass, String adminName) {
    this.adminId = adminId;
    this.adminPass = adminPass;
    this.adminName = adminName;
  }

  public int getAdminId() {
    return adminId;
  }

  public void setAdminId(int adminId) {
    this.adminId = adminId;
  }


  public String getAdminPass() {
    return adminPass;
  }

  public void setAdminPass(String adminPass) {
    this.adminPass = adminPass;
  }


  public String getAdminName() {
    return adminName;
  }

  public void setAdminName(String adminName) {
    this.adminName = adminName;
  }

    @Override
    public String toString() {
        return "Admin{" +
                "adminId=" + adminId +
                ", adminPass='" + adminPass + '\'' +
                ", adminName='" + adminName + '\'' +
                '}';
    }
}
