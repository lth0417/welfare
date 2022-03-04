package cn.com.sise.welfare.controller;

import cn.com.sise.welfare.model.RoleSearchModel;
import cn.com.sise.welfare.service.RoleService;
import cn.com.sise.welfare.utils.ResultModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @PostMapping("/roleList")
    public ResultModel selectRoleList(RoleSearchModel roleSearchModel){
        return ResultModel.ok(roleService.selectRole(roleSearchModel));
    }

    @PostMapping("/addRole")
    public ResultModel addRoleInfo(RoleSearchModel roleSearchModel){
        return ResultModel.ok(roleService.addRole(roleSearchModel));
    }

    @PostMapping("/updateRole")
    public ResultModel updateRoleInfo(RoleSearchModel roleSearchModel){
        return ResultModel.ok(roleService.updateRole(roleSearchModel));
    }

    @GetMapping("/deleteRole")
    public ResultModel deleteRoleInfo(String id){
        return ResultModel.ok(roleService.deleteRole(id));
    }

}
