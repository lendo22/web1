package com.cp.interceptor;

import com.cp.pojo.entity.User;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.servlet.HandlerInterceptor;

public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 判断有没有登录
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if(user == null){
            response.sendRedirect("/user/toLogin");
            return false;
        }
        // 之前登录过，放行，访问后边controller
        return true;
    }
}
