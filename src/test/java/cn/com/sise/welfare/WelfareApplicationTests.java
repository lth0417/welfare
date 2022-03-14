package cn.com.sise.welfare;

import cn.com.sise.welfare.entity.FileEntity;
import cn.com.sise.welfare.entity.OrgEntity;
import cn.com.sise.welfare.entity.UserEntity;
import cn.com.sise.welfare.mapper.FileMapper;
import cn.com.sise.welfare.mapper.OrgMapper;
import cn.com.sise.welfare.mapper.UserMapper;
import cn.com.sise.welfare.model.UserSearchModel;
import cn.com.sise.welfare.service.UserService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class WelfareApplicationTests {
@Autowired
private UserService userService;
    @Autowired
    private OrgMapper orgMapper;
    @Test
    void contextLoads() {
        QueryWrapper<OrgEntity> orgEntityQueryWrapper=new QueryWrapper<>();
        List<OrgEntity> orgresult= orgMapper.selectList(orgEntityQueryWrapper);
    }

}
