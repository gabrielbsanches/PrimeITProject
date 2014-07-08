package com.primeit.client.service;

import java.util.List;

import com.primeit.client.model.Meeting;

public interface MeetingService {

	public void add(Meeting meeting);
	public void update(Meeting meeting);
	public void delete(long id);
	public Meeting findByMeetingId(long id);
	public Meeting findByMeeting(String meetingAny);
	public List<Meeting> findAll();
	
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
	public List<Meeting> findbyWeek(int week);
}
