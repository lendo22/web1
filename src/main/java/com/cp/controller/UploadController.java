package com.cp.controller;

import com.cp.util.Result;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Controller
@RequestMapping("/upload")
public class UploadController {
    // MultipartFile file 封装了所有图片信息
    @RequestMapping("/uploadImage")
    @ResponseBody
    public Result uploadImage(MultipartFile file){
        // UUID生成唯一不重名的名字
        String uuid = UUID.randomUUID().toString().replace("-", "");
        // 图片上传功能
        // a.png
        String filename = file.getOriginalFilename();
        String extension = filename.substring(filename.lastIndexOf("."));
        // extension=".png"
        String newFilename = uuid + extension;
        // a46683a3sd5334.png
        String filePath = "E:\\mypic\\" + newFilename;
        try {
            file.transferTo(new File(filePath));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return Result.ok("上传成功!",newFilename);
    }
}
