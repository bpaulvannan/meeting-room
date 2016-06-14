package com.meetingroom.beans;

import java.util.Date;

/**
 * Bean to hold start and end time of occupation
 * @author Paulvannan Balasubramanian
 *
 */
public class Occupation {
	private final Date start;
	private final Date end;
	public Occupation(Date pStart, Date pEnd){
		if(pStart == null || pEnd == null){
			throw new RuntimeException("Start and End dates required");
		}else if(pStart.after(pEnd)){
			throw new RuntimeException("Start date must be before End date");
		}
		this.start = pStart;
		this.end = pEnd; 
	}
	public Date getStart() {
		return start;
	}
	public Date getEnd() {
		return end;
	}
	@Override
	public String toString() {
		return "Occupation [start=" + start + ", end=" + end + "]";
	}
}
