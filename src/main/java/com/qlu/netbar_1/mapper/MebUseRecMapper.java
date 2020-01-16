package com.qlu.netbar_1.mapper;

import com.qlu.netbar_1.pojo.MebUseRec;

import java.util.Date;
import java.util.List;

public interface MebUseRecMapper {
    //查询全部上机记录
    List<MebUseRec> queryAll();

    //通过ID查询上机记录
    MebUseRec queryById(int useRecId);
    //通过日期查询上机记录
    List<MebUseRec> queryByDate(Date startDate, Date endDate);
    List<MebUseRec> querySingleByDate(Date startDate, Date endDate, int memberId);


    //激活
    int insert(MebUseRec mebUseRec);

    //下机
    int updateEndByMac(int machineId, Date endTime, int consumption, int remains);

    int update(MebUseRec mebUseRec);
    int updAddMoney(int memberId, int addMoney);

    //删除上机记录
    int delete(int useRecId);
}
