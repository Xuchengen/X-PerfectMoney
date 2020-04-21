package com.github.xuchengen.pm.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * 日期工具类<br>
 * 作者：徐承恩<br>
 * 邮箱：xuchengen@gmail.com<br>
 * 日期：2020/4/17 2:02 下午<br>
 */
public class DateTool {

    public static final String ENGLISH_DATETIME = "MM/dd/yyyy HH:mm";

    /**
     * 忽略时间部分比较两个日期相差的天数
     *
     * @param startDate 开始日期
     * @param endDate   结束日期
     * @return 天数
     */
    public static long betweenDay(Date startDate, Date endDate) {
        long diff;
        startDate = beginOfDay(startDate);
        endDate = beginOfDay(endDate);

        if (startDate.after(endDate)) {
            diff = startDate.getTime() - endDate.getTime();
        } else {
            diff = endDate.getTime() - startDate.getTime();
        }
        return diff / TimeUnit.DAYS.toMillis(1);
    }

    /**
     * 获取日期的开始时间
     *
     * @param date 日期
     * @return 日期
     */
    public static Date beginOfDay(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }

    /**
     * 转日期
     *
     * @param dateString 日期字符串
     * @param format     格式字符串
     * @return 日期
     */
    public static Date toDate(String dateString, String format) {
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
            return simpleDateFormat.parse(dateString);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
}
