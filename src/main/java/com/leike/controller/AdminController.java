package com.leike.controller;

import com.leike.constant.ResponseCode;
import com.leike.pojo.Admin;
import com.leike.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author: leike
 * @date: 2019-08-03 16:54
 */
@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    /**
     * 登录
     *
     * @param admin
     * @param session
     * @return
     */
    @RequestMapping("/login")
    @ResponseBody
    public Map<String, Object> login(Admin admin, HttpSession session) {

        Map<String, Object> map = new HashMap<>();
        Integer code = ResponseCode.LOGIN_FAILURE;

        if (admin.getRole().equals("systemAdmin")) {
            Admin system = adminService.selectAdmin(admin);
            System.out.println(system);
            if (system != null) {
                code = ResponseCode.SUCCEED;
                session.setAttribute("SESSION_ADMIN", system);
            }
        }
        if (admin.getRole().equals("clubAdmin")) {
            Admin club = adminService.selectAdmin(admin);
            if (club != null) {
                code = ResponseCode.SUCCEED;
                session.setAttribute("SESSION_ADMIN", club);
            }
        }
        map.put("code", code);
        return map;
    }

    /**
     * 注销
     *
     * @param session
     * @return
     */
    @RequestMapping("/logout")
    @ResponseBody
    public Map<String, Object> logout(HttpSession session) {

        Map<String, Object> map = new HashMap<>();
        Integer code = ResponseCode.LOGOUT;
        session.removeAttribute("SESSION_ADMIN");
        map.put("code", code);
        return map;
    }

    /**
     * 修改密码
     *
     * @param oldPassword
     * @param password
     * @param session
     * @return
     */
    @RequestMapping("/setpass")
    @ResponseBody
    public Map<String, Object> setPass(String oldPassword, String password, HttpSession session) {

        Map<String, Object> map = new HashMap<>();
        Integer code = ResponseCode.SETPASS_FAILURE;

        Admin admin = (Admin) session.getAttribute("SESSION_ADMIN");
        //验证原密码是否正确
        boolean b = adminService.verifyAdmin(admin.getName(), oldPassword, admin.getRole());
        if (b) {
            //更新密码
            boolean b1 = adminService.updateAdmin(admin.getId(), password);
            if (b1) {
                code = ResponseCode.SUCCEED;
            } else {
                code = ResponseCode.ERROR;
            }
        }
        map.put("code", code);
        return map;
    }


    /**
     * 获取admin列表(不包括密码)
     */
    @RequestMapping("/adminList")
    @ResponseBody
    public Map<String, Object> getAdminList() {

        Map<String, Object> map = new HashMap<>();

        Integer code = ResponseCode.FAILURE;

        List<Admin> admins = adminService.selectAdminList();

        if (admins != null) {
            code = ResponseCode.TABLESUCCEED;
        }

        map.put("code", code);
        map.put("msg", "");
        map.put("count", adminService.selectAdminCount());
        map.put("data", admins);

        return map;
    }

    @RequestMapping("/delete")
    @ResponseBody
    public Map<String, Object> deleteAdmin(Integer id) {

        Map<String, Object> map = new HashMap<>();

        Integer code = ResponseCode.FAILURE;

        boolean b = adminService.deleteAdmin(id);
        //如果成功则返回code=200
        if (b) {
            code = ResponseCode.SUCCEED;
        }

        map.put("code", code);

        return map;
    }
}
