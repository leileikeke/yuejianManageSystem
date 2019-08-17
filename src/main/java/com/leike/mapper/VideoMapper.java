package com.leike.mapper;

import com.leike.pojo.Video;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @description:
 * @author: leike
 * @date: 2019-08-16 16:14
 */
public interface VideoMapper {

    List<Video> selectVideoList();

    List<Video> selectVideoListForTerm(@Param("name") String name);
}
