package com.leike.service.impl;

import com.leike.mapper.CourseMapper;
import com.leike.pojo.Course;
import com.leike.service.CourseService;
import com.leike.util.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description:
 * @author: leike
 * @date: 2019-08-14 14:56
 */
@Service("courseService")
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseMapper courseMapper;

    //------------系统管理员--------------

    @Override
    public List<Course> selectCourseListForTerm(Integer page, Integer limit, String name) {
        List<Course> courses = courseMapper.selectCourseListForTerm(page, limit, name);
        return courses;
    }

    @Override
    public List<Course> selectCourseList(Integer page, Integer limit) {
        List<Course> courses = courseMapper.selectCourseList(page, limit);
        return courses;
    }

    @Override
    public Integer selectCourseCount() {
        Integer i = courseMapper.selectCourseCount();
        return i;
    }

    @Override
    public boolean insertCourse(Course course) {
        int i = courseMapper.insertCourse(course);
        return i == 1 ? true : false;
    }

    @Override
    public boolean deleteCourse(Integer kId, String pic, String uploadPath) {
        //删除服务器上的用户头像
        FileUtil.deleteFile(uploadPath, pic);
        int i = courseMapper.deleteCourse(kId);
        return i == 1 ? true : false;
    }

    @Override
    public boolean updateCourse(Course course, String uploadPath) {
        //获取用户原头像
        String pic = courseMapper.selectCoursePic(course.getkId());
        //如果修改了用户头像则删除原头像
        if (!course.getPic().equals(pic)) {
            FileUtil.deleteFile(uploadPath, pic);
        }
        int i = courseMapper.updateCourse(course);
        return i == 1 ? true : false;
    }

    //------------俱乐部管理员--------------

    @Override
    public List<Course> selectCourseToClubList(Integer jId) {
        List<Course> courses = courseMapper.selectCourseToClubList(jId);
        return courses;
    }

    @Override
    public List<Course> selectCoursetoClubListForTerm(Integer jId, String name) {
        List<Course> courses = courseMapper.selectCoursetoClubListForTerm(jId, name);
        return courses;
    }


}
