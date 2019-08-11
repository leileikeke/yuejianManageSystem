package com.leike.mapper;

import com.leike.pojo.Activity;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @description:
 * @author: leike
 * @date: 2019-08-11 16:55
 */
public interface ActivityMapper {

    List<Activity> selectActivityListForTerm(@Param("page") Integer page, @Param("limit") Integer limit, @Param("cId") String cId, @Param("name") String name, @Param("aId") String aId);

    @Select("SELECT * FROM activity limit #{page},#{limit}")
    List<Activity> selectActivityList(@Param("page") Integer page, @Param("limit") Integer limit);

    @Select("select count(*) from activity")
    int selectActivityCount();

    @Select("select pic from activity where a_id = #{aId}")
    String selectActivity(@Param("aId") Integer aId);

    @Update("UPDATE activity SET name = #{name},start_time = #{startTime},end_time = #{endTime},address = #{address},pic = #{pic},price = #{price},type = #{type},detail = #{detail} where a_id = #{aId}")
    int updateActivity(Activity activity);

    int insertMapper(Activity activity);

    @Delete("DELETE FROM club WHERE a_id = #{aId}")
    int deleteActivity(@Param("aId") Integer aId);
}
