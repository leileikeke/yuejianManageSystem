package com.leike.controller;

import com.leike.constant.ResponseCode;
import com.leike.pojo.PrintPic;
import com.leike.service.PrintPicService;
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
 * @description:晒图控制器
 * @author: leike
 * @date: 2019-09-05 21:15
 */
@Controller
@RequestMapping("/printPic")
public class PrintPicController {

    @Autowired
    private PrintPicService printPicService;

    /**
     * 获取course列表(带搜索功能)
     *
     * @param page
     * @param limit
     * @return
     */
    @RequestMapping("/getList")
    @ResponseBody
    public Map<String, Object> selectPrintPicList(Integer page, Integer limit) {

        Map<String, Object> map = new HashMap<>();

        Integer code = ResponseCode.FAILURE;

        Integer count = 0;

        List<PrintPic> printPics;

        String msg = "获取失败";

        printPics = printPicService.selectPrintPicList((page - 1) * limit, limit);
        if (printPics != null) {
            code = ResponseCode.TABLESUCCEED;
            msg = "";
        }

        count = printPicService.selectPrintPicCount();

        map.put("code", code);
        map.put("msg", "");
        map.put("count", count);
        map.put("data", printPics);

        return map;
    }

    /**
     * 删除course
     *
     * @param uId
     * @param picName
     * @param request
     * @return
     */
    @RequestMapping("/delete")
    @ResponseBody
    public Map<String, Object> deletePrintPic(Integer uId, String picName, HttpServletRequest request) {

        Map<String, Object> map = new HashMap<>();

        Integer code = ResponseCode.FAILURE;

        String msg = "删除失败";

        String uploadPath = request.getSession().getServletContext().getRealPath("/");

        boolean b = printPicService.deletePrintPic(uId, picName, uploadPath);
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
     * 批量删除PrintPic
     *
     * @param list
     * @param request
     * @return
     */
    @RequestMapping("/deleteAll")
    @ResponseBody
    public Map<String, Object> deletePrintPicList(@RequestBody List<PrintPic> list, HttpServletRequest request) {

        Map<String, Object> map = new HashMap<>();

        Integer code = ResponseCode.SUCCEED;

        //统计删除成功的条数
        Integer count = 0;

        String uploadPath = request.getSession().getServletContext().getRealPath("/");

        for (int i = 0; i < list.size(); i++) {

            boolean b = printPicService.deletePrintPic(list.get(i).getuId(), list.get(i).getPicName(), uploadPath);

            if (b) {
                count++;
            }

        }

        map.put("code", code);
        map.put("count", count);

        return map;
    }

}
