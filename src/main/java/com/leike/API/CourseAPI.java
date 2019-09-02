package com.leike.API;

import com.leike.constant.ResponseCode;
import com.leike.pojo.Course;
import com.leike.service.CourseService;
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
 * @date: 2019-08-27 21:38
 */
@Controller
@RequestMapping("/api/course")
public class CourseAPI {

    @Autowired
    CourseService courseService;

    /**
     * 获取course列表
     *
     * @return
     */
    @RequestMapping("/getList")
    @ResponseBody
    public Map<String, Object> selectCourseList() {

        Map<String, Object> map = new HashMap<>();

        Integer code = ResponseCode.FAILURE;

        Integer count = 0;

        List<Course> courses;

        String msg = "获取失败";

        courses = courseService.selectCourseList1();
        if (courses != null) {
            code = ResponseCode.TABLESUCCEED;
            msg = "";
        }

        map.put("code", code);
        map.put("msg", "");
        map.put("data", courses);

        return map;
    }


}
