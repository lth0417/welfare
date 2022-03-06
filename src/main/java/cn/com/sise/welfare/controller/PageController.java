package cn.com.sise.welfare.controller;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class PageController {

    @Value("${upload.file.path}")
    private String filePath;
    @Value("${virtual.file.path}")
    private String path;

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/logout")
    public String logout(){
        SecurityUtils.getSubject().logout();
        return "redirect:/login";
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
    public String toBlackList(Model model) {
        model.addAttribute("filePath", path);
        return "backed/blackList";
    }

    @GetMapping("/toWhiteList")
    public String toWhiteList(Model model) {
        model.addAttribute("filePath", path);
        return "backed/whiteList";
    }

}
