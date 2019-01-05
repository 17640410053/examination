package com.system.examination.service;

import com.bilibili.yl.entity.ResultEntity;
import com.system.examination.model.UsersEntity;

public interface UsersService {
    UsersEntity getById(UsersEntity user);

    ResultEntity<UsersEntity> userLogin(UsersEntity user);

    ResultEntity<String> userRegister(UsersEntity user);
}
