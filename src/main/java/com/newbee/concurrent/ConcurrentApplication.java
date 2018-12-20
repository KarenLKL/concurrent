package com.newbee.concurrent;

import com.newbee.concurrent.ThreadLocal.HttpFilter;
import com.newbee.concurrent.ThreadLocal.IntercepterHandler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.servlet.Filter;

@SpringBootApplication
public class ConcurrentApplication extends WebMvcConfigurerAdapter {

    public static void main(String[] args) {
        SpringApplication.run(ConcurrentApplication.class, args);
    }

    // 注册拦截器
    @Bean
    public FilterRegistrationBean httpFilter() {
        FilterRegistrationBean<Filter> filterFilterRegistrationBean = new FilterRegistrationBean<>();
        filterFilterRegistrationBean.setFilter(new HttpFilter());
        filterFilterRegistrationBean.addUrlPatterns("/threadLocal/*");// 要拦截的路径
        return filterFilterRegistrationBean;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new IntercepterHandler());
    }
}
