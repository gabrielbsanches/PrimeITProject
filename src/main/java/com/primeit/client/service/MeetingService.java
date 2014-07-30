package com.primeit.client.service;

import java.util.List;

import com.primeit.client.model.Meeting;

/**
 * This class is the Meeting Service
 * 
 * @author gabrielbsanches
 *
 */
public interface MeetingService {

	/**
	 * This method is to save Meeting in the system
	 * 
	 * @param Meeting
	 */
	void add(Meeting meeting);
	
	/**
	 * This method is to update Meeting in the system
	 * 
	 * @param Meeting
	 */
	void update(Meeting meeting);
	
	/**
	 * This method is to delete Meeting with it's ID from the system
	 * 
	 * @param long
	 */
	void delete(long id);
	
	/**
	 * This method is to find Meeting by it's ID from the system
	 * 
	 * @param 	long
	 * @return 	Meeting
	 */
	Meeting findByMeetingId(long id);
	
	/**
	 * This method is to return all Meetings from the system
	 * 
	 * @return List<Meeting> meetings
	 */
	List<Meeting> findAll();
	
	/**
	 * Method to find meetings for each week.
	 * 
	 * 0 - Last Week
	 * 1 - Current Week
	 * 2 - Next Week
	 * 
	 * @param 	week int
	 * @return	meetings for each week
	 */
	List<Meeting> findbyWeek(int week);
}
