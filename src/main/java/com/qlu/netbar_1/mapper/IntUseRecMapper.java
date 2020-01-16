package com.qlu.netbar_1.mapper;

import com.qlu.netbar_1.pojo.IntUseRec;

import java.util.Date;
import java.util.List;

public interface IntUseRecMapper {
    //查询全部临时卡上机记录
    public List<IntUseRec> queryAll();

    //通过ID查询临时卡上机记录
    public IntUseRec queryById(int useRecId);
    //通过日期查询上机记录
    public List<IntUseRec> queryByDate(Date startDate, Date endDate);
    public List<IntUseRec> querySingleByDate(Date startDate, Date endDate, int interimId);

    //上机
    public int insert(IntUseRec intUseRec);

    //下机
    public int updateEndByMac(int machineId, Date endTime, int consumption, int remains);

    public int update(Date endTime);
    public int updAddMoney(int interimId,int addMoney);

    //删除临时卡上机记录
    public int delete(int useRecId);
}
