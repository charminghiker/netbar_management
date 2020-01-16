package com.qlu.netbar_1.mapper;

import com.qlu.netbar_1.pojo.Machine;

import java.util.List;

public interface MachineMapper {
    //查询全部机器信息
    public List<Machine> queryAll();

    //通过ID查询机器信息
    public Machine queryById(int machineId);

    //查询机器区域
    public List<String> queryArea();
    //查询区域内闲置机器
    public List<Machine> queryAreaIdle(String area);
    public List<Machine> queryIdle();

    public int queryPriceById(int machineId);

    //增加机器信息
    public int insert(Machine machine);

    //修改机器信息
    public int update(int machineId, String area, int price);
    //更新状态信息
    public int updateStartById(int machineId);
    public int updateEndById(int machineId);

    //删除机器信息
    public int delete(int machineId);
}
