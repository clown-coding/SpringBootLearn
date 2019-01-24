package com.clown.shiro.config;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Author: clown
 * @Date: 2019/1/9
 */
@Configuration
public class ShiroConfig {

    //创建ShiroFilterFactoryBean
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("SecurityManager") DefaultWebSecurityManager defaultWebSecurityManager){
        System.out.println("执行认证逻辑......");
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        //设置安全管理器
        shiroFilterFactoryBean.setSecurityManager(defaultWebSecurityManager);

        /* 添加shiro内置过滤器,实现权限拦截
         * 常用过滤器
         *          anon: 匿名访问,无需认证(登录)就可以访问
         *          authc: 必须认证才能访问
         *          user: 如果使用rememberme的功能可以直接访问
         *          perms: 该资源必须得到资源权限才可以访问
         *          role: 该资源必须得到角色权限才能访问
         */
        Map<String,String> filterMap = new LinkedHashMap<String,String>();

        //不需要拦截的资源
        filterMap.put("/index","anon");
        filterMap.put("/listen","anon");
        filterMap.put("/login","anon");

        //授权过滤器:当前授权拦截后,shiro会自动跳转到未授权界面
        //注意:一定要写在拦截资源前面
        filterMap.put("/add","perms[user:add]");
        filterMap.put("/update","perms[user:update]");

        //需要拦截的资源
        filterMap.put("/*","authc");


        //修改跳转的登录页面
        shiroFilterFactoryBean.setLoginUrl("/toLogin");

        //设置未授权提示页面
        shiroFilterFactoryBean.setUnauthorizedUrl("/noAuth");

        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterMap);

        return shiroFilterFactoryBean;
    }

    //创建DefaultWebSecurityManager
    @Bean("SecurityManager")
    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("UserRealm") UserRealm userRealm){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(userRealm);
        return securityManager;
    }

    //创建Realm
    @Bean("UserRealm")
    public UserRealm getUserRealm(){
        return new UserRealm();
    }


    //配置ShiroDialect,用于thymeleaf与shiro标签配合使用
    @Bean
    public ShiroDialect shiroDialect(){
        return new ShiroDialect();
    }
}
