package com.leike.controller;

import com.leike.constant.ResponseCode;
import com.leike.pojo.Activity;
import com.leike.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * activity控制器
 *
 * @description:
 * @author: leike
 * @date: 2019-08-11 16:43
 */
@Controller
@RequestMapping("/activity")
public class ActicityController {

    @Autowired
    private ActivityService activityService;

    /**
     * 获取activity列表(带搜索功能)
     *
     * @param page
     * @param limit
     * @param name
     * @param type
     * @param cName
     * @return
     */
    @RequestMapping("/getList")
    @ResponseBody
    public Map<String, Object> selectActivityList(Integer page, Integer limit, String name, String type, String cName) {

        Map<String, Object> map = new HashMap<>();

        Integer code = ResponseCode.FAILURE;

        Integer count = 0;

        List<Activity> activities;

        if ((name != null && !name.equals("")) || (type != null && !type.equals("")) || (cName != null && !cName.equals(""))) {
            activities = activityService.selectActivityListForTerm((page - 1) * limit, limit, name, type, cName);
            if (activities != null) {
                code = ResponseCode.TABLESUCCEED;
            }
        } else {
            activities = activityService.selectActivityList((page - 1) * limit, limit);
            if (activities != null) {
                code = ResponseCode.TABLESUCCEED;
            }
        }

        count = activityService.selectActivityCount();

        map.put("code", code);
        map.put("msg", "");
        map.put("count", count);
        map.put("data", activities);

        return map;
    }

    /**
     * 修改activity信息
     *
     * @param activity
     * @param request
     * @return
     */
    @RequestMapping("/update")
    @ResponseBody
    public Map<String, Object> updateActivity(@RequestBody Activity activity, HttpServletRequest request) {

        Map<String, Object> map = new HashMap<>();

        Integer code = ResponseCode.FAILURE;

        String msg = "更新活动信息失败";

        String uploadPath = request.getSession().getServletContext().getRealPath("/");

        boolean b = activityService.updateActivity(activity, uploadPath);

        if (b) {
            code = ResponseCode.SUCCEED;
            msg = "";
        }

        map.put("code", code);
        map.put("msg", msg);

        return map;
    }

//    /**
//     * 添加activity
//     *
//     * @param activity
//     * @return
//     */
//    @RequestMapping("/add")
//    @ResponseBody
//    public Map<String, Object> addActivity(@RequestBody Activity activity) {
//
//        Map<String, Object> map = new HashMap<>();
//
//        Integer code = ResponseCode.FAILURE;
//
//        String msg = "添加失败";
//
//        if (activity != null) {
//
//            boolean b = activityService.insertActivity(activity);
//            if (b) {
//                code = ResponseCode.SUCCEED;
//                msg = "";
//            }
//
//        }
//
//        map.put("code", code);
//        map.put("msg", msg);
//
//        return map;
//    }


    /**
     * 删除activity
     *
     * @param aId
     * @param pic
     * @param request
     * @return
     */
    @RequestMapping("/delete")
    @ResponseBody
    public Map<String, Object> deleteActivity(Integer aId, String pic, HttpServletRequest request) {

        Map<String, Object> map = new HashMap<>();

        Integer code = ResponseCode.FAILURE;

        String msg = "删除失败";

        String uploadPath = request.getSession().getServletContext().getRealPath("/");

        boolean b = activityService.deleteActivity(aId, pic, uploadPath);
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
     * 批量删除俱乐部
     *
     * @param list
     * @param request
     * @return
     */
    @RequestMapping("/deleteAll")
    @ResponseBody
    public Map<String, Object> deleteActivityList(@RequestBody List<Activity> list, HttpServletRequest request) {

        Map<String, Object> map = new HashMap<>();

        Integer code = ResponseCode.SUCCEED;

        //统计删除成功的条数
        Integer count = 0;

        String uploadPath = request.getSession().getServletContext().getRealPath("/");

        for (int i = 0; i < list.size(); i++) {

            boolean b = activityService.deleteActivity(list.get(i).getaId(), list.get(i).getPic(), uploadPath);

            if (b) {
                count++;
            }

        }

        map.put("code", code);
        map.put("count", count);

        return map;
    }

    @RequestMapping("/getListForclubAdmin")
    @ResponseBody
    public Map<String, Object> getActivityListForclubAdmin(Integer id, Integer page, Integer limit) {

        Map<String, Object> map = new HashMap<>();

        Integer code = ResponseCode.FAILURE;

        Integer count = 0;

        List<Activity> activities;

        activities = activityService.selectActivityListForclubAdmin((page - 1) * limit, limit, id);
        if (activities != null) {
            code = ResponseCode.TABLESUCCEED;
        }

        count = activityService.selectActivityCountForClubAdmin(id);

        map.put("code", code);
        map.put("msg", "");
        map.put("count", count);
        map.put("data", activities);

        return map;
    }
}
