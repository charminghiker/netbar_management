package com.qlu.netbar_1.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qlu.netbar_1.mapper.IntAddRecMapper;
import com.qlu.netbar_1.mapper.IntUseRecMapper;
import com.qlu.netbar_1.mapper.InterimMapper;
import com.qlu.netbar_1.pojo.IntAddRec;
import com.qlu.netbar_1.pojo.IntUseRec;
import com.qlu.netbar_1.pojo.Interim;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
public class InterimController {
    @Resource
    InterimMapper interimMapper;
    @Resource
    IntUseRecMapper intUseRecMapper;
    @Resource
    IntAddRecMapper intAddRecMapper;

    @RequestMapping("/interimPage")
    public String getIntPage(Model model,@RequestParam(defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "3") Integer pageSize,Interim interim){
        //引入分页查询，使用PageHelper分页功能在查询之前传入当前页，然后多少记录
        PageHelper.startPage(pageNum, pageSize);
        //startPage后紧跟的这个查询就是分页查询
        List<Interim> interimsAll = interimMapper.queryAll();
        //使用PageInfo包装查询结果，只需要将pageInfo交给页面就可以
        PageInfo pageInfo = new PageInfo<Interim>(interimsAll,3);

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
        return "intManage";
    }

//    @RequestMapping("interimAll")
//    public String getIntAll(Model model, Interim interim){
//        List<Interim> interimsAll = interimMapper.queryAll();
//        model.addAttribute("intsAll",interimsAll);
//        return "intManage";
//    }

    @RequestMapping(value = "addInterim")
    @ResponseBody
    public String addInterim(Model model,Interim interim){
        String returns = "";
        int result = interimMapper.insert(interim);
        if (result==1){
            returns = "添加成功！";
        }
        return returns;
    }

    @RequestMapping(value = "/interim")
    public String interim(Model model, Interim interim){
        return "interim/interimLogin";
    }
    @RequestMapping(value = "/interimOnLogin", method= RequestMethod.POST)
    public String interimLogin(Model model,  Interim interim){
        int id = interim.getInterimId();
        String pass = interim.getInterimPass();
        String DBpass = interimMapper.queryById(id).getInterimPass();
        model.addAttribute("interimId",id);
        if (pass.equals(DBpass)){
            return "interim/interimMain";
        }else {
            model.addAttribute("errorInfo","请检查你的密码！");
            return "interim/interimLogin";
        }
    }


    @RequestMapping(value = "/interimRec")
    public String interimRec(Model model, int interimId){
        model.addAttribute("interimId", interimId);
        return "interim/interimRec";
    }
    @PostMapping(value = "/queryIntRec")
    @ResponseBody
    public List<IntUseRec> queryRecByDate(@RequestBody Map<String,Map> req) throws ParseException {
        String stringStart = req.get("params").get("startDate").toString();
        String stringEnd = req.get("params").get("endDate").toString();
        int interimId = Integer.parseInt(req.get("params").get("interimId").toString());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date startDate = sdf.parse(stringStart);
        Date endDate = sdf.parse(stringEnd);
        List<IntUseRec> intRecs = intUseRecMapper.querySingleByDate(startDate,endDate,interimId);
        return intRecs;
    }

    @RequestMapping(value = "/interimMoney")
    public String interimMoney(Model model, int interimId){
        model.addAttribute("interimId", interimId);
        return "interim/interimMoney";
    }
    @PostMapping(value = "/queryIntMoney")
    @ResponseBody
    public List<IntAddRec> queryMoneyByDate(@RequestBody Map<String,Map> req) throws ParseException {
        String stringStart = req.get("params").get("startDate").toString();
        String stringEnd = req.get("params").get("endDate").toString();
        int interimId = Integer.parseInt(req.get("params").get("interimId").toString());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date startDate = sdf.parse(stringStart);
        Date endDate = sdf.parse(stringEnd);
        List<IntAddRec> intRecs = intAddRecMapper.querySingleByDate(startDate,endDate,interimId);
        return intRecs;
    }
}
