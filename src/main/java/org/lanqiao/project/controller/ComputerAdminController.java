package org.lanqiao.project.controller;

import com.alibaba.fastjson.JSON;
import org.lanqiao.project.pojo.Condition;
import org.lanqiao.project.pojo.Goodscomput;
import org.lanqiao.project.service.ComputerAdminService;
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
public class ComputerAdminController {
    @Autowired
    ComputerAdminService computerAdminService;
    @RequestMapping("/goodscomputerlist.do")
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
        int totalRecords = computerAdminService.getComputerCount(condition);
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
        List<Goodscomput> goodscomputList = computerAdminService.getAll(condition);
        model.addAttribute("goodscomputList",goodscomputList);
        model.addAttribute("pm",pageModel);
        model.addAttribute("condition",condition);
        model.addAttribute("currentPage",pageNum);
        return "goodscomputer";
    }
    //修改库存
    @RequestMapping("/updateKucun")
    public String updateGoodscomputKucun(Model model,HttpServletRequest request){
        String id=request.getParameter("id2");
        int id1=Integer.parseInt(id);
        String kucun=request.getParameter("kucun");
        int kc=Integer.parseInt(kucun);
        System.out.println(id1+kc+"!!!!!");
        computerAdminService.updateKucun(kc,id1);
        return getGoodsComputerList(request,model);
    }
    //修改库存
    @RequestMapping("/updatePrice")
    public String updateGoodscomputPrice(Model model,HttpServletRequest request){
        String id=request.getParameter("id3");
        int id1=Integer.parseInt(id);
        String g_oriprice=request.getParameter("g_oriprice");
        Double g_oriprice1=Double.valueOf(g_oriprice);
        String g_price=request.getParameter("g_price");
        Double g_price1=Double.valueOf(g_price);
        computerAdminService.updatePrice(g_price1,g_oriprice1,id1);
        return getGoodsComputerList(request,model);
    }
    //根据id查询商品详情回显出来传到前段用ajax写出回显值
    @RequestMapping("/selectGoods")
    protected void getUserById(int g_id,HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/json;charset=utf-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        Goodscomput goodscomput=computerAdminService.selectGooodsComputById(g_id);
        String goodscomputJson = JSON.toJSONString(goodscomput);
        out.print(goodscomputJson);
    }
    //上架商品
    @RequestMapping("/addgoodscomput")
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
        Goodscomput goodscomput=new Goodscomput(g_img,g_name,g_xiangqing,price1,oriprice2,color,t_type,g_neicun,num);
        computerAdminService.insertAddComput(goodscomput);
         return getGoodsComputerList(request,model);
    }
    //删除
    @RequestMapping("/deletegoodcomput")
    public String delete(HttpServletRequest request,Model model,int g_id){
        computerAdminService.deletegoodscomput(g_id);
        return getGoodsComputerList(request,model);
    }

}