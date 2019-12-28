package com.simplify.service.impl;
import com.simplify.mapper.DeptMapper;
import com.simplify.model.dto.DeptVO;
import com.simplify.service.DeptService;
import com.simplify.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * 部门业务实现类,是部门业务接口的具体实现
 * @author yuntian
 * @date 2019-11-30
 */
@Service("deptService")
public class DeptServiceImpl implements DeptService {
    @Autowired
    private DeptMapper deptMapper;

    @Override
    public int deleteByDeptId(DeptVO deptVO) {
        return deptMapper.deleteByDeptId(deptVO);
    }

    @Override
    public int updateByDeptId(DeptVO deptVO) {
        return deptMapper.updateByDeptId(deptVO);
    }

    @Override
    public int insertDept(DeptVO deptVO) {
        return deptMapper.insertDept(deptVO);
    }

    @Override
    public PageBean<DeptVO> listDeptUser(String deptname, Integer currentPage) {
        PageBean<DeptVO> pageBean = new PageBean<DeptVO>();
        //封装当前页数
        pageBean.setPageNum(currentPage);
        //每页显示的数据
        int pageSize=5;
        pageBean.setPageSize(pageSize);
        //封装总记录数
        int totalCount = deptMapper.selectCounts(deptname);
        pageBean .setTotalCount(totalCount);
        //封装总页数
        double tc = totalCount;
        Double num = Math.ceil(tc / pageSize);//向上取整
        pageBean.setTotalPage(num.intValue());
        int start=(currentPage-1)*pageSize;
        int size = pageBean.getPageSize() * pageBean.getPageNum();
        //封装每页显示的数据
        List<DeptVO> lists = deptMapper.listDeptUser(deptname,start,size);
        pageBean.setLists(lists);
        return pageBean;
    }
}
