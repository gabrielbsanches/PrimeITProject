package com.primeit.client.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.primeit.client.dao.MeetingDAO;
import com.primeit.client.model.Meeting;

@Repository
public class MeetingDAOImpl implements MeetingDAO{
	
	 @Autowired private SessionFactory sessionFactory;

	public void add(Meeting meeting) {
		sessionFactory.getCurrentSession().save(meeting);
	}

	public void update(Meeting meeting) {
		Meeting meetingToUpdate = findByMeetingId(meeting.getMeeting_id());
		meetingToUpdate.setClient_name(meeting.getClient_name());
		meetingToUpdate.setCompany_name(meeting.getCompany_name());
		meetingToUpdate.setManager_name(meeting.getManager_name());
		meetingToUpdate.setMeeting_date(meeting.getMeeting_date());
		sessionFactory.getCurrentSession().update(meetingToUpdate);
	}

	public void delete(long id) {
		Meeting meeting = findByMeetingId(id);
		if(meeting != null){
			sessionFactory.getCurrentSession().delete(meeting);
		}
	}

	public Meeting findByMeetingId(long id) {
		Meeting meeting = (Meeting)sessionFactory.getCurrentSession().get(Meeting.class, id);
		return meeting;
	}

	public Meeting findByMeeting(String meetingAny) {
		Meeting meeting = (Meeting)sessionFactory.getCurrentSession().get(Meeting.class, meetingAny);
		return meeting;
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<Meeting> findAll() {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Meeting.class);
		criteria.addOrder(Order.asc("meeting_date"));
		return criteria.list();
	}

}
