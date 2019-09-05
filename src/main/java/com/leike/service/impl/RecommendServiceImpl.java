package com.leike.service.impl;

import com.leike.mapper.RecommendMapper;
import com.leike.pojo.Recommend;
import com.leike.service.RecommendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @description:
 * @author: leike
 * @date: 2019-08-15 1:37
 */
@Service("recommendService")
public class RecommendServiceImpl implements RecommendService {

    @Autowired
    private RecommendMapper recommendMapper;

    @Override
    public List<Recommend> selectRecommendList() {
        List<Recommend> recommends = recommendMapper.selectRecommendList();

        for (Recommend recommend : recommends) {
            Date checktime = recommendMapper.selectChecktimeByJId(recommend.getjId());
            recommend.setChecktime(checktime);
        }
        return recommends;
    }

    @Override
    public boolean updateState(Integer jId, Boolean state, Integer cId, Integer id) {
        int i = recommendMapper.deleteRecommend(jId);

        if (i == 1) {
            if (state) {
                int i1 = recommendMapper.updateCoachState(jId);
                int i2 = recommendMapper.insertNotity(jId, state, cId, id);
                if (i1 != 1 || i2 != 1) {
                    return false;
                }
            } else {
                int i3 = recommendMapper.insertNotity(jId, state, cId, id);
                if (i3 != 1) {
                    return false;
                }
            }
        }

        if (i == 1) {
            return true;
        }

        return false;
    }

    @Override
    public Integer selectRecommendCount() {
        int i = recommendMapper.selectRecommendCount();
        return i;
    }
}
