package com.leike.controller;

import com.leike.constant.ResponseCode;
import com.leike.pojo.Video;
import com.leike.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 视频控制器
 *
 * @description:
 * @author: leike
 * @date: 2019-08-16 16:10
 */
@Controller
@RequestMapping("/video")
public class VideoController {


    @Autowired
    private VideoService videoService;

    /**
     * 获取activity列表(带搜索功能)
     *
     * @param name
     * @return
     */

    @RequestMapping("/getList")
    @ResponseBody
    public Map<String, Object> selectActivityList(String name) {

        Map<String, Object> map = new HashMap<>();

        Integer code = ResponseCode.FAILURE;

        List<Video> videos;

        if (name != null && !name.equals("")) {
            videos = videoService.selectVideoListForTerm(name);
            if (videos != null) {
                code = ResponseCode.TABLESUCCEED;
            }
        } else {
            videos = videoService.selectVideoList();
            if (videos != null) {
                code = ResponseCode.TABLESUCCEED;
            }
        }

        map.put("code", code);
        map.put("msg", "");
        map.put("count", "");
        map.put("data", videos);

        return map;
    }

}
