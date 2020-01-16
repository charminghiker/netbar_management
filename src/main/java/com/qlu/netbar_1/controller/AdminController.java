package com.qlu.netbar_1.controller;

import com.qlu.netbar_1.mapper.AdminMapper;
import com.qlu.netbar_1.pojo.Admin;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.List;

@Controller
public class AdminController {
    @Resource
    private AdminMapper adminMapper;

    @RequestMapping(value = "/")
    public String index(){return "./index";}

    @RequestMapping(value = "/admin")
    public String adIndex( Admin admin ){    //方法参数必须加实体类声明，否则报错
        return "adLogin";
    }

    @RequestMapping(value = "/submit", method=RequestMethod.POST)
    public String adLogin(Model model,  Admin admin){
        //获得提交的管理员账号、密码
        int id = admin.getAdminId();
        String pass = admin.getAdminPass();
        //获取数据库中此ID的密码信息
        String DBpass = adminMapper.queryById(id).getAdminPass();
        model.addAttribute("adminId",id);
        if (pass.equals(DBpass)){
//            HttpSession session = request.getSession();
            return "adMain";
        }else {
            model.addAttribute("errorInfo","请检查你的密码！");
            return "adLogin";
        }
    }

    @RequestMapping(value = "/adMain")
    public String adMain(){
        return "adMain";
    }


    @RequestMapping(value = "/adminManage")
    public String getAdmAll(Model model, Admin admin){
        List<Admin> adminsAll = adminMapper.queryAll();
        model.addAttribute("admsAll",adminsAll);
        return "adminManage";
    }
    @RequestMapping(value = "/addAdmin")
    @ResponseBody
    public String addInterim(Model model,Admin admin){
        String returns = "添加失败";
        int result = adminMapper.insert(admin);
        if (result==1){
            returns = "添加成功！";
        }
        return returns;
    }
}
