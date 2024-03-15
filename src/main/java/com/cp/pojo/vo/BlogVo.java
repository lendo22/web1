package com.cp.pojo.vo;

import lombok.Data;

import java.util.Date;

@Data
public class BlogVo {
    private Integer id;
    private String title;
    private String image;
    private Integer clickCount;
    private String content;
    private Integer typeId;
    private String typeName;
    private Integer status;
    private Integer deleted;
    private Date gmtCreate;
    private Date gmtModified;
}
