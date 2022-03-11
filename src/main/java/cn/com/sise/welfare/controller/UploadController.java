package cn.com.sise.welfare.controller;

import cn.com.sise.welfare.utils.CodeUtils;
import cn.com.sise.welfare.utils.ResultModel;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@RestController
public class UploadController {

    @Value("${upload.file.path}")
    private String filePath;

    @PostMapping("/upload")
    public ResultModel UploadFile(@RequestParam("file") MultipartFile[] files) {
        String newName = "";
        if (files.length > 0) {
            for (MultipartFile file : files) {
                File folder = new File(filePath);
                if (!folder.isDirectory()) {
                    folder.mkdirs();
                }
                String oldName = file.getOriginalFilename();
                String suffixName = oldName.substring(oldName.lastIndexOf("."));//获取后缀名
                 newName = CodeUtils.getImgName() + suffixName;
                try {
                    //保存文件
                    file.transferTo(new File(folder, newName));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return ResultModel.ok(newName);
        }else {
            return ResultModel.errorMsg("上传失败");
        }
    }
}
