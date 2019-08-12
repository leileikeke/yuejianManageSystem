package com.leike.controller;

import com.leike.constant.ResponseCode;
import com.leike.pojo.Club;
import com.leike.service.ClubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 俱乐部控制器
 * @description:
 * @author: leike
 * @date: 2019-08-09 21:52
 */
@Controller
@RequestMapping("/club")
public class ClubController {

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

    /**
     * 修改俱乐部信息
     * @param club
     * @param request
     * @return
     */
    @RequestMapping("/update")
    @ResponseBody
    public Map<String, Object> updateUser(@RequestBody Club club, HttpServletRequest request) {

        Map<String, Object> map = new HashMap<>();

        Integer code = ResponseCode.FAILURE;

        String msg = "更新俱乐部信息失败";

        String uploadPath = request.getSession().getServletContext().getRealPath("/");
        boolean b = clubService.updateClub(club, uploadPath);

        if (b) {
            code = ResponseCode.SUCCEED;
            msg = "";
        }

        map.put("code", code);
        map.put("msg", msg);

        return map;
    }

    /**
     * 添加俱乐部
     * @param club
     * @return
     */
    @RequestMapping("/add")
    @ResponseBody
    public Map<String, Object> addClub(@RequestBody Club club) {

        Map<String, Object> map = new HashMap<>();

        Integer code = ResponseCode.FAILURE;

        String msg = "添加失败";

        boolean bool = clubService.queryClub(club.getName());
        if (bool) {
            if (club != null) {

                boolean b = clubService.insertClub(club);
                if (b) {
                    code = ResponseCode.SUCCEED;
                    msg = "";
                }

            }
        } else {
            msg = "此俱乐部已存在!";
        }

        map.put("code", code);
        map.put("msg", msg);

        return map;
    }


    /**
     * 删除俱乐部
     * @param cId
     * @param pic
     * @param request
     * @return
     */
    @RequestMapping("/delete")
    @ResponseBody
    public Map<String, Object> deleteClub(Integer cId, String pic, HttpServletRequest request) {

        Map<String, Object> map = new HashMap<>();

        Integer code = ResponseCode.FAILURE;

        String msg = "删除失败";

        String uploadPath = request.getSession().getServletContext().getRealPath("/");

        boolean b = clubService.deleteClub(cId, pic, uploadPath);
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
     * 批量删除俱乐部
     * @param list
     * @param request
     * @return
     */
    @RequestMapping("/deleteAll")
    @ResponseBody
    public Map<String, Object> deleteUserList(@RequestBody List<Club> list, HttpServletRequest request) {

        Map<String, Object> map = new HashMap<>();

        Integer code = ResponseCode.SUCCEED;

        //统计删除成功的条数
        Integer count = 0;

        String uploadPath = request.getSession().getServletContext().getRealPath("/");

        for (int i = 0; i < list.size(); i++) {

            boolean b = clubService.deleteClub(list.get(i).getcId(), list.get(i).getPic(), uploadPath);

            if (b) {
                count++;
            }

        }

        map.put("code", code);
        map.put("count", count);

        return map;
    }

    /**
     * 通过管理员id查club
     * @param id
     * @return
     */
    @RequestMapping("/query")
    @ResponseBody
    public Map<String, Object> queryClubforid(Integer id) {


        Map<String, Object> map = new HashMap<>();

        Integer code = ResponseCode.FAILURE;

        Club club = clubService.queryClubforid(id);
        if (club != null) {
            code = ResponseCode.SUCCEED;
        }

        map.put("code", code);
        map.put("data", club);

        return map;

    }

}
