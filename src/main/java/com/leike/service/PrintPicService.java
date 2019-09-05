package com.leike.service;

import com.leike.pojo.PrintPic;

import java.util.List;

/**
 * @description:
 * @author: leike
 * @date: 2019-09-05 21:17
 */
public interface PrintPicService {

    List<PrintPic> selectPrintPicList(Integer page, Integer limit);

    Integer selectPrintPicCount();

    boolean deletePrintPic(Integer uId, String picName, String uploadPath);
}
