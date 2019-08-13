package com.leike.controller;

import com.leike.constant.ResponseCode;
import com.leike.pojo.User;
import com.leike.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 用户控制器
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
     * 获取user列表(带搜索功能)
     *
     * @param page
     * @param limit
     * @param uId
     * @param name
     * @param phone
     * @param sex
     * @return
     */
    @RequestMapping("/getList")
    @ResponseBody
    public Map<String, Object> selectAdminList(Integer page, Integer limit, String uId, String name, String phone, String sex) {

        Map<String, Object> map = new HashMap<>();

        Integer code = ResponseCode.FAILURE;

        Integer count = 0;

        List<User> users;

        if ((uId != null && !uId.equals("")) || (name != null && !name.equals("")) || (phone != null && !phone.equals("")) || (sex != null && !sex.equals(""))) {
            users = userService.selectUserListForTerm((page - 1) * limit, limit, uId, name, phone, sex);
            if (users != null) {
                code = ResponseCode.TABLESUCCEED;
//                count = userService.selectUserCountForTerm(uId,name,phone,sex);
            }
        } else {
            users = userService.selectUserList((page - 1) * limit, limit);
            if (users != null) {
                code = ResponseCode.TABLESUCCEED;
            }
        }
        count = userService.selectUserCount();

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
    @RequestMapping("/add")
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
    public Map<String, Object> deleteUser(Integer uId, String pic, HttpServletRequest request) {

        Map<String, Object> map = new HashMap<>();

        Integer code = ResponseCode.FAILURE;

        String msg = "删除失败";

        String uploadPath = request.getSession().getServletContext().getRealPath("/");

        boolean b = userService.deleteUser(uId, pic, uploadPath);
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
    public Map<String, Object> deleteUserList(@RequestBody List<User> list, HttpServletRequest request) {

        Map<String, Object> map = new HashMap<>();

        Integer code = ResponseCode.SUCCEED;

        //统计删除成功的条数
        Integer count = 0;

        String uploadPath = request.getSession().getServletContext().getRealPath("/");

        for (int i = 0; i < list.size(); i++) {

            boolean b = userService.deleteUser(list.get(i).getuId(), list.get(i).getPic(), uploadPath);

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
            msg = "";
        }

        map.put("code", code);
        map.put("msg", msg);

        return map;
    }

}
