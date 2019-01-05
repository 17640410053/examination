package com.system.examination.controller;


import com.bilibili.yl.entity.ResultEntity;
import com.system.examination.model.UsersEntity;
import com.system.examination.service.UsersService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("users")
public class UsersController {

    @Resource
    private UsersService usersServiceImpl;

    @RequestMapping("/getById")
    public UsersEntity getById(@RequestBody UsersEntity user) {
        return usersServiceImpl.getById(user);
    }

    @RequestMapping("/login")
    public ResultEntity<UsersEntity> login(@RequestBody UsersEntity user) {
        return usersServiceImpl.userLogin(user);
    }

    @RequestMapping("/register")
    public ResultEntity<String> register(@RequestBody UsersEntity user) {
        return usersServiceImpl.userRegister(user);
    }

    @RequestMapping("/saveSession")
    public ResultEntity<String> saveSession(String info, HttpSession session) {
        ResultEntity<String> result = new ResultEntity<>();
        System.out.println(info);
        session.setAttribute("info", info);
        result.setCode(0);
        result.setMsg("保存成功");
        return result;
    }

    @RequestMapping("/getSession")
    public ResultEntity<String> getSession(@RequestHeader String token, HttpSession session) {
        ResultEntity<String> result = new ResultEntity<>();
        String info = (String) session.getAttribute("info");
        result.setCode(0);
        result.setMsg("获取成功");
        result.setData(info);
        return result;
    }
}
