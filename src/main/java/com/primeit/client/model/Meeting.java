package com.primeit.client.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "meetings")
public class Meeting implements java.io.Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long meeting_id;
	
	private String manager_name;
	private String company_name;
	private String client_name;
	private Date meeting_date;
	
	@Column(name = "meeting_id", unique = true, nullable = false)
	public long getMeeting_id() {
		return meeting_id;
	}
	public void setMeeting_id(long meeting_id) {
		this.meeting_id = meeting_id;
	}
	
	@Column(name = "manager_name")
	public String getManager_name() {
		return manager_name;
	}
	public void setManager_name(String manager_name) {
		this.manager_name = manager_name;
	}
	
	@Column(name = "company_name")
	public String getCompany_name() {
		return company_name;
	}
	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}
	
	@Column(name = "client_name")
	public String getClient_name() {
		return client_name;
	}
	public void setClient_name(String client_name) {
		this.client_name = client_name;
	}
	
	@Column(name = "meeting_date")
	public Date getMeeting_date() {
		return meeting_date;
	}
	public void setMeeting_date(Date meeting_date) {
		this.meeting_date = meeting_date;
	}
	
	@Override
	public String toString() {
		return "Meeting [meeting_id=" + meeting_id + ", manager_name="
				+ manager_name + ", company_name=" + company_name
				+ ", client_name=" + client_name + ", meeting_date="
				+ meeting_date + "]";
	}
}
