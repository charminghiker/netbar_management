package com.qlu.netbar_1.pojo;


public class Member {

    private int memberId;
    private String memberPass;
    private String memberName;
    private int memberState;
    private int memberAccount;
    private String memberIdentityId;
    private int memberAge;
    private int adminId;
    private String memberDate;
    private java.sql.Timestamp lastUse;


    public int getMemberId() {
        return memberId;
    }
    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }


    public String getMemberPass() {
        return memberPass;
    }
    public void setMemberPass(String memberPass) {
        this.memberPass = memberPass;
    }


    public String getMemberName() {
        return memberName;
    }
    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }


    public int getMemberState() {
        return memberState;
    }
    public void setMemberState(int memberState) {
        this.memberState = memberState;
    }


    public int getMemberAccount() {
        return memberAccount;
    }
    public void setMemberAccount(int memberAccount) {
        this.memberAccount = memberAccount;
    }

    public String getMemberIdentityId() {
        return memberIdentityId;
    }
    public void setMemberIdentityId(String memberIdentityId) {
        this.memberIdentityId = memberIdentityId;
    }


    public int getMemberAge() {
        return memberAge;
    }
    public void setMemberAge(int memberAge) {
        this.memberAge = memberAge;
    }


    public int getAdminId() {
        return adminId;
    }
    public void setAdminId(int adminId) {
        this.adminId = adminId;
    }


    public String getMemberDate() {
        return memberDate;
    }
    public void setMemberDate(String memberDate) {
        this.memberDate = memberDate;
    }

    public java.sql.Timestamp getLastUse() {
        return lastUse;
    }
    public void setLastUse(java.sql.Timestamp lastUse) {
        this.lastUse = lastUse;
    }
}