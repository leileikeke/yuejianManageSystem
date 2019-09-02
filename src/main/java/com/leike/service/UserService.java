package com.leike.service;

import com.leike.pojo.User;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @description:
 * @author: leike
 * @date: 2019-08-07 16:42
 */
public interface UserService {

    User login(User user);

    boolean verifyUser(Integer uId, String oldPassword);

    boolean updateUserPass(Integer uId, String password);

    List<User> selectUserList(Integer page, Integer limit);

    List<User> selectUserListForTerm(Integer page, Integer limit, String uId, String name, String phone, String sex);

    Integer selectUserCount();

    boolean insertUser(User user);

    boolean queryUser(String name);

    boolean deleteUser(Integer uId, String pic, String uploadPath);

    boolean updateUser(User user, String uploadPath);

    String uploadPic(MultipartFile multipartFile, String uploadPath);

}
