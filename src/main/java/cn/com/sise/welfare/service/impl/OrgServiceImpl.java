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
    public IPage<OrgEntity> selectOrgList(OrgSearchModel orgSearchModel) {
        return orgMapper.selectOrgList(orgSearchModel);
    }

    @Override
    public int insertOrg(OrgEntity orgEntity) {
        return orgMapper.insert(orgEntity);
    }


}
