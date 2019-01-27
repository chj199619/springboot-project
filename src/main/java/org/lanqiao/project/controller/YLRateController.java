package org.lanqiao.project.controller;

import org.lanqiao.project.pojo.YLRate;
import org.lanqiao.project.service.RateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class YLRateController {
    @Autowired
    RateService rateService;
    @RequestMapping("insertRate")
    public String insertRate(HttpServletRequest request, Model model){
        String g_id=request.getParameter("g_id");
        String u_id=request.getParameter("uid");
        String g_name=request.getParameter("g_name");
        String ratenews=request.getParameter("ratenew");
        int gid=Integer.parseInt(g_id);
        int uid=Integer.parseInt(u_id);
        System.out.println("++++++++++++++++++"+ratenews);
        YLRate ylRate=new YLRate(uid,gid,g_name,ratenews);
        System.out.println(ylRate);
        System.out.println(ylRate);
        rateService.insertRate(ylRate);
        return "pingjiachenggong";


    }
}
