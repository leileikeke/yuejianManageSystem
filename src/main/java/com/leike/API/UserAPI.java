package com.leike.API;

import com.leike.constant.ResponseCode;
import com.leike.pojo.User;
import com.leike.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: leike
 * @date: 2019-08-27 20:49
 */
@Controller
@RequestMapping("/api/user")
public class UserAPI {

    @Autowired
    private UserService userService;

    /**
     * 登录
     *
     * @param user
     * @return
     */
    @RequestMapping("/login")
    @ResponseBody
    public Map<String, Object> login(User user) {

        Map<String, Object> map = new HashMap<>();
        Integer code = ResponseCode.FAILURE;
        String msg = "用户名或者密码错误";

        user = userService.login(user);

        Integer id = 0;

        if (user != null) {
            code = ResponseCode.SUCCEED;
            id = user.getuId();
            msg = "验证成功";
        }

        map.put("code", code);
        map.put("msg", msg);
        map.put("uId", id);
        return map;
    }

    /**
     * 修改密码
     *
     * @param oldPassword
     * @param password
     * @return
     */
    @RequestMapping("/setpass")
    @ResponseBody
    public Map<String, Object> setPass(Integer uId, String oldPassword, String password) {

        Map<String, Object> map = new HashMap<>();

        Integer code = ResponseCode.FAILURE;

        String msg = "原密码错误";

        //验证原密码是否正确
        boolean b = userService.verifyUser(uId, oldPassword);
        if (b) {
            //更新密码
            boolean b1 = userService.updateUserPass(uId, password);
            if (b1) {
                code = ResponseCode.SUCCEED;
                msg = "密码修改成功";
            } else {
                code = ResponseCode.ERROR;
            }
        }

        map.put("code", code);
        map.put("msg", msg);

        return map;
    }

    /**
     * 注册User
     *
     * @param user
     * @return
     */
    @RequestMapping("/add")
    @ResponseBody
    public Map<String, Object> addUser(@RequestBody User user) {

        Map<String, Object> map = new HashMap<>();

        Integer code = ResponseCode.FAILURE;

        String msg = "注册失败";

        boolean bool = userService.queryUser(user.getName());
        if (bool) {
            if (user != null) {

                boolean b = userService.insertUser(user);
                if (b) {
                    code = ResponseCode.SUCCEED;
                    msg = "注册成功";
                }

            }
        } else {
            msg = "此用户已存在!";
        }

        map.put("code", code);
        map.put("msg", msg);

        return map;
    }

    /**
     * 修改Use信息
     *
     * @param user
     * @return
     */
    @RequestMapping("/update")
    @ResponseBody
    public Map<String, Object> updateUser(@RequestBody User user, HttpServletRequest request) {

        Map<String, Object> map = new HashMap<>();

        Integer code = ResponseCode.FAILURE;

        String msg = "用户更新失败";

        String uploadPath = request.getSession().getServletContext().getRealPath("/");
        boolean b = userService.updateUser(user, uploadPath);

        if (b) {
            code = ResponseCode.SUCCEED;
            msg = "修改成功";
        }

        map.put("code", code);
        map.put("msg", msg);

        return map;
    }

    /**
     * 获取Use信息
     *
     * @param uId
     * @return
     */
    @RequestMapping("/get")
    @ResponseBody
    public Map<String, Object> getUser(Integer uId) {

        Map<String, Object> map = new HashMap<>();

        Integer code = ResponseCode.FAILURE;

        String msg = "获取失败";

        User user = userService.getUser(uId);

        if (user != null) {
            code = ResponseCode.SUCCEED;
            msg = "成功";
        }

        map.put("code", code);
        map.put("msg", msg);
        map.put("data",user);
        return map;
    }

}
