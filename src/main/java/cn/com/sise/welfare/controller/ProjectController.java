package cn.com.sise.welfare.controller;

import cn.com.sise.welfare.entity.ProjectEntity;
import cn.com.sise.welfare.model.ProjectInfoModel;
import cn.com.sise.welfare.model.ProjectSearchModel;
import cn.com.sise.welfare.service.ProjectService;
import cn.com.sise.welfare.utils.ResultModel;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/project")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    //待审核项目列表
    @GetMapping("/StayProjectList")
    public ResultModel selectStayProjectList(ProjectSearchModel projectSearchModel) {
        IPage<ProjectInfoModel> data = projectService.selectStayProjectList(projectSearchModel);
        return ResultModel.ok(data.getTotal(),data.getRecords());
    }

    //审核通过项目列表
    @GetMapping("/PassProjectList")
    public ResultModel selectPassProjectList(ProjectSearchModel projectSearchModel) {
        IPage<ProjectInfoModel> data = projectService.selectPassProjectList(projectSearchModel);
        return ResultModel.ok(data.getTotal(),data.getRecords());
    }

    //审核不通过列表
    @GetMapping("/NoPassProjectList")
    public ResultModel selectNoPassProjectList(ProjectSearchModel projectSearchModel) {
        IPage<ProjectInfoModel> data = projectService.selectPassProjectList(projectSearchModel);
        return ResultModel.ok(data.getTotal(),data.getRecords());
    }

    //已发布列表
    @GetMapping("/PublishProjectList")
    public ResultModel selectPublishProjectList(ProjectSearchModel projectSearchModel) {
        IPage<ProjectInfoModel> data = projectService.selectPubilishProjectList(projectSearchModel);
        return ResultModel.ok(data.getTotal(),data.getRecords());
    }

    //审核项目通过
    @PostMapping("/updatePassProject")
    public ResultModel updatePassProject(ProjectEntity projectEntity){
        projectEntity.setStatus("1");
        return ResultModel.ok(projectService.updateProjectInfo(projectEntity));
    }

    //审核项目不通过
    @PostMapping("/updateNoPassProject")
    public ResultModel updateNoPassProject(ProjectEntity projectEntity){
        projectEntity.setStatus("2");
        projectEntity.setReason(projectEntity.getReason());
        return ResultModel.ok(projectService.updateProjectInfo(projectEntity));
    }

    //发布项目
    @PostMapping("/updatePublishProject")
    public ResultModel updatePublishProject(ProjectEntity projectEntity){
        projectEntity.setStatus("3");
        return ResultModel.ok(projectService.updateProjectInfo(projectEntity));
    }

    //用户修改项目信息
    @PostMapping("/updateProject")
    public ResultModel updateProject(ProjectEntity projectEntity){
        return ResultModel.ok(projectService.updateProjectInfo(projectEntity));
    }

    //用户添加项目
    @PostMapping("/addProject")
    public ResultModel addProject(ProjectEntity projectEntity){
        return ResultModel.ok(projectService.addProjectInfo(projectEntity));
    }

    //用户删除项目
    @PostMapping("/deleteProject")
    public ResultModel deleteProject(String id){
        return ResultModel.ok(projectService.deleteProjectInfo(id));
    }

}
