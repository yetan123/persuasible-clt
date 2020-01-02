package com.simplify.controller;
import com.alibaba.fastjson.JSONObject;
import com.simplify.model.dto.UserAndDeptVO;
import com.simplify.model.entity.User;
import com.simplify.service.UserService;
import com.simplify.utils.PageBean;
import com.simplify.utils.SnowFlake;
import com.zhenzi.sms.ZhenziSmsClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;


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
    public Map<String,Object> selectRoleAuthorize(@RequestParam(value ="deptname",required = false)String deptName,
                                                  @RequestParam(value ="username",required = false)String userName,
                                                  @RequestParam(value ="enabled",required = false)String enabled,
                                                  @RequestParam(value ="pid",required = false)String pid,
                                                  @RequestParam(defaultValue = "1",value ="pageNum",required = false)Integer pageNum){
        PageBean<UserAndDeptVO> pages;
        Map<String,Object> userMap = new HashMap<>();
        System.out.println(pid);

        if (deptName!=null || userName!=null || enabled!=null || pid!=null) {
            if (enabled =="" || enabled==null){
                enabled=null;
            }
            if(deptName=="" || deptName== null){
                deptName = null;
            }
            if (userName=="" || userName==null){
                userName=null;
            }


            if(pid =="" || pid ==null){
                pid=null;
            }
            pages= userService.listUserAndDept(deptName,userName,enabled,pid,pageNum);
        }else{
            pages= userService.listUserAndDept(null,null,null,null,pageNum);
        }
        userMap.put("pageInfo",pages);
        return userMap;
    }

    @PostMapping("/add")
    public int add(@RequestBody UserAndDeptVO user) {
        System.out.println("添加");
        long longVal =new SnowFlake(0,0).nextId();
        String id=String.valueOf(longVal);
        user.setId(id);
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        return userService.insertUser(user);
    }
    @PostMapping("/update")
    public int update(@RequestBody UserAndDeptVO user) {
        System.out.println("根据id修改");
        user.setUsername(user.getUsername());
        return userService.updateByUserId(user);
    }
    @ResponseBody
    @GetMapping("/deleteById")
    public int deleteUser( UserAndDeptVO userAndDeptVO){
        System.out.println("根据id删除");
        return userService.deleteByUserId(userAndDeptVO);
    }

    @GetMapping("qqLogin")
    public void qqLoginAfter(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        String code = request.getParameter("code");
        String state = request.getParameter("state");
        String uuid = (String) session.getAttribute("state");
    }
    @PostMapping("/updateByState")
    public int updateByState(@RequestBody UserAndDeptVO user) {
        System.out.println("修改状态");
        return userService.updateByState(user);
    }

    private String apiUrl = "https://sms_developer.zhenzikj.com";
    private String appId = "104110";
    private String appSecret = "ZDJiOTE2NmUtOTg0Yy00ZGRlLThjMjQtYjg2YmY1NjFlYjIy";
    /*以短信的方式修改密码*/
    @PostMapping("/SMS")
    public JSONObject  SMS(HttpSession httpSession,@RequestBody UserAndDeptVO user) throws Exception {
        System.out.println(user);
        JSONObject json =null;
            String code = String.valueOf(new Random().nextInt(99999));
            ZhenziSmsClient client = new ZhenziSmsClient(apiUrl, appId, appSecret);
            String result = client.send(user.getPhone(), "【】您正在使用手机动态码方式登录，验证码为："+code+",该码有效期为5分钟，该码只能使用一次!请勿向任何单位或个人泄漏。");
            json = JSONObject.parseObject(result);
            if (json.getIntValue("code")!=0){//发送短信失败
            }
            json = new JSONObject();
            json.put("memPhone",user.getPhone());
            json.put("code",code);
            json.put("createTime",System.currentTimeMillis());
            // 将认证码存入SESSION
            httpSession.setAttribute("code",json);
        return  json;
    }
    /*以短信的方式修改密码*/
    @PostMapping("/updateCodeByID")
    public int CodeById(@RequestBody UserAndDeptVO user) {
        System.out.println("根据验证码修改密码");
        System.out.println(user+"修改之前");
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        System.out.println(user+"修改之后");
        return userService.updateCodeById(user);
    }
}
