package com.qlu.netbar_1.controller;

import com.qlu.netbar_1.mapper.AdminMapper;
import com.qlu.netbar_1.mapper.MachineMapper;
import com.qlu.netbar_1.mapper.MebUseRecMapper;
import com.qlu.netbar_1.mapper.MemberMapper;
import com.qlu.netbar_1.pojo.Admin;
import com.qlu.netbar_1.pojo.Machine;
import com.qlu.netbar_1.pojo.MebUseRec;
import com.qlu.netbar_1.pojo.Member;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class MebUseRecController {
    @Resource
    MebUseRecMapper mebUseRecMapper;
    @Resource
    MachineMapper machineMapper;
    @Resource
    AdminMapper adminMapper;
    @Resource
    MemberMapper memberMapper;

    @RequestMapping("/mebStart")
    //截获main发的事务 =》 查询闲置机器、管理员 =》 返回addMebUseRec页面
    public String mebStart(Model model,MebUseRec mebUseRec){
        List<Machine> macsIdle = machineMapper.queryIdle();
        List<Admin> admins = adminMapper.queryAll();
        model.addAttribute("macsIdle",macsIdle);
        model.addAttribute("admins",admins);
        return "addMebUseRec";
    }

    @RequestMapping("/addMebUseRec")
    @ResponseBody
    //截获addMebUseRec发的提交事务 =》 业务a自获取时间 b姓名 c处理余额 =》添加记录，返回mainManage
    public String getMebNow(Model model, MebUseRec mebUseRec){
        mebUseRec.setStartTime(new Date());
        //通过激活ID获取member表名字，写入记录表
        Member member = memberMapper.queryById(mebUseRec.getMemberId());
        mebUseRec.setMemberName(member.getMemberName());
        mebUseRec.setRemains(mebUseRec.getAddMoney()+member.getMemberAccount());

        int result1 = mebUseRecMapper.insert(mebUseRec);
        int result2 = machineMapper.updateStartById(mebUseRec.getMachineId());
        int result3 = memberMapper.updateStartById(mebUseRec.getMemberId(),mebUseRec.getAddMoney());
        String results = "添加失败！";
        if (result1==1 && result2==1 &&result3==1){
            results = "添加成功！";
        }
        return results;
    }

}
