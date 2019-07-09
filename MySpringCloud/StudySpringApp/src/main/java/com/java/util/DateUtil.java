package com.java.util;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @Title: DateUtil.java 
 * @Package com.amt.util
 * @Description: TODO(日期工具类) 
 * @author 刘云升  
 * @date 2019年5月21日 下午2:59:27 
 * Copyright (c) ©1994-2018 Scjydz.com All Rights Reserved.
 */
public class DateUtil {


	/**
	 * @description: 获取当前YYYY格式时间
	 */
	public static String getYear() {
		return formatDate(new Date(), "yyyy");
	}

	/**
	 * @description: 获取指定日期的 YYYY格式时间
	 * @param date 日期
	 */
	public static String getYear(Date date) {
		return formatDate(date, "yyyy");
	}

	/**
	 * @description: 获取当前 YYYY-MM-DD格式时间
	 */
	public static String getDay() {
		return formatDate(new Date(), "yyyy-MM-dd");
	}

	/**
	 * @description: 获取指定日期 YYYY-MM-DD格式时间
	 * @param date 日期
	 */
	public static String getDay(Date date) {
		return formatDate(date, "yyyy-MM-dd");
	}

	/**
	 * @Description: 获取当前时间 YYYYMMDD格式 
	 * @return String    返回类型
	 */
	public static String getDays() {
		return formatDate(new Date(), "yyyyMMdd");
	}

	/**
	 * @Description: 获取YYYYMMDD格式
	 * @param date
	 * @return String    返回类型
	 */
	public static String getDays(Date date) {
		return formatDate(date, "yyyyMMdd");
	}

	/**
	 * @Description: 获取当前时间 YYYY-MM-DD HH:mm:ss格式
	 * @return String    返回类型
	 */
	public static String getTime() {
		return formatDate(new Date(), "yyyy-MM-dd HH:mm:ss");
	}

	/**
	 * @Description: 获取当前时间 YYYY-MM-DD HH:mm:ss.SSS格式 
	 * @return String    返回类型
	 */
	public static String getMsTime() {
		return formatDate(new Date(), "yyyy-MM-dd HH:mm:ss.SSS");
	}

	/**
	 * @Description: 获取当前时间YYYYMMDDHHmmss格式
	 * @return String    返回类型
	 */
	public static String getAllTime() {
		return formatDate(new Date(), "yyyyMMddHHmmss");
	}

	/**
	 * @Description: 获取YYYY-MM-DD HH:mm:ss格式
	 * @param date
	 * @return String    返回类型
	 */
	public static String getTime(Date date) {
		return formatDate(date, "yyyy-MM-dd HH:mm:ss");
	}

	/**
	 * @Description: 获取当前时间，不包含年月日
	 * @Return java.lang.String    返回类型
	 */
	public static String getShortTime() {
		String t = formatDate(new Date(), "yyyy-MM-dd HH:mm:ss");
		String time = t.substring(t.indexOf(" "), t.length());
		return time;
	}

	/**
	 * @description: 格式化 制定日期  默认格式yyyy-MM-dd
	 * @param date
	 * @param pattern
	 * @return
	 */
	public static String formatDate(Date date, String pattern) {
		String formatDate = null;
		if (StringUtils.isNotBlank(pattern)) {
			formatDate = DateFormatUtils.format(date, pattern);
		} else {
			formatDate = DateFormatUtils.format(date, "yyyy-MM-dd");
		}
		return formatDate;
	}

	/**
	 * @Description: 日期比较，如果s>=e 返回true 否则返回false
	 * @param s
	 * @param e
	 * @return boolean    返回类型
	 */
	public static boolean compareDate(String s, String e) {
		if (parseDate(s) == null || parseDate(e) == null) {
			return false;
		}
		return parseDate(s).getTime() >= parseDate(e).getTime();
	}

	/**
	 * @Description: 格式化日期，默认格式yyyy-MM-dd 
	 * @param date
	 * @return Date    返回类型
	 */
	public static Date parseDate(String date) {
		return parse(date,"yyyy-MM-dd");
	}

	/**
	 * @Description: 格式化日期，默认格式yyyy-MM-dd HH:mm:ss 
	 * @param date
	 * @return Date    返回类型
	 */
	public static Date parseTime(String date) {
		return parse(date,"yyyy-MM-dd HH:mm:ss");
	}

