package com.leike.service;

import com.leike.pojo.User;

import java.util.List;

/**
 * @description:
 * @author: leike
 * @date: 2019-08-07 16:42
 */
public interface UserService {

    List<User> selectUserList(Integer page, Integer limit);
    
    List<User> selectUserListForTerm(Integer page, Integer limit, String uId, String name, String phone, String sex);

    Integer selectUserCount();

    boolean insertUser(User user);

    boolean queryUser(String name);

    boolean deleteUser(Integer uId);

    boolean updateUser(User user);

}
