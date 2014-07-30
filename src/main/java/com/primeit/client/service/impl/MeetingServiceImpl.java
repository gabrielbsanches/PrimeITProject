package com.primeit.client.service.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.primeit.client.dao.MeetingDAO;
import com.primeit.client.model.Meeting;
import com.primeit.client.service.MeetingService;

@Transactional
@Service("MeetingService")
public class MeetingServiceImpl implements MeetingService {

	@Autowired private MeetingDAO meetingDAO;
	
	public void add(Meeting meeting) {
		meetingDAO.add(meeting);
	}

	public void update(Meeting meeting) {
		meetingDAO.update(meeting);
	}

	public void delete(long id) {
		meetingDAO.delete(id);
	}

	public Meeting findByMeetingId(long id) {
		return meetingDAO.findByMeetingId(id);
	}

	public List<Meeting> findAll() {
		return meetingDAO.findAll();
	}

	/**
	 * Method to find meetings for each week. This specially work just for last/current/next weeks.
	 * 
	 * 0 - Last Week
	 * 1 - Current Week
	 * 2 - Next Week
	 * 
	 * @param 	week int
	 * @return	meetings for each week
	 */
	public List<Meeting> findbyWeek(int week) {
		
		Calendar c = Calendar.getInstance();
		c.set(Calendar.DAY_OF_WEEK,Calendar.SUNDAY);
		c.set(Calendar.HOUR_OF_DAY,0);
		c.set(Calendar.MINUTE,0);
		c.set(Calendar.SECOND,0);
		
		//current date
		Date currentDate = (Date) c.getTime();
		
		//ONE week after the current date
		c.add(Calendar.DATE,7);
		Date nextDate = (Date) c.getTime();
		
		//TWO weeks after current date
		c.add(Calendar.DATE, 7);
		Date futureDate = (Date) c.getTime();
		
		//ONE week before current date
		c.add(Calendar.DATE, -21);
		Date lastDate = (Date) c.getTime();
	
		
		List<Meeting> allMeetings = findAll();
		
		List<Meeting> listWeek = new ArrayList<Meeting>();
		
		switch (week) {
		case 0:
			for (Meeting meeting : allMeetings) {
				if(meeting.getMeeting_date().after(lastDate) && meeting.getMeeting_date().before(currentDate)) {
				    listWeek.add(meeting);
				}
			}
			return listWeek;
		case 1:
			for (Meeting meeting : allMeetings) {
				if(meeting.getMeeting_date().after(currentDate) && meeting.getMeeting_date().before(nextDate)) {
				    listWeek.add(meeting);
				}
			}
			return listWeek;
		case 2:
			for (Meeting meeting : allMeetings) {
				if(meeting.getMeeting_date().after(nextDate) && meeting.getMeeting_date().before(futureDate)) {
				    listWeek.add(meeting);
				}
			}
			return listWeek;

		default:
			return allMeetings;
		}
	}
}
