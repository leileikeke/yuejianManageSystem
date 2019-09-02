package com.leike.mapper;

import com.leike.pojo.Coach;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @description:
 * @author: leike
 * @date: 2019-08-13 14:51
 */
public interface ClubEmpMapper {


    List<Coach> selectEmpListForTerm(@Param("page") Integer page, @Param("limit") Integer limit, @Param("jId") String jId, @Param("name") String name, @Param("phone") String phone, @Param("sex") String sex);

    List<Coach> selectEmpList(@Param("page") Integer page, @Param("limit") Integer limit);

    @Select("SELECT count(*) FROM coach")
    Integer selectEmpCount();

    @Update("UPDATE coach SET state = #{state} WHERE j_id = #{jId}")
    int updateState(@Param("jId") Integer jId, @Param("state") Boolean state);

    @Select("SELECT pic FROM coach WHERE j_id = #{jId}")
    String selectCoachForPic(@Param("jId") Integer jId);

    @Update("UPDATE coach SET name = #{name},pic = #{pic},sex = #{sex},phone = #{phone},intro = #{intro},email = #{email} where j_id = #{jId}")
    int updateCoach(Coach coach);

    @Delete("DELETE FROM coach WHERE j_id = #{jId}")
    int deleteCoach(@Param("jId") Integer jId);

    @Select("SELECT count(*) FROM coach WHERE name = #{name}")
    int queryCoach(@Param("name") String name);

    int insertCoach(Coach coach);

    List<Coach> selectEmpListToClub(@Param("page") Integer page, @Param("limit") Integer limit, @Param("cId") Integer cId);

    @Select("SELECT c_id FROM club WHERE id = #{id}")
    Integer selectClubId(@Param("id") Integer id);

    List<Coach> selectEmpListtoClubForTerm(@Param("page") Integer page, @Param("limit") Integer limit, @Param("jId") String jId, @Param("name") String name, @Param("phone") String phone, @Param("sex") String sex, @Param("cId") Integer cId);

    @Select("SELECT count(*) FROM coach where c_id = #{cId}")
    Integer selectEmpCountToClub(@Param("cId") Integer cId);

}
