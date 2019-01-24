package org.lanqiao.project.controller;

import com.alibaba.fastjson.JSON;
import org.lanqiao.project.pojo.Condition;
import org.lanqiao.project.pojo.Rate;
import org.lanqiao.project.pojo.User;
import org.lanqiao.project.service.RateadminService;
import org.lanqiao.project.utils.PageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@Controller
public class RateadminController {
    @Autowired
    RateadminService rateadminService;
    @RequestMapping("/rate.do")
    public String getRateList(HttpServletRequest request, Model model){
        int pageSize = 2;
        int pageNum = 1;
        if(!StringUtils.isEmpty(request.getParameter("currentPage"))){
            pageNum = Integer.valueOf(request.getParameter("currentPage"));
        }
        Condition condition = Condition.builder().build();
        Object u_name = request.getParameter("searchu_name");
        if(!StringUtils.isEmpty(u_name)){
            condition.setU_name(u_name.toString());
        }
        Object o_id = request.getParameter("searcho_id");
        if(!StringUtils.isEmpty(o_id) && Integer.valueOf(o_id.toString()) != 0){
            condition.setO_id(Integer.valueOf(o_id.toString()));
        }
        Object g_name= request.getParameter("searchg_name");
        if(!StringUtils.isEmpty(g_name)){
            condition.setG_name(g_name.toString());
        }
        Object t_type= request.getParameter("searcht_type");
        if(!StringUtils.isEmpty(t_type)){
            condition.setT_type(t_type.toString());
        }
        int totalRecords = rateadminService.getRateCount(condition);
        PageModel pm = new PageModel(pageNum,totalRecords,pageSize);
        //如果当前页大于总页数，但是排除查询不到数据的情况。当前页等于最大页
        if(pageNum > pm.getTotalPageNum() && pm.getTotalPageNum() != 0){
            pageNum = pm.getTotalPageNum();
        }
        PageModel pageModel = new PageModel(pageNum,totalRecords,pageSize);
        //分页
        condition.setPageSize(pageSize);
        condition.setCurrentPage(pageModel.getStartIndex());
        System.out.println(condition);
        List<Rate> rateList = rateadminService.getAll(condition);
        model.addAttribute("rateList",rateList);
        model.addAttribute("pm",pageModel);
        model.addAttribute("condition",condition);
        model.addAttribute("currentPage",pageNum);
//        model.addAttribute("size",size);
        return "ratelist";
    }
    @RequestMapping("/deleteRate.do")
    public String deleteRateById(int rate_id,HttpServletRequest request, Model model){
        rateadminService.deleteRate(rate_id);
        return getRateList(request,model);
    }
    @RequestMapping("/selectRateByid")
    protected void getUserById(int rate_id,HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/json;charset=utf-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        Rate rate=rateadminService.selectRateByid(rate_id);
        String rateJson = JSON.toJSONString(rate);
        out.print(rateJson);
    }
    //回复评论
    @RequestMapping("/answernews")
    public String answernews(Model model,HttpServletRequest request){
        String id=request.getParameter("id");
        int id1=Integer.parseInt(id);
        String newsanswer=request.getParameter("newsanswer");
        System.out.println(id1+newsanswer+"!!!!!");
        rateadminService.updateRate(newsanswer,id1);
        return getRateList(request,model);
    }
}


