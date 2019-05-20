package com.chen.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(urlPatterns = {"/*"})
public class MyFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("init.........");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("do  begin...");
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("do end.......");
    }

    @Override
    public void destroy() {
        System.out.println("destory...");
        System.out.println("de...");
    }
}
