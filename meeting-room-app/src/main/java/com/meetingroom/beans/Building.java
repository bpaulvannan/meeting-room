package com.meetingroom.beans;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.meetingroom.api.IOccupationExtractor;

/**
 * Bean to hold rooms and occupation extractor
 * @author Paulvannan Balasubramanian
 *
 */
public class Building {
	private final IOccupationExtractor occupationExtractor;
	private final Set<Room> roomSet = new HashSet<Room>();
	public Building(IOccupationExtractor pOccupationExtractor){
		this.occupationExtractor = pOccupationExtractor;
	}
	public void addRoom(Room room){
		if(!roomSet.add(room)){
			throw new RuntimeException("Room " + room.getRoomNo() + " already added");
		}
	}
	public Date findFirstTimeWhenAllRoomsAreOccupied(){
		return this.occupationExtractor.findFirstTimeWhenAllRoomsAreOccupied(this);
	}
	public Set<Room> getRooms() {
		return roomSet;
	}
}
