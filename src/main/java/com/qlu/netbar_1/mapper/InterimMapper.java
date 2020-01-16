package com.qlu.netbar_1.mapper;

import com.qlu.netbar_1.pojo.Interim;

import java.util.List;

public interface InterimMapper {
    //查询全部临时卡信息
    public List<Interim> queryAll();
    public List<Interim> queryPage(int pageNum,int pageSize);

    //通过ID查询临时卡信息
    public Interim queryById(int interimId);

    //通过state查询临时卡信息
    public List<Interim> queryByState(int interimState);

    //增加临时卡信息
    public int insert(Interim interim);

    //修改临时卡信息
    public int update(Interim interim);
    //更新状态信息
    public int updateStartById(int interimId, int interimAccount);
    public int updateEndById(int interimId);

    //删除临时卡信息
    public int delete(int interimId);
}
