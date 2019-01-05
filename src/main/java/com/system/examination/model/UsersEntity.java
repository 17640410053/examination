package com.system.examination.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UsersEntity {
    /**
     * id 用户id
     */
    private Integer id;
    /**
     * username 用户名
     */
    private String username;
    /**
     * password 用户密码
     */
    private String password;
}
