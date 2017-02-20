package com.wqstore.result;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

/**
 * 如果涉及到跨时区的服务，直接new Date 会产生时间问题
 * 
 */
public class DateUtil {

	private final static DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	private final static DateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
	private final static DateFormat dateFormatmonth = new SimpleDateFormat("yyyy-MM");
	private final static DateFormat timestampFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	protected final static TimeZone CHINESE_TIMEZONE = TimeZone.getTimeZone("GMT+8");
	public static Date getChineseTime() {
		return Calendar.getInstance(CHINESE_TIMEZONE).getTime();
	}

	/**
	 * 将时间转换为字符串，格式为：yyyy-MM-dd HH:mm:ss
	 * 
	 * @param date
	 * @return
	 */
	public static synchronized String convertToTimestamp(Date date) {
		return timestampFormat.format(date);
	}

	/**
	 * 将时间转换为字符串，格式为：HH:mm:ss
	 * 
	 * @param date
	 * @return
	 */
	public static synchronized String convertToTime(Date date) {
		return timeFormat.format(date);
	}

	/**
	 * 将时间转换为字符串，格式为：yyyy-MM-dd
	 * 
	 * @param date
	 * @return
	 */
	public static synchronized String convertToDate(Date date) {
		return dateFormat.format(date);
	}
	
	public static synchronized Date parseToDate(String date) {
		try {
			return dateFormat.parse(date);
		} catch (ParseException e) {
			return null;
		}
	}

	public static String parse(String formatText, Date date) {
		DateFormat format = new SimpleDateFormat(formatText);
		return format.format(date);
	}
	public static synchronized String convertToDateMonth(Date date) {
		return dateFormatmonth.format(date);
	}

	public static int getYear(Date date) {
		Calendar ca = Calendar.getInstance();
		ca.setTime(date);
		return ca.get(Calendar.YEAR);
	}
	
	public static int getMonth(Date date) {
		Calendar ca = Calendar.getInstance();
		ca.setTime(date);
		return ca.get(Calendar.MONTH)+1;
	}
	
	public static int getWeek(Date date) {
		Calendar ca = Calendar.getInstance();
		ca.setTime(date);
		return ca.get(Calendar.WEEK_OF_YEAR);
	}
	
	public static int getHour(Date date) {
		Calendar ca = Calendar.getInstance();
		ca.setTime(date);
		return ca.get(Calendar.HOUR_OF_DAY);
	}
	
	
	/**
	 * 获得指定日期的前一天
	 * 
	 * @return
	 * @throws Exception
	 */
	public static Date getDayBefore(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		int day = c.get(Calendar.DATE);
		c.set(Calendar.DATE, day - 1);

		return c.getTime();
	}

	/**
	 * 获得指定日期的后一天
	 * 
	 * @param date
	 * @return
	 */
	public static Date getDayAfter(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		int day = c.get(Calendar.DATE);
		c.set(Calendar.DATE, day + 1);

		return c.getTime();
	}
	
	/**
	 * 获得指定日期一周前
	 * @param date
	 * @return
	 */
	public static Date getLastWeek(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.DATE,  - 7);
		
		return c.getTime();
	}
	
	public static synchronized Date parseTotimestampFormat(String date){
		try {
			return timestampFormat.parse(date);
		} catch (ParseException e) {
			return null;
		}
	}
	
	public static List<String> getDayHour(Date date) {
		List<String> hours = new ArrayList<String>(24);
		int length = 24;
		if(DateUtil.convertToDate(date).equals(DateUtil.convertToDate(new Date()))){
			Calendar c = Calendar.getInstance();
			c.setTime(new Date());
			length = c.get(Calendar.HOUR_OF_DAY)+1;
		}
		for (int i = 0; i < length; i++) {
			hours.add(String.valueOf(i));
		}
		return hours;
	}
	
	public static synchronized List<String> getDateRange(Date startTime, Date endTime) {
		List<String> date = new ArrayList<String>();
		while(endTime.getTime()>startTime.getTime()) {
			date.add(dateFormat.format(startTime));
			startTime = DateUtil.getDayAfter(startTime);
		}
		return date;
	}
	
	public static List<String> getDateRangeByWeek(Date startTime, Date endTime) {
		Calendar cal = Calendar.getInstance();
		List<String> date = new ArrayList<String>();
		cal.setTime(startTime);
		int startDate = cal.get(Calendar.DAY_OF_WEEK);
		cal.setTime(endTime);
		int endDate = cal.get(Calendar.DAY_OF_WEEK);
		//起始日期天小于截止日期天，多加一周
		if(startDate >= endDate) {
			cal.add(Calendar.WEEK_OF_YEAR, 1);
			endTime = cal.getTime();
		}
		cal.setTime(startTime);
		while(endTime.getTime()>startTime.getTime()) {
			date.add(String.valueOf(cal.get(Calendar.WEEK_OF_YEAR)));
			cal.add(Calendar.DATE, 7);
			startTime = cal.getTime();
		}
		return date;
	}
	
	public static List<String> getDateRangeByMonth(Date startTime, Date endTime) {
		Calendar cal = Calendar.getInstance();
		List<String> date = new ArrayList<String>();
		cal.setTime(startTime);
		int startDate = cal.get(Calendar.DAY_OF_MONTH);
		cal.setTime(endTime);
		int endDate = cal.get(Calendar.DAY_OF_MONTH);
		//起始日期天小于截止日期天，多加一个月
		if(startDate >= endDate) {
			cal.add(Calendar.MONTH, 1);
			endTime = cal.getTime();
		}
		cal.setTime(startTime);
		while(endTime.getTime()>startTime.getTime()) {
			date.add(String.valueOf(cal.get(Calendar.MONTH)+1));
			cal.add(Calendar.MONTH, 1);
			startTime = cal.getTime();
		}
		return date;
	}
	
	public static List<String> getTimeRange(Date startTime, Date endTime) {
		List<String> date = new ArrayList<String>();
		Calendar cal = Calendar.getInstance();
		cal.setTime(startTime);
		while(endTime.getTime()>=startTime.getTime()) {
			date.add(timeFormat.format(startTime));
			cal.add(Calendar.MINUTE, 1);
			startTime = cal.getTime();
		}
		return date;
	}
	
	/**
	 * 获取日期格式yyyy-MM-dd 00:00:00.0
	 * @param date
	 * @return
	 */
	public static Date getDate(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		return cal.getTime();
	}
}
