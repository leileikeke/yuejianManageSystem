package com.leike.service;

import com.leike.pojo.Course;

import java.util.List;

/**
 * @description:
 * @author: leike
 * @date: 2019-08-14 14:52
 */
public interface CourseService {


    List<Course> selectCourseListForTerm(Integer page, Integer limit, String name);

    List<Course> selectCourseList(Integer page, Integer limit);

    Integer selectCourseCount();

    boolean insertCourse(Course course);

    boolean deleteCourse(Integer kId, String pic, String uploadPath);

    boolean updateCourse(Course course, String uploadPath);

    List<Course> selectCourseToClubList(Integer jId);

    List<Course> selectCoursetoClubListForTerm(Integer jId, String name);
}
