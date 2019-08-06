package com.leike.mapper;

import com.leike.pojo.Admin;
import org.apache.ibatis.annotations.Delete;
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

    @Select("SELECT * FROM admin WHERE name = #{name} and password = #{oldPassword} and role=#{role}")
    Admin verifyAdmin(@Param("name") String name, @Param("oldPassword") String oldPassword, @Param("role") String role);

    @Update("UPDATE admin SET password = #{password} where id = #{id}")
    int updateAdmin(@Param("id") Integer id, @Param("password") String password);

    @Select("SELECT id,name,nickname,phone,sex,role,jointime,state FROM admin")
    List<Admin> selectAdminList();

    @Select("select count(*) from admin")
    int selectAdminCount();

    @Delete("DELETE FROM admin WHERE id = #{id}")
    int deleteAdmin(Integer id);
}
