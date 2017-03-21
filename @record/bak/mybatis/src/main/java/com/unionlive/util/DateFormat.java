package com.unionlive.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * 时间格式化工具类
 *
 */
public class DateFormat {

    public final static String DEFAULT_FORMAT = "yyyy-MM-dd HH:mm:ss"; //默认时间格式
    public final static String yyyyMMddHHmmss = "yyyyMMddHHmmss";
    public final static String yyyyMMdd = "yyyyMMdd";
    public final static String HHmmss = "HHmmss";

    public static SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DEFAULT_FORMAT);

    /**
     * 获取时间对象
     * @return
     */
    public static Date getDate(){ return new Date();}
    public static Date getDate(Long l){
        return new Date(l);
    }
    public static Date getDate(String date) throws ParseException {
        return getDate(date,DEFAULT_FORMAT);
    }
    public static Date getDate(String date,String format) throws ParseException {
        return new SimpleDateFormat(format).parse(date);
    }

    /**
     * 获取指定格式的字符串时间
     * @param format
     * @return
     */
    public static String getDateFormat(String format){
        return new SimpleDateFormat(format).format(new Date());
    }
    public static String getDateFormat(Date date,String format){
        return new SimpleDateFormat(format).format(date);
    }
    public static String getDateFormat(Long time,String format){
        return new SimpleDateFormat(format).format(new Date(time));
    }
    public static String getDateFormat(Long time){
        return simpleDateFormat.format(new Date(time));
    }
    public static String getDateFormat(){
        return simpleDateFormat.format(new Date());
    }

    /**
     * 获取时间毫秒数
     * @return
     */
    public static Long getTime(){
        return getDate().getTime();
    }
    public static Long getTime(String date,String format) throws ParseException {
        return getDate(date,format).getTime();
    }
    public static Long getTime(String date) throws ParseException {
        return getTime(DEFAULT_FORMAT,String.valueOf(date));
    }

    /**
     * 获取时间秒数
     */
    public static int getSecond(){ return (int) (getTime()/1000);}
    public static int getSecond(String date,String format) throws ParseException { return (int) (getTime(date,format)/1000);}
    public static int getSecond(String date) throws ParseException { return (int) (getTime(date)/1000);}

    /**
     * 返回指定格式时间延迟s毫秒后的相同格式时间
     * @param dateFormat  时间字符串
     * @param format 时间格式
     * @param s  为正数，延迟，为负数提前
     * @return
     */
    public static String getDateDelay(String dateFormat,String format,Long s) throws ParseException {
        return getDateFormat(getTime(dateFormat,format)+s,format);
    }

    public static String getYyyyMMddHHmmss(){
        return getDateFormat(yyyyMMddHHmmss);
    }
    public static String getYyyyMMddHHmmss(String second){
        return getDateFormat(Long.parseLong(second+"000"),yyyyMMddHHmmss);
    }
    public static String getYyyyMMdd(){
        return getDateFormat(yyyyMMdd);
    }
    public static String getHHmmss(){
        return getDateFormat(HHmmss);
    }

    /**
     * 根据字符串日期格式 yyyy-MM-dd HH:mm:ss 转成日期yyyyMMdd格式  时间HHmmss格式
     */
    public static String formatToyyyyMMdd(Object f) throws ParseException {
        return getDateFormat(getDate(String.valueOf(f)),yyyyMMdd);
    }
    public static String formatToHHmmss(Object f) throws ParseException {
        return getDateFormat(getDate(String.valueOf(f)),HHmmss);
    }

    /**
     * 根据秒数转换成制定格式日期字符串
     * @params f 距离1970的秒数
     * @throws ParseException
     */
    public static String secondToyyyyMMdd(Object f){
        long l = Long.parseLong(f+"000");
        return getDateFormat(getDate(l),yyyyMMdd);
    }
    public static String secondToHHmmss(Object f){
        long l = Long.parseLong(f+"000");
        return getDateFormat(getDate(l),HHmmss);
    }
    public static String secondToyyyyMMddHHmmss(Object f){
        long l = Long.parseLong(f+"000");
        return getDateFormat(getDate(l),yyyyMMddHHmmss);
    }
    public static String secondToFormatDate(Object s){
        long l = Long.parseLong(s+"000");
        return getDateFormat(getDate(l),DEFAULT_FORMAT);
    }

    /**
     * 计算量日期范围时间
     */
    public static Integer day(Object begin,Object end,String format) throws ParseException {
        long l = getTime(String.valueOf(end),format)-getTime(String.valueOf(begin),format);
        return Math.toIntExact(l / 1000 / 60 / 60 / 24);
    }


   /* public static void main(String[] args) throws ParseException {
        System.out.println(day("20160830","20160901","yyyyMMdd"));

    }*/
}
