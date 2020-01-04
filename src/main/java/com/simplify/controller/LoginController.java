package com.simplify.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.simplify.model.dto.GithubDTO;
import com.simplify.model.dto.QQAndUserDTO;
import com.simplify.model.entity.GitHub;
import com.simplify.model.entity.QQ;
import com.simplify.model.entity.User;
import com.simplify.service.GitHubService;
import com.simplify.service.QQService;
import com.simplify.service.UserService;
import com.simplify.utils.GitHubConstant;
import com.simplify.utils.HttpClientUtils;
import com.simplify.utils.QQLoginConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Controller
@RequestMapping("oauth")
public class LoginController {
    @Autowired
    private GitHubService gitHubServiceImpl;
    @Autowired
    private UserService userServiceImpl;
    @Autowired
    private QQService qqServiceImpl;
    @GetMapping("github")
    public String githubLoginAfter(String code, String state, Model model, HttpServletResponse response){
        if(!StringUtils.isEmpty(code)) {
            String token_url = GitHubConstant.TOKEN_URL.replace("CODE", code);
            //得到的responseStr是一个字符串需要将它解析放到map中
            String responseStr = null;
            try {
                responseStr = HttpClientUtils.doGet(token_url);
                // 调用方法从map中获得返回的--》 令牌
                String token = HttpClientUtils.getMap(responseStr).get("access_token");
//                //根据token发送请求获取登录人的信息  ，通过令牌去获得用户信息
                model.addAttribute("token",token);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return "other_login";
    }
    @GetMapping("getUserInfo")
    @ResponseBody
    public GitHub getUserInfo(String token){
        //根据token发送请求获取登录人的信息  ，通过令牌去获得用户信息
        String responseStr = null;
        String userinfo_url = GitHubConstant.USER_INFO_URL.replace("TOKEN", token);
        Map<String, String> responseMap = null;
        try {
            responseStr = HttpClientUtils.doGet(userinfo_url);//json
            responseMap = HttpClientUtils.getMapByJson(responseStr);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Objects.nonNull(responseMap)?new GitHub(Long.parseLong(responseMap.get("id")),responseMap.get("name")
                ,responseMap.get("login"),
                responseMap.get("email"),responseMap.get("avatar_url"),null,null):null;
    }

    @GetMapping("checkGithub")
    @ResponseBody
    public User checkGitHub(Long id){
        if(StringUtils.isEmpty(id)){
            return null;
        }
        GitHub gitHub = gitHubServiceImpl.selectGitHubById(id);
        if(Objects.isNull(gitHub)){
            return null;
        }
        User user = userServiceImpl.findUserById(gitHub.getUserId());
        user.setPassword(gitHub.getPassword());
        return user;
    }

    /**
     * 返回值说明：4000账号不存在,4010密码错误,4005已绑定账号,2000成功绑定
     * @param githubDTO
     * @return
     */
    @PostMapping("bindingGithubAndUser")
    @ResponseBody
    public Integer bindingGithubAndUser(@RequestBody GithubDTO githubDTO){
        User userByAccount = userServiceImpl.findUserByAccount(githubDTO.getAccount());
        if(Objects.isNull(userByAccount)){
            return 4000;
        }
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        boolean matches = bCryptPasswordEncoder.matches(githubDTO.getPassword(),userByAccount.getPassword());
        if(!matches){
            return 4010;
        }
        GitHub gitHubByUserId = gitHubServiceImpl.findGitHubByUserId(userByAccount.getId());
        if(Objects.nonNull(gitHubByUserId)){
            return 4005;
        }
        gitHubServiceImpl.addGitHub(new GitHub(githubDTO.getId(), githubDTO.getName(), githubDTO.getLogin(), githubDTO.getEmail(), githubDTO.getAvatarUrl(),githubDTO.getPassword(),userByAccount.getId()));
        return 2000;
    }

    @GetMapping("qq")
    public String handleQQ(String code,Model model){
        if(!StringUtils.isEmpty(code)) {
            String token_url = QQLoginConstant.TOKEN_URL.replace("CODE", code);
            //得到的responseStr是一个字符串需要将它解析放到map中
            String responseStr = null;
            try {
                responseStr = HttpClientUtils.doGet(token_url);
                // 调用方法从map中获得返回的--》 令牌
                Map<String,String> responseMap = HttpClientUtils.url2Map(responseStr);
                String token = responseMap.get("access_token");
//                //根据token发送请求获取登录人的信息  ，通过令牌去获得用户信息
                model.addAttribute("token",token);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return "other_login";
    }

    @GetMapping("getQQUserInfo")
    @ResponseBody
    public QQ getQQUserInfo(String token){
        String openUrl = QQLoginConstant.OPEN_ID_URL.replace("TOKEN", token);
        Map<String, String> responseMap = null;
        String openid = null;
        try {
            String responseStr = HttpClientUtils.doGet(openUrl);//json
            ObjectMapper objectMapper = new ObjectMapper();
            responseMap = objectMapper.readValue(responseStr.substring(responseStr.indexOf("{"), responseStr.lastIndexOf("}") + 1), Map.class);
            openid = responseMap.get("openid");
            String userInfo = HttpClientUtils.doGet(QQLoginConstant.GET_USER_INFO_URL
                    .replace("TOKEN", token)
                    .replace("OPENID", openid));
            responseMap = objectMapper.readValue(userInfo, Map.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(responseMap);
        return Objects.nonNull(responseMap)?new QQ(openid,responseMap.get("nickname")
                ,Objects.isNull(responseMap.get("figureurl_qq_2"))?responseMap.get("figureurl_qq_1"):responseMap.get("figureurl_qq_2")
                ,responseMap.get("gender")
                ,null,null):null;
    }

    @GetMapping("checkQQ")
    @ResponseBody
    public User checkQQ(String openId){
        if(StringUtils.isEmpty(openId)){
            return null;
        }
        QQ qq = qqServiceImpl.selectQQByOpenId(openId);
        if(Objects.isNull(qq)){
            return null;
        }
        User user = userServiceImpl.findUserById(qq.getUserId());
        user.setPassword(qq.getPassword());
        return user;
    }

    @PostMapping("bindingQQAndUser")
    @ResponseBody
    public Integer bindingQQAndUser(@RequestBody QQAndUserDTO qqAndUserDTO){
        User userByAccount = userServiceImpl.findUserByAccount(qqAndUserDTO.getAccount());
        if(Objects.isNull(userByAccount)){
            return QQLoginConstant.ACCOUNT_NOT_FOUND;
        }
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        boolean matches = bCryptPasswordEncoder.matches(qqAndUserDTO.getPassword(),userByAccount.getPassword());
        if(!matches){
            return QQLoginConstant.AUTHORIZATION_ERROR;
        }
        QQ qq = qqServiceImpl.selectQQByUserId(userByAccount.getId());
        if(Objects.nonNull(qq)){
            return 4005;
        }
        qqServiceImpl.BindingUser(new QQ(qqAndUserDTO.getOpenId(),Objects.isNull(qqAndUserDTO.getNickName())?" ":qqAndUserDTO.getNickName(),qqAndUserDTO.getFigureUrl()
                ,qqAndUserDTO.getGender(),userByAccount.getId(),qqAndUserDTO.getPassword()));
        return 2000;
    }
}
