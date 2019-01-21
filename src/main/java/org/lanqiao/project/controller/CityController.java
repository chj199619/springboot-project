package org.lanqiao.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CityController {
    @RequestMapping("city.html")
    public String city(){
        return "city.html";
    }
}
