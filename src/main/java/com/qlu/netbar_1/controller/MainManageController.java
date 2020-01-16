package com.qlu.netbar_1.controller;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.qlu.netbar_1.mapper.*;
import com.qlu.netbar_1.pojo.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
public class MainManageController {
    @Resource
    private MainManageMapper mainManageMapper;
    @Resource
    private MachineMapper machineMapper;
    @Resource
    private AdminMapper adminMapper;
    @Resource
    private InterimMapper interimMapper;
    @Resource
    private IntUseRecMapper intUseRecMapper;
    @Resource
    private IntAddRecMapper intAddRecMapper;
    @Resource
    private MemberMapper memberMapper;
    @Resource
    private MebUseRecMapper mebUseRecMapper;
    @Resource
    private MebAddRecMapper mebAddRecMapper;

    @RequestMapping("/mainManage")
    public String getMainNow(Model model, IntUseRec intUseRec, MebUseRec mebUseRec){
        List<InterimNow> intsNow = mainManageMapper.queryIntNow();
        List<MemberNow> mebsNow = mainManageMapper.queryMebNow();
        Date now = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd kk:mm:ss");
        for(InterimNow i:intsNow){
            long useMilis = now.getTime()-i.getStartTime().getTime();
            long useHours = (useMilis)/(1000*60*60);
            long useMins = useMilis/(1000*60)-useHours*60;
            long useSecs = useMilis/1000-useMins*60-useHours*60*60;
            String useTime = useHours+":"+useMins+":"+useSecs;
            int price = machineMapper.queryPriceById(i.getMachineId());
            i.setStrStar(sdf.format(i.getStartTime()));
            i.setUseTime(useTime);
            if (useMins!=0 && useMilis!=0){
                useHours += 1;
            }
            i.setConsumption((int) (useHours*price));
            i.setRemains((int) (i.getAddMoney()-(useHours*price)));
        }
        for (MemberNow m:mebsNow){
            long useMilis = now.getTime()-m.getStartTime().getTime();
            long useHours = (useMilis)/(1000*60*60);
            long useMins = useMilis/(1000*60)-useHours*60;
            long useSecs = useMilis/1000-useMins*60-useHours*60*60;
            String useTime = useHours+":"+useMins+":"+useSecs;
            m.setStrStar(sdf.format(m.getStartTime()));
            m.setUseTime(useTime);
            if ( useMilis!=0){
                useHours += 1;
            }
            // 预付款=本次预付款+账户余额 **已在MebUseController中添加
            int account = memberMapper.queryById(m.getMemberId()).getMemberAccount();
            m.setAddMoney(account);
            int memberPrice = (int) (machineMapper.queryPriceById(m.getMachineId()) * 0.8);
            int consumption = (int)useHours * memberPrice;
            m.setConsumption(consumption);
            m.setRemains(m.getAddMoney()-consumption);
        }
        model.addAttribute("intsNow",intsNow);
        model.addAttribute("mebsNow",mebsNow);
        return "mainManage";
    }

    @PostMapping(value = "/thisEnd")
    @ResponseBody
    public String thisEnd(@RequestParam Map<String,List<Object>> request){
        String[] arrs = request.values().toArray(new String[request.values().size()]);
        StringBuilder macMsg = new StringBuilder();
        for (String arr: arrs){
            //machineId type cardId consumption remains
            String[] oneInfo = arr.split(",");
            int machineId = Integer.parseInt(oneInfo[0]);
            macMsg.append(machineId).append("号机");
            int cardId = Integer.parseInt(oneInfo[2]);
            int consumption = Integer.parseInt(oneInfo[3]);
            int remains = Integer.parseInt(oneInfo[4]);
            //机器状态置0、卡状态账户置0、上机记录置结束时间-消费-余额
            if ("临时卡".equals(oneInfo[1])){
                machineMapper.updateEndById( machineId );
                interimMapper.updateEndById( cardId );
                intUseRecMapper.updateEndByMac( machineId, new Date(), consumption, remains );
            }else if("会员".equals(oneInfo[1])){
                machineMapper.updateEndById( machineId );
                memberMapper.updateEndById( cardId,remains );
                memberMapper.updateLastUse(cardId, new Date());
                mebUseRecMapper.updateEndByMac( machineId, new Date(), consumption, remains );
            }
        }
        return macMsg+"已下机！";
    }

    @PostMapping(value = "/mainAddMoney")
    @ResponseBody
    public String updMachine(@RequestParam Map<String,List<Object>> request,Machine machine){
        String[] upds = request.values().toArray(new String[request.values().size()]);
        String[] upd = upds[0].split(",");      //拆分：2,临时卡,33
        String resultMsg = "充值失败";
        if ("临时卡".equals(upd[1])){
            int result1 = intUseRecMapper.updAddMoney(Integer.parseInt(upd[0]), Integer.parseInt(upd[2]));
            IntAddRec intAddRec = new IntAddRec(new Date(),Integer.parseInt(upd[0]), Integer.parseInt(upd[2]),888007);
            int result2 = intAddRecMapper.insert(intAddRec);
            if (result1==1 && result2==1){
                resultMsg = "充值成功";
            }
        }else if ("会员".equals(upd[1])){
            int result1 = mebUseRecMapper.updAddMoney(Integer.parseInt(upd[0]), Integer.parseInt(upd[2]));
            MebAddRec mebAddRec = new MebAddRec(new Date(),Integer.parseInt(upd[0]), Integer.parseInt(upd[2]),888007);
            int result2 = mebAddRecMapper.insert(mebAddRec);
            if (result1==1 && result2==1){
                resultMsg = "充值成功";
            }
            System.out.println("member ADD Money");
        }
        return resultMsg;
    }

    @PostMapping(value = "/queryOneMac")
    @ResponseBody
    public Object queryMacById(@RequestParam Map<String,List<Object>> request){
        String[] arrs = request.values().toArray(new String[request.values().size()]);
        InterimNow intNow = mainManageMapper.queryOneInt(Integer.parseInt(arrs[0]));
        MemberNow mebNow = mainManageMapper.queryOneMeb(Integer.parseInt(arrs[0]));

        Date now = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd kk:mm:ss");
        if (intNow != null){
            InterimNow obj = intNow;
            long useMilis = now.getTime()-obj.getStartTime().getTime();
            long useHours = (useMilis)/(1000*60*60);
            long useMins = useMilis/(1000*60)-useHours*60;
            long useSecs = useMilis/1000-useMins*60-useHours*60*60;
            String useTime = useHours+":"+useMins+":"+useSecs;
            int price = machineMapper.queryPriceById(obj.getMachineId());
            obj.setStrStar(sdf.format(obj.getStartTime()));
            obj.setUseTime(useTime);
            obj.setConsumption((int)useHours*price);
            return intNow;
        }else if (mebNow != null){
            MemberNow obj = mebNow;
            long useMilis = now.getTime()-obj.getStartTime().getTime();
            long useHours = (useMilis)/(1000*60*60);
            long useMins = useMilis/(1000*60)-useHours*60;
            long useSecs = useMilis/1000-useMins*60-useHours*60*60;
            String useTime = useHours+":"+useMins+":"+useSecs;
            int price = machineMapper.queryPriceById(obj.getMachineId());
            obj.setStrStar(sdf.format(obj.getStartTime()));
            obj.setUseTime(useTime);
            obj.setConsumption((int)useHours*price);
            return mebNow;
        }else {
            return null;
        }
    }
}