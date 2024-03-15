package com.cp.controller;

import com.cp.pojo.entity.User;
import com.cp.service.IUserService;
import com.cp.util.PageInfo;
import com.cp.util.Result;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private IUserService userService;

    @RequestMapping("/toLogin")
    public String toLogin() {
        return "login";
    }

    @RequestMapping("/login")
    @ResponseBody
    public Result login(String name, String password, String code, HttpSession session) {
        // 先验证验证码对不对，验证码正确再验证用户密码是否正确
        // 验证码不对，直接返回错误，后面不需要执行
        String codeInSession = (String) session.getAttribute("codeInSession");

        if (!codeInSession.equalsIgnoreCase(code)) {
            return Result.error("验证码错误!");
        }

        // 根据name和password查询用户
        User user = userService.login(name, password);
        if (user != null) {
            // 先查询用户状态，看是否禁用
            if (user.getStatus() == 0) {
                return Result.error("该用户已禁用!");
            }
            // 如果有则登录成功，跳转页面
            // 将用户的登录凭证放到Session，Session可以理解为当前用户的回话
            // 一个用户对应一个Session
            session.setAttribute("user", user);
            //Result result = new Result();
            //result.setCode(0);
            //result.setMsg("登录成功");
            //return result;
            return Result.ok("登录成功",user);
            //return Result.ok("登录成功");
        } else {
            // 没有则登录失败，返回登录页面
            return Result.error("用户名或密码错误");
        }

    }

    //@RequestMapping("/login")
    //public String login(String name, String password, HttpSession session){
    //    // 根据name和password查询用户
    //    User user = userService.login(name,password);
    //    if(user != null){
    //        // 如果有则登录成功，跳转页面
    //        // 将用户的登录凭证放到Session，Session可以理解为当前用户的回话
    //        // 一个用户对应一个Session
    //        session.setAttribute("user",user);
    //        return "redirect:/";
    //    }else{
    //        // 没有则登录失败，返回登录页面
    //        return "redirect:/user/toLogin";
    //    }
    //
    //}

    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        // 销毁所有session
        session.invalidate();
        return "redirect:/user/toLogin";
    }

    @RequestMapping("/update")
    public String update(User user) {
        userService.update(user);
        // 更新之后，应该查找展示最新数据
        // redirect重定向: 告诉浏览器发送请求/user/selectAll
        return "redirect:/user/selectByPage";
    }

    @RequestMapping("/toAdd")
    public String toAdd() {
        return "/user/add";
    }

    @RequestMapping("/toUpdate")
    public String toUpdate(Integer id, Model model) {
        User user = userService.selectById(id);
        model.addAttribute("user", user);
        return "/user/update";
    }


    @RequestMapping("/add")
    public String add(User user) {
        userService.add(user);
        // 添加之后，应该查找展示最新数据
        // redirect重定向: 告诉浏览器发送请求/user/selectAll
        return "redirect:/user/selectByPage";
    }

    @RequestMapping("/selectByPage")
    public String selectByPage(@RequestParam(defaultValue = "1") Integer pageNo,
                               @RequestParam(defaultValue = "10") Integer pageSize, Model model) {
        // soutm
        System.out.println("UserController.selectByPage");
        PageInfo pageInfo = userService.selectByPage(pageNo,pageSize);

        //把list数据放到内存里面
        model.addAttribute("pageInfo", pageInfo);
        //转发到user_list界面展示
        return "/user/list";
    }
    @RequestMapping("/selectAll")
    public String selectAll(Model model) {
        // soutm
        System.out.println("UserController.selectAll");
        List<User> list = userService.selectAll();

        //把list数据放到内存里面
        model.addAttribute("list", list);
        //转发到user_list界面展示
        return "/user/list";
    }

    // @ResponseBody 返回json格式数据
    // json集合表示: [{},{}]
    // json对象：{'id',1,'name':'zhangsan'}
    // http://localhost:8080/user/selectAll
    @RequestMapping("/selectAll1")
    @ResponseBody
    public List<User> selectAll1() {
        // soutm
        System.out.println("UserController.selectAll");
        List<User> list = userService.selectAll();

        return list;
    }

    // user/deleteById?id=16
    @RequestMapping("/deleteById")
    public String deleteById(Integer id) {
        userService.deleteById(id);
        // 删除之后，应该查找展示最新数据
        // redirect重定向: 告诉浏览器发送请求/user/selectAll
        return "redirect:/user/selectByPage";
    }

    @RequestMapping("/deleteAll")
    public String deleteAll(Integer [] ids){
        userService.deleteAll(ids);
        return "redirect:/user/selectByPage";
    }
}
