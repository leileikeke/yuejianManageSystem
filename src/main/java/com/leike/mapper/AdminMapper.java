package com.leike.mapper;

import com.leike.pojo.Admin;
import org.apache.ibatis.annotations.*;

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

    @Select("SELECT * FROM admin")
    List<Admin> selectAdminList();

    @Update("UPDATE admin SET password = #{password} where id = #{id}")
    int updateAdminPass(@Param("id") Integer id,@Param("password") String password);

    @Delete("DELETE FROM admin WHERE id = #{id}")
    int deleteAdmin(@Param("id") Integer id);

    int addAdmin(Admin admin);

    @Update("UPDATE admin SET name = #{name},nickname = #{nickname},password = #{password},phone = #{phone},sex = #{sex},role = #{role},state = #{state} where id = #{id}")
    int updateAdmin(Admin admin);

    @Select("SELECT * FROM admin WHERE name = #{name}")
    Admin queryAdmin(@Param("name") String name);

    List<Admin> selectAdminListForTerm(@Param("name") String name,@Param("phone") String phone,@Param("sex") String sex,@Param("role") String role);

    @Update("UPDATE admin SET state=#{state} WHERE id = #{id}")
    int updateState(@Param("id") Integer id,@Param("state") Boolean state);

    @Select("select * from admin where id = #{id}")
    Admin queryAdminforid(@Param("id") Integer id);

    @Update("UPDATE admin SET nickname = #{nickname},phone = #{phone},sex = #{sex} WHERE id = #{id} ")
    int setAdmin(Admin admin);
}
