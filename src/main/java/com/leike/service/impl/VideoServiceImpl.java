package com.leike.service.impl;

import com.leike.mapper.VideoMapper;
import com.leike.pojo.Video;
import com.leike.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @description:
 * @author: leike
 * @date: 2019-08-16 16:12
 */
@Service("videoService")
public class VideoServiceImpl implements VideoService {

    @Autowired
    private VideoMapper videoMapper;

    @Override
    public List<Video> selectVideoListForTerm(String name) {
        videoMapper.selectVideoListForTerm(name);
        return null;
    }

    @Override
    public List<Video> selectVideoList() {
        List<Video> videos = videoMapper.selectVideoList();
        return videos;
    }

}
