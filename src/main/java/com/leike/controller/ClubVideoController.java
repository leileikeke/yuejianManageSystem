package com.leike.controller;

import com.leike.constant.ResponseCode;
import com.leike.pojo.Video;
import com.leike.service.ClubVideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
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
public class ClubVideoController {


    @Autowired
    private ClubVideoService clubVideoService;

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
            videos = clubVideoService.selectVideoListForTerm(name);
            if (videos != null) {
                code = ResponseCode.TABLESUCCEED;
            }
        } else {
            videos = clubVideoService.selectVideoList();
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

    /**
     * 删除教练
     *
     * @param vId
     * @param video
     * @return
     */
    @RequestMapping("/delete")
    @ResponseBody
    public Map<String, Object> deleteVideo(Integer vId, String video, HttpServletRequest request) {

        Map<String, Object> map = new HashMap<>();

        Integer code = ResponseCode.FAILURE;

        String msg = "删除失败";

        String uploadPath = request.getSession().getServletContext().getRealPath("/");

        boolean b = clubVideoService.deleteVideo(vId, video, uploadPath);
        //如果成功则返回code=200
        if (b) {
            code = ResponseCode.SUCCEED;
            msg = "";
        }

        map.put("code", code);
        map.put("msg", msg);
        return map;
    }

    /**
     * 批量删除视频
     *
     * @param list
     * @return
     */
    @RequestMapping("/deleteAll")
    @ResponseBody
    public Map<String, Object> deleteVideoList(@RequestBody List<Video> list, HttpServletRequest request) {

        Map<String, Object> map = new HashMap<>();

        Integer code = ResponseCode.SUCCEED;

        //统计删除成功的条数
        Integer count = 0;

        String uploadPath = request.getSession().getServletContext().getRealPath("/");

        for (int i = 0; i < list.size(); i++) {

            boolean b = clubVideoService.deleteVideo(list.get(i).getvId(), list.get(i).getVideo(), uploadPath);

            if (b) {
                count++;
            }

        }

        map.put("code", code);
        map.put("count", count);

        return map;
    }

}
