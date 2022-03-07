package cn.com.sise.welfare.service;

import cn.com.sise.welfare.entity.UserEntity;
import cn.com.sise.welfare.model.UserInfoModel;
import cn.com.sise.welfare.model.UserSearchModel;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;

public interface UserService extends IService<UserEntity> {

    IPage<UserInfoModel> selectUserWhiteList(UserSearchModel userSearchModel);

    IPage<UserInfoModel> selectUserBlackList(UserSearchModel userSearchModel);

    UserEntity login(String account);

    UserEntity register(UserSearchModel userSearchModel);

    //管理员管理黑名单
    int blackUserChange(UserEntity userEntity);

    //管理员管理白名单
    int whiteUserChange(UserEntity userEntity);

    //管理员批量管理黑名单
    int blackUserChangesList(String[] id);

    //管理员批量管理白名单
    int whiteUserChangesList(String[] id);

    //用户修改个人信息
    int updateUserBaseInfo(UserEntity userEntity);

}
