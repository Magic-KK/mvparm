package com.btten.mvparm.util;

import android.text.TextUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 日期相关工具类
 *
 * @author frj
 */
public class DateUtils {

    /**
     * 默认的日期格式
     */
    private static final String DEFAULT_FORMAT = "yyyy-MM-dd";

    /**
     * 一天的毫秒
     */
    private static final long THE_MS_OF_DAY = 1000 * 60 * 60 * 24;

    /**
     * 判断当前日期是星期几
     *
     * @param pTime 设置的需要判断的时间 //格式如2012-09-08
     * @return dayForWeek 判断结果
     */
    public static String getWeek(String pTime) {
        String Week = "";
        SimpleDateFormat format = new SimpleDateFormat(DEFAULT_FORMAT);
        Calendar c = Calendar.getInstance();
        try {

            c.setTime(format.parse(pTime));

        } catch (ParseException e) {
            e.printStackTrace();
        }
        if (c.get(Calendar.DAY_OF_WEEK) == 1) {
            Week += "周日";
        }
        if (c.get(Calendar.DAY_OF_WEEK) == 2) {
            Week += "周一";
        }
        if (c.get(Calendar.DAY_OF_WEEK) == 3) {
            Week += "周二";
        }
        if (c.get(Calendar.DAY_OF_WEEK) == 4) {
            Week += "周三";
        }
        if (c.get(Calendar.DAY_OF_WEEK) == 5) {
            Week += "周四";
        }
        if (c.get(Calendar.DAY_OF_WEEK) == 6) {
            Week += "周五";
        }
        if (c.get(Calendar.DAY_OF_WEEK) == 7) {
            Week += "周六";
        }
        return Week;
    }

