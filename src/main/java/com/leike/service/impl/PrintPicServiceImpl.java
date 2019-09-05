package com.leike.service.impl;

import com.leike.mapper.PrintPicMapper;
import com.leike.pojo.PrintPic;
import com.leike.service.PrintPicService;
import com.leike.util.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description:
 * @author: leike
 * @date: 2019-09-05 21:17
 */
@Service("printPicService")
public class PrintPicServiceImpl implements PrintPicService {

    @Autowired
    private PrintPicMapper printPicMapper;


    @Override
    public List<PrintPic> selectPrintPicList(Integer page, Integer limit) {
        List<PrintPic> printPics = printPicMapper.selectPrintPicList(page, limit);
        return printPics;
    }

    @Override
    public Integer selectPrintPicCount() {
        int count = printPicMapper.selectPrintPicCount();
        return count;
    }

    @Override
    public boolean deletePrintPic(Integer uId, String picName, String uploadPath) {
        //删除服务器上的用户头像
        FileUtil.deleteFile(uploadPath, picName);

        int i = printPicMapper.deletePrintPic(uId);
        return i == 1 ? true : false;
    }
}
