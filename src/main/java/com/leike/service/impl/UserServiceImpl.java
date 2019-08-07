package com.leike.service.impl;

import com.leike.mapper.UserMapper;
import com.leike.pojo.User;
import com.leike.service.UserService;
import com.leike.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
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
    public List<User> selectUserList(Integer page, Integer limit) {
        List<User> users = userMapper.selectUserList(page, limit);
        return users;
    }

    @Override
    public int selectUserCount() {
        int i = userMapper.selectUserCount();
        return i;
    }

    @Override
    public boolean insertUser(User user) {

        Date date = DateUtil.getCurrentTime(new Date(),"yyyy-MM-dd hh:mm:ss");
        user.setJointime(date);
        int i = userMapper.insertUser(user);
        return i == 1 ? true : false;
    }

    @Override
    public boolean queryUser(String name) {
        User user = userMapper.queryUser(name);
        return user==null?true:false;
    }

    @Override
    public boolean deleteUser(Integer uId) {
        int i = userMapper.deleteUser(uId);
        return i==1?true:false;
    }

    @Override
    public boolean updateUser(User user) {
        int i = userMapper.updateUser(user);
        return i==1?true:false;
    }
}
