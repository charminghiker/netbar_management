package com.qlu.netbar_1.controller;

import com.qlu.netbar_1.mapper.AdminMapper;
import com.qlu.netbar_1.mapper.MebAddRecMapper;
import com.qlu.netbar_1.mapper.MebUseRecMapper;
import com.qlu.netbar_1.mapper.MemberMapper;
import com.qlu.netbar_1.pojo.Admin;
import com.qlu.netbar_1.pojo.MebAddRec;
import com.qlu.netbar_1.pojo.MebUseRec;
import com.qlu.netbar_1.pojo.Member;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
public class MemberController {
    @Resource
    MemberMapper memberMapper;
    @Resource
    AdminMapper adminMapper;
    @Resource
    MebUseRecMapper mebUseRecMapper;
    @Resource
    MebAddRecMapper mebAddRecMapper;

    @RequestMapping("/memberAll")
    public String getMebAll(Model model, Member member){
        List<Member> membersAll = memberMapper.queryAll();
        List<Admin> admins = adminMapper.queryAll();
        model.addAttribute("admins",admins);
        model.addAttribute("mebsAll",membersAll);
        return "mebManage";
    }

    @RequestMapping("addMember")
    @ResponseBody
    public String addInterim(Model model,Member member){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        member.setMemberDate(dateFormat.format(new Date()));
        String returns = "";
        int result = memberMapper.insertMst(member);
        memberMapper.insertDtl(member);
        if (result==1){
            returns = "添加成功！";
        }
        return returns;
    }


    @RequestMapping(value = "/member")
    public String member(Model model, Member member){
        return "member/memberLogin";
    }
    @RequestMapping(value = "/memberOnLogin", method= RequestMethod.POST)
    public String memberLogin(Model model,  Member member){
        int id = member.getMemberId();
        String pass = member.getMemberPass();
        String DBpass = memberMapper.queryById(id).getMemberPass();
        model.addAttribute("memberId",id);
        if (pass.equals(DBpass)){
            return "member/memberMain";
        }else {
            model.addAttribute("errorInfo","请检查你的密码！");
            return "member/memberLogin";
        }
    }

    @RequestMapping(value = "/memberRec")
    public String memberRec(Model model, int memberId){
        model.addAttribute("memberId", memberId);
        return "member/memberRec";
    }
    @PostMapping(value = "/queryMebRec")
    @ResponseBody
    public List<MebUseRec> queryRecByDate(@RequestBody Map<String, Map> req) throws ParseException {
        String stringStart = req.get("params").get("startDate").toString();
        String stringEnd = req.get("params").get("endDate").toString();
        int memberId = Integer.parseInt(req.get("params").get("memberId").toString());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date startDate = sdf.parse(stringStart);
        Date endDate = sdf.parse(stringEnd);
        List<MebUseRec> mebRecs = mebUseRecMapper.querySingleByDate(startDate,endDate,memberId);
        return mebRecs;
    }

    @RequestMapping(value = "/memberMoney")
    public String memberMoney(Model model, int memberId){
        model.addAttribute("memberId", memberId);
        return "member/memberMoney";
    }
    @PostMapping(value = "/queryMebMoney")
    @ResponseBody
    public List<MebAddRec> queryMoneyByDate(@RequestBody Map<String,Map> req) throws ParseException {
        String stringStart = req.get("params").get("startDate").toString();
        String stringEnd = req.get("params").get("endDate").toString();
        int memberId = Integer.parseInt(req.get("params").get("memberId").toString());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date startDate = sdf.parse(stringStart);
        Date endDate = sdf.parse(stringEnd);
        List<MebAddRec> mebRecs = mebAddRecMapper.querySingleByDate(startDate,endDate,memberId);
        return mebRecs;
    }
}
