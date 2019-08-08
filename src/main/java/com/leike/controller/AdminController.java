package com.leike.controller;

import com.leike.constant.ResponseCode;
import com.leike.pojo.Admin;
import com.leike.service.AdminService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
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
        Integer code = ResponseCode.FAILURE;
        String msg = "用户名或者密码错误";

        if (admin.getRole().equals("systemAdmin")) {
            Admin system = adminService.selectAdmin(admin);
            if (system != null) {
                code = ResponseCode.SUCCEED;
                session.setAttribute("SESSION_ADMIN", system);
            }
        }
        if (admin.getRole().equals("clubAdmin")) {
            Admin club = adminService.selectAdmin(admin);
            if (club != null) {
                code = ResponseCode.SUCCEED;
                msg = "";
                session.setAttribute("SESSION_ADMIN", club);
            }
        }
        map.put("code", code);
        map.put("msg", msg);
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

        Integer code = ResponseCode.FAILURE;

        String msg = "原密码错误";

        Admin admin = (Admin) session.getAttribute("SESSION_ADMIN");
        //验证原密码是否正确
        boolean b = adminService.verifyAdmin(admin.getName(), oldPassword, admin.getRole());
        if (b) {
            //更新密码
            boolean b1 = adminService.updateAdminPass(admin.getId(), password);
            if (b1) {
                code = ResponseCode.SUCCEED;
                msg = "";
            } else {
                code = ResponseCode.ERROR;
            }
        }

        map.put("code", code);

        map.put("msg", msg);

        return map;
    }


    /**
     * 获取admin列表(带搜索功能)
     * @param name
     * @param phone
     * @param sex
     * @param role
     * @return
     */
    @RequestMapping("/adminList")
    @ResponseBody
    public Map<String, Object> getAdminList(@Param("name") String name,@Param("phone") String phone,@Param("sex") String sex,@Param("role") String role) {

        Map<String, Object> map = new HashMap<>();

        Integer code = ResponseCode.FAILURE;

        Integer count = 0;

        List<Admin> admins = adminService.selectAdminList(name,phone,sex,role);

        if (admins != null) {
            code = ResponseCode.TABLESUCCEED;
            count = admins.size();
        }

        map.put("code", code);
        map.put("msg", "");
        map.put("count", count);
        map.put("data", admins);

        return map;
    }

    /**
     * 删除管理员
     * @param id
     * @return
     */
    @RequestMapping("/delete")
    @ResponseBody
    public Map<String, Object> deleteAdmin(Integer id) {

        Map<String, Object> map = new HashMap<>();

        Integer code = ResponseCode.FAILURE;

        String msg = "删除失败";

        boolean b = adminService.deleteAdmin(id);
        //如果成功则返回code=200
        if (b) {
            code = ResponseCode.SUCCEED;
            msg = "";
        }

        map.put("code", code);
        map.put("msg", msg);
        return map;
    }

    /**
     * 批量删除Admin
     *
     * @param list
     * @return
     */
    @RequestMapping("/deleteAll")
    @ResponseBody
    public Map<String, Object> deleteAdminList(@RequestBody List<Admin> list) {

        Map<String, Object> map = new HashMap<>();

        Integer code = ResponseCode.SUCCEED;

        //统计删除成功的条数
        Integer count = 0;

        for (int i = 0; i < list.size(); i++) {

            boolean b = adminService.deleteAdmin(list.get(i).getId());

            if (b) {
                count++;
            }

        }

        map.put("code", code);
        map.put("count", count);

        return map;
    }

    /**
     * 添加管理员
     *
     * @param admin
     * @return
     */
    @RequestMapping("/addAdmin")
    @ResponseBody
    public Map<String, Object> addAdmin(@RequestBody Admin admin) {

        Map<String, Object> map = new HashMap<>();

        Integer code = ResponseCode.FAILURE;

        String msg = "管理员添加失败";

        boolean bool = adminService.queryAdmin(admin.getName());

        if (bool) {

            boolean b = adminService.addAdmin(admin);
            if (b) {
                code = ResponseCode.SUCCEED;
                msg = "";
            }

        } else {
            msg = "此账号已存在!";
        }


        map.put("code", code);
        map.put("msg", msg);

        return map;
    }

    /**
     * 更新admin表数据
     * @param admin
     * @return
     */
    @RequestMapping("/update")
    @ResponseBody
    public Map<String, Object> updateAdmin(@RequestBody Admin admin) {

        System.out.println(admin);
        Map<String, Object> map = new HashMap<>();

        Integer code = ResponseCode.FAILURE;

        String msg = "管理员添加失败";

        boolean b = adminService.updateAdmin(admin);

        if (b) {
            code = ResponseCode.SUCCEED;
            msg = "";
        }

        map.put("code", code);
        map.put("msg", msg);

        return map;
    }

    /**
     * 更新审核状态
     * @param id
     * @param state
     * @return
     */
    @RequestMapping("/updateState")
    @ResponseBody
    public Map<String , Object> updateState(Integer id,Boolean state){

        if (state){
            state = false;
        }else {
            state = true;
        }

        Map<String, Object> map = new HashMap<>();

        Integer code = ResponseCode.FAILURE;

        String msg = "修改失败";

        boolean b = adminService.updateState(id, state);
        if (b){
            code = ResponseCode.SUCCEED;
            msg = "修改成功";
        }

        map.put("code", code);
        map.put("msg", msg);

        return map;
    }

}
