package com.leike.service;

import com.leike.pojo.Admin;
import org.springframework.stereotype.Service;

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

    List<Admin> selectAdminList();

    int selectAdminCount();

    boolean deleteAdmin(Integer id);

    boolean addAdmin(Admin admin);

    boolean updateAdmin(Admin admin);
}
