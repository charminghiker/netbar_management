package com.qlu.netbar_1.controller;

import com.qlu.netbar_1.mapper.IntAddRecMapper;
import com.qlu.netbar_1.mapper.IntUseRecMapper;
import com.qlu.netbar_1.mapper.MebAddRecMapper;
import com.qlu.netbar_1.mapper.MebUseRecMapper;
import com.qlu.netbar_1.pojo.IntAddRec;
import com.qlu.netbar_1.pojo.IntUseRec;
import com.qlu.netbar_1.pojo.MebAddRec;
import com.qlu.netbar_1.pojo.MebUseRec;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
public class BusinessController {
    @Resource
    IntUseRecMapper intUseRecMapper;
    @Resource
    MebUseRecMapper mebUseRecMapper;
    @Resource
    IntAddRecMapper intAddRecMapper;
    @Resource
    MebAddRecMapper mebAddRecMapper;

    @RequestMapping(value = "/businessRec")
    public String businessRec(){
        return "businessRec";
    }
    @RequestMapping(value = "/businessMoney")
    public String businessMoney(){
        return "businessMoney";
    }

    @PostMapping(value = "/queryRecByDate")
    @ResponseBody
    public List<?> queryRecByDate(@RequestParam Map<String, List<Object>> request) throws ParseException {
        String[] dates = request.values().toArray(new String[request.values().size()]);
        String[] date = dates[0].split(",");        //分割 开始日期 截止日期
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date startDate = sdf.parse(date[0]);
        Date endDate = sdf.parse(date[1]);
        System.out.println(date[0]);
        System.out.println(startDate);
        System.out.println(endDate);
        List<IntUseRec> intRecs = intUseRecMapper.queryByDate(startDate,endDate);
        List<MebUseRec> mebRecs = mebUseRecMapper.queryByDate(startDate,endDate);
        List<Object> recs = new ArrayList<>();
        recs.addAll(intRecs);
        recs.addAll(mebRecs);
        return recs;
    }

    @PostMapping(value = "/queryMoneyByDate")
    @ResponseBody
    public List<?> queryMoneyByDate(@RequestParam Map<String, List<Object>> request) throws ParseException {
        String[] dates = request.values().toArray(new String[request.values().size()]);
        String[] date = dates[0].split(",");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date startDate = sdf.parse(date[0]);
        Date endDate = sdf.parse(date[1]);
        List<IntAddRec> intRecs = intAddRecMapper.queryByDate(startDate,endDate);
        List<MebAddRec> mebRecs = mebAddRecMapper.queryByDate(startDate,endDate);
        List<Object> recs = new ArrayList<>();
        recs.addAll(intRecs);
        recs.addAll(mebRecs);
        return recs;
    }
}
