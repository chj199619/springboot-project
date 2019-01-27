package org.lanqiao.project.controller;



import org.lanqiao.project.pojo.*;
import org.lanqiao.project.service.CUserService;
import org.lanqiao.project.service.YLCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class YLController {
    @Autowired
    CUserService cUserService;
    @Autowired
    YLCarService service;
    @RequestMapping("/dingdan")
    public String dingdan(HttpServletRequest req,Model model){
        HttpSession session = req.getSession();
        String userid =  session.getAttribute("uid").toString();
        int uid =1;
        if (!StringUtils.isEmpty(userid)){
            uid = Integer.parseInt(userid);
        }

        List<YLCar> carList=service.sAll(uid);
        model.addAttribute("carList",carList);
        return "dingdan";
    }
    @RequestMapping("/daifukuan")
    public String getAll(Model model, HttpServletRequest req, HttpServletResponse resp){
        String cond="待付款";
        System.out.println("-------------------");
        HttpSession session = req.getSession();
        String userid =  session.getAttribute("uid").toString();
        int uid =1;
        if (!StringUtils.isEmpty(userid)){
             uid = Integer.parseInt(userid);
        }
        System.out.println(uid);
        List<YLCar> carlists = service.getAll(uid,0);
        System.out.println(carlists);
        model.addAttribute("carlists",carlists);
        return "daifukuan";
    }
    @RequestMapping("/pay1")
    public String pay(Model model,HttpServletRequest req, HttpServletResponse resp){
        HttpSession session = req.getSession();
        String userid =  session.getAttribute("uid").toString();
        int uid =1;
        if (!StringUtils.isEmpty(userid)){
            uid = Integer.parseInt(userid);
        }
        List<YLCar> carlists = service.getAll(uid,0);
        System.out.println(carlists);
        model.addAttribute("carlists",carlists);
        List<YLCar> cartList = service.getListByid(1);
//        System.out.println(cartList);
        model.addAttribute("cartList",cartList);
        Double total = 0.0;
        for (YLCar cart :carlists){
            Double p = cart.getG_price()*cart.getC_num();
            total += p;
        }
        model.addAttribute("total",total);
        System.out.println(total);
        return "ylcart";
    }
    @RequestMapping("/zhifuchenggong")
    public String chengfong(HttpServletRequest req,Model model){
        String total =req.getParameter("total");
        System.out.println(total+"----");
        double price = Double.parseDouble(total);
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("hhmmss");
        String ddid = sdf.format(date);
        Integer id = Integer.parseInt(ddid);
        System.out.println(date);
        HttpSession session = req.getSession();
        String userid =  session.getAttribute("uid").toString();
        int uid =1;
        String name ="张三";
        String uname = session.getAttribute("uname").toString();
        if (!StringUtils.isEmpty(userid)&&!StringUtils.isEmpty(uname)){
            uid = Integer.parseInt(userid);
            CUser user=cUserService.selectUserById(uid);
            name = uname;
            YLPaper paper = new YLPaper(id,name,price,"未发货","韵达",uid,user.getU_address());
            service.insertPaper(paper);
        }
        YLCar car = new YLCar("未发货",uid,0);
        YLCar car1 = new YLCar("未发货",uid,id);
        System.out.println("****************"+car.getCond());
        service.YLUpdateCar(car);
        service.YLUpdateCar(car1);
        service.longlongUpdate(id,uid);
        YLPerson persons=service.getUserById(uid);
        model.addAttribute("persons",persons);
        model.addAttribute("total",total);
        return "zhifuchenggong";
    }

    @RequestMapping("/daipingjia")
    public String pingjia(Model model,HttpServletRequest req){
        System.out.println("---------------------------------");
        String g_id = req.getParameter("g_id");
        System.out.println(g_id+"===============================");
        if(!StringUtils.isEmpty(g_id)){
            int id=Integer.parseInt(g_id);
            YLCar car = service.yselect(id);
            YLCar car1=new YLCar(id,"已完成");
            service.yUpdate(car1);
        }
        String cond="已完成";
        HttpSession session = req.getSession();
        String userid = session.getAttribute("uid").toString();
        int uid =1;
        if (!StringUtils.isEmpty(userid)){
            uid = Integer.parseInt(userid);
        }
        List<YLCar> daishouhuo=service.carWei(uid,cond);
        model.addAttribute("daipingjia",daishouhuo);


        return "daipingjia";
    }

    @RequestMapping("/daishouhuo")
    public String shouhuo(Model model,HttpServletRequest req){
        String cond="已发货";
        HttpSession session = req.getSession();
        String userid = session.getAttribute("uid").toString();
        System.out.println(userid);
        int uid =1;
        if (!StringUtils.isEmpty(userid)){
            uid = Integer.parseInt(userid);
        }
        List<YLCar> daishouhuo=service.carWei(uid,cond);
        model.addAttribute("daishouhuo",daishouhuo);
        model.addAttribute("uid",uid);
        return "daishouhuo";
    }

    @RequestMapping("/daifahuo")
    public String fahuo(Model model,HttpServletRequest req){
        String cond="未发货";
        HttpSession session = req.getSession();
        String userid =  session.getAttribute("uid").toString();
        int uid =1;
        if (!StringUtils.isEmpty(userid)){
            uid = Integer.parseInt(userid);
        }
        List<YLCar> daifahuo=service.carWei(uid,cond);
        model.addAttribute("daifahuo",daifahuo);
        return "daifahuo";
    }

    @RequestMapping("/gerenziliao")
    public String geren(Model model,HttpServletRequest req){
        HttpSession session = req.getSession();
        String userid =  session.getAttribute("uid").toString();
        int uid =1;
        if (!StringUtils.isEmpty(userid)){
            uid = Integer.parseInt(userid);
        }
        YLPerson persons=service.getUserById(uid);
        String address=persons.getU_address();
        session.setAttribute("address",address);


        model.addAttribute("persons",persons);
        return "gerenziliao";
    }
    @RequestMapping("/baocun")
    public String baocun(HttpServletRequest req){
        String name = req.getParameter("u_name");
        System.out.println(name+"------------------------");
        String password=req.getParameter("u_password");
        String nickname=req.getParameter("u_nickname");
        String phone = req.getParameter("u_phone");
        String email = req.getParameter("u_email");
        String hiredate = req.getParameter("u_hiredate");
        String address=req.getParameter("u_address");
        HttpSession session = req.getSession();
        String userid =  session.getAttribute("uid").toString();
        int uid =1;
        if (!StringUtils.isEmpty(userid)){
            uid = Integer.parseInt(userid);
        }
        YLPerson p=new YLPerson(uid,name,password,nickname,phone,email,hiredate,address);

        service.findUpdate(p);
        return "redirect:/gerenziliao";
    }



    @RequestMapping("/shenqingtuikuan")
    public String tuikuan(Model model){
        List<YLCar> carlists= service.getAllCar();
        model.addAttribute("carlists",carlists);
        return "shenqingtuikuan";
    }
    @RequestMapping("/tuikuan")
    public String tui(HttpServletRequest req,Model model){

        String name=req.getParameter("g_name");
        String price1=req.getParameter("g_price");
        String img= req.getParameter("g_img");
        double price = Double.parseDouble(price1);

        System.out.println("----"+name+"++++++"+price);

        model.addAttribute("name",name);
        model.addAttribute("price",price);
        model.addAttribute("img",img);
        return "tuikuan";
    }
    @RequestMapping("/tijiaoshenqing")
    public String shenqing(){
        return "tijiaochenggong";
    }

    @RequestMapping("/pingjia")
    public String pin(HttpServletRequest req,Model model){
        String gid=req.getParameter("g_id");
        int ggid=Integer.parseInt(gid);
        System.out.println("pingjiA---------------------------");
        HttpSession session = req.getSession();
        String uid =  session.getAttribute("uid").toString();
        int uuid  = Integer.parseInt(uid);
        System.out.println(uuid+"11111111111111111111111111111111111");

        String name=req.getParameter("g_name");
        String lastp=req.getParameter("g_price");
        double price=Double.parseDouble(lastp);
        String color=req.getParameter("g_color");
        model.addAttribute("gid",gid);
        model.addAttribute("uid",uuid);
        model.addAttribute("name",name);
        model.addAttribute("price",price);
        model.addAttribute("color",color);
        return "pingjia";
    }
    @RequestMapping("/pingjiachenggong")
    public String pingj(){
        return "pingjiachenggong";
    }

}
