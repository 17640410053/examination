package com.system.examination.mapper;

import com.system.examination.model.UsersEntity;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersMapper {
    @Select("select * from users where id = #{id}")
    UsersEntity getById(UsersEntity user);


    @Select("select * from users where username = #{username} and password = #{password}")
    UsersEntity getByUsernameAndPassword(UsersEntity user);

    @Insert("insert into users(username,password) values (#{username},#{password})")
    void insertUser(UsersEntity user);

}
