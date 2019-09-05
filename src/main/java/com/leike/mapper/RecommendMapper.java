package com.leike.mapper;

import com.leike.pojo.Recommend;
import org.apache.ibatis.annotations.*;

import java.util.Date;
import java.util.List;

/**
 * @description:
 * @author: leike
 * @date: 2019-08-15 1:42
 */
public interface RecommendMapper {

    List<Recommend> selectRecommendList();

    @Delete("DELETE FROM recommend WHERE j_id = #{jId}")
    int deleteRecommend(@Param("jId") Integer jId);

    @Update("UPDATE coach SET state = 1 WHERE j_id = #{jId}")
    int updateCoachState(@Param("jId") Integer jId);

    @Select("SELECT count(*) FROM recommend")
    int selectRecommendCount();

    @Insert("INSERT Notify(j_id,state,c_id,id,checktime) VALUE (#{jId},#{state},#{cId},#{id},now())")
    int insertNotity(@Param("jId") Integer jId, @Param("state") Boolean state, @Param("cId") Integer cId, @Param("id") Integer id);

    @Select("SELECT checktime FROM recommend WHERE j_id = #{jId}")
    Date selectChecktimeByJId(@Param("jId") Integer jId);
}
