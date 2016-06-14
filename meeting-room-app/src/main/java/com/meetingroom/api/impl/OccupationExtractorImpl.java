package com.meetingroom.api.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.meetingroom.api.IOccupationExtractor;
import com.meetingroom.beans.Building;
import com.meetingroom.beans.Occupation;
import com.meetingroom.beans.Room;

/**
 * Solution to find first time when all rooms are occupied
 * @author Paulvannan Balasubramanian
 *
 */
public class OccupationExtractorImpl implements IOccupationExtractor {

	public Date findFirstTimeWhenAllRoomsAreOccupied(Building building) {
		
		//Collect start date, end date and room no
		List<DataHolder> dataList = new ArrayList<DataHolder>();
		for(Room room : building.getRooms()){
			for(Occupation occ : room.getOccupations()){
				dataList.add(new DataHolder(occ.getStart(), true, room.getRoomNo()));
				dataList.add(new DataHolder(occ.getEnd(), false, room.getRoomNo()));
			}
		}
		
		//Sort by start date, end date and room no
		Collections.sort(dataList);
		
		//Get max rooms count
		int maxRooms = building.getRooms().size();
		
		//Track occupied rooms
		Set<Integer> roomNoSet = new HashSet<Integer>();
		
		//Loop through the data set
		for(DataHolder data : dataList){
			//If starting date, add the room to occupied rooms set
			if(data.isStart()){
				roomNoSet.add(data.getRoomNo());
				//Check if all rooms are occupied, if yes return the date
				if(roomNoSet.size() == maxRooms){
					return data.getDate();
				}
			//If end date, remove the room from occupied rooms set
			}else{
				roomNoSet.remove(data.getRoomNo());
			}
		}
		
		//Could not find the time when all rooms are occupied, return null
		return null;
	}

}
