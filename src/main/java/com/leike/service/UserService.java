package com.leike.service;

import com.leike.pojo.User;

import java.util.List;

/**
 * @description:
 * @author: leike
 * @date: 2019-08-07 16:42
 */
public interface UserService {

    List<User> selectUserList();

    int selectUserCount();
}
