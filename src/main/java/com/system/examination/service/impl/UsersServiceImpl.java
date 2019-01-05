package com.system.examination.service.impl;

import com.bilibili.yl.entity.ResultEntity;
import com.bilibili.yl.enums.ResultEnum;
import com.system.examination.mapper.UsersMapper;
import com.system.examination.model.UsersEntity;
import com.system.examination.service.UsersService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UsersServiceImpl implements UsersService {

    @Resource
    private UsersMapper usersMapper;

    @Override
    public UsersEntity getById(UsersEntity user) {
        return usersMapper.getById(user);
    }

    @Override
    public ResultEntity<UsersEntity> userLogin(UsersEntity user) {
        ResultEntity<UsersEntity> result = new ResultEntity<>();
        UsersEntity info = usersMapper.getByUsernameAndPassword(user);
        if (info != null) {
            result.setCode(0);
            result.setMsg("登录成功");
            result.setData(info);
        } else {
            result.setCodeAndMsg(ResultEnum.USER_ACCOUNT_ERROR);
        }
        return result;
    }

    @Override
    public ResultEntity<String> userRegister(UsersEntity user) {
        ResultEntity<String> result = new ResultEntity<>();
        try {
            usersMapper.insertUser(user);
            result.setCode(0);
            result.setMsg("注册成功");
        } catch (Exception e) {
            result.setMsg("注册失败");
            result.setCode(500);
            e.printStackTrace();
        }
        return result;

    }
}
