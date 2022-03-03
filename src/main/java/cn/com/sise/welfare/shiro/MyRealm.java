package cn.com.sise.welfare.shiro;


import cn.com.sise.welfare.entity.RoleEntity;
import cn.com.sise.welfare.entity.UserEntity;
import cn.com.sise.welfare.service.RoleService;
import cn.com.sise.welfare.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

public class MyRealm extends AuthorizingRealm {
    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection collection) {
        UserEntity userEntity = (UserEntity) collection.getPrimaryPrincipal();
        RoleEntity roleEntity = roleService.getById(userEntity.getRoleId());
        if (roleEntity != null){
            SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
            authorizationInfo.addRole(roleEntity.getRole());
            return authorizationInfo;
        }
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String account = (String) authenticationToken.getPrincipal();
        UserEntity userEntity = userService.login(account);
        if (userEntity!=null){
            return new SimpleAuthenticationInfo(userEntity,userEntity.getPassword(),ByteSource.Util.bytes(userEntity.getSalt()),getName());
        }
        return null;
    }

}
