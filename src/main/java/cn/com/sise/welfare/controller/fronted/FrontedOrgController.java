package cn.com.sise.welfare.controller.fronted;

import cn.com.sise.welfare.entity.OrgEntity;
import cn.com.sise.welfare.mapper.OrgMapper;
import cn.com.sise.welfare.model.OrgSearchModel;
import cn.com.sise.welfare.service.OrgService;
import cn.com.sise.welfare.utils.ResultModel;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: lth
 * @Date: 2022/03/12/22:05
 * @Description:
 */
@Controller
public class FrontedOrgController {
    @Autowired
    private OrgMapper orgMapper;
    @Autowired
    private OrgService orgService;

    @GetMapping("/findAllOrg")
    public String findAllOrg(){
        QueryWrapper<OrgEntity> orgEntityQueryWrapper=new QueryWrapper<>();
        List<OrgEntity> orgEntityList=orgMapper.selectList(orgEntityQueryWrapper);
        return null;
    }

    @GetMapping("/findOrgNumByorgCode")
    public ResultModel findOrgNumByorgCode(OrgEntity orgEntity){
        List<OrgEntity> orgEntityList=orgService.findOrgNumByOrgCode(orgEntity);
        return ResultModel.ok(orgEntityList);
    }
}
