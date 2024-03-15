package com.cp.util;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 封装分页相关的信息
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageInfo<T> {
    // 当前数据集合
    private List<T> list;
    // 一共多少页
    private Integer totalPage;
    // 当前是第几页
    private Integer pageNo;
    // 一页有多少条
    private Integer pageSize;
}
