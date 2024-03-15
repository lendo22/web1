package com.cp.config;

import com.cp.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


// 这是一个配置文件，可以配置拦截器
@Configuration
public class WebConfigurer implements WebMvcConfigurer {
    //虚拟路径
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/pic/**")
                .addResourceLocations("file:/E:/mypic/");
        WebMvcConfigurer.super.addResourceHandlers(registry);
    }
    //@Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 把登录的拦截器配置上才能起作用
        //addPathPatterns("/**")拦截所有请求
        //excludePathPatterns("/user/login","/user/toLogin","/static/**")不需要拦截这些请求
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/user/toLogin", "/user/login", "/auth/code", "/static/**");
    }
}
