package cn.com.sise.welfare.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class PageController {

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/admin")
    public String toAdmin(){
        return "/backed/admin";
    }

    @GetMapping("/register")
    public String toRegister(){
        return "/register";
    }

    /**
     * 跳转到白名单
     * @return
     */
    @GetMapping("/toBlackList")
    public String toBlackList(){
        return "/backed/blackList";
    }

    @GetMapping("/toWhiteList")
    public String toWhiteList(){
        return "/backed/whiteList";
    }

}
