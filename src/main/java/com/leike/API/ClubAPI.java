package com.leike.API;

import com.leike.constant.ResponseCode;
import com.leike.pojo.Club;
import com.leike.service.ClubService;
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
 * @description:
 * @author: leike
 * @date: 2019-08-27 19:23
 */
@Controller
@RequestMapping("/api/club/")
public class ClubAPI {

    @Autowired
    private ClubService clubService;

    /**
     * 获取club列表(带搜索功能)
     * @param page
     * @param limit
     * @param cId
     * @param name
     * @param phone
     * @return
     */
    @RequestMapping("/getList")
    @ResponseBody
    public Map<String, Object> selectClubList(Integer page, Integer limit, String cId, String name, String phone) {

        if ((cId != null && !cId.equals("")) || (name != null && !name.equals("")) || (phone != null && !phone.equals(""))){
            page = 1;
            limit = 1000;
        }

        Map<String, Object> map = new HashMap<>();

        Integer code = ResponseCode.FAILURE;

        Integer count = 0;

        List<Club> clubs;

        if ((cId != null && !cId.equals("")) || (name != null && !name.equals("")) || (phone != null && !phone.equals(""))) {
            clubs = clubService.selectClubListForTerm((page - 1) * limit, limit, cId, name, phone);
            if (clubs != null) {
                code = ResponseCode.TABLESUCCEED;
            }
        } else {
            clubs = clubService.selectClubList((page - 1) * limit, limit);
            if (clubs != null) {
                code = ResponseCode.TABLESUCCEED;
            }
        }

        count = clubService.selectClubCount();

        map.put("code", code);
        map.put("msg", "");
        map.put("count", count);
        map.put("data", clubs);

        return map;
    }


}
