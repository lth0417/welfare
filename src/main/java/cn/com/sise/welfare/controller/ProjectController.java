package cn.com.sise.welfare.controller;

import cn.com.sise.welfare.model.ProjectInfoModel;
import cn.com.sise.welfare.model.ProjectSearchModel;
import cn.com.sise.welfare.model.UserInfoModel;
import cn.com.sise.welfare.model.UserSearchModel;
import cn.com.sise.welfare.service.ProjectService;
import cn.com.sise.welfare.utils.ResultModel;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/project")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @GetMapping("/StayProjectList")
    public ResultModel selectStayProjectList(ProjectSearchModel projectSearchModel) {
        IPage<ProjectInfoModel> data = projectService.selectStayProjectList(projectSearchModel);
        return ResultModel.ok(data.getTotal(),data.getRecords());
    }

    @GetMapping("/PassProjectList")
    public ResultModel selectPassProjectList(ProjectSearchModel projectSearchModel) {
        IPage<ProjectInfoModel> data = projectService.selectPassProjectList(projectSearchModel);
        return ResultModel.ok(data.getTotal(),data.getRecords());
    }

    @GetMapping("/NoPassProjectList")
    public ResultModel selectNoPassProjectList(ProjectSearchModel projectSearchModel) {
        IPage<ProjectInfoModel> data = projectService.selectPassProjectList(projectSearchModel);
        return ResultModel.ok(data.getTotal(),data.getRecords());
    }
}
