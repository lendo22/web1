package com.cp.pojo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

//实体类：和数据库中表一一对应
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Auth {
    private Integer id;
    private String name;
    private String path;
    private Integer role;
    private Integer status;
    private Integer deleted;
    private Date gmtCreate;
    private Date gmtModified;


}
