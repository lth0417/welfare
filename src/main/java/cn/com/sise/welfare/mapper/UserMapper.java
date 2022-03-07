package cn.com.sise.welfare.mapper;

import cn.com.sise.welfare.entity.UserEntity;
import cn.com.sise.welfare.model.UserInfoModel;
import cn.com.sise.welfare.model.UserSearchModel;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper extends BaseMapper<UserEntity> {

    //管理员查看白名单用户信息
    IPage<UserInfoModel> selectUserWhiteList(@Param("user") UserSearchModel userSearchModel);

    //管理员查看黑名单用户信息
    IPage<UserInfoModel> selectUserBlackList(@Param("user") UserSearchModel userSearchModel);

    //管理员批量管理黑名单
    int blackUserChangesList(String[] id);

    //管理员批量管理白名单
    int whiteUserChangesList(String[] id);



}
