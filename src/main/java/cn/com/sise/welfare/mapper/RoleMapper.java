package cn.com.sise.welfare.mapper;

import cn.com.sise.welfare.entity.RoleEntity;
import cn.com.sise.welfare.entity.UserEntity;
import cn.com.sise.welfare.model.RoleSearchModel;
import cn.com.sise.welfare.model.UserInfoModel;
import cn.com.sise.welfare.model.UserSearchModel;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface RoleMapper extends BaseMapper<RoleEntity> {

    //管理员查看角色信息
    IPage<RoleEntity> selectRole(@Param("r") RoleSearchModel roleSearchModel);

    //管理员添加角色
    RoleEntity addRoleInfo(RoleSearchModel roleSearchModel);

    //管理员修改角色
    RoleEntity updateRoleInfo(RoleSearchModel roleSearchModel);

}
