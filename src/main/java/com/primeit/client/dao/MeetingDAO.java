package com.primeit.client.dao;

import java.util.List;

import com.primeit.client.model.Meeting;

public interface MeetingDAO {
	
	void add(Meeting meeting);
	void update(Meeting meeting);
	void delete(long id);
	Meeting findByMeetingId(long id);
	Meeting findByMeeting(String meetingAny);
	List<Meeting> findAll();

}
