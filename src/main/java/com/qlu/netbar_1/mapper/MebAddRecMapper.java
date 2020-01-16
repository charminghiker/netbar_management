package com.qlu.netbar_1.mapper;

import com.qlu.netbar_1.pojo.MebAddRec;

import java.util.Date;
import java.util.List;

public interface MebAddRecMapper {
    //查询全部临时卡充值记录
    List<MebAddRec> queryAll();

    //通过ID查询临时卡充值记录
    MebAddRec queryById(int addRecId);
    //通过日期查询充值记录
    List<MebAddRec> queryByDate(Date startDate, Date endDate);
    List<MebAddRec> querySingleByDate(Date startDate, Date endDate, int memberId);

    //上机、充值
    int insert(MebAddRec mebAddRec);

    //删除临时卡上机记录
    int delete(int addRecId);
}