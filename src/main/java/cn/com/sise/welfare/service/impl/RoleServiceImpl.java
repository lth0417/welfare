package cn.com.sise.welfare.service.impl;

import cn.com.sise.welfare.entity.RoleEntity;
import cn.com.sise.welfare.mapper.RoleMapper;
import cn.com.sise.welfare.service.RoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("roleService")
@Transactional
public class RoleServiceImpl extends ServiceImpl<RoleMapper, RoleEntity> implements RoleService {

}
