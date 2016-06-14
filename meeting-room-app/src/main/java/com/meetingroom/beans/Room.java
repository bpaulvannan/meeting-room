package com.meetingroom.beans;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.meetingroom.util.DateUtil;

/**
 * Bean to hold room no and occupations
 * @author Paulvannan Balasubramanian
 *
 */
public class Room {
	private final int roomNo;
	private final List<Occupation> occupations = new ArrayList<Occupation>();
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + roomNo;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Room other = (Room) obj;
		if (roomNo != other.roomNo)
			return false;
		return true;
	}
	public int getRoomNo() {
		return roomNo;
	}
	public List<Occupation> getOccupations() {
		return occupations;
	}
	public void addOccupation(String startDate, String endDate){
		this.addOccupation(DateUtil.toDate(startDate), DateUtil.toDate(endDate));
	}
	public void addOccupation(Date startDate, Date endDate){
		occupations.add(new Occupation(startDate, endDate));
	}
	public Room(int pRoomNo){
		this.roomNo = pRoomNo;
	}
	@Override
	public String toString() {
		return "Room [roomNo=" + roomNo + ", occupations=" + occupations + "]";
	}
}
