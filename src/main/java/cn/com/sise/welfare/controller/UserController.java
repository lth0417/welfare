package cn.com.sise.welfare.controller;

import cn.com.sise.welfare.entity.UserEntity;
import cn.com.sise.welfare.model.UserInfoModel;
import cn.com.sise.welfare.model.UserSearchModel;
import cn.com.sise.welfare.service.UserService;
import cn.com.sise.welfare.utils.CodeUtils;
import cn.com.sise.welfare.utils.ResultModel;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @Value("${virtual.file.path}")
    private String path;
    @Value("${upload.file.path}")
    private String filePath;

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

    @GetMapping("/userWhiteList")
    public ResultModel selectUserWhiteList(UserSearchModel userSearchModel){
        IPage<UserInfoModel> data = userService.selectUserWhiteList(userSearchModel);
        return ResultModel.ok(data.getTotal(),data.getRecords());
    }

    @GetMapping("/userBlackList")
    public ResultModel selectUserBlackList(UserSearchModel userSearchModel){
        IPage<UserInfoModel> data = userService.selectUserBlackList(userSearchModel);
        return ResultModel.ok(data.getTotal(),data.getRecords());
    }

    /**
     * 拉进黑名单
     * @param userEntity
     * @return
     */
    @PostMapping("/blackUser")
    public ResultModel blackUserChange(UserEntity userEntity){
        userEntity.setStatus("1");
        return ResultModel.ok(userService.updateUserBaseInfo(userEntity));
    }

    /**
     * 移出黑名单
     * @param userEntity
     * @return
     */
    @PostMapping("/whiteUser")
    public ResultModel whiteUserChange(UserEntity userEntity){
        userEntity.setStatus("0");
        return ResultModel.ok(userService.updateUserBaseInfo(userEntity));
    }

    /**
     * 批量拉进黑名单
     * @param ids
     * @return
     */
    @PostMapping("/blackUserChangesList")
    public ResultModel blackUserChangesList(@RequestBody String[] ids){
        return ResultModel.ok(userService.blackUserChangesList(ids));
    }

    /**
     * 批量移出黑名单
     * @param ids
     * @return
     */
    @PostMapping("/whiteUserChangesList")
    public ResultModel whiteUserChangesList(@RequestBody String[] ids){
        return ResultModel.ok(userService.whiteUserChangesList(ids));
    }

    //用户修改个人信息
    @PostMapping("/updateUserBaseInfo")
    public ResultModel updateUserBaseInfo(UserEntity userEntity) {
        return ResultModel.ok(userService.updateUserBaseInfo(userEntity));
    }

    @PostMapping("/imgUpload")
    public Object multiUpload(@RequestParam("file") MultipartFile[] files, UserEntity userEntity) {
        System.out.println("文件的个数:" + files.length);
        String imgName = "";
        for (MultipartFile file : files) {
            if (file.isEmpty()) {
                return "未选择文件";
            }
            //获取上传文件原来的名称
            String oldName = file.getOriginalFilename();
            // 获取文件的后缀名
            String suffixName = oldName.substring(oldName.lastIndexOf("."));
            String fileName = CodeUtils.getImgName()+suffixName;
            File temp = new File(filePath,fileName);
            if (!temp.exists()) {
                temp.mkdirs();
            }
            imgName = imgName + fileName;
            File localFile = new File(filePath + File.separator+ fileName);
            try {
                file.transferTo(localFile); //把上传的文件保存至本地
            } catch (IOException e) {
                e.printStackTrace();
                return "上传失败";
            }
        }
        userEntity.setFilePath(imgName);
        return ResultModel.ok(userService.updateUserBaseInfo(userEntity));
    }

}
