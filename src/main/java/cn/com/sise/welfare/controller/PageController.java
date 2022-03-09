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
     * 内容区显示用户管理的黑名单
     * @return
     */
    @GetMapping("/toBlackList")
    public String toBlackList(Model model) {
        model.addAttribute("filePath", path);
        return "/backed/admin/blackList";
    }

    /**
     * 内容区显示用户管理的白名单
     * @param model
     * @return
     */
    @GetMapping("/toWhiteList")
    public String toWhiteList(Model model) {
        model.addAttribute("filePath", path);
        return "/backed/admin/whiteList";
    }

    //内容区显示组织待审核列表数据
    @GetMapping("/toAuditList")
    public String toAuditList(Model model) {
        model.addAttribute("filePath", path);
        return "/backed/admin/toAuditOrganizationsList";
    }

    //内容区显示组织通过审核列表数据
    @GetMapping("/toApprovedList")
    public String toApprovedList(Model model) {
        model.addAttribute("filePath", path);
        return "/backed/admin/approvedOrganizationsList";
    }

    //内容区显示组织没通过审核列表数据
    @GetMapping("/toFailedList")
    public String toFailedList(Model model) {
        model.addAttribute("filePath", path);
        return "/backed/admin/failedOrganizationsList";
    }

    @GetMapping("/toAdd")
    public String toAdd(){
        return "/backed/admin/add";
    }

    //内容区显示项目待发布列表数据
    @GetMapping("/toBeReleasedList")
    public String toBeReleasedList(Model model) {
        model.addAttribute("filePath", path);
        return "/backed/admin/toBeReleasedList";
    }

    //内容区显示已发布的项目列表数据
    @GetMapping("/toThePublishList")
    public String toThePublishList(Model model) {
        model.addAttribute("filePath", path);
        return "/backed/admin/thePublishedList";
    }



}
