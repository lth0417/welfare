package cn.com.sise.welfare.controller.auditor;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: lth
 * @Date: 2022/03/08/16:52
 * @Description:
 */
@Controller
public class AuditorPageController {

    @Value("${upload.file.path}")
    private String filePath;
    @Value("${virtual.file.path}")
    private String path;

    //登录成功后跳转到auditor首页
    @GetMapping("/auditor")
    public String toAuditor(){
        return "backed/auditor/auditor";
    }

    //内容区显示审核用户加入组织数据
    @GetMapping("/toAuditEnterOrganizations")
    public String toAuditEnterOrganizations(Model model) {
        model.addAttribute("filePath", path);
        return "/backed/auditor/toAuditUserEnterOrganizations";
    }

    //内容区显示用户通过审核
    @GetMapping("/toApprovedEnterOrganizations")
    public String toApprovedEnterOrganizations(Model model) {
        model.addAttribute("filePath", path);
        return "/backed/auditor/approvedEnterOrganizations";
    }

    //内容区显示项目待审核列表数据
    @GetMapping("/toAuditProjectList")
    public String toAuditProjectList(Model model) {
        model.addAttribute("filePath", path);
        return "/backed/auditor/toAuditProjectList";
    }

    //内容区显示项目通过审核列表数据
    @GetMapping("/toApprovedProjectList")
    public String toApprovedProjectList(Model model) {
        model.addAttribute("filePath", path);
        return "/backed/auditor/approvedProjectList";
    }

    //内容区显示项目没通过审核列表数据
    @GetMapping("/toFailedProjectList")
    public String toFailedProjectList(Model model) {
        model.addAttribute("filePath", path);
        return "/backed/auditor/failedProjectList";
    }
}
