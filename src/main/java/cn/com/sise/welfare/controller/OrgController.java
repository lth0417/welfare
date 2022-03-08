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





    /*@RequestMapping("/issue")
    public ResultModel upload(OrgEntity orgEntity, MultipartFile[] file) throws IllegalStateException, IOException {
        File dirPath = new File(filePath);
        if (!dirPath.exists()) {
            dirPath.mkdirs();
        }
        for (int i=0;i<file.length;i++){
            picname=picname+","+file[i].getOriginalFilename();
        }
        orgEntity.setFilePath(picname);
        return ResultModel.ok(orgService.insertOrg(orgEntity));
    }*/
    /*String o = "";
        String n = "";
        String pic = file[0].getOriginalFilename();
        System.out.println(pic);*/
    //Pic pic1 = new Pic();
    /*try {
     *//*for (int i = 0; i < file.length; i++) {
                o = file[i].getOriginalFilename();
                n = produce.getProducename();
                file[i].transferTo(new File(filePath + n + i + ".jpg"));
                String picname="/pic/"+n+i+".jpg";
                pic1.setAddress(picname);
                pic1.setProducename(produce.getProducename());
                pic1.setCate(produce.getCate());
                int rows = produceService.addPic(pic1);
            }*//*
            for (int i=0;i<file.length;i++){
                picname=picname+file[i].getOriginalFilename();
            }

            *//*SecurityContext context = SecurityContextHolder.getContext();
            Authentication authentication = context.getAuthentication();
            UserDetails principal = (UserDetails) authentication.getPrincipal();
            String userid = String.valueOf(principal.getUsername());

            pic = "/pic/" + produce.getProducename() + "0.jpg";
            System.out.println(pic);
            Date date = new Date();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            dateFormat.format(date);
            Produce p = new Produce();

            p.setProducename(produce.getProducename());
            p.setStorename(produce.getStorename());
            p.setPrice(produce.getPrice());
            p.setIntroduce(produce.getIntroduce());
            p.setPhone(produce.getPhone());
            p.setAddress(produce.getAddress());
            p.setPic(pic);
            p.setCreatedate(date);
            p.setIndate(produce.getIndate());
            p.setCate(produce.getCate());
            p.setWarning(produce.getWarning());
            p.setMerchantId(userid);
            p.setStatu("3");
            p.setHeat(3);
            int rows = produceService.issueProduce(p);
            model.addAttribute("result", "上传成功！");*//*
        } catch (IOException e) {
            model.addAttribute("result", "添加失败！请稍后再尝试！");
            e.printStackTrace();

        }*/

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
