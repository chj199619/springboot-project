package org.lanqiao.project.controller;

import com.alibaba.fastjson.JSON;
import org.lanqiao.project.pojo.Condition;
import org.lanqiao.project.pojo.Goodscomput;
import org.lanqiao.project.pojo.Type;
import org.lanqiao.project.pojo.User;
import org.lanqiao.project.service.TypeService;
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
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class TypeController {
    @Autowired
    TypeService typeService;
    @RequestMapping("/typelist")
    public String getTypeList(HttpServletRequest request, Model model) {
        int pageSize = 5;
        int pageNum = 1;
        if(!StringUtils.isEmpty(request.getParameter("currentPage"))){
            pageNum = Integer.valueOf(request.getParameter("currentPage"));
        }
        Condition condition = Condition.builder().build();
        Object id = request.getParameter("searchid");
        if(!StringUtils.isEmpty(id) && Integer.valueOf(id.toString()) != 0){
            condition.setId(Integer.valueOf(id.toString()));
        }
        Object zhuangtai= request.getParameter("searchzhuangtai");
        if(!StringUtils.isEmpty(zhuangtai)){
            condition.setZhuangtai(zhuangtai.toString());
        }
        Object t_type= request.getParameter("searcht_type");
        if(!StringUtils.isEmpty(t_type)){
            condition.setT_type(t_type.toString());
        }
        int totalRecords = typeService.getTypeCount(condition);
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
        List<Type> typeList = typeService.getAll(condition);
        model.addAttribute("typeList",typeList);
        model.addAttribute("pm",pageModel);
        model.addAttribute("condition",condition);
        model.addAttribute("currentPage",pageNum);
        return "typelist";
    }
    @RequestMapping("deleteTypeById")
    public String deleteType(HttpServletRequest request,Model model,int id){
        typeService.deleteType(id);
        return getTypeList(request,model);
    }
    @RequestMapping("addType")
    public String addType(Model model,HttpServletRequest request)  {
        String typename=request.getParameter("t_type");
        String zhuangtai=request.getParameter("condition");
        Date date=new Date();
        SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd hh-MM");
        String time=sdf.format(date);
        Type type=new Type(typename,zhuangtai,time);
        typeService.insertType(type);
        return getTypeList(request,model);
    }
    @RequestMapping("/selectType")
    protected void getTypeById(int id,HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/json;charset=utf-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        Type type=typeService.selectTypeByid(id);
        String typeJson = JSON.toJSONString(type);
        out.print(typeJson);
    }
    @RequestMapping("/updatezhuangtai")
    public String updateZhuangtai(Model model,HttpServletRequest request){
        String id=request.getParameter("id2");
        int id1=Integer.parseInt(id);
        Date date=new Date();
        SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd hh-MM");
        String time=sdf.format(date);
        String condition2=request.getParameter("condition2");
        System.out.println(condition2+"121324545");
        if (condition2.equals("已上架")){
            typeService.updateRate3(condition2,time,"",id1);
            return getTypeList(request,model);
        }if(condition2.equals("敬请期待")||condition2.equals("预售")){
            typeService.updateRate3(condition2,"","",id1);
            return getTypeList(request,model);
        }
        else {
            typeService.updateRate(condition2,time,id1);
            return getTypeList(request,model);
        }

    }


}
