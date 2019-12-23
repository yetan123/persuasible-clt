package com.simplify.controller;
import com.simplify.model.dto.UserAndDeptDTO;
import com.simplify.model.entity.User;
import com.simplify.service.UserService;
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


}
