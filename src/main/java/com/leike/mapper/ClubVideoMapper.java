package com.leike.mapper;

import com.leike.pojo.Video;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;

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
}
