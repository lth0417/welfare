package cn.com.sise.welfare.controller;

import cn.com.sise.welfare.entity.OrgEntity;
import cn.com.sise.welfare.model.OrgSearchModel;
import cn.com.sise.welfare.model.UserInfoModel;
import cn.com.sise.welfare.model.UserSearchModel;
import cn.com.sise.welfare.service.OrgService;
import cn.com.sise.welfare.utils.ResultModel;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/org")
public class OrgController {

    @Autowired
    private OrgService orgService;

    @GetMapping("/selectOrgList")
    public ResultModel selectOrgList(OrgSearchModel orgSearchModel){
        IPage<OrgEntity> data = orgService.selectOrgList(orgSearchModel);
        return ResultModel.ok(data.getTotal(),data.getRecords());
    }

    @PostMapping("/insertOrg")
    public ResultModel insertOrg(OrgEntity orgEntity){
        return ResultModel.ok(orgService.insertOrg(orgEntity));
    }
}
