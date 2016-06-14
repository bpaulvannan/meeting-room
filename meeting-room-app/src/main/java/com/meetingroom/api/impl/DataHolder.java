package com.meetingroom.api.impl;

import java.util.Date;

/**
 * Bean to hold the date, start or end flag and room no
 * Implements comparable to sort by start date, end date and room no
 * @author Paulvannan Balasubramanian
 *
 */
public class DataHolder implements Comparable<DataHolder>{
	private final Date date;
	private final boolean start;
	private final int roomNo;
	public DataHolder(Date pDate, boolean pStart, int pRoomNo){
		this.date = pDate;
		this.start = pStart;
		this.roomNo = pRoomNo;
	}
	public Date getDate() {
		return date;
	}
	public boolean isStart() {
		return start;
	}
	public int getRoomNo() {
		return roomNo;
	}
	public int compareTo(DataHolder o) {
		int result = this.date.compareTo(o.date);
		if(result == 0){
			if(this.start && o.start){
				return new Integer(this.roomNo).compareTo(o.roomNo);
			}else if(this.start){
				return -1;
			}else{
				return 1;
			}
		}
		return result;
	}
	
}
