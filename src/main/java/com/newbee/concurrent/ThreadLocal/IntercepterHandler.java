package com.newbee.concurrent.ThreadLocal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class IntercepterHandler extends HandlerInterceptorAdapter {
    private final static Logger LOGGER= LoggerFactory.getLogger(IntercepterHandler.class);
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        LOGGER.info("........preHandle");
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        LOGGER.info("afterCompletion........");
        RequestHolder.remove();
        super.afterCompletion(request, response, handler, ex);
    }
}
