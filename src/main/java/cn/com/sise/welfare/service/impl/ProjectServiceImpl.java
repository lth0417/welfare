package cn.com.sise.welfare.service.impl;

import cn.com.sise.welfare.entity.ProjectEntity;
import cn.com.sise.welfare.mapper.ProjectMapper;
import cn.com.sise.welfare.model.ProjectInfoModel;
import cn.com.sise.welfare.model.ProjectSearchModel;
import cn.com.sise.welfare.service.ProjectService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("projectService")
@Transactional
public class ProjectServiceImpl extends ServiceImpl<ProjectMapper, ProjectEntity> implements ProjectService {
    @Autowired
    private ProjectMapper projectMapper;

    @Override
    public IPage<ProjectInfoModel> selectStayProjectList(ProjectSearchModel projectSearchModel) {
        return projectMapper.selectStayProjectList(projectSearchModel);
    }

    @Override
    public IPage<ProjectInfoModel> selectPassProjectList(ProjectSearchModel projectSearchModel) {
        return projectMapper.selectPassProjectList(projectSearchModel);
    }

    @Override
    public IPage<ProjectInfoModel> selectNoPassProjectList(ProjectSearchModel projectSearchModel) {
        return projectMapper.selectNoPassProjectList(projectSearchModel);
    }
}
