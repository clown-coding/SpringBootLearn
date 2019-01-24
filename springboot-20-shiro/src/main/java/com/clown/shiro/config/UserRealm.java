package com.clown.shiro.config;

import com.clown.shiro.model.User;
import com.clown.shiro.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author: clown
 * @Date: 2019/1/9
 */
public class UserRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;


    /**
     * 执行授权逻辑
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        System.out.println("执行授权逻辑");

        //给资源进行授权,添加资源的授权字符
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();

        //数据库查询当前登录用的权限
        //获取当前登录用户
        Subject subject = SecurityUtils.getSubject();
        User user = (User)subject.getPrincipal();
        User loginUser = userService.findById(user.getId());

        //添加用户权限信息
        info.addStringPermission(loginUser.getPerms());
        return info;
    }

    /**
     * 执行认证逻辑
     * @param arg0
     * @return
     * @throws AuthenticationException
     */



    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken arg0) throws AuthenticationException {
        UsernamePasswordToken token =(UsernamePasswordToken)arg0;

        //0.根据用户名查询数据库
        User user = userService.findByName(token.getUsername());
        if(null == user){
            return null;
        }
        //1.编写shiro逻辑: 判断密码
        return new SimpleAuthenticationInfo(user,user.getPassword(),"");
    }
}
