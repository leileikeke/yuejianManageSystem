package com.leike.service;

import com.leike.pojo.Admin;

import java.util.List;

/**
 * @description:
 * @author: leike
 * @date: 2019-08-03 16:51
 */
public interface AdminService {

    Admin selectAdmin(Admin admin);

    boolean verifyAdmin(String name, String oldPassword, String role);

    boolean updateAdminPass(Integer id, String password);

    List<Admin> selectAdminList(String name, String phone, String sex, String role);

    boolean deleteAdmin(Integer id);

    boolean addAdmin(Admin admin);

    boolean updateAdmin(Admin admin);

    boolean queryAdmin(String name);

    boolean updateState(Integer id, Boolean state);
}
