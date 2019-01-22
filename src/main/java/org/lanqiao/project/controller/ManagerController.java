package org.lanqiao.project.controller;

import org.lanqiao.project.pojo.Manager;
import org.lanqiao.project.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class ManagerController {
    @Autowired
    ManagerService managerService;
    @RequestMapping("adminlogin")
    public String login(HttpServletRequest request, Model model, HttpSession session){
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        System.out.println(username+"------"+password);
        Manager manager=managerService.selectUsername(username);
        System.out.println(manager);
//        System.out.println(manager.getPassword()+"根据用户查到的密码");
        session.setAttribute("username",username);
        session.setAttribute("password",password);
        if(username.equals(manager.getUsername())&&password.equals(manager.getPassword())){
            System.out.println("aaaaaaaaaaaaaaaaa");
            return "ad-index";
        }
       else {
           return "ad-login";
        }
    }
    //添加管理员
    @RequestMapping("admin-add.html")
    public  String adminadd(){
        return "admin-add";
    }
    //会员相关
    @RequestMapping("admin-cate.html")
    public  String admincate(){
        return "admin-cate";
    }
    @RequestMapping("admin-edit.html")
    public  String adminedit(){
        return "admin-edit";
    }
    //管理员表
    @RequestMapping("admin-list.html")
    public  String adminlist(Model model){
        List<Manager>managerList=managerService.selectAll();
        int size=managerList.size(); //总共几条数据
        model.addAttribute("managerList",managerList);
        model.addAttribute("size",size);
        return "admin-list";
    }
    @RequestMapping("admin-rule.html")
    public  String adminrule(){
        return "admin-rule";
    }
    @RequestMapping("admin-role.html")
    public  String adminrole(){
        return "admin-role";
    }


}
