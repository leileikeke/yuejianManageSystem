package com.leike.API;

import com.leike.constant.ResponseCode;
import com.leike.pojo.Activity;
import com.leike.service.ActivityService;
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
 * @date: 2019-08-27 20:45
 */
@Controller
@RequestMapping("/api/clubActivity")
public class ClubActivityAPI {

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
            activities = activityService.selectActivityListForTerm(0, 1000, name, type, cName);
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
     * 获取activity列表(带搜索功能)
     *
     * @param cId
     * @return
     */
    @RequestMapping("/get")
    @ResponseBody
    public Map<String, Object> selectActivityForClub(Integer cId) {

        Map<String, Object> map = new HashMap<>();

        Integer code = ResponseCode.SUCCEED;

        Integer count = 0;

        Activity activity;

        activity = activityService.selectActivityForCId(cId);

        count = activityService.selectActivityCount();

        map.put("code", code);
        map.put("msg", "");
        map.put("count", count);
        map.put("data", activity);

        return map;
    }

}
