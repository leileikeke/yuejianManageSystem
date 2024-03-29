package com.leike.controller;

import com.leike.constant.ResponseCode;
import com.leike.service.UploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @description:上传通用控制器
 * @author: leike
 * @date: 2019-08-11 18:17
 */

@Controller
@RequestMapping("/upload")
public class UploadController {

    @Autowired
    private UploadService uploadService;

    /**
     * 上传图片
     *
     * @param multipartFile
     * @param request
     * @return
     */
    @RequestMapping("/pic")
    @PostMapping
    @ResponseBody
    public Map<String, Object> uploadPic(@RequestParam("file") MultipartFile multipartFile, String addr, HttpServletRequest request) {
        addr = "/static/imgs/" + addr + "/";
        Map<String, Object> map = new HashMap<>();

        Integer code = ResponseCode.FAILURE;

        String msg = "上传失败";

        // 1.不为空才上传
        if (multipartFile != null && !multipartFile.isEmpty()) {

            String uploadPath = request.getSession().getServletContext().getRealPath("/");
            String picName = uploadService.uploadFile(multipartFile, uploadPath, addr);

            if (picName != null) {
                code = ResponseCode.SUCCEED;
                msg = "上传成功";
                //返回新名字
                map.put("picName", picName);
            }
        }

        map.put("code", code);
        map.put("msg", msg);

        return map;
    }

    /**
     * 上传视频
     *
     * @param multipartFile
     * @param request
     * @return
     */
    @RequestMapping("/video")
    @ResponseBody
    public Map<String, Object> uploadVideo(@RequestParam("file") MultipartFile multipartFile, HttpServletRequest request) {
        String addr = "/static/videos/";
        Map<String, Object> map = new HashMap<>();

        Integer code = ResponseCode.FAILURE;

        String msg = "上传失败请重试";


        // 1.不为空才上传
        if (multipartFile != null && !multipartFile.isEmpty()) {

            String uploadPath = request.getSession().getServletContext().getRealPath("/");
            String videoName = uploadService.uploadFile(multipartFile, uploadPath, addr);

            if (videoName != null) {
                code = ResponseCode.SUCCEED;
                msg = "上传成功";
                //返回新名字
                map.put("videoName", videoName);
            }
        }

        map.put("code", code);
        map.put("msg", msg);

        return map;
    }
}
