package com.leike.util;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
/**
 * @description:
 * @author: leike
 * @date: 2019-08-06 23:41
 */
public class DateUtil {
    /**
     * 日期转化为字符串
     * @param date 日期
     * @param format 转换的形式
     * @return 日期字符串
     */
    public static String formatDate(Date date,String format){
        SimpleDateFormat sdf= new SimpleDateFormat(format);
        if(date!=null)
            return sdf.format(date);
        return null;
    }

    /**
     * 当前日期转化为特定字符串
     * @return 日期字符串
     */
    public static String getCurrentDateString(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        return sdf.format(new Date());
    }

    /**
     * 字符串转化为日期
     * @param str 字符串
     * @param format 形式
     * @return 日期
     * @throws ParseException
     */
    public static Date formatString(String str, String format) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        if(str!=null)
            return sdf.parse(str);
        return null;
    }
}
