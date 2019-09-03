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

    List<Activity> selectActivityListForTerm(@Param("page") Integer page, @Param("limit") Integer limit, @Param("name") String name, @Param("type") String type, @Param("cName") String cName);

    List<Activity> selectActivityList(@Param("page") Integer page, @Param("limit") Integer limit);

    @Select("select count(*) from activity")
    int selectActivityCount();

    @Select("select pic from activity where a_id = #{aId}")
    String selectActivityPic(@Param("aId") Integer aId);

    @Update("UPDATE activity SET name = #{name},start_time = #{startTime},end_time = #{endTime},address = #{address},pic = #{pic},price = #{price},type = #{type},detail = #{detail} where a_id = #{aId}")
    int updateActivity(Activity activity);

    int insertActivity(Activity activity);

    @Delete("DELETE FROM activity WHERE a_id = #{aId}")
    int deleteActivity(@Param("aId") Integer aId);

    List<Activity> selectActivityListForclubAdmin(@Param("page") Integer page,@Param("limit") Integer limit,@Param("id") Integer id);

    Integer selectActivityCountForClubAdmin(@Param("id") Integer id);

    @Select("SELECT * FROM Activity WHERE c_id = #{cId}")
    List<Activity> selectActivityForCId(@Param("cId") Integer cId);

    @Select("SELECT * FROM activity WHERE a_id = #{aId}")
    Activity selectActivityByAId(@Param("aId") Integer aId);

}
