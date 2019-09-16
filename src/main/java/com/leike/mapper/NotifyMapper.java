package com.leike.mapper;

import com.leike.pojo.Notify;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @description:
 * @author: leike
 * @date: 2019-09-05 16:33
 */
public interface NotifyMapper {


    @Select("SELECT count(*) FROM notify WHERE c_id=#{cId}")
    int selectNotifyCount(@Param("cId") Integer cId);

    List<Notify> selectNotifyList(@Param("cId") Integer cId);

    @Select("SELECT c_id FROM club WHERE id = #{id}")
    int selectCIdById(@Param("id") Integer id);

    @Select("SELECT nickname FROM admin WHERE id=#{id}")
    String queryAdminNameById(@Param("id") Integer id);

    @Delete("DELETE FROM notify WHERE j_id=#{jId}")
    int deleteNotify(@Param("jId") Integer jId);
}