    /**
     * 判断str和str1的日期大小
     *
     * @param str
     * @param str1
     * @param type yyyy-MM-dd
     * @return true or false str大返回true否则false
     */
    public static boolean isDateError(String str, String str1, String type) {
        SimpleDateFormat df = new SimpleDateFormat(type);
        Date date = null;
        Date date1 = null;
        try {
            date = df.parse(str);
            date1 = df.parse(str1);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        long time = date.getTime();
        long time1 = date1.getTime();
        if (time > time1) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 获取两个日期之间的时间间隔
     *
     * @param date1 不为空，否则返回-1
     * @param date2 不为空，否则返回-1
     * @return 如果返回-1，表示当前参数不合法。
     */
    public static int getDateIntervel(Date date1, Date date2) {
        if (date1 == null || date2 == null) {
            return -1;
        }
        long l_date1 = date1.getTime();
        long l_date2 = date2.getTime();
        long intervel = Math.abs(l_date1 - l_date2);
        return (int) (intervel / THE_MS_OF_DAY);
    }

    /**
     * 日期转换成字符串
     *
     * @param date
     * @return str “yyyy-MM-dd”格式的字符串
     */
    public static String DateToStr(Date date) {
        return DateToStr(date, DEFAULT_FORMAT);
    }

    /**
     * 日期转换成字符串
     *
     * @param date
     * @return str
     */
    public static String DateToStr(Date date, String type) {

        String str = "";
        try {
            SimpleDateFormat format = new SimpleDateFormat(type);
            str = format.format(date);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return str;
    }

    /**
     * @param str 日期字符串
     * @return 如果是那么返回true
     * @author：frj 功能:判断日期是否是今天 使用方法：
     */
    public static boolean isToday(String str) {
        Date date = StrToDate(str, DEFAULT_FORMAT);
        return isToday(date);
    }

    /**
     * @param date 日期对象
     * @return 如果是那么返回true
     * @author：frj 功能:判断日期是否是今天 使用方法：
     */
    public static boolean isToday(Date date) {
        String str = DateToStr(date, DEFAULT_FORMAT);
        Date toDay = new Date();
        String str_today = DateToStr(toDay, DEFAULT_FORMAT);
        if (str.equals(str_today)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * @param week
     * @return
     * @author：Frj 功能:获取星期几 使用方法：
     */
    public static String getWeek(int week) {
        String str = "";
        if (week == 1) {
            str = "星期天";
        } else if (week == 2) {
            str = "星期一";
        } else if (week == 3) {
            str = "星期二";
        } else if (week == 4) {
            str = "星期三";
        } else if (week == 5) {
            str = "星期四";
        } else if (week == 6) {
            str = "星期五";
        } else if (week == 7) {
            str = "星期六";
        }
        return str;
    }

    /**
     * 字符串转换成日期
     *
     * @param str
     * @return date
     */
    public static Date StrToDate(String str, String type) {

        SimpleDateFormat format = new SimpleDateFormat(type);
        Date date = null;
        try {
            date = format.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    /**
     * 字符串转换成日期 默认根据“yyyy-MM-dd”格式转
     *
     * @return date
     */
    public static Date StrToDate(String str) {

        SimpleDateFormat format = new SimpleDateFormat(DEFAULT_FORMAT);
        Date date = null;
        try {
            date = format.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    /**
     * 显示时间戳转化"yyyy-MM-dd"格式
     *
     * @param str
     * @return date
     */
    public static String getDate(String str) {
        String date = "";
        long time = 0;
        try {
            time = Long.parseLong(str);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        SimpleDateFormat format = new SimpleDateFormat(DEFAULT_FORMAT);
        date = format.format(time * 1000);
        return date;
    }

    /**
     * 功能：获取本周的开始时间 示例：2013-05-13 00:00:00
     */
    public static Date getWeekStart() {// 当周开始时间
        Calendar currentDate = Calendar.getInstance();
        currentDate.setFirstDayOfWeek(Calendar.MONDAY);
        currentDate.set(Calendar.HOUR_OF_DAY, 0);
        currentDate.set(Calendar.MINUTE, 0);
        currentDate.set(Calendar.SECOND, 0);
        currentDate.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        return currentDate.getTime();
    }

    /**
     * 功能：获取本周的结束时间 示例：2013-05-19 23:59:59
     */
    public static Date getWeekEnd() {// 当周结束时间
        Calendar currentDate = Calendar.getInstance();
        currentDate.setFirstDayOfWeek(Calendar.MONDAY);
        currentDate.set(Calendar.HOUR_OF_DAY, 23);
        currentDate.set(Calendar.MINUTE, 59);
        currentDate.set(Calendar.SECOND, 59);
        currentDate.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
        return currentDate.getTime();
    }

    /**
     * 获取当月的开始日期
     *
     * @return
     */
    public static Date getMonthStart() {
        Calendar cal = Calendar.getInstance();// 获取日历实例
        cal.setTime(new Date());// cal设置为当天的
        cal.set(Calendar.DATE, 1);// cal设置当前day为当前月第一天
        return cal.getTime();
    }

    /**
     * 获取指定日期当前月份的天数
     *
     * @return
     */
    public static int getMonthDays(Date date) {
        Calendar calendar = Calendar.getInstance();
        if (date == null) {
            date = new Date();
        }
        calendar.setTime(date);
        int day = calendar.getActualMaximum(Calendar.DATE);
        return day;
    }

    /**
     * 获取指定日期当前月份的天数
     *
     * @param date 日期字符串 格式"yyyy-MM-dd"
     * @return
     */
    public static int getMonthDays(String date) {
        if (TextUtils.isEmpty(date)) {
            return getMonthDays(new Date());
        }
        return getMonthDays(StrToDate(date));
    }

    /**
     * 功能：获取该天的开始时间：2013-05-13 00:00:00
     */
    public static Date getDayStart(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        return calendar.getTime();
    }

    /**
     * 功能：增加时间,单位分钟
     *
     * @return 增加时间后的日期
     */
    public static Date addInterval(Date date, int minute) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.MINUTE, calendar.get(Calendar.MINUTE) + minute);
        return calendar.getTime();
    }

    /**
     * 根据年月日拼接日期
     *
     * @paramisMonth 表示是否是月数据
     */
    public static Date getDateString(String year, String month, String day) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Integer.valueOf(year, 16) + 2000, Integer.valueOf(month, 16) - 1, Integer.valueOf(day, 16));
        return calendar.getTime();
    }

    /**
     * 获取日期的年
     */
    public static byte getByteYear(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return (byte) ((calendar.get(Calendar.YEAR) - 2000) & 0xff);
    }

    /**
     * 获取日期的月
     */
    public static byte getByteMonth(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return (byte) ((calendar.get(Calendar.MONTH) + 1) & 0xff);
    }

    /**
     * 获取日期的日
     */
    public static byte getByteDay(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return (byte) (calendar.get(Calendar.DAY_OF_MONTH) & 0xff);
    }

    /**
     * 功能：获取当前年月日时分秒
     */
    public static byte[] getDayValue() {
        Calendar calendar = Calendar.getInstance();
        byte[] today = new byte[6];
        today[0] = (byte) ((calendar.get(Calendar.YEAR) - 2000) & 0xff);
        today[1] = (byte) ((calendar.get(Calendar.MONTH) + 1) & 0xff);
        today[2] = (byte) (calendar.get(Calendar.DAY_OF_MONTH) & 0xff);
        today[3] = (byte) (calendar.get(Calendar.HOUR_OF_DAY) & 0xff);
        today[4] = (byte) (calendar.get(Calendar.MINUTE) & 0xff);
        today[5] = (byte) (calendar.get(Calendar.SECOND) & 0xff);
        return today;
    }

    /**
     * 功能：获取上一天
     */
    public static Date getLastDay(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, -1);
        return calendar.getTime();
    }

}
