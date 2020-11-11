package com.znv.peim.bpm.common.utils;

import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang3.StringUtils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.function.BiFunction;
import java.util.stream.LongStream;
import java.util.stream.Stream;

import static java.util.concurrent.TimeUnit.MILLISECONDS;
import static org.apache.commons.lang3.time.DateUtils.addDays;

/**
 * 日期处理
 *
 * @date 2016年12月21日 下午12:53:33
 */
@Log4j2
public class DateUtils {

    public final static String DATE_PATTERN = "yyyy-MM-dd";
    public final static String DATE_MONTH_PATTERN = "yyyy-MM";
    public final static String DATE_TIME_PATTERN = "yyyy-MM-dd HH:mm:ss";
    public final static String YEAR_PATTERN = "yyyy";
    public final static String YEAR_MONTH_PATTERN = "yyyyMM";
    public final static String YEAR_MONTH_DAY_PATTERN = "yyyyMMdd";
    private static List<String> monthlist;
    private static List<String> datelist2;
    private static List<String> daylist;

    /**
     * 日期格式化 日期格式为：yyyy-MM-dd
     *
     * @param date 日期
     * @return 返回yyyy-MM-dd格式日期
     */
    public static String format(Date date) {
        return format(date, DATE_PATTERN);
    }

    /**
     * 日期格式化 日期格式为：yyyy-MM-dd
     *
     * @param date    日期
     * @param pattern 格式，如：DateUtils.DATE_TIME_PATTERN
     * @return 返回yyyy-MM-dd格式日期
     */
    public static String format(Date date, String pattern) {
        if (date != null) {
            SimpleDateFormat df = new SimpleDateFormat(pattern);
            return df.format(date);
        }
        return null;
    }

    /**
     * 字符串转换成日期
     *
     * @param strDate 日期字符串
     * @param pattern 日期的格式，如：DateUtils.DATE_TIME_PATTERN
     */
    public static Date stringToDate(String strDate, String pattern) {
        if (StringUtils.isBlank(strDate)) {
            return null;
        }
        DateFormat dateFormat = new SimpleDateFormat(pattern);
        try {
            return dateFormat.parse(strDate);
        } catch (ParseException e) {
            log.error(e.getMessage());
        }
        return null;
    }

    public static String parse(String strDate, String inputPattern, String outputPattern) {
        if (StringUtils.isNotBlank(strDate)) {
            Date date = stringToDate(strDate, inputPattern);
            return format(date, outputPattern);
        }
        return null;
    }

    /**
     * 获取最近半点或者整点数据
     * 例如：晚上12点记录的是前晚11:30-12:00之间数据 记录时间算11:30
     *
     * @return dateStr
     */
    public static String halfHour() {
        String minuteStr = "00";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH");
        Calendar cal = Calendar.getInstance();

        cal.add(Calendar.MINUTE, -30);
        Date time = cal.getTime();
        String hourStr = sdf.format(time);

        int minute = cal.get(Calendar.MINUTE);
        if (minute >= 30) {
            minuteStr = "30";
        }
        return hourStr + ":" + minuteStr + ":00";
    }

    /**
     * 得到服务器的当前时间
     *
     * @return
     */
    public static Date getCurrentDate() {
        return new Date(System.currentTimeMillis());
    }

