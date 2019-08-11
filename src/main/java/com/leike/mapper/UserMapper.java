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

    @Update("UPDATE user SET name = #{name},pic = #{pic},sex = #{sex},phone = #{phone},password = #{password},email = #{email} where u_id = #{uId}")
    int updateUser(User user);

    List<User> selectUserListForTerm(@Param("page") Integer page, @Param("limit") Integer limit, @Param("uId") String uId, @Param("name") String name, @Param("phone") String phone, @Param("sex") String sex);

    @Select("select * from User where u_id = #{uId}")
    String selectUser(@Param("uId") Integer uId);
}
