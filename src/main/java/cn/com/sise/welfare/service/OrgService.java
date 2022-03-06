package cn.com.sise.welfare.service;

import cn.com.sise.welfare.entity.OrgEntity;
import cn.com.sise.welfare.model.OrgSearchModel;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Mapper;


public interface OrgService extends IService<OrgEntity> {
    //查询通过审核组织
    IPage<OrgEntity> selectPassOrgList(OrgSearchModel orgSearchModel);

    //查询待审核组织
    IPage<OrgEntity> selectStayOrgList(OrgSearchModel orgSearchModel);

    //查询未通过审核组织
    IPage<OrgEntity> selectNoPassOrgList(OrgSearchModel orgSearchModel);

    //添加组织
    int insertOrg(OrgEntity orgEntity);

    //删除组织
    int deleteOrg(String id);

    //修改组织信息
    int updateOrg(OrgEntity orgEntity);

}
