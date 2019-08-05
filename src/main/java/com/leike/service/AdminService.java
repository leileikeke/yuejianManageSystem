package com.leike.service;

import com.leike.pojo.Admin;
import org.springframework.stereotype.Service;

/**
 * @description:
 * @author: leike
 * @date: 2019-08-03 16:51
 */
public interface AdminService {

    Admin selectAdmin(Admin admin);

    boolean verifyAdmin(String name, String oldPassword, String role);

    boolean updateAdmin(Integer id, String password);
}
