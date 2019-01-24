package org.lanqiao.project.controller;

import com.alibaba.fastjson.JSON;
import org.lanqiao.project.mapper.ComputerTsAdminMapper;
import org.lanqiao.project.pojo.Condition;
import org.lanqiao.project.pojo.Goodscomput;
import org.lanqiao.project.pojo.Goodscomputer;
import org.lanqiao.project.service.ComputerTsAdminService;
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
public class ComputerTsAdminController {
    @Autowired
    ComputerTsAdminService computerTsAdminService;

    @RequestMapping("/goodscomputerTslist.do")
    public String getGoodsComputerList(HttpServletRequest request, Model model) {
        int pageSize = 5;
        int pageNum = 1;
        if(!StringUtils.isEmpty(request.getParameter("currentPage"))){
            pageNum = Integer.valueOf(request.getParameter("currentPage"));
        }
        Condition condition = Condition.builder().build();
        Object g_id = request.getParameter("searchg_id");
        if(!StringUtils.isEmpty(g_id) && Integer.valueOf(g_id.toString()) != 0){
            condition.setG_id(Integer.valueOf(g_id.toString()));
        }
        Object g_name= request.getParameter("searchg_name");
        if(!StringUtils.isEmpty(g_name)){
            condition.setG_name(g_name.toString());
        }
        Object t_type= request.getParameter("searcht_type");
        if(!StringUtils.isEmpty(t_type)){
            condition.setT_type(t_type.toString());
        }
        int totalRecords = computerTsAdminService.getComputerTsCount(condition);
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
        List<Goodscomputer> goodscomputerList = computerTsAdminService.getAll(condition);
        model.addAttribute("goodscomputerList",goodscomputerList);
        model.addAttribute("pm",pageModel);
        model.addAttribute("condition",condition);
        model.addAttribute("currentPage",pageNum);
        return "goodscomputer2";
    }
    //修改库存
    @RequestMapping("/updateTsKucun")
    public String updateGoodscomputerKucun(Model model,HttpServletRequest request){
        String id=request.getParameter("id2");
        int id1=Integer.parseInt(id);
        String kucun=request.getParameter("kucun");
        int kc=Integer.parseInt(kucun);
        System.out.println(id1+kc+"!!!!!");
        computerTsAdminService.updateTsKucun(kc,id1);
        return getGoodsComputerList(request,model);
    }
    //修改库存
    @RequestMapping("/updateTsPrice")
    public String updateGoodscomputerPrice(Model model,HttpServletRequest request){
        String id=request.getParameter("id3");
        int id1=Integer.parseInt(id);
        String g_oriprice=request.getParameter("g_oriprice");
        Double g_oriprice1=Double.valueOf(g_oriprice);
        String g_price=request.getParameter("g_price");
        Double g_price1=Double.valueOf(g_price);
        computerTsAdminService.updateTsPrice(g_price1,g_oriprice1,id1);
        return getGoodsComputerList(request,model);
    }
    //根据id查询商品详情回显出来传到前段用ajax写出回显值
    @RequestMapping("/selectGoods2")
    protected void getUserById(int g_id,HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/json;charset=utf-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        Goodscomput goodscomput=computerTsAdminService.selectGooodsComputerById(g_id);
        String goodscomputJson = JSON.toJSONString(goodscomput);
        out.print(goodscomputJson);
        System.out.println(goodscomput+"1111111111111111110");
    }
    //上架商品
    @RequestMapping("/addgoodscomputer")
    public String addgoodscomput(Model model,HttpServletRequest request){
        String g_name=request.getParameter("goodsname");
        String price=request.getParameter("price");
        String oriprice=request.getParameter("oriprice");
        Double price1=Double.valueOf(price);
        Double oriprice2=Double.valueOf(oriprice);
        String color=request.getParameter("color");
        String t_type=request.getParameter("t_type");
        String g_num=request.getParameter("g_num");
        int num=Integer.valueOf(g_num);
        String g_img=request.getParameter("g_img");
        String select1=request.getParameter("condition1");
        String select2=request.getParameter("condition2");
        String select3=request.getParameter("condition3");
        String g_xiangqing=select1+","+select2+","+select3;
        String g_neicun=request.getParameter("condition4");
        Date date=new Date();
        SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd hh-MM");
        String time=sdf.format(date);
        Goodscomputer goodscomputer=new Goodscomputer(g_img,g_name,g_xiangqing,price1,oriprice2,color,t_type,g_neicun,time,num);
        computerTsAdminService.insertAddComputer(goodscomputer);
        return getGoodsComputerList(request,model);

    }
    @RequestMapping("/deleteTsComputer")
    public String deleteTsComputer(int g_id,Model model,HttpServletRequest request){
        computerTsAdminService.deleteTsComputer(g_id);
      return getGoodsComputerList(request,model);

    }
}

