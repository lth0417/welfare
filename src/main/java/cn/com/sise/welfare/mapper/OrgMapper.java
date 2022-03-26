package cn.com.sise.welfare.mapper;

import cn.com.sise.welfare.entity.OrgEntity;
import cn.com.sise.welfare.model.OrgSearchModel;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface OrgMapper extends BaseMapper<OrgEntity> {
    //查询通过审核组织
    IPage<OrgEntity> selectPassOrgList(@Param("org") OrgSearchModel orgSearchModel);

    //查询待审核组织
    IPage<OrgEntity> selectStayOrgList(@Param("org") OrgSearchModel orgSearchModel);

    //查询未通过审核组织
    IPage<OrgEntity> selectNoPassOrgList(@Param("org") OrgSearchModel orgSearchModel);

    //批量通过审核
    int passOrgList(String[] id);

    List<OrgEntity> findOrgNumByOrgCode(OrgEntity orgEntity);
}
