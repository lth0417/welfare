package cn.com.sise.welfare.controller;

import cn.com.sise.welfare.entity.OrgEntity;
import cn.com.sise.welfare.model.OrgSearchModel;
import cn.com.sise.welfare.model.UserInfoModel;
import cn.com.sise.welfare.model.UserSearchModel;
import cn.com.sise.welfare.service.OrgService;
import cn.com.sise.welfare.utils.ResultModel;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/org")
public class OrgController {

    @Autowired
    private OrgService orgService;

    @GetMapping("/selectPassOrgList")
    public ResultModel selectPassOrgList(OrgSearchModel orgSearchModel){
        IPage<OrgEntity> data = orgService.selectPassOrgList(orgSearchModel);
        return ResultModel.ok(data.getTotal(),data.getRecords());
    }

    @GetMapping("/selectStayOrgList")
    public ResultModel selectStayOrgList(OrgSearchModel orgSearchModel){
        IPage<OrgEntity> data = orgService.selectStayOrgList(orgSearchModel);
        return ResultModel.ok(data.getTotal(),data.getRecords());
    }

    @GetMapping("/selectNoPassOrgList")
    public ResultModel selectNoPassOrgList(OrgSearchModel orgSearchModel){
        IPage<OrgEntity> data = orgService.selectNoPassOrgList(orgSearchModel);
        return ResultModel.ok(data.getTotal(),data.getRecords());
    }

    //添加组织
    @PostMapping("/insertOrg")
    public ResultModel insertOrg(OrgEntity orgEntity){

        return ResultModel.ok(orgService.insertOrg(orgEntity));
    }

    //删除组织
    @PostMapping("/deleteOrg")
    public ResultModel deleteOrg(String id){
        return ResultModel.ok(orgService.deleteOrg(id));
    }

   //审核组织通过
   @PostMapping("/updatePassOrg")
   public ResultModel updatePassOrg(OrgEntity orgEntity){
       return ResultModel.ok(orgService.updatePassOrg(orgEntity));
   }

    //审核组织不通过
    @PostMapping("/updateNoPassOrg")
    public ResultModel updateNoPassOrg(OrgEntity orgEntity){
        return ResultModel.ok(orgService.updateNoPassOrg(orgEntity));
    }

    //禁用组织
    @PostMapping("/updateBanOrg")
    public ResultModel updateBanOrg(OrgEntity orgEntity){
        return ResultModel.ok(orgService.updateBanOrg(orgEntity));
    }

    //批量通过审核
    @PostMapping("/passOrgList")
    public ResultModel passOrgList(@RequestBody String[] id){
        return ResultModel.ok(orgService.passOrgList(id));
    }

    //用户修改组织信息
    @PostMapping("/updateOrg")
    public ResultModel updateOrg(OrgEntity orgEntity){
        return ResultModel.ok(orgService.updateOrg(orgEntity));
    }


}
