package com.meetingroom.api;

import java.util.Date;

import com.meetingroom.beans.Building;

/**
 * API to implement the solution - First time when all rooms are occupied
 * @author Paulvannan Balasubramanian
 *
 */
public interface IOccupationExtractor {
	Date findFirstTimeWhenAllRoomsAreOccupied(Building building);
}