	/**
	 * @Description: 格式化日期
	 * @param date
	 * @param pattern
	 * @return Date    返回类型
	 */
	public static Date parse(String date, String pattern) {
		try {
			return DateUtils.parseDate(date,pattern);
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * @Description: 格式化日期 
	 * @param date
	 * @param pattern
	 * @return String    返回类型
	 */
	public static String format(Date date, String pattern) {
		return DateFormatUtils.format(date, pattern);
	}

	/**
	 * @Description: 把日期转换为Timestamp 
	 * @param date
	 * @return Timestamp    返回类型
	 */
	public static Timestamp format(Date date) {
		return new Timestamp(date.getTime());
	}

	/**
	 * @Description: 校验日期是否合法，格式yyyy-MM-dd HH:mm:ss 
	 * @param s
	 * @return boolean    返回类型
	 */
	public static boolean isValidDate(String s) {
		return parse(s, "yyyy-MM-dd HH:mm:ss") != null;
	}

	/**
	 * @Description: 校验日期是否合法 
	 * @param s
	 * @param pattern
	 * @return boolean    返回类型
	 */
	public static boolean isValidDate(String s, String pattern) {
        return parse(s, pattern) != null;
	}

	public static int getDiffYear(String startTime, String endTime) {
		DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
		try {
			int years = (int) (((fmt.parse(endTime).getTime() - fmt.parse(
					startTime).getTime()) / (1000 * 60 * 60 * 24)) / 365);
			return years;
		} catch (Exception e) {
			// 如果throw java.text.ParseException或者NullPointerException，就说明格式不对
			return 0;
		}
	}

	/**
	 * @Description: 时间相减得到天数
	 * @param beginDateStr
	 * @param endDateStr
	 * @return long    返回类型
	 */
	public static long getDaySub(String beginDateStr, String endDateStr) {
		long day = 0;
		SimpleDateFormat format = new SimpleDateFormat(
				"yyyy-MM-dd");
		Date beginDate = null;
		Date endDate = null;

		try {
			beginDate = format.parse(beginDateStr);
			endDate = format.parse(endDateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		day = (endDate.getTime() - beginDate.getTime()) / (24 * 60 * 60 * 1000);
		// System.out.println("相隔的天数="+day);

		return day;
	}

	/**
	 * @Description: 得到n天之后的日期 
	 * @param days
	 * @return String    返回类型
	 */
	public static String getAfterDayDate(String days) {
		int daysInt = Integer.parseInt(days);

		Calendar canlendar = Calendar.getInstance(); // java.util包
		canlendar.add(Calendar.DATE, daysInt); // 日期减 如果不够减会将月变动
		Date date = canlendar.getTime();

		SimpleDateFormat sdfd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateStr = sdfd.format(date);

		return dateStr;
	}

	/**
	 * @Description: 得到n天之后是周几
	 * @param days
	 * @return String    返回类型
	 */
	public static String getAfterDayWeek(String days) {
		int daysInt = Integer.parseInt(days);

		Calendar canlendar = Calendar.getInstance(); // java.util包
		canlendar.add(Calendar.DATE, daysInt); // 日期减 如果不够减会将月变动
		Date date = canlendar.getTime();

		SimpleDateFormat sdf = new SimpleDateFormat("E");
		String dateStr = sdf.format(date);

		return dateStr;
	}

	/**
	 * @Description: 格式化Oracle Date 
	 * @param args
	 * @return void    返回类型
	 */
/*	public static String buildDateValue(Object value){
		if(Func.isOracle()){
			return "to_date('"+ value +"','yyyy-mm-dd HH24:MI:SS')";
		}else{
			return Func.toStr(value);
		}
	}*/

	/*public static void main(String[] args) {
		String t = getShortTime();
		System.out.println(t.substring(t.indexOf(" "), t.length()));
	}*/


	/**
	 *  时间转换: 如果是今天，返回时间  如果是昨天，返回“昨天”，否则返回月-日
	 * @param date
	 * @return
	 */
	public static String getDateStrByRule(Date date){
		//今天
		if (getDay().equals(getDay(date)))
			return formatDate(date,"HH:mm");
		//昨天
		if (getDaySub(getDay(),getDay(date)) == 1)
			return "昨天";
		return formatDate(date,"MM-dd");
	}

	/**
	 * @description: 计算 年龄
	 * @param birthDay 出生日期格式 yyyy-MM-dd
	 * @throws Exception
	 */
	 public static int getAge(Date birthDay) throws Exception {
        Calendar cal = Calendar.getInstance();
 
        if (cal.before(birthDay)) {
            throw new IllegalArgumentException(
                    "The birthDay is before Now.It's unbelievable!");
        }
        int yearNow = cal.get(Calendar.YEAR);
        int monthNow = cal.get(Calendar.MONTH);
        int dayOfMonthNow = cal.get(Calendar.DAY_OF_MONTH);
        cal.setTime(birthDay);
 
        int yearBirth = cal.get(Calendar.YEAR);
        int monthBirth = cal.get(Calendar.MONTH);
        int dayOfMonthBirth = cal.get(Calendar.DAY_OF_MONTH);
 
        int age = yearNow - yearBirth;
 
        if (monthNow <= monthBirth) {
            if (monthNow == monthBirth) {
                if (dayOfMonthNow < dayOfMonthBirth) age--;
            }else{
                age--;
            }
        }
        return age;
    }
	 
	 /**
	  * @description: 计算年龄
	  * @param idcard 身份证号码
	  * @throws Exception
	  */
	 public static int getAge(String idcard) throws Exception{
		 Date time = DateUtil.parse(idcard.substring(6,10)+"-"+idcard.substring(10,12)+"-"+idcard.substring(12,14),"yyyy-MM-dd");
		 return getAge(time);
	 }
	 
}
