package com.clown.servlet.config;

import com.clown.servlet.filter.MyFilter;
import com.clown.servlet.listener.MyListener;
import com.clown.servlet.servlet.MyServlet;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

/**
 * @author: Richard·Ackerman
 * @create: 2019/1/18
 **/
@Configuration
public class MyServletConfig {

    /**
     * 注册Servlet
     * @return
     */
    @Bean
    public ServletRegistrationBean myServlet(){
        ServletRegistrationBean<MyServlet> servlet = new ServletRegistrationBean<>(new MyServlet(), "/myServlet");
        servlet.setLoadOnStartup(1);
        return servlet;
    }

    /**
     * 注册filter
     * @return
     */
    @Bean
    public FilterRegistrationBean myFilter(){
        FilterRegistrationBean<MyFilter> filter = new FilterRegistrationBean<>();
        filter.setFilter(new MyFilter());
        filter.setUrlPatterns(Arrays.asList("/listen","/myServlet"));
        return filter;
    }

    /**
     * 注册listener
     * @return
     */
    @Bean
    public ServletListenerRegistrationBean myListener(){
        ServletListenerRegistrationBean<MyListener> listen = new ServletListenerRegistrationBean<>(new MyListener());
        return listen;
    }
}
