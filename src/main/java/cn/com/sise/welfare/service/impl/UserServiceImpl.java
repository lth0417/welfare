package cn.com.sise.welfare.service.impl;

import cn.com.sise.welfare.entity.UserEntity;
import cn.com.sise.welfare.mapper.UserMapper;
import cn.com.sise.welfare.model.UserSearchModel;
import cn.com.sise.welfare.service.UserService;
import cn.com.sise.welfare.utils.SaltUtils;
import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("userService")
@Transactional
public class UserServiceImpl extends ServiceImpl<UserMapper, UserEntity>implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public IPage<UserEntity> selectUserInfo(UserSearchModel userSearchModel) {
        return userMapper.selectUserList(userSearchModel);
    }

    @Override
    public UserEntity login(String account) {
        QueryWrapper<UserEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("account",account);
        return userMapper.selectOne(queryWrapper);
    }

    @Override
    public UserEntity insertUser(UserSearchModel userSearchModel) {
        //1.获取随机盐
        String salt = SaltUtils.getSalt(8);
        //2.将随机盐保存到数据
        userSearchModel.setSalt(salt);
        //3.明文密码进行md5 + salt + hash散列
        Md5Hash MD5 = new Md5Hash(userSearchModel.getPassword(),salt,1024);
        userSearchModel.setPassword(MD5.toHex());
        UserEntity userEntity = new UserEntity();
        BeanUtil.copyProperties(userSearchModel,userEntity);
        int row = userMapper.insert(userEntity);
        if (row == 1){
            return userEntity;
        }
        return null;
    }
}
