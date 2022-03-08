package cn.com.sise.welfare.mapper;

import cn.com.sise.welfare.entity.ProjectEntity;
import cn.com.sise.welfare.model.ProjectInfoModel;
import cn.com.sise.welfare.model.ProjectSearchModel;
import cn.com.sise.welfare.model.UserInfoModel;
import cn.com.sise.welfare.model.UserSearchModel;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ProjectMapper extends BaseMapper<ProjectEntity> {

    //管理员查看所有待审核公益项目信息
    IPage<ProjectInfoModel> selectStayProjectList(@Param("project") ProjectSearchModel projectSearchModel);

    //管理员查看所有通过公益项目信息
    IPage<ProjectInfoModel> selectPassProjectList(@Param("project") ProjectSearchModel projectSearchModel);

    //管理员查看所有不通过公益项目信息
    IPage<ProjectInfoModel> selectNoPassProjectList(@Param("project") ProjectSearchModel projectSearchModel);

    //管理员查看所有发布公益项目信息
    IPage<ProjectInfoModel> selectPublishProjectList(@Param("project") ProjectSearchModel projectSearchModel);


}
