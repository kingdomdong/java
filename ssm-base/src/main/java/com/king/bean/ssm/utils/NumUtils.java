package com.king.bean.ssm.utils;

import java.util.regex.Pattern;

public class NumUtils {

    private static Pattern patternInteger = Pattern.compile("^[-\\+]?[\\d]*$");

    /**
     * 判断是否为整数.
     * @param source 传入的字符串
     * @return 是整数返回true,否则返回false
     */
    public static boolean isInteger(String source) {
        boolean rtn = false;
        if (source != null && !source.trim().equals("")) {
            rtn = patternInteger.matcher(source).matches();
        }
        return rtn;
    }

    /**
     * 是否为指定范围的整数.
     * @param source
     * @param minValue
     * @param maxValue
     * @return
     */
    public static boolean isInteger(String source, Integer minValue, Integer maxValue) {
        boolean rtn = false;
        if (source != null && !source.trim().equals("")) {
            rtn = patternInteger.matcher(source).matches();
            if (rtn) {
                long value = Long.parseLong(source);
                if (value < minValue || value > maxValue) {
                    rtn = false;
                }
            }
        }
        return rtn;
    }
}
