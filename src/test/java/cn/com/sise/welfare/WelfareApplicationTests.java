package cn.com.sise.welfare;

import cn.com.sise.welfare.entity.UserEntity;
import cn.com.sise.welfare.mapper.UserMapper;
import cn.com.sise.welfare.model.UserSearchModel;
import cn.com.sise.welfare.service.UserService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class WelfareApplicationTests {
@Autowired
private UserService userService;
    @Test
    void contextLoads() {
        UserSearchModel userSearchModel = new UserSearchModel();
        userSearchModel.setAccount("admin");
        userSearchModel.setPassword("123456");
        userSearchModel.setRoleId("0");
        userService.insertUser(userSearchModel);
    }

}
