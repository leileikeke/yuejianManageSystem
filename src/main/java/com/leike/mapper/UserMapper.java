package com.leike.mapper;

import com.leike.pojo.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @description:
 * @author: leike
 * @date: 2019-08-07 16:51
 */
public interface UserMapper {

    @Select("SELECT u_id,name,pic,sex,phone,email,jointime FROM user")
    List<User> selectUserList();
}
