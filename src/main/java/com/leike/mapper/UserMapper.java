package com.leike.mapper;

import com.leike.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @description:
 * @author: leike
 * @date: 2019-08-07 16:51
 */
public interface UserMapper {

    @Select("SELECT * FROM user limit #{page},#{limit}")
    List<User> selectUserList(@Param("page") Integer page, @Param("limit") Integer limit);

    @Select("SELECT count(*) FROM user")
    int selectUserCount();


    int insertUser(User user);

    @Select("SELECT * FROM user WHERE name = #{name}")
    User queryUser(@Param("name") String name);

    @Delete("delete from user where u_id = #{uId}")
    int deleteUser(@Param("uId") Integer uId);

    @Update("UPDATE user SET name = #{name},pic = #{pic},sex = #{sex},phone = #{phone},password = #{password},email = #{email} where uId = #{uId}")
    int updateUser(User user);
}
