package cn.com.sise.welfare.service;

import cn.com.sise.welfare.entity.ProjectEntity;
import cn.com.sise.welfare.model.ProjectInfoModel;
import cn.com.sise.welfare.model.ProjectSearchModel;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

public interface ProjectService extends IService<ProjectEntity> {

    //管理员查看所有待审核公益项目信息
    IPage<ProjectInfoModel> selectStayProjectList(ProjectSearchModel projectSearchModel);

    //管理员查看所有通过公益项目信息
    IPage<ProjectInfoModel> selectPassProjectList(ProjectSearchModel projectSearchModel);

    //管理员查看所有不通过公益项目信息
    IPage<ProjectInfoModel> selectNoPassProjectList(ProjectSearchModel projectSearchModel);

    //管理员查看所有不通过公益项目信息
    IPage<ProjectInfoModel> selectPubilishProjectList(ProjectSearchModel projectSearchModel);

    //用户添加项目
    int addProjectInfo(ProjectEntity projectEntity);

    //用户修改项目信息
    int updateProjectInfo(ProjectEntity projectEntity);

    //用户删除项目信息
    int deleteProjectInfo(String id);
}
