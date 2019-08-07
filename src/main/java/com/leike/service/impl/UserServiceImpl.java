package com.leike.service.impl;

import com.leike.mapper.UserMapper;
import com.leike.pojo.User;
import com.leike.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description:
 * @author: leike
 * @date: 2019-08-07 16:43
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> selectUserList() {
        List<User> users = userMapper.selectUserList();
        return users;
    }

    @Override
    public int selectUserCount() {
        return 0;
    }
}
