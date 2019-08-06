package com.leike.service.impl;

import com.leike.mapper.AdminMapper;
import com.leike.pojo.Admin;
import com.leike.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description:
 * @author: leike
 * @date: 2019-08-03 16:52
 */
@Service("adminService")
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminMapper adminMapper;

    @Override
    public Admin selectAdmin(Admin admin) {
        Admin admin1 = adminMapper.selectAdmin(admin);
        return admin1;
    }

    @Override
    public boolean verifyAdmin(String name, String oldPassword, String role) {
        Admin admin = adminMapper.verifyAdmin(name, oldPassword, role);
        return admin == null ? false : true;
    }

    @Override
    public boolean updateAdmin(Integer id, String password) {
        int i = adminMapper.updateAdmin(id, password);
        return i == 1 ? true : false;
    }

    @Override
    public List<Admin> selectAdminList() {
        List<Admin> admins = adminMapper.selectAdminList();
        return admins;
    }

    @Override
    public int selectAdminCount() {
        int i = adminMapper.selectAdminCount();
        return i;
    }

    @Override
    public boolean deleteAdmin(Integer id) {
        int i = adminMapper.deleteAdmin(id);
        return i == 1 ? true : false;
    }
}
