package cn.com.sise.welfare.controller;

import cn.com.sise.welfare.model.UserSearchModel;
import cn.com.sise.welfare.service.UserService;
import cn.com.sise.welfare.utils.ResultModel;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResultModel userLogin(String account,String password){
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(account,password);
        try {
            subject.login(token);
            if (subject.hasRole("admin")){
                return ResultModel.ok("/admin");
            }else if (subject.hasRole("auditor")){
                return ResultModel.ok("/auditor");
            }else{
                return ResultModel.ok("/user");
            }
        } catch (UnknownAccountException e) {
            return ResultModel.errorMsg("账户不存在");
        }catch (CredentialsException e){
            return ResultModel.errorMsg("密码错误");
        }
    }

    @PostMapping("/register")
    public ResultModel register(UserSearchModel userSearchModel){
       return ResultModel.ok(userService.register(userSearchModel));
    }

    @PostMapping("/userList")
    public ResultModel selectUserList(UserSearchModel userSearchModel){
        return ResultModel.ok(userService.selectUserInfo(userSearchModel));
    }

    @PostMapping("/blackUser")
    public ResultModel blackUserChange(UserSearchModel userSearchModel){
        return ResultModel.ok(userService.blackUserChange(userSearchModel));
    }

    @PostMapping("/whiteUser")
    public ResultModel whiteUserChange(UserSearchModel userSearchModel){
        return ResultModel.ok(userService.whiteUserChange(userSearchModel));
    }

}
