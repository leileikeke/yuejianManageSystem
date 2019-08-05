package com.leike.mapper;

import com.leike.pojo.Admin;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @description:
 * @author: leike
 * @date: 2019-08-03 16:47
 */
public interface AdminMapper {

    Admin selectAdmin(Admin admin);

    @Select("select * from admin where name = #{name} and password = #{oldPassword} and role=#{role}")
    Admin verifyAdmin(@Param("name") String name, @Param("oldPassword") String oldPassword, @Param("role") String role);

    @Update("update admin set password = #{password} where id = #{id}")
    int updateAdmin(@Param("id") Integer id, @Param("password") String password);

    @Select("select id,name,nickname,phone,sex,role,jointime,state from admin")
    List<Admin> selectAdminList();

    @Select("select count(*) from admin")
    int selectAdminCount();
}
