package com.cp.pojo.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BlogType {
    private Integer id;
    private String name;
    private Integer deleted;
    private Date gmtCreate;
    private Date gmtModified;
}
