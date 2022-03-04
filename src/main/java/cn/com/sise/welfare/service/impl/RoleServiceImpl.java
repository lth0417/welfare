package cn.com.sise.welfare.service.impl;

import cn.com.sise.welfare.entity.RoleEntity;
import cn.com.sise.welfare.mapper.RoleMapper;
import cn.com.sise.welfare.model.RoleSearchModel;
import cn.com.sise.welfare.service.RoleService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("roleService")
@Transactional
public class RoleServiceImpl extends ServiceImpl<RoleMapper, RoleEntity> implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public IPage<RoleEntity> selectRole(RoleSearchModel roleSearchModel) {
        return roleMapper.selectRole(roleSearchModel);
    }

    @Override
    public RoleEntity addRole(RoleSearchModel roleSearchModel) {
        return roleMapper.addRoleInfo(roleSearchModel);
    }

    @Override
    public RoleEntity updateRole(RoleSearchModel roleSearchModel) {
        return roleMapper.updateRoleInfo(roleSearchModel);
    }

    @Override
    public int deleteRole(String id) {
        return roleMapper.deleteById(id);
    }

}
