package cn.com.sise.welfare.controller;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class PageController {

    @Value("${upload.file.path}")
    private String filePath;
    @Value("${virtual.file.path}")
    private String path;

    /**
     * 跳转登录页面
     * @return
     */
    @GetMapping("/login")
    public String login(){
        return "login";
    }

    /**
     * 退出
     * @return
     */
    @GetMapping("/logout")
    public String logout(){
        SecurityUtils.getSubject().logout();
        return "redirect:/login";
    }

    /**
     * 跳转到admin
     * @return
     */
    @GetMapping("/admin")
    public String toAdmin(){
        return "/backed/admin/admin";
    }

    /**
     * 跳转到注册页面
     * @return
     */
    @GetMapping("/register")
    public String toRegister(){
        return "/register";
    }

    /**
     * 跳转到我的桌面
     * @return
     */
    @GetMapping("/welcome")
    public String toWelcome(){
        return "/welcome";
    }

    /**
     * 跳转到黑名单
     * @return
     */
    @GetMapping("/toBlackList")
    public String toBlackList(Model model) {
        model.addAttribute("filePath", path);
        return "/backed/admin/blackList";
    }

    /**
     * 跳转到白名单
     * @param model
     * @return
     */
    @GetMapping("/toWhiteList")
    public String toWhiteList(Model model) {
        model.addAttribute("filePath", path);
        return "/backed/admin/whiteList";
    }

    //跳转到组织待审核列表
    @GetMapping("/toAuditList")
    public String toAuditList(Model model) {
        model.addAttribute("filePath", path);
        return "/backed/admin/toAuditList";
    }

    //跳转到组织通过审核列表
    @GetMapping("/toApprovedList")
    public String toApprovedList(Model model) {
        model.addAttribute("filePath", path);
        return "/backed/admin/approvedOrganizationsList";
    }
    //跳转到组织没通过审核列表
    @GetMapping("/toFailedList")
    public String toFailedList(Model model) {
        model.addAttribute("filePath", path);
        return "/backed/admin/failedOrganizationsList";
    }
}
