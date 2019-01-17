package com.clown.thymeleaf.component;

import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;
import java.util.function.BiFunction;

/**
 * @author: Richard·Ackerman
 * @create: 2019/1/16
 *
 * 此配置是为了点击按钮实现中英文转换
 * 可以在连接上携带国际化的区域信息
 *
 **/
public class MyLocaleResolve implements LocaleResolver {

    @Override
    public Locale resolveLocale(HttpServletRequest request) {
        String language = request.getParameter("l");
        Locale locale = Locale.getDefault();
        if (!StringUtils.isEmpty(language)) {
            String[] str = language.split("_");

            //正常构建
            //locale = new Locale(str[0], str[1]);

            //以下为Lambda表达式构建
            BiFunction<String,String,Locale> fun = Locale::new;
            locale = fun.apply(str[0], str[1]);
        }
        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {

    }
}
