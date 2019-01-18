package com.clown.servlet.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author: Richard·Ackerman
 * @create: 2019/1/18
 **/
public class MyFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("clown is laughing at you...");
        chain.doFilter(request,response);
    }

    @Override
    public void destroy() {

    }
}
