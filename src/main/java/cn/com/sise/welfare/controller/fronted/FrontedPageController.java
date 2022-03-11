package cn.com.sise.welfare.controller.fronted;

import cn.com.sise.welfare.entity.FileEntity;
import cn.com.sise.welfare.mapper.FileMapper;
import cn.com.sise.welfare.utils.ResultModel;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: lth
 * @Date: 2022/03/08/22:08
 * @Description:
 */
@Controller
@RequestMapping("/main")
public class FrontedPageController {
    @Autowired
    private FileMapper fileMapper;

    //登录后跳转到前端页面
    @GetMapping("/user")
    public String toFronted(Model model) {
        QueryWrapper<FileEntity> fileEntityQueryWrapper = new QueryWrapper<>();
        List<FileEntity> banners = fileMapper.selectList(fileEntityQueryWrapper);
        model.addAttribute("banners", banners);
        return "/fronted/index";
    }

    @GetMapping("/findWall")
    public String findAllWall(Model model){
        QueryWrapper<FileEntity> fileEntityQueryWrapper= new QueryWrapper<>();
        List<FileEntity>banners= fileMapper.selectList(fileEntityQueryWrapper);
        model.addAttribute("banners",banners);
        return "/fronted/index";
    }

}
