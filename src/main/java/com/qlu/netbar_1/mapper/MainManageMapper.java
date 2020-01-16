package com.qlu.netbar_1.mapper;

import com.qlu.netbar_1.pojo.InterimNow;
import com.qlu.netbar_1.pojo.MemberNow;

import java.util.List;

public interface MainManageMapper {

    //查询当前机器、临时卡信息
    public List<InterimNow> queryIntNow();

    //查询当前机器、会员信息
    public List<MemberNow> queryMebNow();

    //精确查询
    public InterimNow queryOneInt(int macId);
    public MemberNow queryOneMeb(int macId);

}
