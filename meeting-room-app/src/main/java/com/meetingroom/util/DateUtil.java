package com.meetingroom.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	public static final String DATE_TIME_PATTERN = "yyyy.MM.dd HH:mm:ss";
	private DateUtil(){}
	public static Date toDate(String dateString){
		try{
			SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_TIME_PATTERN);
			return dateFormat.parse(dateString);
		}catch(ParseException pe){
			return null;
		}
	}
}
