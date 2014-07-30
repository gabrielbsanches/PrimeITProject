package com.primeit.client.dao;

import java.util.List;

import com.primeit.client.model.Meeting;

/**
 * This class is the interface of MeetingDAO
 * 
 * @author gabrielbsanches
 *
 */
public interface MeetingDAO {
	
	/**
	 * This method is to save Meeting in the system using sessionFactory
	 * 
	 * @param Meeting
	 */
	void add(Meeting meeting);
	
	/**
	 * This method first gets the meeting from the system by "findByMeetingId" and then
	 * set all values that are in this Meeting parameter object
	 * 
	 * @param Meeting
	 */
	void update(Meeting meeting);
	
	/**
	 * This method is to delete Meeting with it's ID from the system using sessionFactory
	 * 
	 * @param long
	 */
	void delete(long id);
	
	/**
	 * This method is to find Meeting by it's ID from the system using sessionFactory
	 * 
	 * @param 	long
	 * @return 	Client
	 */
	Meeting findByMeetingId(long id);
	
	/**
	 * This method is to return all Meetings from the system and ordered by meeting_date(desc)
	 * 
	 * @return List<Meeting> meetings
	 */
	List<Meeting> findAll();

}
