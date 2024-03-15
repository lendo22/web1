package com.cp.controller;

import com.cp.pojo.entity.Auth;
import com.cp.service.IAuthService;
import com.cp.util.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private IAuthService authService;


    @RequestMapping("/update")
    public String update(Auth auth) {
        authService.update(auth);
        // 更新之后，应该查找展示最新数据
        // redirect重定向: 告诉浏览器发送请求/auth/selectAll
        return "redirect:/auth/selectByPage";
    }

    @RequestMapping("/toAdd")
    public String toAdd() {
        return "/auth/add";
    }

    @RequestMapping("/toUpdate")
    public String toUpdate(Integer id, Model model) {
        Auth auth = authService.selectById(id);
        model.addAttribute("auth", auth);
        return "/auth/update";
    }


    @RequestMapping("/add")
    public String add(Auth auth) {
        authService.add(auth);
        // 添加之后，应该查找展示最新数据
        // redirect重定向: 告诉浏览器发送请求/auth/selectAll
        return "redirect:/auth/selectByPage";
    }

    @RequestMapping("/selectByPage")
    public String selectByPage(@RequestParam(defaultValue = "1") Integer pageNo,
                               @RequestParam(defaultValue = "10") Integer pageSize, Model model) {
        // soutm
        System.out.println("AuthController.selectByPage");
        PageInfo pageInfo = authService.selectByPage(pageNo,pageSize);

        //把list数据放到内存里面
        model.addAttribute("pageInfo", pageInfo);
        //转发到auth_list界面展示
        return "/auth/list";
    }
    @RequestMapping("/selectAll")
    public String selectAll(Model model) {
        // soutm
        System.out.println("AuthController.selectAll");
        List<Auth> list = authService.selectAll();

        //把list数据放到内存里面
        model.addAttribute("list", list);
        //转发到auth_list界面展示
        return "/auth/list";
    }

    // @ResponseBody 返回json格式数据
    // json集合表示: [{},{}]
    // json对象：{'id',1,'name':'zhangsan'}
    // http://localhost:8080/auth/selectAll
    @RequestMapping("/selectAll1")
    @ResponseBody
    public List<Auth> selectAll1() {
        // soutm
        System.out.println("AuthController.selectAll");
        List<Auth> list = authService.selectAll();

        return list;
    }

    // auth/deleteById?id=16
    @RequestMapping("/deleteById")
    public String deleteById(Integer id) {
        authService.deleteById(id);
        // 删除之后，应该查找展示最新数据
        // redirect重定向: 告诉浏览器发送请求/auth/selectAll
        return "redirect:/auth/selectByPage";
    }

    @RequestMapping("/deleteAll")
    public String deleteAll(Integer [] ids){
        authService.deleteAll(ids);
        return "redirect:/auth/selectByPage";
    }
}
