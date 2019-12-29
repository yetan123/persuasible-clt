package com.simplify.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class PageBean<T> {
    private int pageNum;    //当前页数
    private int pageSize;   //当前页数的记录数
    private int totalCount;  //总记录数
    private int totalPage;  //总页数
    private List<T> lists;      //每页的显示数据

}
