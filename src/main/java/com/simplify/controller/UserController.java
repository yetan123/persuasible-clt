package com.simplify.controller;
import com.simplify.model.dto.UserAndDeptDTO;
import com.simplify.model.entity.User;
import com.simplify.service.UserService;
import com.simplify.utils.SnowFlake;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @GetMapping("/")
    @ResponseBody
    public List<UserAndDeptDTO> getAllUser() {
        System.out.println("部门与用户的连表查询");
        return userService.findUserAndDeptDeptId();
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

}
