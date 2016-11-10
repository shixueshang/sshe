package com.lhd.util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * 基于JDK8的时间工具类
 * Created by lihongde on 2016/11/10 14:15.
 */
public class DateUtil {

    /**
     * 获取默认时间格式: yyyy-MM-dd HH:mm:ss
     */
    private static final DateTimeFormatter DEFAULT_DATETIME_FORMATTER = DateTimeFormat.LONG_DATE_PATTERN_LINE.formatter;

    /**
     * String 转时间
     *
     * @param timeStr
     * @return
     */
    public static LocalDateTime parseTime(String timeStr) {
        return LocalDateTime.parse(timeStr, DEFAULT_DATETIME_FORMATTER);
    }

    /**
     * String 转时间
     *
     * @param dateStr
     * @return
     */
    public static LocalDate parseDate(String dateStr) {
        return LocalDate.parse(dateStr);
    }

    /**
     * String 转时间
     *
     * @param timeStr
     * @param format  时间格式
     * @return
     */
    public static LocalDateTime parseTime(String timeStr, DateTimeFormat format) {
        return LocalDateTime.parse(timeStr, format.formatter);
    }

    /**
     * String 转时间
     *
     * @param dateStr
     * @param format  时间格式
     * @return
     */
    public static LocalDate parseDate(String dateStr, DateTimeFormat format) {
        return LocalDate.parse(dateStr, format.formatter);
    }



    /**
     * 时间转 String
     *
     * @param time
     * @return
     */
    public static String parseTime(LocalDateTime time) {
        return DEFAULT_DATETIME_FORMATTER.format(time);
    }

    /**
     * 时间转 String
     *
     * @param time
     * @param format 时间格式
     * @return
     */
    public static String parseTime(LocalDateTime time, DateTimeFormat format) {
        return format.formatter.format(time);
    }

    /**
     * 获取当前时间
     *
     * @return
     */
    public static String getCurrentDatetime() {
        return DEFAULT_DATETIME_FORMATTER.format(LocalDateTime.now());
    }

    /**
     * 获取当前时间
     *
     * @param format 时间格式
     * @return
     */
    public static String getCurrentDatetime(DateTimeFormat format) {
        return format.formatter.format(LocalDateTime.now());
    }

    /**
     * 年份
     * @return
     */
    public static int getYear(){
        LocalDate now = LocalDate.now();
        return now.getYear();
    }

    /**
     * 获得年份
     * @param date
     * @return
     */
    public static int getYear(LocalDate date){
        return date.getYear();
    }

    /**
     * 月份
     * @return
     */
    public static int getMonth(){
        LocalDate now = LocalDate.now();
        return now.getMonthValue();
    }



    /**
     * 时间格式
     */
    public enum DateTimeFormat {

        /**
         * 短时间格式
         */
        SHORT_DATE_PATTERN_LINE("yyyy-MM-dd"),
        SHORT_DATE_PATTERN_SLASH("yyyy/MM/dd"),
        SHORT_DATE_PATTERN_DOUBLE_SLASH("yyyy\\MM\\dd"),
        SHORT_DATE_PATTERN_NONE("yyyyMMdd"),

        /**
         * 长时间格式
         */
        LONG_DATE_PATTERN_LINE("yyyy-MM-dd HH:mm:ss"),
        LONG_DATE_PATTERN_SLASH("yyyy/MM/dd HH:mm:ss"),
        LONG_DATE_PATTERN_DOUBLE_SLASH("yyyy\\MM\\dd HH:mm:ss"),
        LONG_DATE_PATTERN_NONE("yyyyMMdd HH:mm:ss"),

        /**
         * 长时间格式 带毫秒
         */
        LONG_DATE_PATTERN_WITH_MILSEC_LINE("yyyy-MM-dd HH:mm:ss.SSS"),
        LONG_DATE_PATTERN_WITH_MILSEC_SLASH("yyyy/MM/dd HH:mm:ss.SSS"),
        LONG_DATE_PATTERN_WITH_MILSEC_DOUBLE_SLASH("yyyy\\MM\\dd HH:mm:ss.SSS"),
        LONG_DATE_PATTERN_WITH_MILSEC_NONE("yyyyMMdd HH:mm:ss.SSS");

        private transient DateTimeFormatter formatter;

        DateTimeFormat(String pattern) {
            formatter = DateTimeFormatter.ofPattern(pattern);
        }
    }
}
