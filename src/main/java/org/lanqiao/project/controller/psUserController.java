package org.lanqiao.project.controller;

import com.alibaba.fastjson.JSON;
import org.lanqiao.project.pojo.PsPaper;
import org.lanqiao.project.pojo.User;
import org.lanqiao.project.pojo.psCar;
import org.lanqiao.project.service.PsPaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.lang.System.out;

@Controller
public class psUserController {
    @Autowired
    PsPaperService paperService;
    @RequestMapping("order-list.html")
    public String bb(Model model){
        List<PsPaper>papers = this.getAll(model);
        return "order-list";
    }

    @RequestMapping("conditions")
    public String conditions(HttpServletRequest req, HttpServletResponse resp,String pscondition,Model model,String id) throws IOException {

        out.println(id+"---"+pscondition);
        out.println(pscondition);
        Integer pid = Integer.parseInt(id);
        paperService.update(new PsPaper(pid,pscondition));
        List<PsPaper>papers = this.getAll(model);
        return "order-list";
    }


    @RequestMapping("findcon")
    public String findcon(String conId,String condition,Model model) {
        out.println(condition);
        out.println("ddid--" + conId);
        List<PsPaper> papers = null;
//        id模糊查询
        if (conId != ""&&conId!=null) {
            Integer id = Integer.parseInt(conId);
             papers = paperService.findByDdid(id);
            out.println(papers);
//         condition查询
        }else {
            if ("全部订单".equals(condition)){
                papers = this.getAll(model);
            }else {
                papers = paperService.fingBycondition(condition);
                out.println(papers);
            }
        }
        model.addAttribute("papers", papers);
        model.addAttribute("len",papers.size());
        return "order-list";
    }
    @RequestMapping("psde")
    public String psde(HttpServletRequest req, HttpServletResponse resp,String id,Model model){
        out.println("id:-----"+id);
        Integer pid= Integer.parseInt(id);
        paperService.deletePaper(pid);
        List<PsPaper>papers = this.getAll(model);
        return "order-list";
    }

    @RequestMapping("psupd.html")
    public void psupd(HttpServletRequest req, HttpServletResponse resp,String id,String pscondition) throws IOException {
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/json");
        PrintWriter out = resp.getWriter();
        System.out.println("id----"+id);
        if (id!=null){
            Integer pid= Integer.parseInt(id);
            PsPaper paper = paperService.findById(pid);
            System.out.println(paper);
            Map<String,Object> returnMap = new HashMap<>();
            returnMap.put("paper",paper);
            String mapStr = JSON.toJSONString(returnMap);
            out.print(mapStr);
        }
    }

    @RequestMapping("/condition")
    public void cnditionAll(String condition ,HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/json");
        out.println("condition--"+condition);
        List<String> list = new ArrayList<>();
        if ("已完成".equals(condition)||"已取消".equals(condition)){
            list.add(condition);
        }else  if ("已发货".equals(condition)){
            list.add("已完成");
            list.add("已取消");
        }else  if ("未发货".equals(condition)){
            list.add("已发货");
            list.add("已取消");
        }
        out.println(list);
        PrintWriter out = resp.getWriter();
        String mapStr = JSON.toJSONString(list);
        out.print(mapStr);
    }

    public  List<PsPaper> getAll(Model model){
        List<PsPaper> papers = paperService.findAll();
        model.addAttribute("papers",papers);
        model.addAttribute("len",papers.size());
        return papers;
    }

    @RequestMapping("detail")
    public String detai(HttpServletRequest req,Model model){
        String ddid =req.getParameter("ddid");
        String uid = req.getParameter("uid");
        out.println(ddid+"--"+uid);
        int did = Integer.parseInt(ddid);
        int u_id = Integer.parseInt(uid);
        User user = (User) paperService.user(u_id);
        out.println(user);
        String name ="暂无数据";
        String phone ="13612536987";
        if (user!=null){
            name = user.getU_name();
            phone= user.getU_phone();
        }
        List<psCar> papers= paperService.details(did,u_id);
        out.println(papers);
        model.addAttribute("name",name);
        model.addAttribute("phone",phone);
        model.addAttribute("papers",papers);
        return "detail";
    }



}
