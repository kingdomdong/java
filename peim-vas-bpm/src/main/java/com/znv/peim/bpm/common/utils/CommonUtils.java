package com.znv.peim.bpm.common.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author 李志超
 * @Date 2020/8/14 15:20
 * @Description: 封装公共方法
 */
@Component
public class CommonUtils {
    /**
     * @Fields logger : 日志
     */
    private static Logger logger = LoggerFactory.getLogger(CommonUtils.class);

    /**
     * 检查对象是否是数组
     *
     * @param obj 对象
     * @return
     */
    public static boolean isArray(Object obj) {
        return (obj != null && obj.getClass().isArray());
    }

    /**
     * 检查字节数组是否为空
     *
     * @param array
     * @return
     */
    public static boolean isEmpty(byte[] array) {
        return (array == null || array.length == 0);
    }

    /**
     * 获取格式化时间
     *
     * @param format 格式化类型  yyyy-MM-dd HH:mm:ss/YYYYMMddhhmmss
     * @return 格式化后的时间
     */
    public static String getDateStr(Date date,String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        String dateNowStr = sdf.format(date);
        return dateNowStr;
    }

    /**
     * 原格式时间数据转成新格式数据
     *
     * @param time      时间
     * @param oldFormat 原格式类型
     * @param newFormat 现格式类型
     * @return 新格式时间类型
     */
    public static String getFormatTime(String time, String oldFormat, String newFormat) {
        String newTime = "";
        try {
            SimpleDateFormat oldSdf = new SimpleDateFormat(oldFormat);
            SimpleDateFormat newSdf = new SimpleDateFormat(newFormat);
            Date oldDate = null;
            oldDate = oldSdf.parse(time);
            newTime = newSdf.format(oldDate);
        } catch (ParseException e) {
            logger.error("时间格式转换出错   time={}", time);
        }
        return newTime;
    }

    public static String mathRandom(int count) {
        String math = "";
        if (count > 0) {
            while (math.length() < count) {
                math += (int) (Math.random() * 10);
            }
        }
        return math;

    }

    /**
     * 获取前多少分钟时间
     *
     * @param format      转换成的时间格式 YYYYMMddHHmmss
     * @param forwardTime 前多少分钟
     * @return
     */
    public String getBeforeTime(String format, int forwardTime) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        Calendar beforeTime = Calendar.getInstance();
        // xx分钟之前的时间
        beforeTime.add(Calendar.MINUTE, -forwardTime);
        Date beforeD = beforeTime.getTime();
        String time = sdf.format(beforeD);
        return time;
    }

    /**
     * 比较数值型字符串大小
     *
     * @param version1
     * @param version2
     * @return
     */
    public static int compareVersion(String version1, String version2) {

        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");

        for (int i = 0; i < Math.max(v1.length, v2.length); i++) {
            int num1 = i < v1.length ? Integer.parseInt(v1[i]) : 0;
            int num2 = i < v2.length ? Integer.parseInt(v2[i]) : 0;
            if (num1 < num2) {
                return -1;
            } else if (num1 > num2) {
                return 1;
            }
        }
        return 0;
    }

    /**
     * 提供精确的加法运算。
     *
     * @param v1 被加数
     * @param v2 加数
     * @return 两个参数的和
     */
    public static double add(double v1, double v2) {
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return b1.add(b2).doubleValue();
    }

    /**
     * 提供精确的减法运算。
     *
     * @param v1 被减数
     * @param v2 减数
     * @return 两个参数的差
     */
    public static double sub(double v1, double v2) {
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return b1.subtract(b2).doubleValue();
    }

    /**
     * 除法，并格式化结果
     *
     * @param v1     除数
     * @param v2     被除数
     * @param format 数字格式化类型 00.00，0.00%等
     * @return
     */
    public static String percentFormat(String v1, String v2, String format) {
        if (!StringUtils.isEmpty(v1) && !StringUtils.isEmpty(v2)) {
            DecimalFormat decimalFormat = new DecimalFormat(format);
            double percent = Double.parseDouble(v1) / Double.parseDouble(v2) * 100;
            return decimalFormat.format(percent);
        }
        return "";
    }

    /**
     * 将数字格式化
     *
     * @param v
     * @param format
     * @return
     */
    public static String percentFormat(float v, String format) {
        if (!StringUtils.isEmpty(v)) {
            DecimalFormat decimalFormat = new DecimalFormat(format);
            return decimalFormat.format(v);
        }
        return "";
    }

    public static String handleStrNUll(String src) {
        if (!StringUtils.isEmpty(src)) {
            return src;
        }
        return "";
    }
}
