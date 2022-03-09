package cn.com.sise.welfare.controller;

import cn.com.sise.welfare.entity.OrgEntity;
import cn.com.sise.welfare.entity.UserEntity;
import cn.com.sise.welfare.model.OrgSearchModel;
import cn.com.sise.welfare.model.UserInfoModel;
import cn.com.sise.welfare.model.UserSearchModel;
import cn.com.sise.welfare.service.OrgService;
import cn.com.sise.welfare.utils.CodeUtils;
import cn.com.sise.welfare.utils.ResultModel;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @Value("${upload.file.path}")
    private String filePath;
    private static String picname="";
    //添加组织

    @RequestMapping(value ="/insertOrg", method = RequestMethod.POST)
    public ResultModel UploadFile(HttpServletRequest request,OrgEntity orgEntity){
        CommonsMultipartResolver cResolver = new CommonsMultipartResolver();
        if (cResolver.isMultipart(request)) {
            MultipartHttpServletRequest httpservletrequest = (MultipartHttpServletRequest) request;
            List<MultipartFile> list = httpservletrequest.getFiles("files");
            for (int i = 0; i < list.size(); i++) {
                System.out.println(list.get(i).getOriginalFilename());
                System.out.println(list.get(i).getContentType());
                picname=picname+","+list.get(i).getOriginalFilename();
                try {
                    list.get(i).transferTo(new File(filePath+list.get(i).getOriginalFilename()+i));
                    orgEntity.setFilePath(picname);
                    return ResultModel.ok(orgService.insertOrg(orgEntity));
                } catch (IllegalStateException e) {
                    e.printStackTrace();
                    //model.addAttribute("msg", "上传失败");
                    return ResultModel.errorMsg("上传失败");
                } catch (IOException e) {
                    e.printStackTrace();
                    //model.addAttribute("msg", "上传失败");
                    return ResultModel.errorMsg("上传失败");
                }
            }
        }
        return ResultModel.ok();
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


    @PostMapping("/imgUpload")
    public Object multiUpload(@RequestParam("file") MultipartFile[] files, OrgEntity orgEntity) {
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
        orgEntity.setFilePath(imgName);
        return ResultModel.ok(orgService.insertOrg(orgEntity));
    }

}
