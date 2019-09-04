package com.leike.service.impl;

import com.leike.mapper.ClubVideoMapper;
import com.leike.pojo.Video;
import com.leike.service.ClubVideoService;
import com.leike.util.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description:
 * @author: leike
 * @date: 2019-08-16 16:12
 */
@Service("videoService")
public class ClubVideoServiceImpl implements ClubVideoService {

    @Autowired
    private ClubVideoMapper clubVideoMapper;

    @Override
    public List<Video> selectVideoListForTerm(String name) {
        List<Video> videos = clubVideoMapper.selectVideoListForTerm(name);
        return videos;
    }

    @Override
    public List<Video> selectVideoList() {
        List<Video> videos = clubVideoMapper.selectVideoList();
        return videos;
    }

    @Override
    public boolean deleteVideo(Integer vId, String video, String uploadPath) {
        //删除服务器上的视频
        FileUtil.deleteFile(uploadPath, video);

        int i = clubVideoMapper.deleteVideo(vId);
        return i == 1 ? true : false;
    }

    @Override
    public boolean updateVideo(Video video, String uploadPath) {
        //获取原视频
        String videoName = clubVideoMapper.selectVideoForVideo(video.getvId());
        //如果修改了视频则删除原视频
        if (!video.getVideo().equals(videoName)) {
            FileUtil.deleteFile(uploadPath, videoName);
        }

        int i = clubVideoMapper.updateVideo(video);
        return i == 1 ? true : false;
    }

    @Override
    public Video queryVideoForId(Integer id) {
        Integer cId = clubVideoMapper.queryCIdForId(id);
        Video video = clubVideoMapper.queryVideoForCId(cId);
        return video;
    }
}
