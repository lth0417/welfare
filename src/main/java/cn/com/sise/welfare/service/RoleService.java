package cn.com.sise.welfare.service;

import cn.com.sise.welfare.entity.RoleEntity;
import cn.com.sise.welfare.model.RoleSearchModel;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

public interface RoleService extends IService<RoleEntity> {

    IPage<RoleEntity> selectRole(RoleSearchModel roleSearchModel);

    RoleEntity addRole(RoleSearchModel roleSearchModel);

    RoleEntity updateRole(RoleSearchModel roleSearchModel);

    int deleteRole(String id);
}
