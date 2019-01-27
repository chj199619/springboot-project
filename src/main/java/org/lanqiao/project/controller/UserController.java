package org.lanqiao.project.controller;

import org.lanqiao.project.pojo.*;
import org.lanqiao.project.service.CartService;
import org.lanqiao.project.service.GoodsServiceimpl;
import org.lanqiao.project.service.UserService;
import org.lanqiao.project.utils.MD5Utils;
import org.lanqiao.project.utils.VerifyCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    GoodsServiceimpl goodsServiceimpl;
    @Autowired
    CartService cartService;
    CDT condition = new CDT();

//
//    前端
//验证码
    @RequestMapping("/imageCodePage")
    public void imageCodePage(HttpServletRequest request, HttpServletResponse response) throws IOException {
        VerifyCode vc  = new VerifyCode();
        BufferedImage bi = vc.getImage();
        String rcode = vc.getText();
        rcode = rcode.toLowerCase();
        System.out.println("验证码"+rcode);
        HttpSession s = request.getSession();
        s.setAttribute("rcode",rcode);
        VerifyCode.output(bi,response.getOutputStream());
    }
    @RequestMapping("/")
    public String Deindex(Model model,HttpServletRequest req){
        req.getSession().removeAttribute("uname");
        req.getSession().removeAttribute("uid");
        List<Goods> goodsList = goodsServiceimpl.findAllgoods();
        List<Goods> newgoodsList = goodsServiceimpl.findNewgoods();
        List<Goods> shangoodsList = goodsServiceimpl.findShangoods();
        for (int i=0;i<shangoodsList.size();i++){
            double pri=shangoodsList.get(i).getG_oriprice()-shangoodsList.get(i).getG_price();
            model.addAttribute("pri",pri);

        }

        List<Computer> computerList = goodsServiceimpl.findsyComgoods();
        List<Computer> yxcomList = goodsServiceimpl.findsyYXComgoods();
        List<Jianpan>  jpList = goodsServiceimpl.findJsyPgoods();
        int carsize = 0;

        model.addAttribute("carsize",carsize);
        model.addAttribute("goods",goodsList);
        model.addAttribute("newgoods",newgoodsList);
        model.addAttribute("shangoods",shangoodsList);
        model.addAttribute("Comgoods",computerList);
        model.addAttribute("yxCom",yxcomList);
        model.addAttribute("jpgoods",jpList);
        return "index";
    }
    @RequestMapping("index")
    public String Deindex1(HttpServletRequest req, Model model){
        HttpSession session=req.getSession();
        Object object = session.getAttribute("uid");
        int uid =0;
        if(null==object){

        }else {
            uid=Integer.parseInt( session.getAttribute("uid").toString());
        }
        System.out.println(uid);
        List<Cart> cars=cartService.selectAll(uid,0);
        Double total = 0.0;
        for (Cart cart :cars){
            Double p = cart.getG_price()*cart.getC_num();
            total += p;
        }
        model.addAttribute("total",total);
        List<Goods> goodsList = goodsServiceimpl.findAllgoods();
        List<Goods> newgoodsList = goodsServiceimpl.findNewgoods();
        List<Goods> shangoodsList = goodsServiceimpl.findShangoods();
        List<Computer> computerList = goodsServiceimpl.findsyComgoods();
        List<Computer> yxcomList = goodsServiceimpl.findsyYXComgoods();
        List<Jianpan>  jpList = goodsServiceimpl.findJsyPgoods();
        int carsize = cars.size();
        model.addAttribute("car",cars);
        System.out.println(cars);
        model.addAttribute("carsize",carsize);
        model.addAttribute("goods",goodsList);
        model.addAttribute("newgoods",newgoodsList);
        model.addAttribute("shangoods",shangoodsList);
        model.addAttribute("Comgoods",computerList);
        model.addAttribute("yxCom",yxcomList);
        model.addAttribute("jpgoods",jpList);
        return "index";
    }

    @RequestMapping("login")
    public String login(HttpServletRequest req, HttpServletResponse resp,Model model) throws UnsupportedEncodingException, SQLException {

        return "login";
    }

    @RequestMapping("denglu")
    public String submit(HttpServletRequest req, HttpServletResponse resp,Model model) throws IOException, SQLException, ServletException {
        req.setCharacterEncoding("UTF-8");
        HttpSession session=req.getSession();
        String msg = "";
        session.setAttribute("msg",msg);
        String username = req.getParameter("username");
        System.out.println("用户名999999999999999999999"+username);
        String password = MD5Utils.md5(req.getParameter("password"));
        System.out.println("密码"+password);
        User user =userService.selectUser1(username);
        System.out.println("--------------"+user);
        if (username.isEmpty()){
            model.addAttribute("msg","用户名未输入！");
            return "login";
        }

        String rcode = req.getParameter("rcodea");
        String s = (String)req.getSession().getAttribute("rcode");
        System.out.println("验证码："+s);
        if (null == user){
            model.addAttribute("msg","用户不存在！");
            System.out.println("用户为空");
            return "login";
        }else if (user != null){
            if (s.equals(rcode.toLowerCase())){
                if (username.equals(user.getU_name())&&password.equals(user.getU_password())) {
                    int id=user.getU_id();
                    System.out.println("通过");
                    session.setAttribute("uname",username);
                    session.setAttribute("uid",id);
                    resp.sendRedirect("index");
                }else{
                    model.addAttribute("msg", "账户不存在或密码有误！");
                    System.out.println("密码错");
                }
            }else {
                model.addAttribute("msg","验证码有误！");
                return "login";
            }
        }
        return "login";

    }

    @RequestMapping("register")
    public String register(Model model){
        return "register";
    }
    @RequestMapping("zhuce")
    public String submit2(HttpServletRequest req,HttpServletResponse resp) throws IOException, SQLException, ServletException, ParseException {
        Object u_name = req.getParameter("username");
        Object u_password = MD5Utils.md5(req.getParameter("password"));
        Object u_nickname = req.getParameter("nickname");
        Object u_phone = req.getParameter("tel");
        Object u_email = req.getParameter("email");
        Object u_hiredate = req.getParameter("hiredate");
        User user = new User();
        if (!StringUtils.isEmpty(u_name)){
            user.setU_name(u_name.toString());
        }
        if (!StringUtils.isEmpty(u_password)){
            user.setU_password(u_password.toString());
        }
        if (!StringUtils.isEmpty(u_nickname)){
            user.setU_nickname(u_nickname.toString());
        }
        if (!StringUtils.isEmpty(u_phone)){
            user.setU_phone(u_phone.toString());
        }
        if (!StringUtils.isEmpty(u_email)){
            user.setU_email(u_email.toString());
        }
        if (!StringUtils.isEmpty(u_hiredate)){
//            SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
//            user.setuHiredate(sdf.parse(u_hiredate.toString()));
            user.setU_hiredate(u_hiredate.toString());
        }
        userService.addUser(user);
        return "login";
    }

    @RequestMapping("productyx/{g_id}")
    public String productyx(HttpServletRequest req, Model model, @PathVariable int g_id){
        HttpSession session=req.getSession();
        Object object = session.getAttribute("uid");
        int uid =0;
        if(null==object){

        }else {
            uid=Integer.parseInt( session.getAttribute("uid").toString());
        }

        List<Cart> cars=cartService.selectAll(uid,0);
        Double total = 0.0;
        for (Cart cart :cars){
            Double p = cart.getG_price()*cart.getC_num();
            total += p;
        }
        model.addAttribute("total",total);
        int carsize = cars.size();
        model.addAttribute("carsize",carsize);
        model.addAttribute("car",cars);
        List<Computer> comList = goodsServiceimpl.findYXCombyid(g_id);
        Date date=new Date();
        SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd hh-MM");
        String time=sdf.format(date);
        model.addAttribute("time",time);
        model.addAttribute("cominfo",comList);
        return "productyx";
    }
    @RequestMapping("productInadd/{g_id}/{uid}")
    public String productInaddcart(HttpServletRequest req,HttpServletResponse resp,Model model,String nums,@PathVariable int g_id,@PathVariable String uid) throws IOException {
        int uId = Integer.parseInt(uid);
        System.out.println(uId);
        List<Cart> cars=cartService.selectAll(uId,0);
        Double total = 0.0;
        for (Cart cart :cars){
            Double p = cart.getG_price()*cart.getC_num();
            total += p;
        }
        model.addAttribute("total",total);
        int carsize = cars.size();
        model.addAttribute("carsize",carsize);
        model.addAttribute("car",cars);
        List<Computer> comList = goodsServiceimpl.findYXCombyid(g_id);

        String gName = "";
        String gColor = "";
        Double cPrice = 0.0;
        int cNum = 1;
        String gImg = "";
        for (Computer com:comList){
            gName = com.getG_name();
            gColor = com.getG_color();
            gImg = com.getG_img();
            cPrice =  com.getG_price();
        }
        Cart cart = new Cart();
        cart.setC_num(cNum);
        cart.setG_price(cPrice);
        cart.setG_name(gName);
        cart.setG_color(gColor);
        cart.setG_img(gImg);
        cart.setU_id(uId);
        cart.setG_id(g_id);
        cartService.add(cart);

        model.addAttribute("cominfo",comList);
        return Deindex1(req, model);
    }
    @RequestMapping("productyxadd/{g_id}/{uid}")
    public String productyxaddcart(HttpServletRequest req,HttpServletResponse resp,Model model,String nums,@PathVariable int g_id,@PathVariable String uid) throws IOException {
        int uId = Integer.parseInt(uid);
        List<Cart> cars=cartService.selectAll(uId,0);
        Double total = 0.0;
        for (Cart cart :cars){
            Double p = cart.getG_price()*cart.getC_num();
            total += p;
        }
        model.addAttribute("total",total);
        int carsize = cars.size();
        model.addAttribute("carsize",carsize);
        model.addAttribute("car",cars);
        List<Computer> comList = goodsServiceimpl.findYXCombyid(g_id);

        String gName = "";
        String gColor = "";
        Double cPrice = 0.0;
        int cNum = 0;
        String gImg = "";
        for (Computer com:comList){
            gName = com.getG_name();
            gColor = com.getG_color();
            gImg = com.getG_img();
            cPrice =  com.getG_price();
            cNum = Integer.parseInt(nums);
        }
        Cart cart = new Cart();
        cart.setC_num(cNum);
        cart.setG_price(cPrice);
        cart.setG_name(gName);
        cart.setG_color(gColor);
        cart.setG_img(gImg);
        cart.setU_id(uId);
        cart.setG_id(g_id);
        cartService.add(cart);

        model.addAttribute("cominfo",comList);
        return productyx(req, model, g_id);
    }
    @RequestMapping("product/{g_id}")
    public String product(HttpServletRequest req, Model model, @PathVariable int g_id){
        HttpSession session=req.getSession();
        Object object = session.getAttribute("uid");
        int uid =0;
        if(null==object){

        }else {
            uid=Integer.parseInt( session.getAttribute("uid").toString());
        }

        List<Cart> cars=cartService.selectAll(uid,0);
        Double total = 0.0;
        for (Cart cart :cars){
            Double p = cart.getG_price()*cart.getC_num();
            total += p;
        }
        model.addAttribute("total",total);
        int carsize = cars.size();
        model.addAttribute("carsize",carsize);
        model.addAttribute("car",cars);
        List<Computer> comList = goodsServiceimpl.findCombyid(g_id);
        Date date=new Date();
        SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd hh-MM");
        String time=sdf.format(date);
        model.addAttribute("time",time);
        model.addAttribute("cominfo",comList);
        return "product";
    }
    @RequestMapping("productadd/{g_id}/{uid}")
    public String productaddcart(HttpServletRequest req,HttpServletResponse resp,Model model,String nums,@PathVariable int g_id,@PathVariable String uid) throws IOException {
        int uId = Integer.parseInt(uid);
        List<Cart> cars=cartService.selectAll(uId,0);
        Double total = 0.0;
        for (Cart cart :cars){
            Double p = cart.getG_price()*cart.getC_num();
            total += p;
        }
        model.addAttribute("total",total);
        int carsize = cars.size();
        model.addAttribute("carsize",carsize);
        model.addAttribute("car",cars);
        List<Computer> comList = goodsServiceimpl.findCombyid(g_id);

        String gName = "";
        String gColor = "";
        Double cPrice = 0.0;
        int cNum = 0;
        String gImg = "";
        for (Computer com:comList){
            gName = com.getG_name();
            gColor = com.getG_color();
            gImg = com.getG_img();
            cPrice =  com.getG_price();
            cNum = Integer.parseInt(nums);
        }
        Cart cart = new Cart();
        cart.setC_num(cNum);
        cart.setG_price(cPrice);
        cart.setG_name(gName);
        cart.setG_color(gColor);
        cart.setG_img(gImg);
        cart.setU_id(uId);
        cart.setG_id(g_id);
        System.out.println(cart);
        cartService.add(cart);

        model.addAttribute("cominfo",comList);
        return product(req, model,g_id);
    }


    @RequestMapping("category")
    public String category(Model model,HttpServletRequest request,String beprice,String endprice){

        double endnu = Double.parseDouble(endprice);
        double begnu = Double.parseDouble(beprice);
        condition.setBegprice(begnu);
        condition.setEndprice(endnu);
        HttpSession session=request.getSession();
        Object object = session.getAttribute("uid");
        int uid =0;
        if(null==object){

        }else {
            uid=Integer.parseInt( session.getAttribute("uid").toString());
        }

        List<Cart> cars=cartService.selectAll(uid,0);
        Double total = 0.0;
        for (Cart cart :cars){
            Double p = cart.getG_price()*cart.getC_num();
            total += p;
        }
        model.addAttribute("total",total);
        List<Computer> comAllZh =goodsServiceimpl.findComgoods(condition);
        int carsize = cars.size();
        model.addAttribute("carsize",carsize);
        model.addAttribute("car",cars);
        model.addAttribute("allcomZh",comAllZh);
        return "category";
    }
    @RequestMapping("categoryyx")
    public String categoryyx(Model model,HttpServletRequest request,String beprice,String endprice){

        double endnu = Double.parseDouble(endprice);
        double begnu = Double.parseDouble(beprice);
        condition.setBegprice(begnu);
        condition.setEndprice(endnu);
        HttpSession session=request.getSession();
        Object object = session.getAttribute("uid");
        int uid =0;
        if(null==object){

        }else {
            uid=Integer.parseInt( session.getAttribute("uid").toString());
        }
        List<Cart> cars=cartService.selectAll(uid,0);
        Double total = 0.0;
        for (Cart cart :cars){
            Double p = cart.getG_price()*cart.getC_num();
            total += p;
        }
        model.addAttribute("total",total);

        List<Computer> comAllYx = goodsServiceimpl.findYXComgoods(condition);
        int carsize = cars.size();
        model.addAttribute("carsize",carsize);
        model.addAttribute("car",cars);

        model.addAttribute("allcomYx",comAllYx);

        return "categoryyx";
    }


}
