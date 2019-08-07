package com.leike.controller;

import com.leike.constant.ResponseCode;
import com.leike.pojo.User;
import com.leike.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author: leike
 * @date: 2019-08-07 16:41
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 获取user列表(不包括密码)
     */
    @RequestMapping("/userList")
    @ResponseBody
    public Map<String, Object> getAdminList() {

        Map<String, Object> map = new HashMap<>();

        Integer code = ResponseCode.FAILURE;

        List<User> users = userService.selectUserList();

        if (users != null) {
            code = ResponseCode.TABLESUCCEED;
        }

        map.put("code", code);
        map.put("msg", "");
        map.put("count", userService.selectUserCount());
        map.put("data", users);

        return map;
    }


}
