package com.leike.mapper;

import com.leike.pojo.Video;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @description:
 * @author: leike
 * @date: 2019-08-16 16:14
 */
public interface ClubVideoMapper {

    List<Video> selectVideoList();

    List<Video> selectVideoListForTerm(@Param("name") String name);

    @Delete("DELETE FROM video WHERE v_id = #{vId}")
    int deleteVideo(@Param("vId") Integer vId);

    @Select("SELECT video FROM video WHERE v_id = #{vId}")
    String selectVideoForVideo(@Param("vId") Integer vId);

    @Update("UPDATE video SET name = #{name},video=#{video} where v_id = #{vId}")
    int updateVideo(Video video);

    @Select("SELECT c_id FROM club WHERE id = #{id}")
    int queryCIdForId(@Param("id") Integer id);

    @Select("SELECT * FROM video WHERE c_id = #{cId}")
    Video queryVideoForCId(@Param("cId") Integer cId);
}
