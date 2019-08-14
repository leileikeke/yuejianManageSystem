package com.leike.mapper;

import com.leike.pojo.Club;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @description:
 * @author: leike
 * @date: 2019-08-09 21:55
 */
public interface ClubMapper {

    @Select("SELECT count(*) FROM club")
    int selectClubCount();


    List<Club> selectClubList(@Param("page") Integer page,@Param("limit") Integer limit);

    List<Club> selectClubListForTerm(@Param("page") Integer page,@Param("limit") Integer limit,@Param("cId") String cId,@Param("name") String name,@Param("phone") String phone);

    @Delete("DELETE FROM club WHERE c_id = #{cId}")
    int deleteClub(@Param("cId") Integer cId);

    @Select("SELECT pic FROM club WHERE c_id = #{cId}")
    String selectClubPic(@Param("cId") Integer cId);

    @Update("UPDATE club SET name = #{name},phone = #{phone},pic = #{pic},intro = #{intro},address = #{address} where c_id = #{cId}")
    int updateClub(Club club);

    @Select("SELECT * FROM club WHERE name = #{name}")
    Club queryClub(@Param("name") String name);

    int insertClub(Club club);

    @Select("SELECT * FROM club WHERE id = #{id}")
    Club queryClubforid(@Param("id") Integer id);

    @Select("select id from admin where name = #{aName}")
    Integer selectAdminId(String aName);

    @Select("SELECT name FROM admin WHERE id = #{id}")
    String queryAdminName(@Param("id") Integer id);
}
