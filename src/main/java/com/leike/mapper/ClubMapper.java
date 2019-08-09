package com.leike.mapper;

import com.leike.pojo.Club;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @description:
 * @author: leike
 * @date: 2019-08-09 21:55
 */
public interface ClubMapper {


    @Select("SELETE count(*) FROM club")
    int selectClubCount();

    @Select("SELECT * FROM club limit #{page},#{limit}")
    List<Club> selectClubList(@Param("page") Integer page,@Param("limit") Integer limit);

    List<Club> selectClubListForTerm(Integer page, Integer limit, String cId, String name, String phone);
}
