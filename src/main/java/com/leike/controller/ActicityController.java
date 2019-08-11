package com.leike.controller;

import com.leike.constant.ResponseCode;
import com.leike.pojo.Activity;
import com.leike.service.ActivityService;
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
 * activity控制器
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
     * @param cId
     * @param aId
     * @param name
     * @return
     */
    @RequestMapping("/clubList")
    @ResponseBody
    public Map<String, Object> selectActivityList(Integer page, Integer limit, String cId, String aId, String name) {

        Map<String, Object> map = new HashMap<>();

        Integer code = ResponseCode.FAILURE;

        Integer count = 0;

        List<Activity> activities;

        if ((cId != null && !cId.equals("")) || (name != null && !name.equals("")) || (aId != null && !aId.equals(""))) {
            activities = activityService.selectActivityListForTerm((page - 1) * limit, limit, cId, name, aId);
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

        String msg = "添加俱乐部失败";

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

    /**
     * 添加activity
     *
     * @param activity
     * @return
     */
    @RequestMapping("/addActivity")
    @ResponseBody
    public Map<String, Object> addActivity(@RequestBody Activity activity) {

        Map<String, Object> map = new HashMap<>();

        Integer code = ResponseCode.FAILURE;

        String msg = "添加失败";

        if (activity != null) {

            boolean b = activityService.insertActivity(activity);
            if (b) {
                code = ResponseCode.SUCCEED;
                msg = "";
            }

        }

        map.put("code", code);
        map.put("msg", msg);

        return map;
    }


    /**
     * 删除activity
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




}
