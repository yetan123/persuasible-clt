package com.simplify.controller;
import com.simplify.model.entity.User;
import com.simplify.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
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
    @RequestMapping(value = "getAllUser",method = RequestMethod.GET)
    public List<User> getAllUser() {
        System.out.println(userService.findAll());
        return userService.findAll();
    }


}
