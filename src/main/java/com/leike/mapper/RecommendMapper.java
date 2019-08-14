package com.leike.mapper;

import com.leike.pojo.Coach;
import com.leike.pojo.Recommend;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

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
    int updateCoachState(Integer jId);

    @Select("SELECT count(*) FROM recommend")
    int selectRecommendCount();
}
