package com.leike.API;

import com.leike.constant.ResponseCode;
import com.leike.pojo.Coach;
import com.leike.service.ClubEmpService;
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
 * @date: 2019-08-27 21:24
 */
@Controller
@RequestMapping("/api/clubEmp")
public class ClubEmpAPI {

    @Autowired
    ClubEmpService clubEmpService;

    /**
     * 获取员工列表(带搜索功能)
     *
     * @param cId  俱乐部id
     * @param page
     * @param limit
     * @return
     */
    @RequestMapping("/getList")
    @ResponseBody
    public Map<String, Object> selectEmpList(Integer cId, Integer page, Integer limit) {

        Map<String, Object> map = new HashMap<>();

        Integer code = ResponseCode.FAILURE;

        Integer count = 0;

        List<Coach> coaches;

        coaches = clubEmpService.selectEmpListToClub1(cId,(page - 1) * limit, limit);
        if (coaches != null) {
            code = ResponseCode.TABLESUCCEED;
        }

        map.put("code", code);
        map.put("msg", "");
        map.put("data", coaches);

        return map;
    }

}
