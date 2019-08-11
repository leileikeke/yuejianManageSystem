package com.leike.controller;

import com.leike.constant.ResponseCode;
import com.leike.service.UploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * 上传通用控制器
 *
 * @description:
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
    @ResponseBody
    public Map<String, Object> uploadPic(@RequestParam("file") MultipartFile multipartFile, String addr, HttpServletRequest request) {
        addr = "/static/imgs/" + addr + "/";
        Map<String, Object> map = new HashMap<>();

        Integer code = ResponseCode.FAILURE;

        String msg = "上传失败";


        // 1.不为空才上传
        if (multipartFile != null && !multipartFile.isEmpty()) {

            String uploadPath = request.getSession().getServletContext().getRealPath("/");
            String picName = uploadService.uploadPic(multipartFile, uploadPath,addr);

            if (picName != null) {
                code = ResponseCode.SUCCEED;
                msg = "上传成功";
                map.put("picName", picName);
            }
        }

        map.put("code", code);
        map.put("msg", msg);

        return map;
    }
}