    public static String getFormatDateMonth() {
        Date date = getCurrentDate();
        SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_MONTH_PATTERN);
        return dateFormat.format(date);
    }

    /**
     * 传入日期获得当前日期所在月的天数
     *
     * @param date yyyy-mm-dd
     */
    public static int getDaysOfMonth(String date) {
        Calendar calendar = Calendar.getInstance();
        Date date1 = null;
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        try {
            date1 = format.parse(date);
        } catch (ParseException e) {
            log.error(e.getMessage());
        }
        calendar.setTime(date1);
        return calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
    }

    /**
     * 获取月的list
     */
    public static List<String> getMonthOfYear() {
        if (monthlist == null) {
            monthlist = new ArrayList<>();
            for (int i = 1; i <= 12; i++) {
                monthlist.add(i + "月");
            }
        }
        return monthlist;
    }

    //通过天数获取放i号格式的数据的list

    public static List<String> getDaysListOfMonth(int daysOfMonth) {
        //不考虑过高并发，仅加单层锁
        if (datelist2 == null) {
            datelist2 = new ArrayList<>();
            for (int i = 1; i <= daysOfMonth; i++) {
                datelist2.add(i + "号");
            }
        }
        return datelist2;
    }

    public static List<String> getHoursOfDay() {
        //不考虑过高并发，仅加单层锁
        if (daylist == null) {
            daylist = new ArrayList<>();
            for (int i = 1; i <= 24; i++) {
                daylist.add(i + "时");
            }
        }
        return daylist;
    }

    public static String addDateTime(int num, String date) {
        Calendar calendar = Calendar.getInstance();
        Date date1 = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            date1 = sdf.parse(date);
        } catch (ParseException e) {
            log.error(e.getMessage());
        }
        calendar.setTime(date1);
        calendar.add(Calendar.DATE, num);
        Date time = calendar.getTime();
        return sdf.format(time);
    }

    public static String today() {
        return format(new Date());
    }

    public static String yesterday() {
        return format(addDays(new Date(), -1));
    }

    public static String dayBeforeYesterday() {
        return format(addDays(new Date(), -2));
    }

    public static Stream<String> rangeDates(long before, long after, String pattern, BiFunction<Date, Integer, Date> biFunction) {
        Date date = new Date();
        return LongStream.rangeClosed(-before, after)
                .mapToObj(diff -> format(biFunction.apply(date, (int) diff), pattern))
                .distinct();
    }

    public static Stream<String> rangeDates(String start, String end, String pattern) {
        int[] starts = Arrays.stream(datePattern(start).split("-")).mapToInt(Integer::valueOf).toArray();
        int[] ends = Arrays.stream(datePattern(end).split("-")).mapToInt(Integer::valueOf).toArray();
        LocalDate now = LocalDate.now();
        long before = ChronoUnit.DAYS.between(LocalDate.of(starts[0], starts[1], starts[2]), now);
        long after = ChronoUnit.DAYS.between(now, LocalDate.of(ends[0], ends[1], ends[2]));
        return rangeDates((int) before, (int) after, pattern, org.apache.commons.lang3.time.DateUtils::addDays);
    }

    public static Date getBeforeDay() {
        Date dNow = new Date();   //当前时间
        Date dBefore = new Date();

        Calendar calendar = Calendar.getInstance(); //得到日历
        calendar.setTime(dNow);//把当前时间赋给日历
        calendar.add(Calendar.DAY_OF_MONTH, -1);  //设置为前一天
        dBefore = calendar.getTime();   //得到前一天的时间
        return dBefore;
    }

    public static long diff(String startDate, String endDate, TimeUnit unit, String pattern) {
        long diffInMillis = 0;
        SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
        try {
            diffInMillis = dateFormat.parse(endDate).getTime() - dateFormat.parse(datePattern(startDate)).getTime();
        } catch (ParseException e) {
            log.error(e.getMessage());
        }
        return unit.convert(diffInMillis, MILLISECONDS);
    }

    public static List<String> halfHourList(String daySuffix) {
        String date = parse(daySuffix, YEAR_MONTH_DAY_PATTERN, DATE_PATTERN);
        List<String> dates = new ArrayList<>();
        for (int i = 0; i < 24; i++) {
            dates.add(date + " " + String.format("%02d", i) + ":00:00");
            dates.add(date + " " + String.format("%02d", i) + ":30:00");
        }
        return dates;
    }

    public static String datePattern(String dateTime) {
        if (StringUtils.isBlank(dateTime)) {
            return yesterday();
        } else if (dateTime.length() > 10) {
            return dateTime.substring(0, 10);
        }
        return dateTime;
    }

}
