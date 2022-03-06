package cn.com.sise.welfare.service;

import cn.com.sise.welfare.entity.OrgEntity;
import cn.com.sise.welfare.model.OrgSearchModel;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Mapper;


public interface OrgService extends IService<OrgEntity> {
    IPage<OrgEntity> selectOrgList(OrgSearchModel orgSearchModel);

    //添加组织
    int insertOrg(OrgEntity orgEntity);

}
