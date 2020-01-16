package com.qlu.netbar_1.mapper;

import com.qlu.netbar_1.pojo.Admin;

import java.util.List;

public interface AdminMapper {

    //查询全部管理员信息
    public List<Admin> queryAll();

    //通过ID查询管理员信息
    public Admin queryById(int adminId);

    //增加管理员信息
    public int insert(Admin admin);

    //修改管理员信息
    public int update(Admin admin);

    //删除管理员信息
    public int delete(int adminId);

}
