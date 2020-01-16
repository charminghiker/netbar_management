package com.qlu.netbar_1.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qlu.netbar_1.mapper.IntUseRecMapper;
import com.qlu.netbar_1.mapper.MachineMapper;
import com.qlu.netbar_1.pojo.Machine;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Controller
public class MachineController {
    @Resource
    MachineMapper machineMapper;

    @RequestMapping("/machineInfo")
    public String getMachineInfo(Model model, Machine machine){
        List<Machine> machineInfos = machineMapper.queryAll();
        model.addAttribute("macInfos",machineInfos);
        return "macManage";
    }

    @RequestMapping("/machinePage")
    public String getIntPage(Model model,@RequestParam(defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "10") Integer pageSize,Machine machine){
        //引入分页查询，使用PageHelper分页功能在查询之前传入当前页，然后多少记录
        PageHelper.startPage(pageNum, pageSize);
        //startPage后紧跟的这个查询就是分页查询
        List<Machine> machines = machineMapper.queryAll();
        //使用PageInfo包装查询结果，只需要将pageInfo交给页面就可以
        PageInfo pageInfo = new PageInfo<Machine>(machines,5);

        model.addAttribute("pageInfo", pageInfo);
        //获得当前页
        model.addAttribute("pageNum", pageInfo.getPageNum());
        //获得一页显示的条数
        model.addAttribute("pageSize", pageInfo.getPageSize());
        //是否是第一页
        model.addAttribute("isFirstPage", pageInfo.isIsFirstPage());
        //获得总页数
        model.addAttribute("totalPages", pageInfo.getPages());
        //是否是最后一页
        model.addAttribute("isLastPage", pageInfo.isIsLastPage());
        return "macManage";
    }

    @RequestMapping("/addMachine")
    @ResponseBody
    public String addMachine(Machine machine){
        int result = machineMapper.insert(machine);
        String resultMsg = "添加失败！";
        if (result==1){
            resultMsg = "添加成功！";
        }
        return resultMsg;
    }

    @PostMapping(value = "/updMachine")
    @ResponseBody
    public String updMachine(@RequestParam Map<String,List<Object>> request,Machine machine){
        String[] upds = request.values().toArray(new String[request.values().size()]);
        String[] upd = upds[0].split(",");      //拆分：1,娱乐休闲区,33
        int result = machineMapper.update(Integer.parseInt(upd[0]),upd[1],Integer.parseInt(upd[2]));
        String resultMsg = "修改失败";
        if (result == 1){
            resultMsg = "修改成功";
        }
        return resultMsg;
    }

    @PostMapping(value = "/delMachine")
    @ResponseBody
    public String delMachine(@RequestParam Map<String,List<Object>> request,Machine machine){
        //根据获取机器ID，删除
        String[] macsId = request.values().toArray(new String[request.values().size()]);
        String resultMsg = "删除成功";
        for (String macId:macsId){
            if ( machineMapper.delete(Integer.parseInt(macId))==0 ){
                resultMsg = "删除失败";
            }
        }
        return resultMsg;
    }
}
