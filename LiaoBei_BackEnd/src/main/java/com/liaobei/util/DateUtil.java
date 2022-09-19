package com.liaobei.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author whr
 * @description 时间格式转换
 */
public class DateUtil {

    public static String pattern1 = "yyyy-MM-dd";
    public static String pattern2 = "yyyy-MM-dd HH:mm:ss";
    public static String pattern3 = "yyyy/MM/dd";
    public static String pattern4 = "yyyy/MM/dd HH:mm:ss";

//    默认转换格式为pattern2
    private static SimpleDateFormat sdf = new SimpleDateFormat(pattern2);

    public static String DateFormat(Date date){
        return sdf.format(date);
    }
//    可修改转换的格式
    public static void setPattern(String pattern){
        sdf = new SimpleDateFormat(pattern);
    }
}
