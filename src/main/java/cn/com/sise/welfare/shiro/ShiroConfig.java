package cn.com.sise.welfare.shiro;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.cache.ehcache.EhCacheManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {
    //ShiroFilter过滤所有请求
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(DefaultWebSecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        //给ShiroFilter配置安全管理器
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        //配置系统受限资源
        //配置系统公共资源
        Map<String, String> map = new HashMap<>();
        map.put("/css/**", "anon");//表示这个为公共资源 一定是在受限资源上面
        map.put("/fonts/**", "anon");//表示这个为公共资源 一定是在受限资源上面
        map.put("/images/**", "anon");//表示这个为公共资源 一定是在受限资源上面
        map.put("/js/**", "anon");//表示这个为公共资源 一定是在受限资源上面
        map.put("/lib/**", "anon");//表示这个为公共资源 一定是在受限资源上面
        map.put("/login/**", "anon");//表示这个为公共资源 一定是在受限资源上面
        map.put("/login", "anon");//表示这个为公共资源 一定是在受限资源上面
        map.put("/user/login", "anon");//表示这个为公共资源 一定是在受限资源上面
        map.put("/org/**", "anon");//表示这个为公共资源 一定是在受限资源上面
        map.put("/fronted/**", "anon");//表示这个为公共资源 一定是在受限资源上面
        map.put("/main/**", "anon");//表示这个为公共资源 一定是在受限资源上面
//        map.put("/user/login", "anon");//表示这个为公共资源 一定是在受限资源上面
//        map.put("/user/register", "anon");//表示这个为公共资源 一定是在受限资源上面
//        map.put("/register.jsp", "anon");//表示这个为公共资源 一定是在受限资源上面
        map.put("/**", "authc");//表示这个受限资源需要认证和授权
        // 设置认证界面路径
        shiroFilterFactoryBean.setLoginUrl("/login");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(map);

        return shiroFilterFactoryBean;
    }

    //创建安全管理器
    @Bean
    public DefaultWebSecurityManager getDefaultWebSecurityManager(MyRealm myRealm) {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(myRealm);
        return securityManager;
    }

    //创建自定义Realm
    @Bean
    public MyRealm getMyRealm() {
        MyRealm myRealm = new MyRealm();
        HashedCredentialsMatcher credentialsMatcher = new HashedCredentialsMatcher();
        //设置使用MD5加密算法
        credentialsMatcher.setHashAlgorithmName("md5");
        //散列次数
        credentialsMatcher.setHashIterations(1024);
        myRealm.setCredentialsMatcher(credentialsMatcher);

        //开启缓存管理器
        myRealm.setCacheManager(new EhCacheManager());
        myRealm.setCachingEnabled(true);//开启缓存
        myRealm.setAuthenticationCachingEnabled(true);//开启认证缓存
        myRealm.setAuthenticationCacheName("authentication");
        myRealm.setAuthorizationCachingEnabled(true);//开启授权缓存
        myRealm.setAuthorizationCacheName("authorization");

        return myRealm;
    }

    @Bean(name = "shiroDialect")
    public ShiroDialect shiroDialect(){
        return new ShiroDialect();
    }

}