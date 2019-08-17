package com.leike.service;

import com.leike.pojo.Video;

import java.util.List;

/**
 * @description:
 * @author: leike
 * @date: 2019-08-16 16:12
 */
public interface VideoService {

    List<Video> selectVideoListForTerm(String name);

    List<Video> selectVideoList();

}
