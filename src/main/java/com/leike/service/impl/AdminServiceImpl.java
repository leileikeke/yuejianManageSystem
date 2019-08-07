package com.leike.service.impl;

import com.leike.mapper.AdminMapper;
import com.leike.pojo.Admin;
import com.leike.service.AdminService;
import com.leike.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
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
    public boolean updateAdminPass(Integer id, String password) {
        int i = adminMapper.updateAdminPass(id, password);
        return i == 1 ? true : false;
    }

    @Override
    public boolean updateAdmin(Admin admin) {
        int i = adminMapper.updateAdmin(admin);
        return i == 1 ? true : false;
    }

    @Override
    public List<Admin> selectAdminList() {
        List<Admin> admins = adminMapper.selectAdminList();
        return admins;
    }

    @Override
    public boolean deleteAdmin(Integer id) {
        int i = adminMapper.deleteAdmin(id);
        return i == 1 ? true : false;
    }

    @Override
    public boolean addAdmin(Admin admin) {
        //获取当前系统时间
        Date date = DateUtil.getCurrentTime(new Date(),"yyyy-MM-dd hh:mm:ss");
        admin.setJointime(date);
        int i = adminMapper.addAdmin(admin);

        return i == 1 ? true : false;
    }
}
