package com.leike.service;

import com.leike.pojo.User;

import java.util.List;

/**
 * @description:
 * @author: leike
 * @date: 2019-08-07 16:42
 */
public interface UserService {

    List<User> selectUserList(Integer page,Integer limit);

    int selectUserCount();

    boolean insertUser(User user);

    boolean queryUser(String name);

    boolean deleteUser(Integer uId);

    boolean updateUser(User user);
}
