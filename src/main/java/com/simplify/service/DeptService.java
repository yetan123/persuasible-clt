package com.simplify.service;

import com.simplify.model.dto.DeptVO;
import com.simplify.model.entity.Dept;
import com.simplify.utils.PageBean;

/**
 * 部门表业务接口,提供对用户表的抽象方法
 * @author yuntian
 * @date 2019-1130
 */
public interface DeptService {

    int deleteByDeptId(DeptVO deptVO);

    int updateByDeptId(DeptVO deptVO);

    int insertUser(Dept dept);
    //分页 模糊查询
    PageBean<DeptVO> listDeptUser(String deptname,String enabled, Integer currentPage );

}
