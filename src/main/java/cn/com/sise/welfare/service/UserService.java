package cn.com.sise.welfare.service;

import cn.com.sise.welfare.entity.UserEntity;
import cn.com.sise.welfare.model.UserSearchModel;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

public interface UserService extends IService<UserEntity> {

    IPage<UserEntity> selectUserInfo(UserSearchModel userSearchModel);

    UserEntity login(String account);

    UserEntity insertUser(UserSearchModel userSearchModel);
}
