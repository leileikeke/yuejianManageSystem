package com.leike.controller;

import com.leike.constant.ResponseCode;
import com.leike.pojo.Admin;
import com.leike.pojo.Notify;
import com.leike.pojo.Recommend;
import com.leike.service.NotifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description:通知控制器
 * @author: leike
 * @date: 2019-09-05 17:19
 */
@Controller
@RequestMapping("/notify")
public class NotifyController {

    @Autowired
    private NotifyService notifyService;

    /**
     * 获取Notify列表
     *
     * @return
     */
    @RequestMapping("/getList")
    @ResponseBody
    public Map<String, Object> selectNotifyList(HttpSession session) {

        Admin admin = (Admin) session.getAttribute("SESSION_ADMIN");
        Integer id = admin.getId();

        Map<String, Object> map = new HashMap<>();

        Integer code = ResponseCode.FAILURE;

        Integer count = 0;

        List<Notify> notifies;

        Integer cId = notifyService.selectCIdById(id);

        notifies = notifyService.selectNotifyList(cId);
        if (notifies != null) {
            code = ResponseCode.TABLESUCCEED;
        }

        map.put("code", code);
        map.put("msg", "");
        map.put("count", count);
        map.put("data", notifies);

        return map;
    }

    /**
     * 删除User
     *
     * @param jId
     * @return
     */
    @RequestMapping("/delete")
    @ResponseBody
    public Map<String, Object> deleteNotify(Integer jId) {

        Map<String, Object> map = new HashMap<>();

        Integer code = ResponseCode.FAILURE;

        String msg = "删除失败";

        boolean b = notifyService.deleteNotify(jId);
        //如果成功则返回code=200
        if (b) {
            code = ResponseCode.SUCCEED;
            msg = "";
        }

        map.put("code", code);
        map.put("msg", msg);
        return map;
    }

}
