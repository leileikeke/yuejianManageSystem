package com.leike.service;

import com.leike.pojo.Video;

import java.util.List;

/**
 * @description:
 * @author: leike
 * @date: 2019-08-16 16:12
 */
public interface ClubVideoService {

    List<Video> selectVideoListForTerm(String name);

    List<Video> selectVideoList();

    boolean deleteVideo(Integer vId, String video, String uploadPath);
}
