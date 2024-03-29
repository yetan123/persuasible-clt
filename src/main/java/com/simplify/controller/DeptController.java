package com.simplify.controller;
import com.simplify.model.dto.DeptVO;
import com.simplify.model.entity.Dept;
import com.simplify.service.DeptService;
import com.simplify.utils.PageBean;
import com.simplify.utils.SnowFlake;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
/**
 * 部门控制器,负责对部门实体的业务分发
 * @author yuntian
 * @date 2019-12-1
 */
@RestController
@CrossOrigin
@RequestMapping("dept")
public class DeptController {
    @Autowired
    private DeptService deptService;

    @GetMapping("/selectAll")
    public JSONObject selectAll(@RequestParam(value ="deptname",required = false)String deptName,
                                @RequestParam(value ="oldDate",required = false)String oldDate,
                                @RequestParam(value ="newDate",required = false)String newDate,
                                @RequestParam(defaultValue = "1",value ="pageNum",required = false)Integer pageNum){
        PageBean<DeptVO> pages;
        if (deptName!=null || oldDate!=null || newDate!=null) {
            if (deptName == "" || deptName == null){
                deptName=null;
            }


            if (oldDate == "" || newDate == null){
                oldDate=null;
            }


            if (newDate=="" || newDate==null){
                newDate=null;
            }

            pages= deptService.listDeptUser(deptName,oldDate,newDate,pageNum);
        }else{
            pages= deptService.listDeptUser(null,null,null,pageNum);
        }
        //封装好信息返回给前台页面
        JSONObject json=new JSONObject();
        json.put("pageInfo",pages);
        return json;
    }

    @PostMapping("/add")
    public int add(@RequestBody DeptVO dept) {
        System.out.println("进入添加方法");
        long deptIds = new SnowFlake(0,0).nextId();
        String id = String.valueOf(deptIds);
        dept.setId(id);
        System.out.println(dept);
        return deptService.insertDept(dept);
    }

    @PostMapping("/update")
    public int update(@RequestBody DeptVO deptVO) {
        System.out.println("进入修改方法");
        return deptService.updateByDeptId(deptVO);
    }
    @GetMapping("/deleteById")
    public int deleteUser(DeptVO deptVO){
        System.out.println("进入删除方法");
        return deptService.deleteByDeptId(deptVO);
    }


        @GetMapping("/findAllDept")
    public List<DeptVO> findAllDept(){
       return deptService.findAll();
    }

}
