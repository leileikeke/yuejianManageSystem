package com.leike.controller;

import com.leike.constant.ResponseCode;
import com.leike.pojo.Course;
import com.leike.service.CourseService;
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
 * 课程控制器
 *
 * @description:
 * @author: leike
 * @date: 2019-08-14 14:50
 */
@Controller
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private CourseService courseService;

    /**
     * 获取activity列表(带搜索功能)
     *
     * @param page
     * @param limit
     * @param name
     * @return
     */
    @RequestMapping("/getList")
    @ResponseBody
    public Map<String, Object> selectCourseList(Integer page, Integer limit, String name) {

        Map<String, Object> map = new HashMap<>();

        Integer code = ResponseCode.FAILURE;

        Integer count = 0;

        List<Course> courses;

        if ((name != null && !name.equals(""))) {
            courses = courseService.selectCourseListForTerm((page - 1) * limit, limit, name);
            if (courses != null) {
                code = ResponseCode.TABLESUCCEED;
            }
        } else {
            courses = courseService.selectCourseList((page - 1) * limit, limit);
            if (courses != null) {
                code = ResponseCode.TABLESUCCEED;
            }
        }

        count = courseService.selectCourseCount();

        map.put("code", code);
        map.put("msg", "");
        map.put("count", count);
        map.put("data", courses);

        return map;
    }


    /**
     * 添加activity
     *
     * @param course
     * @return
     */
    @RequestMapping("/add")
    @ResponseBody
    public Map<String, Object> addCourse(@RequestBody Course course) {

        Map<String, Object> map = new HashMap<>();

        Integer code = ResponseCode.FAILURE;

        String msg = "添加失败";

        System.out.println(course);

        if (course != null) {

            boolean b = courseService.insertCourse(course);
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
     * 删除course
     *
     * @param kId
     * @param pic
     * @param request
     * @return
     */
    @RequestMapping("/delete")
    @ResponseBody
    public Map<String, Object> deleteCourse(Integer kId, String pic, HttpServletRequest request) {

        Map<String, Object> map = new HashMap<>();

        Integer code = ResponseCode.FAILURE;

        String msg = "删除失败";

        String uploadPath = request.getSession().getServletContext().getRealPath("/");

        boolean b = courseService.deleteCourse(kId, pic, uploadPath);
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
     * 批量删除Course
     *
     * @param list
     * @param request
     * @return
     */
    @RequestMapping("/deleteAll")
    @ResponseBody
    public Map<String, Object> deleteCourseList(@RequestBody List<Course> list, HttpServletRequest request) {

        Map<String, Object> map = new HashMap<>();

        Integer code = ResponseCode.SUCCEED;

        //统计删除成功的条数
        Integer count = 0;

        String uploadPath = request.getSession().getServletContext().getRealPath("/");

        for (int i = 0; i < list.size(); i++) {

            boolean b = courseService.deleteCourse(list.get(i).getkId(), list.get(i).getPic(), uploadPath);

            if (b) {
                count++;
            }

        }

        map.put("code", code);
        map.put("count", count);

        return map;
    }

    /**
     * 修改course信息
     *
     * @param course
     * @param request
     * @return
     */
    @RequestMapping("/update")
    @ResponseBody
    public Map<String, Object> updateActivity(@RequestBody Course course, HttpServletRequest request) {

        Map<String, Object> map = new HashMap<>();

        Integer code = ResponseCode.FAILURE;

        String msg = "更新活动信息失败";

        String uploadPath = request.getSession().getServletContext().getRealPath("/");

        boolean b = courseService.updateCourse(course, uploadPath);

        if (b) {
            code = ResponseCode.SUCCEED;
            msg = "";
        }

        map.put("code", code);
        map.put("msg", msg);

        return map;
    }

}
