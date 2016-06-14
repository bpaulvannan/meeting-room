package com.meetingroom.api;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Test;

import com.meetingroom.api.impl.OccupationExtractorImpl;
import com.meetingroom.beans.Building;
import com.meetingroom.beans.Room;
import com.meetingroom.util.DateUtil;

public class OccupationExtractorTest {
	
	private Date addRoomsForFound(Building building){
		Room r1 = new Room(1);
		r1.addOccupation(DateUtil.toDate("2016.06.14 09:00:00"), DateUtil.toDate("2016.06.14 09:30:00"));
		r1.addOccupation(DateUtil.toDate("2016.06.14 10:00:00"), DateUtil.toDate("2016.06.14 10:30:00"));
		r1.addOccupation(DateUtil.toDate("2016.06.14 11:00:00"), DateUtil.toDate("2016.06.14 11:30:00"));
		
		Room r2 = new Room(2);
		r2.addOccupation(DateUtil.toDate("2016.06.14 09:30:00"), DateUtil.toDate("2016.06.14 10:00:00"));
		r2.addOccupation(DateUtil.toDate("2016.06.14 11:00:00"), DateUtil.toDate("2016.06.14 12:00:00"));
		
		Room r3 = new Room(3);
		r3.addOccupation(DateUtil.toDate("2016.06.14 11:15:00"), DateUtil.toDate("2016.06.14 12:15:00"));
		
		building.addRoom(r1);
		building.addRoom(r2);
		building.addRoom(r3);
		return DateUtil.toDate("2016.06.14 11:15:00");
	}
	
	private Date addRoomsForNotFound(Building building){
		
		Room r1 = new Room(1);
		r1.addOccupation(DateUtil.toDate("2016.06.14 09:00:00"), DateUtil.toDate("2016.06.14 09:30:00"));
		
		Room r2 = new Room(2);
		r2.addOccupation(DateUtil.toDate("2016.06.14 10:00:00"), DateUtil.toDate("2016.06.14 10:30:00"));
		
		Room r3 = new Room(3);
		r3.addOccupation(DateUtil.toDate("2016.06.14 11:00:00"), DateUtil.toDate("2016.06.14 11:30:00"));
		
		building.addRoom(r1);
		building.addRoom(r2);
		building.addRoom(r3);
		
		return null;
	}
	
	@Test
	public void testFound(){
		Building building = new Building(new OccupationExtractorImpl());
		Date expected = addRoomsForFound(building);
		assertEquals(expected, building.findFirstTimeWhenAllRoomsAreOccupied());
	}
	
	@Test
	public void testNotFound(){
		Building building = new Building(new OccupationExtractorImpl());
		Date expected = addRoomsForNotFound(building);
		assertEquals(expected, building.findFirstTimeWhenAllRoomsAreOccupied());
	}
}
