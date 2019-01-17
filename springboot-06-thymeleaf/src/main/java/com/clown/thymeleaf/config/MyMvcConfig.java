package com.clown.thymeleaf.config;

import com.clown.thymeleaf.component.MyLocaleResolve;
import com.clown.thymeleaf.interpceptor.LoginHandlerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author: Richard·Ackerman
 * @create: 2019/1/15
 * springboot 2.0 之后直接实现 WebMvcConfigurer接口就可以
 **/
//@EnableWebMvc
@Configuration
public class MyMvcConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //浏览器发送listening请求,返回给浏览器listening页面
        registry.addViewController("/listening").setViewName("success/listening");
    }




    //自定义视图,使用@Bean注解将组件注册到容器中,上面是添加一个视图解析器,下面是添加一个自定义配置集合
    @Bean
    public WebMvcConfigurer webMvcConfigurer(){
        return new WebMvcConfigurer(){
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("/").setViewName("login");
                registry.addViewController("/index.html").setViewName("login");
                registry.addViewController("/main.html").setViewName("dashboard");
            }

            //注册拦截器 //静态资源在springboot2.0发生改变,还是要放行
            @Override
            public void addInterceptors(InterceptorRegistry registry) {
                registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**")
                        .excludePathPatterns("/index.html","/","/user/login")
                        .excludePathPatterns("/asserts/css/**","/asserts/js/**","/asserts/img/**","/webjars/**");
            }
        };
    }

    //注册拦截器


    //将我们自定义的国际化组件放入容器中
    @Bean
    public LocaleResolver localeResolver(){
        return new MyLocaleResolve();
    }
}
