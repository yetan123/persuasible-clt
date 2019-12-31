package com.simplify.service;

import com.simplify.model.dto.DeptVO;
import com.simplify.model.entity.Dept;
import com.simplify.utils.PageBean;
import net.minidev.json.JSONObject;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 部门表业务接口,提供对用户表的抽象方法
 * @author yuntian
 * @date 2019-1130
 */
public interface DeptService {

    int deleteByDeptId(DeptVO deptVO);

    int updateByDeptId(DeptVO deptVO);

    int insertDept(DeptVO deptVO);
    //分页 模糊查询
    PageBean<DeptVO> listDeptUser(String deptname,Integer currentPage );

    /**
     * Tree树
     */
    /* List<DeptVO> findAll();*/
    List<DeptVO> tree();
    List<DeptVO> tree2(String id);
    /**
     * 部门树节点
     * @return
     */
    List<DeptVO> findAll();

}
