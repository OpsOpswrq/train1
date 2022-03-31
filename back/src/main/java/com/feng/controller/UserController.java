package com.feng.controller;

import com.alibaba.fastjson.JSONObject;
import com.feng.pojo.User;
import com.feng.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserService userService;
    @PostMapping("/adduser")
    public String addUser(@RequestBody  User user) {
        if(userService.selectUser(user).size()==0){
            userService.addUser(user);
            return "1";
        }
        return "2";
    }
    @PostMapping("/login")
    public String login(@RequestBody User user, HttpSession session){
        if(userService.selectUser(user).size()!=0){
            session.setAttribute("username",user.getUsername());
            return "1";
        }
        return "2";
    }
    @PostMapping("/logout")
    public String logout(HttpSession session){
        if(session.getAttribute("username")!=null){
            session.removeAttribute("username");
            return "1";
        }
        return "2";
    }
    @PostMapping("/auth")
    public String auth(HttpSession session){
        if(session.getAttribute("username")!=null){
            return "1";
        }
        return "2";
    }
    @PostMapping("/userInfo")
    public String getUserInfo(@RequestBody JSONObject object){
        List<User> users = userService.selectUser1(object.get("username").toString());
        return JSONObject.toJSONString(users.get(0));
    }
    @PostMapping("updateUserInfo")
    public String updateUserInfo(@RequestBody User user){
        userService.updateUser(user);
        return JSONObject.toJSONString(userService.selectUser(user).get(0));
    }
}
