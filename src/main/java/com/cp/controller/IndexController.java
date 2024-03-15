package com.cp.controller;


import com.cp.pojo.entity.Auth;
import com.cp.pojo.entity.User;
import com.cp.service.IAuthService;
import org.springframework.ui.Model;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * index跳转转发控制
 */

@Controller
public class IndexController {
    @Autowired
    private IAuthService authService;
    @RequestMapping("/")
    public String index(HttpSession session,Model model){
        User user = (User) session.getAttribute("user");
        List<Auth> list = authService.selectByRoleId(user.getRole());
        model.addAttribute("list", list);
        return "index";
    }
    @RequestMapping("/indexAdmin")
    public String indexAdmin(){
        return "index_admin";
    }

    @RequestMapping("/indexNormal")
    public String indexNormal(){
        return "index_normal";
    }
}
