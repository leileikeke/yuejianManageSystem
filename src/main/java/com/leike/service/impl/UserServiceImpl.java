package com.leike.service.impl;

import com.leike.mapper.UserMapper;
import com.leike.pojo.User;
import com.leike.service.UserService;
import com.leike.util.DateUtil;
import com.leike.util.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

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

    //---------------客户端api-------------
    @Override
    public User login(User user) {
        User user1 = userMapper.login(user);
        return user1;
    }

    @Override
    public boolean verifyUser(Integer uId, String oldPassword) {
        User user = userMapper.verifyUser(uId, oldPassword);
        return user != null ? true : false;
    }

    @Override
    public boolean updateUserPass(Integer uId, String password) {
        int i = userMapper.updateUserPass(uId, password);
        return i == 1 ? true : false;
    }

    //---------------后台接口----------------
    @Override
    public List<User> selectUserList(Integer page, Integer limit) {
        List<User> users = userMapper.selectUserList(page, limit);
        return users;
    }

    @Override
    public List<User> selectUserListForTerm(Integer page, Integer limit, String uId, String name, String phone, String sex) {
        List<User> users = userMapper.selectUserListForTerm(page, limit, uId, name, phone, sex);
        return users;
    }

    @Override
    public Integer selectUserCount() {
        int i = userMapper.selectUserCount();
        return i;
    }

    @Override
    public boolean insertUser(User user) {

        Date date = DateUtil.getCurrentTime(new Date(), "yyyy-MM-dd HH:mm:ss");
        System.out.println(date.toString());
        user.setJointime(date);
        int i = userMapper.insertUser(user);
        return i == 1 ? true : false;
    }

    @Override
    public boolean queryUser(String name) {
        User user = userMapper.queryUser(name);
        return user == null ? true : false;
    }

    @Override
    public boolean deleteUser(Integer uId, String pic, String uploadPath) {

        //删除服务器上的用户头像
        FileUtil.deleteFile(uploadPath, pic);

        int i = userMapper.deleteUser(uId);
        return i == 1 ? true : false;
    }

    @Override
    public boolean updateUser(User user, String uploadPath) {

        //获取用户原头像
        String pic = userMapper.selectUserPic(user.getuId());
        //如果修改了用户头像则删除原头像
        if (!user.getPic().equals(pic)) {
            FileUtil.deleteFile(uploadPath, pic);
        }

        int i = userMapper.updateUser(user);
        return i == 1 ? true : false;
    }

    @Override
    public User getUser(Integer uId) {
        User user = userMapper.getUser(uId);
        if (user != null) {
            user.setPassword("");
        }
        return user;
    }
}
