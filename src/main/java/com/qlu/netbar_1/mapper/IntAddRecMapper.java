package com.qlu.netbar_1.mapper;

import com.qlu.netbar_1.pojo.IntAddRec;

import java.util.Date;
import java.util.List;

public interface IntAddRecMapper {
    //查询全部临时卡充值记录
    List<IntAddRec> queryAll();
    Date queryAdminById(int recId);

    //通过ID查询临时卡充值记录
    IntAddRec queryById(int addRecId);
    //通过日期查询充值记录
    List<IntAddRec> queryByDate(Date startDate, Date endDate);
    List<IntAddRec> querySingleByDate(Date startDate, Date endDate, int interimId);

    //上机、充值
    int insert(IntAddRec intAddRec);

    //删除临时卡充值记录
    int delete(int addRecId);
}