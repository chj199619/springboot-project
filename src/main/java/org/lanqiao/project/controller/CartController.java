package org.lanqiao.project.controller;

import org.lanqiao.project.pojo.Cart;
import org.lanqiao.project.pojo.Paper;
import org.lanqiao.project.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class CartController {
    @Autowired
    CartService cartService;



    @RequestMapping("cart")
    public String initCart(HttpServletRequest request, HttpServletResponse response,Model model){
        HttpSession s = request.getSession();
        System.out.println(s);
        String uid =   s.getAttribute("uid").toString();
        System.out.println(uid);
        int u_id = Integer.parseInt(uid);
        List<Cart> cartList = cartService.selectAll(u_id,0);
//        int carsize = cartList.size();
//        model.addAttribute("carsize",carsize);
        model.addAttribute("cartList",cartList);
        Double total = 0.0;
        for (Cart cart :cartList){
            Double p = cart.getG_price()*cart.getC_num();
            total += p;
        }
        model.addAttribute("total",total);
        return "cart";
    }

    @RequestMapping("wish.do")
    public String initWish(HttpServletRequest request, HttpServletResponse response,Model model){
        String uid = request.getParameter("uid");
        System.out.println(uid);
//        int u_id = Integer.parseInt(uid);
        List<Cart> cartList = cartService.selectWish(1);
//        System.out.println(cartList);
        model.addAttribute("cartList",cartList);
        return "wish";
    }


//    @RequestMapping("wishadd")
//    public String wishadd(HttpServletRequest request, HttpServletResponse response,Model model){
//        String gid = request.getParameter("id");
//        System.out.println(gid);
//        int g_id = Integer.parseInt(gid);
//
//        System.out.println(g_id);
//        String img = "https://img12.360buyimg.com/n1/s450x450_jfs/t27328/348/1322253158/210285/301e901e/5bc57dc1N79b78245.jpg";
//        String gname = "神州";
//        String gcolor = "黑色";
//        Double cprice = 12.0;
//        int cnum = 3;
//        Cart cart = new Cart(gId,gname,gcolor,cprice,cnum,1,img);
//        System.out.println(cart);
//        cartService.add(cart);
//        List<Cart> cartList = cartService.selectWish(1);
//        model.addAttribute("cartList",cartList);
//        return "wish";
//    }

    @RequestMapping("upnum")
    public String upnum(HttpServletRequest request, HttpServletResponse responsel,Model model){
        String id = request.getParameter("id");
        String method = request.getParameter("method");
        String uid = request.getParameter("uid");

        String c_num=request.getParameter("cnum");
        System.out.println(c_num);
        int g_id = Integer.parseInt(id);
        int u_id = Integer.parseInt(uid);
        System.out.println(method);
        System.out.println(g_id+"商品id");

        System.out.println(u_id+"用户id");
        Cart cart1= cartService.selectCartById(g_id,u_id);

        System.out.println(cart1+"-------------------");
//        System.out.println(cnum+"---------------------------");
        int cnum=cart1.getC_num();
        System.out.println(cnum);
        List<Cart> cartList;
        Double total;
        String view = "cart";
        switch (method){
            case "del":
                if(cnum<=1){
                    cartService.del(g_id,u_id);
                }else {
                    cartService.upnum(cnum-1,g_id);
                }
                cartList = cartService.selectAll(u_id,0);
                model.addAttribute("cartList",cartList);
                total = 0.0;
                for (Cart cart :cartList){
                    Double p = cart.getG_price()*cart.getC_num();
                    total += p;
                }
                model.addAttribute("total",total);
                view = "cart";
                return view;
            case "add":
                int num = 0;
                Cart cartadd = cartService.selectCartById(g_id,u_id);
                System.out.println(cartadd);
                num = cartadd.getC_num();
                System.out.println(num);
//                if(num<=1){
//                    System.out.println(g_id);
//                    String img = "https://img12.360buyimg.com/n1/s450x450_jfs/t27328/348/1322253158/210285/301e901e/5bc57dc1N79b78245.jpg";
//                    String gname = "神州";
//                    String gcolor = "黑色";
//                    String cond = "未付款";
//                    Double cprice = 12000.0;
//                    cnum = 1;
//                    Cart cart = new Cart(g_id,img,gname,gcolor,cprice,cnum,u_id,0,cond);
//                    cartService.add(cart);
//                    System.out.println(cart);
                    view = "cart";
//                }else {
////                    cartService.upnum(cnum+1,g_id);
////                    view = "cart";
////                }
                cartService.upnum(cnum+1,g_id);
                cartList = cartService.selectAll(u_id,0);
                model.addAttribute("cartList",cartList);
                total = 0.0;
                for (Cart cart :cartList){
                    Double p = cart.getG_price()*cart.getC_num();
                    total += p;
                }
                model.addAttribute("total",total);
        }
        return view;
    }

    @RequestMapping("del")
    public String del(HttpServletRequest request, HttpServletResponse responsel,Model model){
        String id = request.getParameter("id");
        int g_id = Integer.parseInt(id);
        HttpSession session=request.getSession();
        String uid =session.getAttribute("uid").toString();
        System.out.println(uid);
        int u_id = Integer.parseInt(uid);
        cartService.del(g_id,u_id);
        List<Cart> cartList = cartService.selectAll(u_id,0);
        System.out.println(cartList);
        model.addAttribute("cartList",cartList);
        Double total = 0.0;
        for (Cart cart :cartList){
            Double p = cart.getG_price()*cart.getC_num();
            total += p;
        }
        model.addAttribute("total",total);
        return "cart";
    }

    @RequestMapping("delwish")
    public String delWish(HttpServletRequest request, HttpServletResponse responsel,Model model){
        String id = request.getParameter("id");
        int g_id = Integer.parseInt(id);
        String uid = request.getParameter("uid");
        System.out.println(uid);
        int u_id = Integer.parseInt(uid);
        cartService.delWish(g_id,u_id);
        List<Cart> cartList = cartService.selectWish(1);
        System.out.println(cartList);
        model.addAttribute("cartList",cartList);
        return "wish";
    }

    @RequestMapping("topay")
    public String toPay(HttpServletRequest request, HttpServletResponse responsel,Model model){
        String id = request.getParameter("id");
        int pid = Integer.parseInt(id);
        String total = request.getParameter("total");
        int p_id = pid;
        HttpSession s = request.getSession();
        String uid = s.getAttribute("uid").toString();
        System.out.println(uid);
        int u_id = Integer.parseInt(uid);

        String address = request.getParameter("address");
        model.addAttribute("address",address);

        List<Cart> cartList = cartService.selectAll(u_id,0);
        model.addAttribute("cartList",cartList);
        String kuaidi = request.getParameter("kuaidi");
        model.addAttribute("u_id",u_id);
        model.addAttribute("total",total);
        model.addAttribute("p_id",p_id);
        model.addAttribute("kuaidi",kuaidi);
        return "pay";
    }

    @RequestMapping("panshuo")
    public String panshuo(HttpServletRequest request, HttpServletResponse responsel,Model model){
        String condition = "未发货";
        String id = request.getParameter("uid");
        System.out.println("---"+id);
        Date data = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("hhmmss");
        String ddid = sdf.format(data);
        Integer dd = Integer.parseInt(ddid);
        int uid =0;
//        int pid =0;
        double price =0;
        if (id!=null){
            uid = Integer.parseInt(id);
//            pid = Integer.parseInt(id);
        }
//        String p_id = request.getParameter("pid");
//        if (u_id!=null){
//             pid = Integer.parseInt(u_id);
//        }
        String total = request.getParameter("total");
        if (total!=null){
             price = Double.parseDouble(total);
        }
//        String kuaidi = request.getParameter("kuaidi");
        System.out.println("total::"+total+"  uid:"+uid+"  pid:"+dd);
        String name ="123";
        String kuaidi = "da通";
        //修改购物车中p_id
        System.out.println(dd+"--"+uid);
        cartService.pansUpdate(dd,condition,uid);
        Paper paper = new Paper(dd,name,price,condition,kuaidi,uid);
        System.out.println(paper);
        cartService.psaddPaper(paper);
        return "index";
    }

    @RequestMapping("cancel")
    public String cancel(HttpServletRequest request, HttpServletResponse responsel,Model model){
        String id = request.getParameter("uid");
        int uid = Integer.parseInt(id);
        System.out.println(uid);
        cartService.uppid(0,uid);
        return "index";
    }
//    @RequestMapping("house")
//    public String house(HttpServletRequest request, HttpServletResponse responsel,Model model){
//
//        String id = request.getParameter("id");
//        int g_id = Integer.parseInt(id);
//        String uid = request.getParameter("uid");
//        int u_id = Integer.parseInt(uid);
//        String img = "https://img12.360buyimg.com/n1/s450x450_jfs/t27328/348/1322253158/210285/301e901e/5bc57dc1N79b78245.jpg";
//        String gname = "神州";
//        String gcolor = "黑色";
//        Double cprice = 12.0;
//        int cnum = 3;
//        Cart cart = new Cart(g_id,gname,gcolor,cprice,cnum,u_id,img);
//        cartService.house(cart);
//        List<Cart> cartList = cartService.selectAll(1);
//        model.addAttribute("cartList",cartList);
//        Double total = 0.0;
//        for (Cart car :cartList){
//            Double p = car.getC_price()*car.getC_num();
//            total += p;
//        }
//        model.addAttribute("total",total);
//        return "cart";
//    }
@RequestMapping("upaddress")
public String upaddress(HttpServletRequest request,Model model){
    HttpSession s = request.getSession();
    String uid = s.getAttribute("uid").toString();
    int u_id = Integer.parseInt(uid);
    String province = request.getParameter("provinceName");
    String city = request.getParameter("cityName");
    String area = request.getParameter("districtName");
    String address = province+city+area;
    System.out.println(address);

    List<Cart> cartList = cartService.selectAll(u_id,0);
    model.addAttribute("cartList",cartList);

    model.addAttribute("address",address);
    model.addAttribute("u_id",1);
//        model.addAttribute("total",total);
    Double total = 0.0;
    for (Cart cart :cartList){
        Double p = cart.getG_price()*cart.getC_num();
        total += p;
    }
    model.addAttribute("total",total);
    model.addAttribute("kuaidi","申通");
    return "pay";
}

}

