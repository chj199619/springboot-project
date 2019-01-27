package org.lanqiao.project.controller;


import com.alibaba.fastjson.JSON;
import org.lanqiao.project.pojo.Condition;
import org.lanqiao.project.pojo.CUser;
import org.lanqiao.project.service.CUserService;
import org.lanqiao.project.utils.PageModel;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class CUserController {
    @Autowired
    CUserService cuserService;
    @RequestMapping("ad-index")
    public String index(Model model){
        return "ad-index";
    }
    @RequestMapping("member-list.html")
    public String queryAll(Model model){
        List<CUser>userList=cuserService.selectAll();
        int size=userList.size();
        model.addAttribute("size",size);
        model.addAttribute("userlist",userList);
        return "member-list";
    }
@RequestMapping("/memberlist2.do")
public String getUserList(HttpServletRequest request,Model model){
    int pageSize = 5;
    int pageNum = 1;
    if(!StringUtils.isEmpty(request.getParameter("currentPage"))){
        pageNum = Integer.valueOf(request.getParameter("currentPage"));
    }
    Condition condition = Condition.builder().build();
    Object u_id = request.getParameter("searchu_id");
    if(!StringUtils.isEmpty(u_id) && Integer.valueOf(u_id.toString()) != 0){
        condition.setU_id(Integer.valueOf(u_id.toString()));
    }
    Object u_name= request.getParameter("searchu_name");
    if(!StringUtils.isEmpty(u_name)){
        condition.setU_name(u_name.toString());
    }
    Object u_nickname= request.getParameter("searchu_nickname");
    if(!StringUtils.isEmpty(u_nickname)){
        condition.setU_nickname(u_nickname.toString());
    }
    int totalRecords = cuserService.getUserCount(condition);
    PageModel pm = new PageModel(pageNum,totalRecords,pageSize);
        //如果当前页大于总页数，但是排除查询不到数据的情况。当前页等于最大页
    if(pageNum > pm.getTotalPageNum() && pm.getTotalPageNum() !=0){
            pageNum = pm.getTotalPageNum();
    }
    PageModel pageModel = new PageModel(pageNum,totalRecords,pageSize);
    //分页
    condition.setPageSize(pageSize);
    condition.setCurrentPage(pageModel.getStartIndex());
    System.out.println(condition);
    //总共人数
    List<CUser> userList1 = cuserService.selectAll();
    int size=userList1.size();
    List<CUser> userList = cuserService.getAll(condition);
    model.addAttribute("userList",userList);
    model.addAttribute("pm",pageModel);
    model.addAttribute("condition",condition);
    model.addAttribute("currentPage",pageNum);
    model.addAttribute("size",size);
    return "member-list2";
}

    //新增用户
    @RequestMapping("adduser")
    public String adduser(Model model,HttpServletRequest request)  {
        String username=request.getParameter("username");
        System.out.println(username+"11111111111111111111111111111111111111111111111111111");
        String nikename=request.getParameter("nickname");
        String n1=request.getParameter("username");
        String password=request.getParameter("password");
        String tel=request.getParameter("tel");
        String email=request.getParameter("email");
        String province=request.getParameter("province");
        String city=request.getParameter("city");
        String area=request.getParameter("area");
        String address=request.getParameter("address");
        String address1=province+city+area+address;
        System.out.println(username+"前端的username输入值");
        Date date=new Date();
        SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd hh-MM");
        String time=sdf.format(date);
        CUser user=new CUser(username,password,nikename,tel,email,time,province,city,area,address1);
        System.out.println(user+"9999999999999999999999999");
        cuserService.insertUser(user);
        return getUserList(request,model);
}

    //根据id查询用户
    @RequestMapping("/selectUser")
        protected void getUserById(int u_id,HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/json;charset=utf-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        CUser user=cuserService.selectUserById(u_id);
        String userJson = JSON.toJSONString(user);
        out.print(userJson);
        System.out.println(user+"1111111111111111110");
    }


    //修改用户密码
    @RequestMapping("/update")
    public String updateUserPassword(Model model,HttpServletRequest request){
        String id=request.getParameter("id2");
        int id1=Integer.parseInt(id);
        String password=request.getParameter("newpassword");
        System.out.println(id1+password+"!!!!!");
        cuserService.updateUser(password,id1);
        return getUserList(request,model);
    }
    @RequestMapping("/delete")
        public String delete(HttpServletRequest request,Model model,int u_id){
        cuserService.deleteUser(u_id);
        return getUserList(request,model);
        }

    @RequestMapping("aaa")
    public String loginOut(){
        return "ad-login";
    }
    //欢迎yemian
    @RequestMapping("welcome.html")
    public String welcome(HttpSession session,HttpServletRequest request,Model model){
        String username=session.getAttribute("username").toString();
//        System.out.println(username+"11111111111111111111111111111111");
        model.addAttribute("manager",username);
        Date date=new Date();
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd hh:mm");
        String time=simpleDateFormat.format(date);
        model.addAttribute("time",time);
        return "welcome";
    }


}
