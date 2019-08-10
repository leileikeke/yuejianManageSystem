package com.leike.service.impl;

import com.leike.mapper.ClubMapper;
import com.leike.pojo.Club;
import com.leike.service.ClubService;
import com.leike.util.DateUtil;
import com.leike.util.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @description:
 * @author: leike
 * @date: 2019-08-09 21:54
 */
@Service("clubService")
public class ClubServiceImpl implements ClubService {

    @Autowired
    private ClubMapper clubMapper;

    @Override
    public Integer selectClubCount() {
        int i = clubMapper.selectClubCount();
        return i;
    }

    @Override
    public List<Club> selectClubList(Integer page, Integer limit) {
        List<Club> clubs = clubMapper.selectClubList(page, limit);
        return clubs;
    }

    @Override
    public List<Club> selectClubListForTerm(Integer page, Integer limit, String cId, String name, String phone) {
        List<Club> clubs = clubMapper.selectClubListForTerm(page, limit, cId, name, phone);
        return clubs;
    }

    @Override
    public boolean deleteClub(Integer cId, String pic, String uploadPath) {
        //删除服务器上的用户头像
        FileUtil.deleteFile(uploadPath,pic);

        int i = clubMapper.deleteClub(cId);
        return i == 1 ? true : false;
    }

    @Override
    public boolean updateClub(Club club, String uploadPath) {
        //获取用户原头像
        Club club1 = clubMapper.selectClub(club.getcId());
        //如果修改了用户头像则删除原头像
        if (!club.getPic().equals(club1.getPic())){
            FileUtil.deleteFile(uploadPath,club1.getPic());
        }

        int i = clubMapper.updateClub(club);
        return i == 1 ? true : false;
    }

    @Override
    public boolean queryClub(String name) {
        Club club = clubMapper.queryClub(name);
        return club == null ? true : false;
    }

    @Override
    public boolean insertClub(Club club) {
        Date date = DateUtil.getCurrentTime(new Date(), "yyyy-MM-dd");
        club.setJointime(date);
        int i = clubMapper.insertClub(club);
        return i == 1 ? true : false;
    }
}
