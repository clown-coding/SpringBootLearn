package com.clown.security.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author: Richard·Ackerman
 * @create: 2019/1/24
 **/
@EnableWebSecurity
public class MySecurityConfig extends WebSecurityConfigurerAdapter {

    //控制请求的访问权限
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        //定义授权规则
        http.authorizeRequests()
                //对根目录下的所有访问放行
                .antMatchers("/").permitAll()
                //访问level1下的页面需要VIP1级别
                .antMatchers("/level1/**").hasRole("VIP1")
                .antMatchers("/level2/**").hasRole("VIP2")
                .antMatchers("/level3/**").hasRole("VIP3");

        /**
         * 开启登录功能,如果没有权限就会来到登录页面
         * formLogin的功能
         *  1. /login来到登录页面
         *  2. 重定向到login?error表示登录失败
         *  3. 默认post形式的/login代表处理登录
         *  4. 一旦定制loginPage,那么loginPage的post请求就是登录
         */
        http.formLogin()
                .usernameParameter("user")
                .passwordParameter("password")
                .loginPage("/userlogin");

        /**
         * 开启自动配置的注销功能,注销成功以后来到welcome.html
         * 访问/logout表示用户注销,清空session
         */
        http.logout().logoutSuccessUrl("/");

        /**
         * 开启记住我功能
         * 登录成功后,将cookie发给浏览器保存,再次进入网页,只要通过检查cookie就可以免登陆
         * 点击注销,删除cookie
         *
         */
        http.rememberMe().rememberMeParameter("rememberMe");
    }

    //定义认证规则
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //从内存中获取,springSecurity 5.0 的加密方式是{id}………… id为加密方式
        auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder())
                .withUser("zhang")
                .password(new BCryptPasswordEncoder().encode("123456")).roles("VIP1","VIP2")
                .and()
                .withUser("li")
                .password(new BCryptPasswordEncoder().encode("123456")).roles("VIP2","VIP3")
                .and()
                .withUser("wang")
                .password(new BCryptPasswordEncoder().encode("123456")).roles("VIP1","VIP3");
    }
}
