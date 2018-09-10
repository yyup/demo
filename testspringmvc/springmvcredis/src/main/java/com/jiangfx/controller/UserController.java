package com.jiangfx.controller;

import com.jiangfx.entity.User;
import com.jiangfx.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by jiangfeixiang on 2018/4/27
 */
@Controller
public class UserController {
    //注入
    @Autowired
    private UserService userService;

    /**
     * 查询所有用户
     */
    @RequestMapping(value = "/getAll",method = RequestMethod.GET)
    public String getAll(){
        List<User> list = userService.getAll();
        return "list";
    }
    /**
     * 跳转到添加页面
     */
    @RequestMapping(value = "/insertUserPage",method = RequestMethod.GET)
    public String insertUserPage(){
        return "save";
    }
    /**
     * 插入
     */
    @RequestMapping(value = "/insertUser",method = RequestMethod.POST)
    public String insertUser(User user){
        userService.insertUser(user);
        return "redirect:/getAll";
    }
}
