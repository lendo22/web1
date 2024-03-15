package com.cp.controller;

import com.cp.pojo.entity.BlogType;
import com.cp.service.IBlogTypeService;
import com.cp.util.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/blogType")
public class BlogTypeController {
    @Autowired
    private IBlogTypeService blogTypeService;


    @RequestMapping("/update")
    public String update(BlogType blogType) {
        blogTypeService.update(blogType);
        // 更新之后，应该查找展示最新数据
        // redirect重定向: 告诉浏览器发送请求/blogType/selectAll
        return "redirect:/blogType/selectByPage";
    }

    @RequestMapping("/toAdd")
    public String toAdd() {
        return "/blog_type/add";
    }

    @RequestMapping("/toUpdate")
    public String toUpdate(Integer id, Model model) {
        BlogType blogType = blogTypeService.selectById(id);
        model.addAttribute("blogType", blogType);
        return "/blog_type/update";
    }


    @RequestMapping("/add")
    public String add(BlogType blogType) {
        blogTypeService.add(blogType);
        // 添加之后，应该查找展示最新数据
        // redirect重定向: 告诉浏览器发送请求/blogType/selectAll
        return "redirect:/blogType/selectByPage";
    }

    @RequestMapping("/selectByPage")
    public String selectByPage(@RequestParam(defaultValue = "1") Integer pageNo,
                               @RequestParam(defaultValue = "10") Integer pageSize, Model model) {
        // soutm
        System.out.println("BlogTypeController.selectByPage");
        PageInfo pageInfo = blogTypeService.selectByPage(pageNo,pageSize);

        //把list数据放到内存里面
        model.addAttribute("pageInfo", pageInfo);
        //转发到blogType_list界面展示
        return "/blog_type/list";
    }
    @RequestMapping("/selectAll")
    public String selectAll(Model model) {
        // soutm
        System.out.println("BlogTypeController.selectAll");
        List<BlogType> list = blogTypeService.selectAll();

        //把list数据放到内存里面
        model.addAttribute("list", list);
        //转发到blogType_list界面展示
        return "/blog_type/list";
    }

    // @ResponseBody 返回json格式数据
    // json集合表示: [{},{}]
    // json对象：{'id',1,'name':'zhangsan'}
    // http://localhost:8080/blogType/selectAll
    @RequestMapping("/selectAll1")
    @ResponseBody
    public List<BlogType> selectAll1() {
        // soutm
        System.out.println("BlogTypeController.selectAll");
        List<BlogType> list = blogTypeService.selectAll();

        return list;
    }

    // blogType/deleteById?id=16
    @RequestMapping("/deleteById")
    public String deleteById(Integer id) {
        blogTypeService.deleteById(id);
        // 删除之后，应该查找展示最新数据
        // redirect重定向: 告诉浏览器发送请求/blogType/selectAll
        return "redirect:/blogType/selectByPage";
    }

    @RequestMapping("/deleteAll")
    public String deleteAll(Integer [] ids){
        blogTypeService.deleteAll(ids);
        return "redirect:/blogType/selectByPage";
    }
}
