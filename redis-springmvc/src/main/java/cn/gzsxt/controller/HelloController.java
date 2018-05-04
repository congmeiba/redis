package cn.gzsxt.controller;


import cn.gzsxt.redis.RedisManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
public class HelloController {

    @Resource
    private RedisManager redisManager;

    @RequestMapping("/hello")
    public String hello(Model model){
        redisManager.setString("redisSpring","redisSpring");
        model.addAttribute("msg",redisManager.getString("redisSpring"));
        return "index";
    }




}
