package com.simplify.controller;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.simplify.model.dto.UserAndDeptDTO;
import com.simplify.model.entity.User;
import com.simplify.service.UserService;
import com.simplify.utils.PageBean;
import com.simplify.utils.SnowFlake;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestParam;
import java.text.ParseException;
import java.util.List;
import java.util.Map;

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
    UserService userService;
 /*   @GetMapping("/")
    @ResponseBody
    public List<UserAndDeptDTO> getAllUser() {
        System.out.println("部门与用户的连表查询");
        return userService.findUserAndDeptDeptId();
    }*/

    @GetMapping("/selectAll")
    public JSONObject selectAll(@RequestParam(value ="deptName",required = false)String deptName,
                                @RequestParam(value ="userSearch",required = false)String userSearch,
                                @RequestParam(defaultValue = "1",value ="pageNum",required = false)Integer pageNum){
        PageBean<UserAndDeptDTO> pageInfo=null;
        if (deptName!=null ||
                userSearch!=null ||
                userSearch !=null
        ) {
            System.out.println("!");
            if (userSearch=="" || userSearch==null){
                userSearch=null;
            }
            if (userSearch=="" || userSearch==null){
                userSearch=null;
            }
            pageInfo= userService.listUserAndDept(deptName,userSearch,pageNum);
        }else{
            pageInfo= userService.listUserAndDept(deptName,userSearch,pageNum);
        }
        //封装好信息返回给前台页面
        System.out.println(pageInfo.toString());
        JSONObject json=new JSONObject();
        json.put("pageInfo",pageInfo);
        return json;
    }



    @PostMapping("/add")
    public int add(@RequestBody User user) {
        System.out.println("进入添加页面");
        user.setId(new SnowFlake(0,0).nextId());
        System.out.println(user);
        return userService.insertUser(user);
    }
    @PostMapping("/update")
    public int update(@RequestBody User user) {
        System.out.println("进入修改页面");
        System.out.println(user.getId());
        System.out.println(user);
        return userService.updateById(user);
    }

     /**
     * 获取分页信息
     * @return pageInfo
     * @auhor lanmu
     * @date 2019/12/21 17:29
     */
    /*private PageInfo<UserAndDeptDTO> getPageInfo(Map params) {

        PageHelper.startPage(1, 4, true);
        PageInfo<UserAndDeptDTO> page = new PageInfo<UserAndDeptDTO>(userService.listUserAndDept(params.get("deptName").toString(), params.get("userSearch").toString()));
        return page;
    }*/

}
