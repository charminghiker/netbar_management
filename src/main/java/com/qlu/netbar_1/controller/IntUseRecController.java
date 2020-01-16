package com.qlu.netbar_1.controller;

import com.qlu.netbar_1.mapper.*;
import com.qlu.netbar_1.pojo.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class IntUseRecController {
    @Resource
    InterimMapper interimMapper;
    @Resource
    IntUseRecMapper intUseRecMapper;
    @Resource
    MachineMapper machineMapper;
    @Resource
    AdminMapper adminMapper;

    @RequestMapping("/intStart")
    public String intStart(Model model, IntUseRec intUseRec){
        List<Interim> intsIdle = interimMapper.queryByState(0);
        List<Machine> macsIdle = machineMapper.queryIdle();
        List<Admin> admins = adminMapper.queryAll();
        model.addAttribute("intsIdle",intsIdle);
        model.addAttribute("macsIdle",macsIdle);
        model.addAttribute("admins",admins);
        return "addIntUseRec";
    }

    @RequestMapping("/addIntUseRec")
    @ResponseBody
    public String getIntNow(Model model, IntUseRec intUseRec,MebUseRec mebUseRec){
        intUseRec.setStartTime(new Date());
        intUseRec.setRemains(intUseRec.getAddMoney());
        int result1 = intUseRecMapper.insert(intUseRec);
        int result2 = machineMapper.updateStartById(intUseRec.getMachineId());
        int result3 = interimMapper.updateStartById(intUseRec.getInterimId(),intUseRec.getAddMoney());
        String results = "添加失败！";
        if (result1==1 && result2==1 &&result3==1){
            results = "添加成功！";
        }
        return results;
    }
}
