package cn.com.sise.welfare.mapper;

import cn.com.sise.welfare.entity.UserEntity;
import cn.com.sise.welfare.model.UserSearchModel;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper extends BaseMapper<UserEntity> {

    //管理员查看用户信息
    IPage<UserEntity> selectUserList(@Param("user") UserSearchModel userSearchModel);

    //管理员管理黑名单
    UserEntity blackUserChange(@Param("p") UserSearchModel userSearchModel);

    //管理员管理白名单
    UserEntity whiteUserChange(@Param("p") UserSearchModel userSearchModel);

    //用户修改个人信息
    UserEntity updateUserBaseInfo(@Param("p") UserSearchModel userSearchModel);

}
