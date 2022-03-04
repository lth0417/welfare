package cn.com.sise.welfare.service;

import cn.com.sise.welfare.entity.UserEntity;
import cn.com.sise.welfare.model.UserInfoModel;
import cn.com.sise.welfare.model.UserSearchModel;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;

public interface UserService extends IService<UserEntity> {

    IPage<UserInfoModel> selectUserInfo(UserSearchModel userSearchModel);

    UserEntity login(String account);

    UserEntity register(UserSearchModel userSearchModel);

    //管理员管理黑名单
    UserEntity blackUserChange(UserSearchModel userSearchModel);

    //管理员管理白名单
    UserEntity whiteUserChange(UserSearchModel userSearchModel);

    //用户修改个人信息
    UserEntity updateUserBaseInfo(UserSearchModel userSearchModel);
}
