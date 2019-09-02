package com.leike.mapper;

import com.leike.pojo.Course;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @description:
 * @author: leike
 * @date: 2019-08-14 14:59
 */
public interface CourseMapper {


    List<Course> selectCourseList(@Param("page") Integer page,@Param("limit") Integer limit);

    List<Course> selectCourseListForTerm(@Param("page") Integer page,@Param("limit") Integer limit,@Param("name") String name);

    @Select("SELECT count(*) FROM course")
    Integer selectCourseCount();


    int insertCourse(Course course);

    @Delete("DELETE FROM course WHERE k_id = #{kId}")
    int deleteCourse(@Param("kId") Integer kId);

    @Select("SELECT pic FROM course WHERE k_id = #{kId}")
    String selectCoursePic(Integer getkId);

    @Update("UPDATE course SET name = #{name},intro = #{intro},class_hours = #{classHours},price = #{price},pic = #{pic} WHERE k_id = #{kId}")
    int updateCourse(Course course);

    List<Course> selectCourseToClubList(@Param("jId") Integer jId);

    List<Course> selectCoursetoClubListForTerm(@Param("jId") Integer jId,@Param("name") String name);

    List<Course> selectCourseList1();
}
