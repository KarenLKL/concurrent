package com.newbee.concurrent.ThreadLocal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class HttpFilter implements Filter {
    private final static Logger LOGGER = LoggerFactory.getLogger(HttpFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        RequestHolder.add(Thread.currentThread().getId());
//        LOGGER.info(request.getSession().getAttribute("user"));
        LOGGER.info("do filter: {} {}", Thread.currentThread().getId(), request.getServletPath());
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
