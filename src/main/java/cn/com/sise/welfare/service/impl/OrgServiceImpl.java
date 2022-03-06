package cn.com.sise.welfare.service.impl;

import cn.com.sise.welfare.entity.OrgEntity;
import cn.com.sise.welfare.mapper.OrgMapper;
import cn.com.sise.welfare.model.OrgSearchModel;
import cn.com.sise.welfare.service.OrgService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("orgService")
@Transactional
public class OrgServiceImpl extends ServiceImpl<OrgMapper, OrgEntity>implements OrgService {

    @Autowired
    private OrgMapper orgMapper;


    @Override
    public IPage<OrgEntity> selectPassOrgList(OrgSearchModel orgSearchModel) {
        return orgMapper.selectPassOrgList(orgSearchModel);
    }

    @Override
    public IPage<OrgEntity> selectStayOrgList(OrgSearchModel orgSearchModel) {
        return orgMapper.selectStayOrgList(orgSearchModel);
    }

    @Override
    public IPage<OrgEntity> selectNoPassOrgList(OrgSearchModel orgSearchModel) {
        return orgMapper.selectNoPassOrgList(orgSearchModel);
    }

    @Override
    public int insertOrg(OrgEntity orgEntity) {
        return orgMapper.insert(orgEntity);
    }

    @Override
    public int deleteOrg(String id) {
        return orgMapper.deleteById(id);
    }

    @Override
    public int updateOrg(OrgEntity orgEntity) {
        return orgMapper.updateById(orgEntity);
    }


}
