package com.simplify.mapper;
import com.simplify.model.dto.DeptVO;
import com.simplify.model.entity.Dept;
import net.minidev.json.JSONObject;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 部门映射层
 * @author yuntian
 * @date 2019-11-30
 */
@Repository
public interface DeptMapper extends Mapper<Dept> {

    int updateByDeptId(DeptVO deptVO);

    int deleteByDeptId(DeptVO deptVO);

    int insertDept(DeptVO deptVO);

    //分页 模糊查询
    List<DeptVO> listDeptUser(@Param("deptname") String deptname,@Param("start") int start, @Param("size") int size);

    //查询总记录
    int selectCounts(@Param("deptname") String deptname);
    /**
     * Tree树
     */
    /* List<DeptVO> findAll();*/
    List<DeptVO> tree();
    List<DeptVO> tree2(@Param("id")String id);

    List<DeptVO> findAll();
}
