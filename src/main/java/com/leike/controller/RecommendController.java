package com.leike.controller;

import com.leike.constant.ResponseCode;
import com.leike.pojo.Coach;
import com.leike.pojo.Recommend;
import com.leike.service.RecommendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author: leike
 * @date: 2019-08-15 1:34
 */
@Controller
@RequestMapping("/recommend")
public class RecommendController {

    @Autowired
    private RecommendService recommendService;

    /**
     * 获取user列表(带搜索功能)
     *
     * @return
     */
    @RequestMapping("/getList")
    @ResponseBody
    public Map<String, Object> selectCoacheList() {

        Map<String, Object> map = new HashMap<>();

        Integer code = ResponseCode.FAILURE;

        Integer count = 0;

        List<Recommend> recommends;

        recommends = recommendService.selectRecommendList();
        if (recommends != null) {
            code = ResponseCode.TABLESUCCEED;
        }

        map.put("code", code);
        map.put("msg", "");
        map.put("count", count);
        map.put("data", recommends);

        return map;
    }

    /**
     * 更新审核状态
     *
     * @param jId
     * @return
     */
    @RequestMapping("/updateState")
    @ResponseBody
    public Map<String, Object> updateState(Integer jId) {

        Map<String, Object> map = new HashMap<>();

        Integer code = ResponseCode.FAILURE;

        String msg = "审核失败";

        boolean b = recommendService.updateState(jId);
        if (b) {
            code = ResponseCode.SUCCEED;
            msg = "审核成功";
        }


        map.put("code", code);
        map.put("msg", msg);

        return map;
    }

}
