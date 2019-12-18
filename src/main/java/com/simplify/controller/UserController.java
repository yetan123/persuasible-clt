package com.simplify.controller;

import com.simplify.mapper.UserMapper;
import com.simplify.model.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 用户控制器,负责对用户实体的业务分发
 * @author yuntian
 * @date 2019-12-1
 */
@RestController
public class UserController {

    @GetMapping("order")
    public String order(){
        return "order";
    }
}
