package com.leike.mapper;

import com.leike.pojo.PrintPic;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @description:
 * @author: leike
 * @date: 2019-09-05 21:18
 */
public interface PrintPicMapper {

    List<PrintPic> selectPrintPicList(@Param("page") Integer page,@Param("limit") Integer limit);

    @Select("SELECT count(*) FROM printpic")
    int selectPrintPicCount();

    @Delete("DELETE FROM printpic WHERE u_id=#{uId}")
    int deletePrintPic(@Param("uId") Integer uId);
}
