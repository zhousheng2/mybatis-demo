package com.mybatis.dao;


import com.mybatis.pojo.User;

public interface UserDao {

    User queryUserById(User param);

}