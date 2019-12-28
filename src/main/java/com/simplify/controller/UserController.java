package com.simplify.controller;
import com.simplify.model.dto.UserAndDeptDTO;
import com.simplify.model.dto.UserAndDeptVO;
import com.simplify.model.entity.User;
import com.simplify.service.UserService;
import com.simplify.utils.PageBean;
import com.simplify.utils.SnowFlake;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 用户控制器,负责对用户实体的业务分发
 * @author yuntian
 * @date 2019-12-1
 */
@RestController
@CrossOrigin
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;
    /*分页*/
    @GetMapping("/selectAll")
    public JSONObject selectAll(@RequestParam(value ="deptname",required = false)String deptName,
                                @RequestParam(value ="username",required = false)String userName,
                                @RequestParam(value ="enabled",required = false)String enabled,
                                @RequestParam(defaultValue = "1",value ="pageNum",required = false)Integer pageNum){
        PageBean<UserAndDeptVO> pages;
        if (deptName!=null || userName!=null || enabled!=null) {
            if (enabled =="" || enabled==null){
                enabled=null;
            }
            if(deptName=="" || deptName== null){
                deptName = null;
            }
            if (userName=="" || userName==null){
                userName=null;
            }
            pages= userService.listUserAndDept(deptName,userName,enabled,pageNum);
        }else{
            pages= userService.listUserAndDept(null,null,null,pageNum);
        }
        //封装好信息返回给前台页面
        JSONObject json=new JSONObject();
/*        for(UserAndDeptVO userAndDeptVO: pages.getLists()) {
            System.out.println(userAndDeptVO);
        }*/
        json.put("pageInfo",pages);
        return json;
    }
    @PostMapping("/add")
    public int add(@RequestBody User user) {
        user.setId(new SnowFlake(0,0).nextId());
        return userService.insertUser(user);
    }
    @PostMapping("/update")
    public int update(@RequestBody UserAndDeptVO user) {
        System.out.println("进入修改方法");
        user.setUsername(user.getUsername());
        System.out.println(user+""+user.getId());
        return userService.updateByUserId(user);
    }
    @ResponseBody
    @GetMapping("/deleteById")
    public int deleteUser( UserAndDeptVO userAndDeptVO){
        System.out.println("进入删除方法");
        return userService.deleteByUserId(userAndDeptVO);
    }

    @PostMapping("/updateByState")
    public int updateByState(@RequestBody UserAndDeptVO user) {
        System.out.println("进入修改状态方法");
        System.out.println(user+""+user.getUserState());
        return userService.updateByState(user);
    }

}
