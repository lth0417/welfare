package cn.com.sise.welfare.controller.fronted;

import cn.com.sise.welfare.entity.ProjectEntity;
import cn.com.sise.welfare.mapper.ProjectMapper;
import cn.com.sise.welfare.utils.ResultModel;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: lth
 * @Date: 2022/03/10/20:03
 * @Description:
 */
@RestController
@RequestMapping("/fronted")
public class FrontedProjectController {
    @Autowired
    private ProjectMapper projectMapper;

    @GetMapping("/findProject")
    public ResultModel findProject(){
        QueryWrapper<ProjectEntity> queryWrapper=new QueryWrapper<>();
        List<ProjectEntity> projectEntities=projectMapper.selectList(queryWrapper);
        return ResultModel.ok(projectEntities);
    }
}
