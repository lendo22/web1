package com.cp.controller;

import com.cp.pojo.vo.BlogTypeCountVo;
import com.cp.service.IBlogTypeService;
import com.cp.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/echarts")
public class EChartsController {

    @Autowired
    private IBlogTypeService blogTypeService;
    @RequestMapping("/toECharts")
    public String toECharts(){
        return"echarts";
    }

    @RequestMapping("/selectBlogTypeCount")
    @ResponseBody
    public Result selectBlogTypeCount(){
        List<BlogTypeCountVo> list = blogTypeService.selectBlogTypeCount();
        return Result.ok(list);
    }
}
