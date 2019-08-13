package com.leike.controller;

import com.leike.constant.ResponseCode;
import com.leike.pojo.Admin;
import com.leike.pojo.Coach;
import com.leike.service.ClubEmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 俱乐部员工控制器
 * @description:
 * @author: leike
 * @date: 2019-08-13 14:44
 */
@Controller
@RequestMapping("/clubemp")
public class ClubEmpController {

    @Autowired
    private ClubEmpService clubEmpService;

    /**
     *  获取员工列表(带搜索功能)
     * @param page
     * @param limit
     * @param jId
     * @param name
     * @param phone
     * @param sex
     * @return
     */
    @RequestMapping("/getList")
    @ResponseBody
    public Map<String, Object> selectEmpList(Integer page, Integer limit, String jId, String name, String phone, String sex) {

        Map<String, Object> map = new HashMap<>();

        Integer code = ResponseCode.FAILURE;

        Integer count = 0;

        List<Coach> coaches;

        if ((jId != null && !jId.equals("")) || (name != null && !name.equals("")) || (phone != null && !phone.equals("")) || (sex != null && !sex.equals(""))) {
            coaches = clubEmpService.selectEmpListForTerm((page - 1) * limit, limit, jId, name, phone, sex);
            if (coaches != null) {
                code = ResponseCode.TABLESUCCEED;
            }
        } else {
            coaches = clubEmpService.selectEmpList((page - 1) * limit, limit);
            if (coaches != null) {
                code = ResponseCode.TABLESUCCEED;
            }
        }
        count = clubEmpService.selectEmpCount();

        map.put("code", code);
        map.put("msg", "");
        map.put("count", count);
        map.put("data", coaches);

        return map;
    }

    /**
     * 更新审核状态
     *
     * @param jId
     * @param state
     * @return
     */
    @RequestMapping("/updateState")
    @ResponseBody
    public Map<String, Object> updateState(Integer jId, Boolean state, HttpSession session) {

        Map<String, Object> map = new HashMap<>();

        Integer code = ResponseCode.FAILURE;

        String msg = "修改失败";

        Integer role = 1;

        Admin admin = (Admin) session.getAttribute("SESSION_ADMIN");

        //判断当前用户权限
        if (admin.getRole().equals("systemAdmin")){

            if (state) {
                state = false;
            } else {
                state = true;
            }

            boolean b = clubEmpService.updateState(jId, state);
            if (b) {
                code = ResponseCode.SUCCEED;
                msg = "修改成功";
            }
        }else {
            code = ResponseCode.SUCCEED;
            msg = "请联系管理员审核!";
            role = 0;
        }

        map.put("code", code);
        map.put("msg", msg);
        map.put("role",role);

        return map;
    }

    /**
     * 更新User数据
     *
     * @param coach
     * @return
     */
    @RequestMapping("/update")
    @ResponseBody
    public Map<String, Object> updateUser(@RequestBody Coach coach, HttpServletRequest request) {

        Map<String, Object> map = new HashMap<>();

        Integer code = ResponseCode.FAILURE;

        String msg = "教练信息失败";

        String uploadPath = request.getSession().getServletContext().getRealPath("/");
        boolean b = clubEmpService.updateCoach(coach, uploadPath);

        if (b) {
            code = ResponseCode.SUCCEED;
            msg = "";
        }

        map.put("code", code);
        map.put("msg", msg);

        return map;
    }

    /**
     * 删除教练
     *
     * @param jId
     * @return
     */
    @RequestMapping("/delete")
    @ResponseBody
    public Map<String, Object> deleteUser(Integer jId, String pic, HttpServletRequest request) {

        Map<String, Object> map = new HashMap<>();

        Integer code = ResponseCode.FAILURE;

        String msg = "删除失败";

        String uploadPath = request.getSession().getServletContext().getRealPath("/");

        boolean b = clubEmpService.deleteCoach(jId, pic, uploadPath);
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
     * 批量删除教练
     *
     * @param list
     * @return
     */
    @RequestMapping("/deleteAll")
    @ResponseBody
    public Map<String, Object> deleteUserList(@RequestBody List<Coach> list, HttpServletRequest request) {

        Map<String, Object> map = new HashMap<>();

        Integer code = ResponseCode.SUCCEED;

        //统计删除成功的条数
        Integer count = 0;

        String uploadPath = request.getSession().getServletContext().getRealPath("/");

        for (int i = 0; i < list.size(); i++) {

            boolean b = clubEmpService.deleteCoach(list.get(i).getjId(), list.get(i).getPic(), uploadPath);

            if (b) {
                count++;
            }

        }

        map.put("code", code);
        map.put("count", count);

        return map;
    }
    /**
     * 添加Coach
     *
     * @param coach
     * @return
     */
    @RequestMapping("/add")
    @ResponseBody
    public Map<String, Object> addCoach(@RequestBody Coach coach) {

        Map<String, Object> map = new HashMap<>();

        Integer code = ResponseCode.FAILURE;

        String msg = "添加失败";

        boolean bool = clubEmpService.queryCoach(coach.getName());
        if (bool) {
            if (coach != null) {

                boolean b = clubEmpService.insertCoach(coach);
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
//
//    /**
//     * 删除User
//     *
//     * @param uId
//     * @return
//     */
//    @RequestMapping("/delete")
//    @ResponseBody
//    public Map<String, Object> deleteUser(Integer uId, String pic, HttpServletRequest request) {
//
//        Map<String, Object> map = new HashMap<>();
//
//        Integer code = ResponseCode.FAILURE;
//
//        String msg = "删除失败";
//
//        String uploadPath = request.getSession().getServletContext().getRealPath("/");
//
//        boolean b = clubEmpService.deleteUser(uId, pic, uploadPath);
//        //如果成功则返回code=200
//        if (b) {
//            code = ResponseCode.SUCCEED;
//            msg = "";
//        }
//
//        map.put("code", code);
//        map.put("msg", msg);
//        return map;
//    }
//
//    /**
//     * 批量删除User
//     *
//     * @param list
//     * @return
//     */
//    @RequestMapping("/deleteAll")
//    @ResponseBody
//    public Map<String, Object> deleteUserList(@RequestBody List<User> list, HttpServletRequest request) {
//
//        Map<String, Object> map = new HashMap<>();
//
//        Integer code = ResponseCode.SUCCEED;
//
//        //统计删除成功的条数
//        Integer count = 0;
//
//        String uploadPath = request.getSession().getServletContext().getRealPath("/");
//
//        for (int i = 0; i < list.size(); i++) {
//
//            boolean b = clubEmpService.deleteUser(list.get(i).getuId(), list.get(i).getPic(), uploadPath);
//
//            if (b) {
//                count++;
//            }
//
//        }
//
//        map.put("code", code);
//        map.put("count", count);
//
//        return map;
//    }
//
//    /**
//     * 更新User数据
//     *
//     * @param user
//     * @return
//     */
//    @RequestMapping("/update")
//    @ResponseBody
//    public Map<String, Object> updateUser(@RequestBody User user, HttpServletRequest request) {
//
//        Map<String, Object> map = new HashMap<>();
//
//        Integer code = ResponseCode.FAILURE;
//
//        String msg = "用户添加失败";
//
//        String uploadPath = request.getSession().getServletContext().getRealPath("/");
//        boolean b = clubEmpService.updateUser(user, uploadPath);
//
//        if (b) {
//            code = ResponseCode.SUCCEED;
//            msg = "";
//        }
//
//        map.put("code", code);
//        map.put("msg", msg);
//
//        return map;
//    }



}
