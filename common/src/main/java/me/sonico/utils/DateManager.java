package me.sonico.utils;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateManager {
	
	/**
	 * 当前时间(Timestamp格式)
	 */
	private Timestamp dateTime;
	
	/**
	 * 当前时间(long格式:yyyyMMddHHmmss)
	 */
	private Long dateTimeInt;
	
	/**
	 * 当前时间(String格式:yyyy-MM-dd HH:mm:ss)
	 */
	private String dateTimeString;
	
	public Date getDateTime() {
//		return dateTime;
		return new Timestamp(System.currentTimeMillis());
	}

	public void setDateTime(Timestamp dateTime) {
		this.dateTime = dateTime;
	}
	
	public Long getDateTimeInt() {
		return dateTimeInt;
	}
	
	public void setDateTimeInt(Long dateTimeInt) {
		this.dateTimeInt = dateTimeInt;
	}
	
	public String getDateTimeString() {
		return dateTimeString;
	}

	public void setDateTimeString(String dateTimeString) {
		this.dateTimeString = dateTimeString;
	}
	SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
	SimpleDateFormat formatterString = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	public DateManager(){
		Timestamp nowDate = new Timestamp(System.currentTimeMillis());

		String nowDateIntString = formatter.format(nowDate);
		Long nowDateLong = Long.parseLong(nowDateIntString);
		String nowDateString = formatterString.format(nowDate);

		this.dateTime = nowDate;
		this.dateTimeInt = nowDateLong;
		this.dateTimeString = nowDateString;
	}
	public DateManager(String dateTimeString){
//		SimpleDateFormat formatterInt = new SimpleDateFormat("yyyyMMddHHmmss");
//		SimpleDateFormat formatterString = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		this.dateTime = Timestamp.valueOf(dateTimeString);
		this.dateTimeInt = Long.parseLong(formatterString.format(dateTime));
		this.dateTimeString = formatterString.format(dateTime);
	}
	public DateManager(Timestamp dateTime){
		SimpleDateFormat formatterInt = new SimpleDateFormat("yyyyMMddHHmmss");
		SimpleDateFormat formatterString = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		this.dateTime = dateTime;
		this.dateTimeInt = Long.parseLong(formatterInt.format(dateTime));
		this.dateTimeString = formatterString.format(dateTime);
	}
}
