package com.leike.controller;

import com.leike.constant.ResponseCode;
import com.leike.pojo.User;
import com.leike.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
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
     *
     * @param page
     * @param limit
     * @return
     */
    @RequestMapping("/userList")
    @ResponseBody
    public Map<String, Object> selectAdminList(Integer page, Integer limit) {

        Map<String, Object> map = new HashMap<>();

        Integer code = ResponseCode.FAILURE;

        Integer count = 0;

        List<User> users = userService.selectUserList((page - 1) * limit, limit);

        if (users != null) {
            code = ResponseCode.TABLESUCCEED;
            count = userService.selectUserCount();
        }

        map.put("code", code);
        map.put("msg", "");
        map.put("count", count);
        map.put("data", users);

        return map;
    }

    /**
     * 添加User
     *
     * @param user
     * @return
     */
    @RequestMapping("addUser")
    @ResponseBody
    public Map<String, Object> addUser(@RequestBody User user) {

        Map<String, Object> map = new HashMap<>();

        Integer code = ResponseCode.FAILURE;

        String msg = "添加失败";

        boolean bool = userService.queryUser(user.getName());
        if (bool) {
            if (user != null) {

                boolean b = userService.insertUser(user);
                if (b) {
                    code = ResponseCode.SUCCEED;
                    msg = "";
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
     * 删除User
     *
     * @param uId
     * @return
     */
    @RequestMapping("/delete")
    @ResponseBody
    public Map<String, Object> deleteUser(Integer uId) {

        Map<String, Object> map = new HashMap<>();

        Integer code = ResponseCode.FAILURE;

        String msg = "删除失败";

        boolean b = userService.deleteUser(uId);
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
     * 批量删除User
     *
     * @param list
     * @return
     */
    @RequestMapping("/deleteAll")
    @ResponseBody
    public Map<String, Object> deleteUser(@RequestBody List<User> list) {

        Map<String, Object> map = new HashMap<>();

        Integer code = ResponseCode.SUCCEED;

        //统计删除成功的条数
        Integer count = 0;

        for (int i = 0; i < list.size(); i++) {

            boolean b = userService.deleteUser(list.get(i).getuId());

            if (b) {
                count++;
            }

        }

        map.put("code", code);
        map.put("count", count);

        return map;
    }

    /**
     * 更新User数据
     * @param user
     * @return
     */
    @RequestMapping("/update")
    @ResponseBody
    public Map<String, Object> updateAdmin(@RequestBody User user) {

        System.out.println(user);
        Map<String, Object> map = new HashMap<>();

        Integer code = ResponseCode.FAILURE;

        String msg = "管理员添加失败";

        boolean b = userService.updateUser(user);

        if (b) {
            code = ResponseCode.SUCCEED;
            msg = "";
        }

        map.put("code", code);
        map.put("msg", msg);

        return map;
    }

}
