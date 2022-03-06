package cn.com.sise.welfare.mapper;

import cn.com.sise.welfare.entity.OrgEntity;
import cn.com.sise.welfare.model.OrgSearchModel;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface OrgMapper extends BaseMapper<OrgEntity> {
    //管理员查看组织列表
    IPage<OrgEntity> selectOrgList(@Param("org") OrgSearchModel orgSearchModel);

    //添加组织

}
