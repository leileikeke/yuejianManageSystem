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

    @Delete("DELETE FROM user WHERE u_id = #{uId}")
    int deleteUser(@Param("uId") Integer uId);

    @Update("UPDATE user SET name = #{name},pic = #{pic},sex = #{sex},phone = #{phone},password = #{password},email = #{email} where u_id = #{uId}")
    int updateUser(User user);

    List<User> selectUserListForTerm(@Param("page") Integer page, @Param("limit") Integer limit, @Param("uId") String uId, @Param("name") String name, @Param("phone") String phone, @Param("sex") String sex);

    @Select("SELECT pic FROM user WHERE u_id = #{uId}")
    String selectUserPic(@Param("uId") Integer uId);

    @Select("SELECT * FROM user WHERE name = #{name} AND password = #{password}")
    User login(User user);

    @Select("SELECT * FROM user WHERE u_id = #{uId} AND password = #{oldPassword}")
    User verifyUser(@Param("uId") Integer uId, @Param("oldPassword") String oldPassword);

    @Update("UPDATE user SET password = #{password} where u_id = #{uId}")
    int updateUserPass(@Param("uId") Integer uId, @Param("password") String password);

    @Select("SELECT * FROM user WHERE u_id = #{uId}")
    User getUser(@Param("uId") Integer uId);

}
